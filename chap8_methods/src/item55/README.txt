ITEM 55: RETURN OPTIONALS JUDICIOUSLY

- approach to writing methods that may not be able to return a value

- So how do you choose to return an optional instead of returning a null or throwing an exception?
  - Optionals are similar in spirit to checked exceptions
  // Using an optional to provide a chosen default value
  String lastWordInLexicon = max(words).orElse("No words...");

- Occasionally you may be faced with a situation where it’s expensive to get the default value,
  and you want to avoid that cost unless it’s necessary.
  For these situations, Optional provides a method that takes a Supplier<T> and invokes it only when necessary.
  This method is called orElseGet, but perhaps it should have been called orElseCompute because it is closely related to the three Map methods whose names begin with compute.
  There are several Optional methods for dealing with more specialized use cases: filter, map, flatMap, and ifPresent. In Java 9, two more of these methods were added: or and ifPresentOrElse.

- Container types, including collections, maps, streams, arrays, and optionals should not be wrapped in optionals.
  Rather than returning an empty Optional<List<T>>, you should simply return an empty List<T>

- So when should you declare a method to return Optional<T> rather than T?
  - As a rule, you should declare a method to return Optional<T> if it might not be able to return a result and
    clients will have to perform special processing if no result is returned.
  - Optional<T> is not without cost.

- you should never return an optional of a boxed primitive type
  - use of OptionalInt, OptionalLong, OptionalDouble is recommended

- most other uses of optionals are suspect.
  - it is almost never appropriate to use an optional as a key, value, or element in a collection or array

- This leaves a big question unanswered. Is it ever appropriate to store an optional in an instance field? Often it’s a “bad smell”:
  - classes with many not-required fields : use optionals

SUMMARY
In summary, if you find yourself writing a method that can’t always return a value and you believe it is important that
users of the method consider this possibility every time they call it, then you should probably return an optional.
You should, however, be aware that there are real performance consequences associated with returning optionals;
for performance-critical methods, it may be better to return a null or throw an exception.
Finally, you should rarely use an optional in any other capacity than as a return value.