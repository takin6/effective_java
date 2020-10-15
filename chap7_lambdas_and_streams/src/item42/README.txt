ITEM 42: PREFER LAMBDAS TO ANONYMOUS CLASSES

- Omit the types of all lambda parameters unless their presence makes your program clearer.

- lambdas lack names and documentation; if a computation isn’t self-explanatory, or exceeds a few lines, don’t put it in a lambda.
    - One line is ideal for a lambda, and three lines is a reasonable maximum.

Lambdas vs. Anonymous classes
- An anonymous class object generates a separate class file after compilation that increases the size of a jar file while a lambda expression is converted into a private method. It uses invokedynamic bytecode instruction to bind this method dynamically, which saves time and memory.
- We use this keyword to represent the current class in lambda expression while in the case of an anonymous class, this keyword can represent that particular anonymous class.
- Anonymous classes can be used in case of more than one abstract method while a lambda expression specifically used for functional interfaces.
- We need to provide the function body only in lambda expression while in the case of an anonymous class, we need to write the redundant class definition.

- you should rarely, if ever, serialize a lambda (or an anonymous class instance).

SUMMARY
In summary, as of Java 8, lambdas are by far the best way to represent small function objects.
Don’t use anonymous classes for function objects unless you have to create instances of types that aren’t functional interfaces.
Also, remember that lambdas make it so easy to represent small function objects that it opens the door to functional programming techniques that were not previously practical in Java.







