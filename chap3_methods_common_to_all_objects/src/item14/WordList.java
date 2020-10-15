package item14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class WordList {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        String[] foo = {"C", "A", "B"};
        Collections.addAll(s, foo);
        System.out.println(s);
    }
}
