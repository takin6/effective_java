package item45;

public class CharStream {
    public static void main(String[] args) {
        // Does not produce the expected result
        "Hello World!".chars().forEach(System.out::print);
        System.out.println();

        "Hello World!".chars().forEach(x -> System.out.print((char) x));
        System.out.println();
    }
}
