ITEM 41: USE MARKER INTERFACES TO DEFINE TYPES

- marker interfaces define a type that is implemented by instances of the marked class; marker annotations do not.

- Another advantage of marker interfaces over marker annotations is that they can be targeted more precisely.

- The chief advantage of marker annotations over marker interfaces is that they are part of the larger annotation facility.

So when should you use a marker annotation and when should you use a marker interface?
- you must use an annotation if the marker applies to any program element other than a class or interface, because only classes and interfaces can be made to implement or extend an interface.
- If the marker applies only to classes and interfaces, ask yourself the question “Might I want to write one or more methods that accept only objects that have this marking?”
    - If so, you should use a marker interface in preference to an annotation. This will make it possible for you to use the interface as a parameter type for the methods in question, which will result in the benefit of compile-time type checking.
    - If you can convince yourself that you’ll never want to write a method that accepts only objects with the marking, then you’re probably better off using a marker annotation.
- If, additionally, the marking is part of a framework that makes heavy use of annotations, then a marker annotation is the clear choice.



SUMMARY
In summary, marker interfaces and marker annotations both have their uses.
If you want to define a type that does not have any new methods associated with it, a marker interface is the way to go.
If you want to mark program elements other than classes and interfaces or to fit the marker into a framework that already makes heavy use of annotation types, then a marker annotation is the correct choice.
If you find yourself writing a marker annotation type whose target is ElementType.TYPE, take the time to figure out whether it really should be an annotation type or whether a marker interface would be more appropriate.