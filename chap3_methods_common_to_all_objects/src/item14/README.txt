ITEM 14: CONSIDER IMPLEMENTING COMPARABLE

By implementing Comparable, you allow your class to interoperate with all of the many generic algorithms and collection implementations that depend on this interface.
You gain a tremendous amount of power for a small amount of effort.
Virtually all of the value classes in the Java platform libraries, as well as all enum types, implement Comparable.
If you are writing a value class with an obvious natural ordering, such as alphabetical order, numerical order, or chronological order, you should implement the Comparable interface

- Unlike the equals method, which imposes a global equivalence relation on all objects,
  compareTo doesn’t have to work across objects of different types: when confronted with objects of different types,
  compareTo is permitted to throw ClassCastException.


- In a compareTo method, fields are compared for order rather than equality.
  To compare object reference fields, invoke the compareTo method recursively.


- Using Comparator
// BROKEN difference-based comparator - violates transitivity!
static Comparator<Object> hashCodeOrder = new Comparator<>() {
    public int compare(Object o1, Object o2) {
        return o1.hashCode() - o2.hashCode();
    }
};

// Comparator based on static compare method
static Comparator<Object> hashCodeOrder = new Comparator<>() {
    public int compare(Object o1, Object o2) {
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
};

// Comparator based on Comparator construction method
static Comparator<Object> hashCodeOrder =
        Comparator.comparingInt(o -> o.hashCode());


SUMMARY
In summary, whenever you implement a value class that has a sensible ordering,
you should have the class implement the Comparable interface so that its instances can be easily sorted, searched, and used in comparison-based collections.
When comparing field values in the implementations of the compareTo methods, avoid the use of the < and > operators.
Instead, use the static compare methods in the boxed primitive classes or the comparator construction methods in the Comparator interface.