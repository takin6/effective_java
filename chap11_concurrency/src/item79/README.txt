ITEM79: AVOID EXCESSIVE SYNCHRONIZETION

- To avoid liveness and safety failures, never cede control to the client within a synchronized method or block.

- Invoking alien methods from within synchronized regions has caused many deadlocks in real systems

- there’s a better way to move the alien method invocations out of the synchronized block.
  The libraries provide a concurrent collection (Item 81) known as CopyOnWriteArrayList

- As a rule, you should do as little work as possible inside synchronized regions.

- In a multicore world, the real cost of excessive synchronization is not the CPU time spent getting locks;
  it is contention: the lost opportunities for parallelism and the delays imposed by the need to ensure that every core has a consistent view of memory.

SUMMARY
In summary, to avoid deadlock and data corruption, never call an alien method from within a synchronized region.
More generally, keep the amount of work that you do from within synchronized regions to a minimum.
When you are designing a mutable class, think about whether it should do its own synchronization.
In the multicore era, it is more important than ever not to oversynchronize.
Synchronize your class internally only if there is a good reason to do so, and document your decision clearly