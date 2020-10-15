package item31;

import java.util.List;

public class RecursiveTypeBound {
    // list produces T instances
    // a comparable of T consumes T instances (and produces integers indicating order relations)
    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("Empty list");

        E result = null;
        for (E e : list)
            if (result == null || e.compareTo(result) > 0)
                result = e;

        return result;
    }
}
