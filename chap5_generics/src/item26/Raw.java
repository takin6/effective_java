package item26;

import java.util.ArrayList;
import java.util.List;

// Fails at runtime - unsafeAdd method uses a raw type (List)!  (Page 119)

public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
