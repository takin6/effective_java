package item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class SortFourWays {
    public static void main(String[] args) {
        String[] foo = {"takayuki", "yukari", "BBBs", "ccceeeee", "aaa"};
        List<String> words = Arrays.asList(foo);

        // Anonymous class instance as a function object - obsolete!
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(words);
        Collections.shuffle(words);

        // Lambda expression as function object (replaces anonymous class)
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(words);
        Collections.shuffle(words);

        // Comparator construction method (with method reference) in place of lambda
        Collections.sort(words, comparingInt(String::length));
        System.out.println(words);
        Collections.shuffle(words);

        // Default method List.sort in conjunction with comparator construction method
        words.sort(comparingInt(String::length));
        System.out.println(words);
    }
}
