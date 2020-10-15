package item32;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class PickTwo {
    // UNSAFE - Exposes a reference to its generic parameter array!

    // This code allocates an array of type Object[], which is the most specific type that is guaranteed to hold these instances,
    // no matter what types of objects are passed to pickTwo at the call site.
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a,b);
            case 1: return toArray(a,c);
            case 2: return toArray(b,c);
        }
        throw new AssertionError();
    }

    public static void main(String[] args) {
        // a hidden cast to String[] on the value returned by pickTwo
        String[] attributes = pickTwo("Good", "Fast", "Cheap");
        System.out.println(Arrays.toString(attributes));
    }
}
