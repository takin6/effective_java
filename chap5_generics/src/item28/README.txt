ITEM 28: PREFER LISTS TO ARRAYS

Arrays differ from generic types in two important ways.
- Arrays are covariant : if Sub is a subtype of Super, then the array type Sub[] is a subtype of the array type Super[].
  Generics are invariant :  for any two distinct types Type1 and Type2, List<Type1> is neither a subtype nor a supertype of List<Type2>
- Arrays are reified : arrays know and enforce their element type at runtime
  Generics are implemented by erasure : enforce their type constraints only at compile time and discard (or erase) their element type information at runtime


Because of these fundamental differences, arrays and generics do not mix well.
For example, it is illegal to create an array of a generic type, a parameterized type, or a type parameter.
Therefore, none of these array creation expressions are legal: new List<E>[], new List<String>[], new E[].
All will result in generic array creation errors at compile time.

Why is it illegal to create a generic array?
Because it isn’t typesafe.
List<String>[] stringLists = new List<String>[1];  // (1) Acceptable
List<Integer> intList = List.of(42);               // (2) Acceptable
Object[] objects = stringLists;                    // (3) Acceptable
objects[0] = intList;                              // (4) Acceptable because arrays are covariant
String s = stringLists[0].get(0);                  // (5) TYPE ERROR

SUMMARY
In summary, arrays and generics have very different type rules.
Arrays are covariant and reified; generics are invariant and erased.
As a consequence, arrays provide runtime type safety but not compile-time type safety, and vice versa for generics.
As a rule, arrays and generics don’t mix well.
If you find yourself mixing them and getting compile-time errors or warnings, your first impulse should be to replace the arrays with lists.