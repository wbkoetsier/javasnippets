package nl.wilkoetsier.javasnippets.kyu6;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;

/**
 * https://www.codewars.com/kata/51b62bf6a9c58071c600001b/
 * Roman Numerals Encoder
 */
public class Conversion {

    private static final Map<Integer, String> ROMAN_NUMERALS_BY_POSITION = Map.of(1, "I", 5, "V", 10, "X",
            50, "L", 100, "C", 500, "D", 1000, "M");

    public String solution(int n) {

        if (n < 1 || n > 3999) {
            throw new RuntimeException("Input must be 1 or higher and 3999 or lower");
        }

        // iterate over the separate digits of the number, right to left, taking into account the meaning of the
        // position of the digit in the number
        String solution = "";
        int position = 0;
        while (n > 0) {
            String romanNumeral = "";
            // 1 * (10 ^ position) 1 for 1, 10 for 2, 100 for 3, etc
            double d = Math.pow(10, position);
            // the value of the digit at this position, e.g. 9->40->200 for 249
            double digit = (n % 10) * d;
            // iterate over the values of the Roman numerals to find the numeral that represents the digit
            for (int romanNumeralValue : List.of(1000, 500, 100, 50, 10, 5, 1)) {
                // skip values that aren't needed, highest is always the digit + (1 * (10 ^ position))
                // for example 9 + 1 = 10 is needed to get X, and 90 + 10 = 100 is needed to make C
                if (romanNumeralValue > digit + d) {
                    continue;
                }
                // use a recursive function to get the Roman numeral for this specific digit
                Pair<String, Double> numeralDigitPair = getRomanNumeral(digit, d, romanNumeralValue, "");
                romanNumeral = String.format("%s%s", romanNumeral, numeralDigitPair.getLeft());
                // the function also returns the digit that remains after subtracting the value of the Roman numeral
                digit = numeralDigitPair.getRight();
                // if the Roman numeral value was 5, 50, etc, the new digit will be >= 1 and another iteration is
                // needed to calculate the remainder. This isn't needed if the digit is < 1
                if (digit < 1) {
                    break;
                }
            }
            // the Roman numeral representing the current digit is added to the left
            solution = String.format("%s%s", romanNumeral, solution);
            // move to the digit to the left of the current one
            n /= 10;
            position += 1;
        }
        return solution;
    }

    Pair<String, Double> getRomanNumeral(double digit, double decimalPlaceValue, int romanNumeralValue,
                                         String romanNumeral) {
        if ((digit / romanNumeralValue) == 1) {
            // 1, 5, 10, 50, 100, 500, 1000
            romanNumeral = String.format("%s%s", romanNumeral, ROMAN_NUMERALS_BY_POSITION.get(romanNumeralValue));
        } else if ((digit / romanNumeralValue) > 1) {
            // 2, 3, 6, 8, 20, 30, 60, 80, etc
            romanNumeral = String.format("%s%s", romanNumeral, ROMAN_NUMERALS_BY_POSITION.get(romanNumeralValue));
        } else if (digit > 0 && ((digit + decimalPlaceValue) / romanNumeralValue) == 1) {
            // 4, 9, 40, 90, etc
            romanNumeral = String.format("%s%s%s",
                    romanNumeral,
                    ROMAN_NUMERALS_BY_POSITION.get(romanNumeralValue - (int) digit),
                    ROMAN_NUMERALS_BY_POSITION.get(romanNumeralValue));
        } else {
            return Pair.of(romanNumeral, digit);
        }
        digit -= romanNumeralValue;
        return getRomanNumeral(digit, decimalPlaceValue, romanNumeralValue, romanNumeral);
    }
}
