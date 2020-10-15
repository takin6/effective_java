package Item8;


// The behavior of cleaners during System.exit is implementation specific.
// No guarantees are made relating to whether cleaning actions are invoked or not.
public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("Peace out");
    }
}
