ITEM 81: PREFER CONCURRENCY UTILITIES TO WAIT AND NOTIFY

- Given the difficulty of using wait and notify correctly, you should use the higher-level concurrency utilities instead.

- The higher-level utilities in java.util.concurrent fall into three categories:
    - the Executor Framework
    - concurrent collections
    - synchronizers

- concurrent collections : high-performance concurrent implementations of standard collection interfaces such as List, Queue, and Map.
                           these implementations manage their own synchronization internally
  => it is impossible to exclude concurrent activity from a concurrent collection; locking it will only slow the program.

- use ConcurrentHashMap in preference to Collections.synchronizedMap

- Some of the collection interfaces were extended with blocking operations, which wait (or block) until they can be successfully performed.
  ex) BlockingQueue extends Queue and adds several methods, including take, which removes and returns the head element from the queue, waiting if the queue is empty

- Synchronizers are objects that enable threads to wait for one another, allowing them to coordinate their activities.
  The most commonly used synchronizers are CountDownLatch and Semaphore. Less commonly used are CyclicBarrier and Exchanger. The most powerful synchronizer is Phaser.

- // The standard idiom for using the wait method
  synchronized (obj) {
      while (<condition does not hold>)
          obj.wait(); // (Releases lock, and reacquires on wakeup)
      ... // Perform action appropriate to condition
  }
- Always use the wait loop idiom to invoke the wait method; never invoke it outside of a loop.

- CountDownLatch/CyclicBarrierPhaser/
  https://www.youtube.com/watch?v=J3QZ5gfCtAg
  CountDownLatch: Perform each by each and privide await method to wait until all the threads are done
  CyclicBarrier: Wait until each thread arrives to a certain point, and provides await method to continue further

SUMMARY
In summary, using wait and notify directly is like programming in “concurrency assembly language,”
as compared to the higher-level language provided by java.util.concurrent.
There is seldom, if ever, a reason to use wait and notify in new code.
If you maintain code that uses wait and notify, make sure that it always invokes wait from within a while loop using the standard idiom.
The notifyAll method should generally be used in preference to notify. If notify is used, great care must be taken to ensure liveness.

