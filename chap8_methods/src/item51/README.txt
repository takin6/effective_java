ITEM 51: DESIGN METHOD SIGNATURES CAREFULLY

- Choose method names carefully
- Don’t go overboard in providing convenience methods.
- Avoid long parameter lists. Aim for four parameters or fewer.
    - Long sequences of identically typed parameters are especially harmful.
- There are three techniques for shortening overly long parameter lists.
  1. to break the method up into multiple methods, each of which requires only a subset of the parameters.
  2. to create helper classes to hold groups of parameters. Typically these helper classes are static member classes
  3. combines aspects of the first two is to adapt the Builder pattern

- For parameter types, favor interfaces over classes
  ex) map over hashmap

- Prefer two-element enum types to boolean parameters




