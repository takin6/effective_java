ITEM 61: PREFER PRIMITIVE TYPES TO BOXED PRIMITIVES

- major differences between primitives and boxed primitives.
  1. primitives have only their values, whereas boxed primitives have identities distinct from their values.
     In other words, two boxed primitive instances can have the same value and different identities.
  2. primitive types have only fully functional values, whereas each boxed primitive type has one nonfunctional value, which is null,
     in addition to all the functional values of the corresponding primitive type.
  3. primitives are more time- and space-efficient than boxed primitives.
  All three of these differences can get you into real trouble if you aren’t careful.

- Applying the == operator to boxed primitives is almost always wrong.

- In nearly every case when you mix primitives and boxed primitives in an operation, the boxed primitive is auto-unboxed.

- So when should you use boxed primitives?
  1. as elements, keys, and values in collections. You can’t put primitives in collections, so you’re forced to use boxed primitives.
     This is a special case of a more general one. You must use boxed primitives as type parameters in parameterized types and methods,
     because the language does not permit you to use primitives. For example, you cannot declare a variable to be of type ThreadLocal<int>, so you must use ThreadLocal<Integer> instead.
  2. Finally, you must use boxed primitives when making reflective method invocations (Item 65).


SUMMARY
In summary, use primitives in preference to boxed primitives whenever you have the choice.
Primitive types are simpler and faster. If you must use boxed primitives, be careful!
Autoboxing reduces the verbosity, but not the danger, of using boxed primitives.
When your program compares two boxed primitives with the == operator, it does an identity comparison, which is almost certainly not what you want.
When your program does mixed-type computations involving boxed and unboxed primitives, it does unboxing, and when your program does unboxing, it can throw a NullPointerException.
Finally, when your program boxes primitive values, it can result in costly and unnecessary object creations.