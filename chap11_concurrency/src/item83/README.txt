ITEM 83: USE LAZY INITIALIZATION JUDICIOUSLY

- Lazy initialization is the act of delaying the initialization of a field until its value is needed.
  This technique is applicable to both static and instance fields

- the best advice for lazy initialization is “don’t do it unless you need to”

- If a field is accessed only on a fraction of the instances of a class and it is costly to initialize the field, then lazy initialization may be worthwhile

- In the presence of multiple threads, lazy initialization is tricky.
  If two or more threads share a lazily initialized field, it is critical that some form of synchronization be employed, or severe bugs can result

- Under most circumstances, normal initialization is preferable to lazy initialization.

- If you need to use lazy initialization for performance on a static field, use the lazy initialization holder class idiom
    - once without locking and then, if the field appears to be uninitialized, a second time with locking

SUMMARY
In summary, you should initialize most fields normally, not lazily.
If you must initialize a field lazily in order to achieve your performance goals or to break a harmful initialization circularity,
then use the appropriate lazy initialization technique.
For instance fields, it is the double-check idiom; for static fields, the lazy initialization holder class idiom.
For instance fields that can tolerate repeated initialization, you may also consider the single-check idiom.

