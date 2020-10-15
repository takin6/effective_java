package item31;

import java.util.Arrays;
import java.util.List;

public class Swap {
    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    // Private helper method for wildcard capture
    public static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        String[] words = {"abc","def","ghi"};
        List<String> argList = Arrays.asList(words);
        swap(argList, 0, argList.size()-1);
        System.out.println(argList);
    }
}
