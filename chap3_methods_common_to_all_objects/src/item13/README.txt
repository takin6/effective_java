ITEM 13: OVERRIDE CLONE JUDICIOUSLY

This item tells you how to implement a well-behaved clone method, discusses when it is appropriate to do so, and presents alternatives.

what does Cloneable do, given that it contains no methods?
- determines the behavior of Object’s protected clone implementation
- if a class implements Cloneable, Object’s clone method returns a field-by-field copy of the object

- in practice, a class implementing Cloneable is expected to provide a properly functioning public clone method


The general contract for the clone method is weak
- x.clone() != x => true
- x.clone().getClass() == x.getClass() => true
- x.clone().equals(x) => true

(PhoneNumber) super.clone();
The object you get back will be a fully functional replica of the original.
Any fields declared in your class will have values identical to those of the original.
immutable classes should never provide a clone method


If an object contains fields that refer to mutable objects, the simple clone implementation shown earlier can be disastrous.

the Cloneable architecture is incompatible with normal use of final fields referring to mutable objects

Subclass classes should not implement Cloneable
If clone invokes a method that is overridden in a subclass, this method will execute before the subclass has had a chance to fix its state in the clone, quite possibly leading to corruption in the clone and the original.

SUMMARY
To recap, all classes that implement Cloneable should override clone with a public method whose return type is the class itself.
This method should first call super.clone, then fix any fields that need fixing.
Typically, this means copying any mutable objects that comprise the internal “deep structure” of the object and replacing the clone’s references to these objects with references to their copies.
While these internal copies can usually be made by calling clone recursively, this is not always the best approach.
If the class contains only primitive fields or references to immutable objects, then it is likely the case that no fields need to be fixed.
There are exceptions to this rule. For example, a field representing a serial number or other unique ID will need to be fixed even if it is primitive or immutable.


A better approach to object copying is to provide a copy constructor or copy factory.
- don’t rely on a risk-prone extralinguistic object creation mechanism
- don’t conflict with the proper use of final fields
- don’t require casts
- don’t throw unnecessary checked exceptions
- can take an argument whose type is an interface implemented by the class

FINAL SUMMARY
Given all the problems associated with Cloneable, new interfaces should not extend it, and new extendable classes should not implement it.
While it’s less harmful for final classes to implement Cloneable, this should be viewed as a performance optimization, reserved for the rare cases where it is justified (Item 67).
As a rule, copy functionality is best provided by constructors or factories.
A notable exception to this rule is arrays, which are best copied with the clone method.

