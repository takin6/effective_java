ITEM 4: ENFORCE NONINSTANTIABILITY WITH A PRIVATE CONSTRUCTOR

- you’ll want to write a class that is just a grouping of static methods and static fields.

- Attempting to enforce noninstantiability by making a class abstract does not work.
  The class can be subclassed and the subclass instantiated.
  Furthermore, it misleads the user into thinking the class was designed for inheritance (Item 19).
- There is, however, a simple idiom to ensure noninstantiability.
  A default constructor is generated only if a class contains no explicit constructors,
  so a class can be made noninstantiable by including a private constructor:


- It guarantees the class will never be instantiated under any circumstances.
  This idiom is mildly counterintuitive because the constructor is provided expressly so that it cannot be invoked.
  It is therefore wise to include a comment, as shown earlier.