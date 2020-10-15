package item45.anagrams;

import java.io.File;
import java.io.IOException;
import java.util.*;

// Prints all large anagram groups in a dictionary iteratively (Page 204)
public class IterativeAnagrams {
    public static void main(String[] args) throws IOException {
        File dictionary = new File("");
        int minGroupSize = Integer.parseInt("5");

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                // If the key is present, the method simply returns the value associated with it.
                // If not, the method computes a value by applying the given function object to the key,
                // associates this value with the key, and returns the computed value.
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }

        for (Set<String> group: groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
