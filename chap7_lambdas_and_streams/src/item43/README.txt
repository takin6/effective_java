ITEM 43: PREFER METHOD REFERENCES TO LAMBDAS

- The primary advantage of lambdas over anonymous classes is that they are more succinct.
  Java provides a way to generate function objects even more succinct than lambdas: method references.

- The function of the code snippet is to associate the number 1 with the key if it is not in the map
  and to increment the associated value if the key is already present
    map.merge(key, 1, (count, incr) -> count + incr);
    map.merge(key, 1, Integer::sum);

- There’s nothing you can do with a method reference that you can’t also do with a lambda
  That said, method references usually result in shorter, clearer code.

-  Occasionally, a lambda will be more succinct than a method reference. This happens most often when the method is in the same class as the lambda.

- Many method references refer to static methods, but there are four kinds that do not.
  Type                  Example                 Lambda Equivalent
  Static                Integer::parseInt       str -> Integer.parseInt(str)
  Bound (instance)      Instant.now()::isAfter  Instant then = Instant.now(); t -> then.isAfter(t)
  Unbound (instance)    String::toLowerCase     str -> str.toLowerCase()
  class constructor     TreeMap<K,V>::new       () -> new TreeMap<K,V>
  Array constructor     int[]::new              len -> new int[len]

Bound vs. Unbound
- unbound receivers allow you to use instance methods as if they were static methods with a first parameter of the declaring type
- a bound receiver, the "target" instance is effectively part of the function.


SUMMARY
In summary, method references often provide a more succinct alternative to lambdas.
Where method references are shorter and clearer, use them; where they aren’t, stick with lambdas.




