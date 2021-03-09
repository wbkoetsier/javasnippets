package nl.wilkoetsier.javasnippets.kyu8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/5a2fd38b55519ed98f0000ce
 */
public class MultiplicationTable {

    private MultiplicationTable() {
    }

    public static String multiTable(int num) {
        return IntStream.rangeClosed(1, 10)
                        .boxed()
                        .map(i -> multiplicationLine(i, num))
                        .collect(Collectors.joining("\n"));
    }

    private static String multiplicationLine(int multiplier, int num) {
        return multiplier + " * " + num + " = " + (multiplier * num);
    }
}
