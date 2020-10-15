package item52;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// autoboxing and generics increased the importance of caution when overloading.
public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i=-3; i<3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i=0; i<3; i++) {
            // set.remove(E) - removes the element i
            set.remove(i);
            // list.remove(int i) - removes the elemnt at the position of i
            list.remove(i);
            // list.remove(E)
//            list.remove((Integer) i);
        }

        System.out.println(set + " " + list);
    }
}
