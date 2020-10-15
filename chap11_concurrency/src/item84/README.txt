ITEM 84: DON’T DEPEND ON THE THREAD SCHEDULER

- When many threads are runnable, the thread scheduler determines which ones get to run and for how long.
  Any reasonable operating system will try to make this determination fairly, but the policy can vary.
  Therefore, well-written programs shouldn’t depend on the details of this policy.
  Any program that relies on the thread scheduler for correctness or performance is likely to be nonportable.

- The best way to write a robust, responsive, portable program is to ensure that the average number of runnable threads is not significantly greater than the number of processors.

- Threads should not run if they aren’t doing useful work.
  In terms of the Executor Framework, this means sizing thread pools appropriately

- Threads should not busy-wait, repeatedly checking a shared object waiting for its state to change. >> SlowCountDownLatch example

- it’s not uncommon to see systems with one or more threads that are unnecessarily runnable. Performance and portability are likely to suffer.

- resist the temptation to “fix” the program by putting in calls to Thread.yield.
  Thread.yield has no testable semantics.
  Thread.yield: 現在処理中のスレッドを一時休止し、他のスレッドに実行の機会

- Thread priorities are among the least portable features of Java.

SUMMARY
In summary, do not depend on the thread scheduler for the correctness of your program.
The resulting program will be neither robust nor portable.
As a corollary, do not rely on Thread.yield or thread priorities. These facilities are merely hints to the scheduler.
Thread priorities may be used sparingly to improve the quality of service of an already working program, but they should never be used to “fix” a program that barely works.
