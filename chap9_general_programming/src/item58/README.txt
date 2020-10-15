ITEM 58: PREFER FOR-EACH LOOPS TO TRADITIONAL FOR LOOPS

-  for-each
  // The preferred idiom for iterating over collections and arrays
  for (Element e : elements) {
      ... // Do something with e
  }

- three common situations where you can’t use for-each
  1. Destructive Filtering - If you need to traverse a collection removing selected elements, then you need to use an explicit iterator so that you can call its remove method.
  2. Transforming—If you need to traverse a list or array and replace some or all of the values of its elements, then you need the list iterator or array index in order to replace the value of an element.
  3. Parallel iteration

-


SUMMARY
In summary, the for-each loop provides compelling advantages over the traditional for loop
in clarity, flexibility, and bug prevention, with no performance penalty.
Use for-each loops in preference to for loops wherever you can.