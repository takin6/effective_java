ITEM 48: USE CAUTION WHEN MAKING STREAMS PARALLEL

- parallelizing a pipeline is unlikely to increase its performance if the source is from Stream.iterate,
  or the intermediate operation limit is used.

- The moral of this story is simple: Do not parallelize stream pipelines indiscriminately.
  The performance consequences may be disastrous.

- performance gains from parallelism are best on streams over ArrayList, HashMap, HashSet, and ConcurrentHashMap instances; arrays; int ranges; and long ranges.
  - What these data structures have in common is that they can all be accurately and cheaply split into subranges of any desired sizes,
    which makes it easy to divide work among parallel threads.
  - The abstraction used by the streams library to perform this task is the spliterator, which is returned by the spliterator method on Stream and Iterable.
  - all of these data structures have in common is that they provide good-to-excellent locality of reference when processed sequentially
    locality of reference: sequential element references are stored together in memory

- The nature of a stream pipeline’s terminal operation also affects the effectiveness of parallel execution.
  If a significant amount of work is done in the terminal operation compared to the overall work of the pipeline and that operation is inherently sequential,
  then parallelizing the pipeline will have limited effectiveness.
  - The best terminal operations for parallelism are reductions, where all of the elements emerging from the pipeline are combined using one of Stream’s reduce methods,
    or prepackaged reductions such as min, max, count, and sum.
  - The short-circuiting operations anyMatch, allMatch, and noneMatch are also amenable to parallelism.
  - The operations performed by Stream’s collect method, which are known as mutable reductions, are not good candidates for parallelism because the overhead of combining collections is costly.

-  (safety failures): Not only can parallelizing a stream lead to poor performance, including liveness failures; it can lead to incorrect results and unpredictable behavior
   - Safety failures may result from parallelizing a pipeline that uses mappers, filters, and other programmer-supplied function objects that fail to adhere to their specifications.
   - For example, the accumulator and combiner functions passed to Stream’s reduce operation must be associative, non-interfering, and stateless.

- To preserve the order displayed by the sequential version, you’d have to replace the forEach terminal operation with forEachOrdered, which is guaranteed to traverse parallel streams in encounter order.

- Normally, all parallel stream pipelines in a program run in a common fork-join pool. A single misbehaving pipeline can harm the performance of others in unrelated parts of the system.

- Under the right circumstances, it is possible to achieve near-linear speedup in the number of processor cores simply by adding a parallel call to a stream pipeline.


SUMMARY
In summary, do not even attempt to parallelize a stream pipeline
unless you have good reason to believe that it will preserve the correctness of the computation and increase its speed.
The cost of inappropriately parallelizing a stream can be a program failure or performance disaster.
If you believe that parallelism may be justified, ensure that your code remains correct when run in parallel,
and do careful performance measurements under realistic conditions.
If your code remains correct and these experiments bear out your suspicion of increased performance,
then and only then parallelize the stream in production code.