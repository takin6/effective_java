package item61;

import java.util.Comparator;

public class BrokenComparator {
    public static void main(String[] args) {
        Comparator<Integer> brokenNaturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        // Fixed Comparator
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed; // Auto-unboxing
            return i<j ? -1 : (i==j ? 0 : 1);
        };

        int result1 = brokenNaturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(result1);

        int result2 = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(result2);
    }
}
