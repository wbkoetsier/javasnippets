package nl.wilkoetsier.javasnippets.kyu8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplicationTableTest {

    @Test
    public void test01() {
        assertEquals(
                "1 * 5 = 5\n2 * 5 = 10\n3 * 5 = 15\n4 * 5 = 20\n5 * 5 = 25\n6 * 5 = 30\n7 * 5 = 35\n8 * 5 = 40\n9 * 5" +
                " = 45\n10 * 5 = 50",
                MultiplicationTable.multiTable(5));
    }

    @Test
    public void test02() {
        assertEquals(
                "1 * 8 = 8\n2 * 8 = 16\n3 * 8 = 24\n4 * 8 = 32\n5 * 8 = 40\n6 * 8 = 48\n7 * 8 = 56\n8 * 8 = 64\n9 * 8" +
                " = 72\n10 * 8 = 80",
                MultiplicationTable.multiTable(8));
    }
}
