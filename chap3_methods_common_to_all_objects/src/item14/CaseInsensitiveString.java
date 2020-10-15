package item14;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

// Note that CaseInsensitiveString implements Comparable<CaseInsensitiveString>.
// This means that a CaseInsensitiveString reference can be compared only to another CaseInsensitiveString reference.
// This is the normal pattern to follow when declaring a class to implement Comparable.
public class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Fixed equals method (Page 40)
    @Override public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

    @Override public int hashCode() {
        return s.hashCode();
    }

    @Override public String toString() {
        return s;
    }

    public int compareTo(CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }

    public static void main(String[] args) {
        Set<CaseInsensitiveString> s = new TreeSet<>();
        String[] foo = {"AA", "aa", "bb", "BA"};
        for (String arg : foo)
            s.add(new CaseInsensitiveString(arg));
        System.out.println(s);
    }

}
