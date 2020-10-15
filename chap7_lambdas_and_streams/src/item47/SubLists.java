package item47;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubLists {
    // Returns a stream of all the sublists of its input list
//    public static <E> Stream<List<E>> of(List<E> list){
//        return Stream.concat(Stream.of(Collections.emptyList()), prefixes(list).flatMap(SubLists::suffixes));
//    }

    public static <E> Stream<List<E>> of(List<E> list) {
        return IntStream.range(0, list.size())
                .mapToObj(start -> IntStream.rangeClosed(start+1, list.size()).mapToObj(end -> list.subList(start, end)))
                .flatMap(x -> x);
    }

    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size()).mapToObj(end -> list.subList(0, end));
    }

    private static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream.range(0, list.size()).mapToObj(start -> list.subList(start, list.size()));
    }

    public static void main(String[] args) {
//        List<String> list = Arrays.asList(args);
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        SubLists.of(list).forEach(System.out::println);
    }

}
