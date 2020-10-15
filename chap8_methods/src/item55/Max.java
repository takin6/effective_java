package item55;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class Max {
    // Returns maximum value in collection - throws exception if empty
    public static <E extends Comparable<E>> E throwsExceptionMax(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Empty Collection");

        E result = null;
        for (E e: c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

            return result;
    }

    // Returns maximum value in Collection as an Optional<E>
    public static <E extends Comparable<E>> Optional<E> optionalMax(Collection<E> c) {
        if (c.isEmpty())
            return Optional.empty();

        E result = null;
        for (E e: c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

            return Optional.of(result);
    }

    // Returns maximum value in Collection as an Optional<E>
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }
}
