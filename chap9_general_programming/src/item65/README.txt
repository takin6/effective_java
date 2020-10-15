ITEM 65: PREFER INTERFACES TO REFLECTION

- The core reflection facility, java.lang.reflect, offers programmatic access to arbitrary classes.
  Given a Class object, you can obtain Constructor, Method, and Field instances representing the constructors, methods, and fields of the class represented by the Class instance.

- Cons of reflection facility
  - You lose all the benefits of compile-time type checking
  - The code required to perform reflective access is clumsy and verbose.
  - Performance suffers. Reflective method invocation is much slower than normal method invocation.

- You can obtain many of the benefits of reflection while incurring few of its costs by using it only in a very limited form

- For many programs that must use a class that is unavailable at compile time,
  there exists at compile time an appropriate interface or superclass by which to refer to the class (Item 64).
  If this is the case, you can create instances reflectively and access them normally via their interface or superclass.




SUMMARY
In summary, reflection is a powerful facility that is required for certain sophisticated system programming tasks, but it has many disadvantages.
If you are writing a program that has to work with classes unknown at compile time, you should, if at all possible, use reflection only to instantiate objects,
and access the objects using some interface or superclass that is known at compile time.

