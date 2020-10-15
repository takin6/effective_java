package item79;

import java.util.HashSet;

// More complex test of ObservableSet
public class Test2 {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        // - Note that this call uses an anonymous class instance in place of the lambda used in the previous call.
        //   That is because the function object needs to pass itself to s.removeObserver, and lambdas cannot access themselves
        // - We are trying to remove an element from a list in the midst of iterating over it, which is illegal.
        set.addObserver(new SetObserver<>() {
            @Override
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e==23)
                    s.removeObserver(this);
            }
        });

        for (int i=0; i<100; i++)
            set.add(i);
    }
}
