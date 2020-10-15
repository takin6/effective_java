package item39.markerannotation;

// Program to process marker annotations

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
//        Class<?> testClass = Class.forName(args[0]);
        Class<?> testClass = Class.forName("item39.markerannotation.Sample");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception e) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }

        System.out.printf("passed: %d, Failed: %d%n", passed, tests-passed);
    }
}
