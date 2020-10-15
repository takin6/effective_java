package Item8;

public class Adult {
    public static void main(String[] args) {
//        If clients surround all Room instantiations in try-with-resource blocks,
//        automatic cleaning will never be required. This well-behaved client demonstrates that behavior:
        try (Room myRoom = new Room(7)) {
            System.out.println("Goodbye");
        }
    }
}
