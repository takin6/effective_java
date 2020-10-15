ITEM 17: MINIMIZE MUTABILITY

Immutable classes are easier to design, implement, and use than mutable classes. They are less prone to error and are more secure.

Rules
1. Don’t provide methods that modify the object’s state (known as mutators).
2. Ensure that the class can’t be extended.
3. Make all fields final.
4. Make all fields private.
5. Ensure exclusive access to any mutable components.

- Immutable objects are simple. An immutable object can be in exactly one state, the state in which it was created.
- Immutable objects are inherently thread-safe; they require no synchronization.


SUMMARY
To summarize, resist the urge to write a setter for every getter.
Classes should be immutable unless there’s a very good reason to make them mutable.
Immutable classes provide many advantages, and their only disadvantage is the potential for performance problems under certain circumstances.
You should always make small value objects, such as PhoneNumber and Complex, immutable.
(There are several classes in the Java platform libraries, such as java.util.Date and java.awt.Point, that should have been immutable but aren’t.)
You should seriously consider making larger value objects, such as String and BigInteger, immutable as well.
You should provide a public mutable companion class for your immutable class only once you’ve confirmed that it’s necessary to achieve satisfactory performance (Item 67).

- If a class cannot be made immutable, limit its mutability as much as possible.
- declare every field private final unless there’s a good reason to do otherwise.
- Constructors should create fully initialized objects with all of their invariants established.





