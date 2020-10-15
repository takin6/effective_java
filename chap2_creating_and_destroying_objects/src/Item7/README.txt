
ITEM 7: ELIMINATE OBSOLETE OBJECT REFERENCES

- Generally speaking, whenever a class manages its own memory, the programmer should be alert for memory leaks.
    - So when should you null out a reference? What aspect of the Stack class makes it susceptible to memory leaks?
        - Simply put, it manages its own memory.
          The storage pool consists of the elements of the elements array (the object reference cells, not the objects themselves).
          The elements in the active portion of the array (as defined earlier) are allocated, and those in the remainder of the array are free.
          The garbage collector has no way of knowing this; to the garbage collector, all of the object references in the elements array are equally valid.
          Only the programmer knows that the inactive portion of the array is unimportant. The programmer effectively communicates this fact to the garbage collector by manually nulling out array elements as soon as they become part of the inactive portion.


- Another common source of memory leaks is caches.
    - If you’re lucky enough to implement a cache for which an entry is relevant exactly so long as there are references to its key outside of the cache, represent the cache as a WeakHashMap

- A third common source of memory leaks is listeners and other callbacks.