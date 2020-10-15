package item39.markerannotation;

public class Sample {
    // a marker annotation: no parameters but simply “marks” the annotated element
    @Test public static void m1() {}

    public static void m2() {}

    @Test public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {}

    @Test public void m5() {} // INVALID USE : nonstatic method

    public void m6() {}

    @Test public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {}


}
