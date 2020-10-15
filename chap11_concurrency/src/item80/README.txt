ITEM 80: PREFER EXECUTORS, TASKS, AND STREAMS TO THREADS

- Executor Framework, which is a flexible interface-based task execution facility.

- Executor Framework
    - Creating a work queue : ExecutorService exec = Executors.newSingleThreadExecutor();
    - Submit Runnable: exec.execute(runnable);
    - you can wait for a particular task to complete (with the get method)
    - you can wait for any or all of a collection of tasks to complete (using the invokeAny or invokeAll methods)
    - wait for the executor service to terminate (using the awaitTermination method)
    - retrieve the results of tasks one by one as they complete (using an ExecutorCompletionService)
    - schedule tasks to run at a particular time or to run periodically (using a ScheduledThreadPoolExecutor)

- If you want more than one thread to process requests from the queue,
  simply call a different static factory that creates a different kind of executor service called a thread pool.
    - java.util.concurrent.Executors class contains static factories that provide most of the executors you’ll ever need.
      If, however, you want something out of the ordinary, you can use the ThreadPoolExecutor class directly.

- Choosing the executor service for a particular application can be tricky.
    - For a small program, or a lightly loaded server, Executors.newCachedThreadPool is generally a good choice
      submitted tasks are not queued but immediately handed off to a thread for execution.
    - In a heavily loaded production server, you are much better off using Executors.newFixedThreadPool,
      which gives you a pool with a fixed number of threads, or using the ThreadPoolExecutor class directly, for maximum control.

- Benefits of Executor Framework
    - refrain from writing your own work queues
    - refrain from working directly with threads
    - In the executor framework, the unit of work and the execution mechanism are separate.
        - The key abstraction is the unit of work, which is the task (2 kinds of tasks)
            - Runnable and its close cousin, Callable (which is like Runnable, except that it returns a value and can throw arbitrary exceptions)
        -  The general mechanism for executing tasks is the executor service.

- In Java 7, the Executor Framework was extended to support fork-join tasks, which are run by a special kind of executor service known as a fork-join pool.
    - split up into smaller subtasks, and the threads comprising a ForkJoinPool not only process these tasks
      but “steal” tasks from one another to ensure that all threads remain busy, resulting in higher CPU utilization, higher throughput, and lower latency.

- more: Java Concurrency in Practice

