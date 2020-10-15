package Item6;

import java.util.regex.Pattern;

public class RomanNumerals {
//    While String.matches is the easiest way to check if a string matches a regular expression,
//    it’s not suitable for repeated use in performance-critical situations.
    // it internally creates a Pattern instance for the regular expression
    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        int numSets = 100;
        int numReps = 100;
        boolean b = false;

        for (int i=0; i<numSets; i++) {
            long start = System.nanoTime();
            for (int j=0; j<numReps; j++) {
                b ^= isRomanNumeralFast("MCMLXXVI");
            }
            long end = System.nanoTime();
            System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
        }

        if (!b)
            System.out.println();
    }
}
