package item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

// Enum type with constant-specific class bodies and data (Pages 163-4)
public enum Operation {
    // constant-specific class body, constant-specific method implementations
    PLUS("+") {
        public double apply(double x, double y) { return x + y; };
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; };
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; };
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; };
    };

    private final String symbol;

    Operation(String symbol) { this.symbol = symbol; }

    @Override public String toString() { return symbol; }

    public abstract double apply(double x, double y);

    // Implementing a fromString method on an enum type
    private static final Map<String, Operation> stringToEnum =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e));

    // Returns Operation for String, if any
    // Enum types have an automatically generated valueOf(String) method that translates a constant’s name into the constant itself.
    // If you override the toString method in an enum type, consider writing a fromString method to translate the custom string representation back to the corresponding enum.
    // - to indicate that the string that was passed in does not represent a valid operation, and it forces the client to confront this possibility
    private static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("13.6");
        double y = Double.parseDouble("19.33");
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x,y));
        }
    }
}
