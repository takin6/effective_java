package item32;

import java.util.List;

// It is unsafe to store a value in a generic varargs array parameter
public class Dangerous {
    // Mixing generics and varargs can violate type safety!
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // heap polution
        String s = stringLists[0].get(0); // ClassCastException
    }

    public static void main(String[] args) {
        System.out.println(List.of("There be dragons!"));
        dangerous(List.of("There be dragons!"));
    }
}
