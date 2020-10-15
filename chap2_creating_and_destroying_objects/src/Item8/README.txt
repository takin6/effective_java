
ITEM 8: AVOID FINALIZERS AND CLEANERS

- Finalizers are unpredictable, often dangerous, and generally unnecessary.
-  Cleaners are less dangerous than finalizers, but still unpredictable, slow, and generally unnecessary.

- never do anything time-critical in a finalizer or cleaner.
    - never depend on a finalizer or cleaner to update persistent state.
    - There is a severe performance penalty for using finalizers and cleaners.
    - Finalizers have a serious security problem: they open your class up to finalizer attacks.

    - Why?
        - an uncaught exception thrown during finalization is ignored, and finalization of that object terminates
        - does the specification provide no guarantee that finalizers or cleaners will run promptly; it provides no guarantee that they’ll run at all.

- So what, if anything, are finalizers and cleaners good for?
    - to act as a safety net in case the owner of a resource neglects to call its close method.
    - concerns objects with native peers.
      (A native peer is a native (non-Java) object to which a normal object delegates via native methods)

- Use of Cleaners
    - Cleaners are a bit tricky to use. Below is a simple Room class demonstrating the facility.
      Let’s assume that rooms must be cleaned before they are reclaimed.
      The Room class implements AutoCloseable; the fact that its automatic cleaning safety net uses a cleaner is merely an implementation detail.
      Unlike finalizers, cleaners do not pollute a class’s public API:


- In summary, don’t use cleaners, or in releases prior to Java 9, finalizers, except as a safety net or to terminate noncritical native resources.
  Even then, beware the indeterminacy and performance consequences.
