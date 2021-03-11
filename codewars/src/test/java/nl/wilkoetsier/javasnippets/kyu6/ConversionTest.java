package nl.wilkoetsier.javasnippets.kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConversionTest {

    private final Conversion conversion = new Conversion();

    @Test
    public void shouldConvertToRoman1() {
        assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
    }

    @Test
    public void shouldConvertToRoman3() {
        assertEquals("solution(3) should equal to III", "III", conversion.solution(3));
    }

    @Test
    public void shouldConvertToRoman4() {
        assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
    }

    @Test
    public void shouldConvertToRoman6() {
        assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
    }

    @Test
    public void shouldConvertToRoman11() {
        assertEquals("solution(11) should equal to XI", "XI", conversion.solution(11));
    }

    @Test
    public void shouldConvertToRoman38() {
        assertEquals("solution(38) should equal to XXXVIII", "XXXVIII", conversion.solution(38));
    }

    @Test
    public void shouldConvertToRoman1949() {
        assertEquals("solution(1949) should equal to MCMXLIX", "MCMXLIX", conversion.solution(1949));
    }

    @Test
    public void shouldConvertToRoman2021() {
        assertEquals("solution(2021) should equal to MMXXI", "MMXXI", conversion.solution(2021));
    }
}
