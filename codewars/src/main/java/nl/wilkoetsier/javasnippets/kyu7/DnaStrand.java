package nl.wilkoetsier.javasnippets.kyu7;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * https://www.codewars.com/kata/554e4a2f232cdd87d9000038
 */
public class DnaStrand {

    private static final Map<String, String> NUCLEOTIDES = Map.of("A", "T", "T", "A", "C", "G", "G", "C");

    private DnaStrand() {
    }

    public static String makeComplement(String dna) {
        return Stream.of(dna.split(""))
                     .map(s -> NUCLEOTIDES.getOrDefault(s, "N"))
                     .collect(joining());
    }
}
