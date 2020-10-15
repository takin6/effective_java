ITEM 46: PREFER SIDE-EFFECT-FREE FUNCTIONS IN STREAMS

-  In order to obtain the expressiveness, speed, and in some cases parallelizability that streams have to offer, you have to adopt the paradigm as well as the API.

- pure function : result depends only on its input: it does not depend on any mutable state, nor does it update any state
  any function objects that you pass into stream operations, both intermediate and terminal, should be free of side-effects.

- collector : opaque object that encapsulates a reduction strategy.
              In this context, reduction means combining the elements of a stream into a single object.
              The object produced by a collector is typically a collection (which accounts for the name collector).

- Collections APIのまとめ
  1. groupingBy
    - groupingBy(Function<? super T, ? extends K> classifier)
      classifierにしたがって要素をグルーピング -> 結果(all the elements in each category.)をmapに格納して返す
    - groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T,A,D> downstream)
      classifierにしたがって要素をグルーピング -> downstreamを使って特定のキーに関連づけられた値をリダクション -> 結果をmapに格納して返す
      ex)
      Map<String, Long> freq = words.collect(groupingBy(String::toLowerCase, counting()));
    - groupingBy(Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)
      classifierにしたがって要素をグルーピング -> 結果をmapFactory型に入れる -> downstreamを使って特定のキーに関連づけられた値をリダクション -> 結果をmapに格納して返す
      ex)
      Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting())

  2. topMap
    - toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
    - toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)
      Collectors.toMap() には第3引数に BinaryOperator<U> mergeFunction を指定することで、キー重複時の動作を指定できます。
      https://blog1.mammb.com/entry/2017/04/21/122919
      ex)
      Map<Artist, Album> topHists = album.collect(toMap(Album::artist, a->a, maxBy(comparing(Album::sales))));


SUMMARY
In summary, the essence of programming stream pipelines is side-effect-free function objects.
This applies to all of the many function objects passed to streams and related objects.
The terminal operation forEach should only be used to report the result of a computation performed by a stream, not to perform the computation.
In order to use streams properly, you have to know about collectors. The most important collector factories are toList, toSet, toMap, groupingBy, and joining.