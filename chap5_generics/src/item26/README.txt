ITEM 26: DON’T USE RAW TYPES

- Terms
    - A class or interface whose declaration has one or more type parameters is a generic class or interface
    - Generic classes and interfaces are collectively known as generic types.
    - Each generic type defines a set of parameterized types, which consist of the class or interface name
      followed by an angle-bracketed list of actual type parameters corresponding to the generic type's formal type parameters
        ex) List<String> (read “list of string”) is a ...
            - parameterized type representing a list whose elements are of type String.
            - (String is the actual type parameter corresponding to the formal type parameter E.)
    - each generic type defines a raw type, which is the name of the generic type used without any accompanying type parameters
        ex) List<E> => List

Reasons to Use Generics All the Time
- If you use raw types, you lose all the safety and expressiveness benefits of generics.
- So Why exists ? - to be compatible with legacy java codes
- you lose type safety if you use a raw type such as List, but not if you use a parameterized type such as List<Object>
- You can put any element into a collection with a raw type, easily corrupting the collection’s type invariant; you can’t put any element (other than null) into a Collection<?>.

Exceptions
- You must use raw types in class literals
    - illegal: List<String>.class and List<?>.class
- Concerns the instanceof operator
    - This is the preferred way to use the instanceof operator with generic types

SUMMARY
In summary, using raw types can lead to exceptions at runtime, so don’t use them.
They are provided only for compatibility and interoperability with legacy code that predates the introduction of generics.
As a quick review,
Set<Object> is a parameterized type representing a set that can contain objects of any type,
Set<?> is a wildcard type representing a set that can contain only objects of some unknown type,
and Set is a raw type, which opts out of the generic type system.
The first two are safe, and the last is not
.


