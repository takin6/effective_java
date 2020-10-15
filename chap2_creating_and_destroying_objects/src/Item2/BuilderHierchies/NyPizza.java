package Item2.BuilderHierchies;

import java.util.Objects;

public class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    // static classはextendsできる
    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        // This technique, wherein a subclass method is declared to return a subtype of the return type declared in the super-class,
        // is known as covariant return typing.
        @Override public NyPizza build() { return new NyPizza(this); }

        @Override protected Builder self() {return this; }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override public String toString() { return "New York Pizza with " + toppings; }
}
