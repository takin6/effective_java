ITEM 15: MINIMIZE THE ACCESSIBILITY OF CLASSES AND MEMBERS

The single most important factor that distinguishes a well-designed component from a poorly designed one is
the degree to which the component hides its internal data and other implementation details from other components.
=> information hiding or encapsulation

The rule of thumb is simple:
make each class or member as inaccessible as possible.
In other words, use the lowest possible access level consistent with the proper functioning of the software that you are writing.

- For top-level (non-nested) classes and interfaces, there are only two possible access levels: package-private and public.
    - If a package-private top-level class or interface is used by only one class, consider making the top-level class a private static nested class of the sole class that uses it

- Members
    • private—The member is accessible only from the top-level class where it is declared.
    • package-private—The member is accessible from any class in the package where it is declared. Technically known as package access,
      this is the access level you get if no access modifier is specified
    • protected—The member is accessible from subclasses of the class where it is declared
    • public—The member is accessible from anywhere.


- There is a key rule that restricts your ability to reduce the accessibility of methods.
If a method overrides a superclass method, it cannot have a more restrictive access level in the subclass than in the superclass

- Instance fields of public classes should rarely be public.  classes with public mutable fields are not generally thread-safe.

- it is wrong for a class to have a public static final array field, or an accessor that returns such a field
    // Potential security hole!
    public static final Thing[] VALUES = { ... };

    // Solution1. make the public array private and add a public immutable list
    private static final Thing[] PRIVATE_VALUES = { ... };
    public static final List<Thing> VALUES =
       Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    // Make the array private and add a public method that retursn a copy of a private array
    private static final Thing[] PRIVATE_VALUES = { ... };
    public static final Thing[] values() {
        return PRIVATE_VALUES.clone();
    }

- there are two additional, implicit access levels introduced as part of the module system.
    - A module is a grouping of packages
    - Public and protected members of unexported packages in a module are inaccessible outside the module; within the module, accessibility is unaffected by export declarations.

SUMMARY
To summarize, you should reduce accessibility of program elements as much as possible (within reason).
After carefully designing a minimal public API, you should prevent any stray classes, interfaces, or members from becoming part of the API.
With the exception of public static final fields, which serve as constants, public classes should have no public fields.
Ensure that objects referenced by public static final fields are immutable.
