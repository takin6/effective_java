ITEM 57: MINIMIZE THE SCOPE OF LOCAL VARIABLES

- The most powerful technique for minimizing the scope of a local variable is to declare it where it is first used.

- Nearly every local variable declaration should contain an initializer.

- prefer for loops to while loops to minimize the scope of local variables
  // Preferred idiom for iterating over a collection or array
  for (Element e : c) {
      ... // Do Something with e
  }

  // Idiom for iterating when you need the iterator
  for (Iterator<Element> i = c.iterator(); i.hasNext(); ) {
      Element e = i.next();
      ... // Do something with e and i
  }

- A final technique to minimize the scope of local variables is to keep methods small and focused.


