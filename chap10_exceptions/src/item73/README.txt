ITEM 73: THROW EXCEPTIONS APPROPRIATE TO THE ABSTRACTION

-  exception translation: higher layers should catch lower-level exceptions and, in their place,
   throw exceptions that can be explained in terms of the higher-level abstraction.

- ex)
    // Exception Translation
    try {
        ... // Use lower-level abstraction to do our bidding
    } catch (LowerLevelException e) {
        throw new HigherLevelException(...);
    }

- exception chaining
    // Exception Chaining
    try {
        ... // Use lower-level abstraction to do our bidding
    } catch (LowerLevelException cause) {
        throw new HigherLevelException(cause);
    }

- // Exception with chaining-aware constructor
  class HigherLevelException extends Exception {
      HigherLevelException(Throwable cause) {
          super(cause);
      }
  }

- While exception translation is superior to mindless propagation of exceptions from lower layers, it should not be overused.

SUMMARY
In summary, if it isn’t feasible to prevent or to handle exceptions from lower layers,
use exception translation, unless the lower-level method happens to guarantee that all of its exceptions are appropriate to the higher level.
Chaining provides the best of both worlds: it allows you to throw an appropriate higher-level exception,
while capturing the underlying cause for failure analysis (Item 75).

