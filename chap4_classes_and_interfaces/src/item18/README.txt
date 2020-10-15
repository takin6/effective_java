ITEM 18: FAVOR COMPOSITION OVER INHERITANCE

It is safe to use inheritance within a package ...
- where the subclass and the superclass implementations are under the control of the same programmers
- when extending classes specifically designed and documented for extension

- Unlike method invocation, inheritance violates encapsulation
    - a subclass depends on the implementation details of its superclass for its proper function.
      The superclass’s implementation may change from release to release, and if it does, the subclass may break

- This “self-use” is an implementation detail, not guaranteed to hold in all implementations of the Java platform and subject to change from release to release.
  Therefore, the resulting InstrumentedHashSet class would be fragile.

- Instead of extending an existing class, give your new class a private field that references an instance of the existing class.
  This design is called composition because the existing class becomes a component of the new one.
    - forwarding: Each instance method in the new class invokes the corresponding method on the contained instance of the existing class and returns the results.


- The InstrumentedSet class is known as a wrapper class because each InstrumentedSet instance contains (“wraps”) another Set instance.
  This is also known as the Decorator pattern [Gamma95] because the InstrumentedSet class “decorates” a set by adding instrumentation.
  => Sometimes the combination of composition and forwarding is loosely referred to as delegation.
     Technically it’s not delegation unless the wrapper object passes itself to the wrapped object

- One caveat is that wrapper classes are not suited for use in callback frameworks, wherein objects pass self-references to other objects for subsequent invocations (“callbacks”).
   Because a wrapped object doesn’t know of its wrapper, it passes a reference to itself (this) and callbacks elude the wrapper.
   This is known as the SELF problem


- Inheritance is appropriate only in circumstances where the subclass really is a subtype of the superclass.
  In other words, a class B should extend a class A only if an “is-a” relationship exists between the two classes.

SUMMARY
To summarize, inheritance is powerful, but it is problematic because it violates encapsulation.
It is appropriate only when a genuine subtype relationship exists between the subclass and the superclass.
Even then, inheritance may lead to fragility if the subclass is in a different package from the superclass and the superclass is not designed for inheritance.
To avoid this fragility, use composition and forwarding instead of inheritance, especially if an appropriate interface to implement a wrapper class exists.
Not only are wrapper classes more robust than subclasses, they are also more powerful.










