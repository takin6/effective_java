ITEM 45: USE STREAMS JUDICIOUSLY

- The streams API was added in Java 8 to ease the task of performing bulk operations, sequentially or in parallel.
- This API provides two key abstractions:
  the stream : presents a finite or infinite sequence of data elements
  stream pipeline : which represents a multistage computation on these elements.

- A stream pipeline consists of a source stream followed by zero or more intermediate operations and one terminal operation.

- Stream pipelines are evaluated lazily
  - intermediate operations are not evaluated unless terminal operation is invoked.
    Each intermediate operation creates a new stream, stores the provided operation/function and return the new stream.
    The pipeline accumulates these newly created streams.

- By default, stream pipelines run sequentially.
  Making a pipeline execute in parallel is as simple as invoking the parallel method on any stream in the pipeline, but it is seldom appropriate to do so

- Overusing streams makes programs hard to read and maintain.

- In the absence of explicit types, careful naming of lambda parameters is essential to the readability of stream pipelines.

-you should refrain from using streams to process char values.


SUMMARY
In summary, some tasks are best accomplished with streams, and others with iteration.
Many tasks are best accomplished by combining the two approaches.
There are no hard and fast rules for choosing which approach to use for a task, but there are some useful heuristics.
In many cases, it will be clear which approach to use; in some cases, it won’t.
If you’re not sure whether a task is better served by streams or iteration, try both and see which works better.



