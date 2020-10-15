ITEM 78: SYNCHRONIZE ACCESS TO SHARED MUTABLE DATA

- Synchronized
    - The synchronized keyword ensures that only a single thread can execute a method or block at one time.
    - means of mutual exclusion, to prevent an object from being seen in an inconsistent state by one thread while it’s being modified by another.
    - These methods observe the state and optionally cause a state transition
    - Proper use of synchronization guarantees that no method will ever observe the object in an inconsistent state.
    - Without synchronization, one thread’s changes might not be visible to other threads.
      ensures that each thread entering a synchronized method or block sees the effects of all previous modifications that were guarded by the same lock.

- a variable is atomic unless the variable is of type long or double
  reading a variable other than a long or double is guaranteed to return a value that was stored into that variable by some thread,
  even if multiple threads modify the variable concurrently and without synchronization.
    - it does not guarantee that a value written by one thread will be visible to another.

- memory model: Synchronization is required for reliable communication between threads as well as for mutual exclusion.

- Do not use Thread.stop. A recommended way to stop one thread from another is to have the first thread poll a boolean field
  that is initially false but can be set to true by the second thread to indicate that the first thread is to stop itself.

- Synchronization is not guaranteed to work unless both read and write operations are synchronized.

- Volatile modifier: performs no mutual exclusion, it guarantees that any thread that reads the field will see the most recently written value:

- // Broken - requires synchronization!
  private static volatile int nextSerialNumber = 0;

  public static int generateSerialNumber() {
      return nextSerialNumber++;
  }
  - the increment operator (++) is not atomic
  - performs two operations on the nextSerialNumber field: first it reads the value, and then it writes back a new value, equal to the old value plus one.
  - If a second thread reads the field between the time a thread reads the old value and writes back a new one, the second thread will see the same value as the first and return the same serial number.
  => safety failure

  - Correction1: synchronized keyword on declaration
  private static synchronized int nextSerialNumber = 0;

  - Correction2: use the class AtomicLong, lock-free, thread-safe programming on single variables, likely to outperform the synchronized version
  // Lock-free synchronization with java.util.concurrent.atomic
  private static final AtomicLong nextSerialNum = new AtomicLong();

  public static long generateSerialNumber() {
      return nextSerialNum.getAndIncrement();
  }


- confine mutable data to a single thread as best as you can

- effectively immutable
  ne thread to modify a data object for a while and then to share it with other threads, synchronizing only the act of sharing the object reference
  ransferring such an object reference from one thread to others is called safe publication

SUMMARY
In summary, when multiple threads share mutable data, each thread that reads or writes the data must perform synchronization.
In the absence of synchronization, there is no guarantee that one thread’s changes will be visible to another thread.
The penalties for failing to synchronize shared mutable data are liveness and safety failures.
These failures are among the most difficult to debug.
They can be intermittent and timing-dependent, and program behavior can vary radically from one VM to another.
If you need only inter-thread communication, and not mutual exclusion,
the volatile modifier is an acceptable form of synchronization, but it can be tricky to use correctly.