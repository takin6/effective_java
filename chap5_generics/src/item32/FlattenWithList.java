package item32;

import java.util.ArrayList;
import java.util.List;

public class FlattenWithList {
    // the compiler can prove that the method is typesafe.
    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> flatList = flatten(List.of(List.of(1,2), List.of(3,4), List.of(5,6)));
        System.out.println(flatList);
    }
}
