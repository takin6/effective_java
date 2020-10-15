
Item2: CONSIDER A BUILDER WHEN FACED WITH MANY CONSTRUCTOR PARAMETERS

- Example : Nutrition Facts label

- What sort of constructors or static factories should you write for such a class?


1. Telescoping Constructor Pattern - Does now scale well!!
    - hard to write client code when there are many parameters, and harder still to read it.

2. JavaBeans Pattern - allows inconsistency, mandates mutability
    - It is easy, if a bit wordy, to create instances, and easy to read the resulting code
    - Serious disadvantages:
        - a JavaBean may be in an inconsistent state partway through its construction
          Attempting to use an object when it’s in an inconsistent state may cause failures that are far removed from the code containing the bug and hence difficult to debug.
        - the JavaBeans pattern precludes the possibility of making a class immutable
          not thread-safe

3. Builder Pattern -
    1. The client calls a constructor (or static factory) with all of the required parameters and gets a builder object.
    2. Then the client calls setter-like methods on the builder object to set each optional parameter of interest.
    3. Finally, the client calls a parameterless build method to generate the object, which is typically immutable.
       The builder is typically a static member class (Item 24) of the class it builds.

    - This client code is easy to write and, more importantly, easy to read. The Builder pattern simulates named optional parameters

4.