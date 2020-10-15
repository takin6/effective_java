ITEM 44: FAVOR THE USE OF STANDARD FUNCTIONAL INTERFACES

- If one of the standard functional interfaces does the job, you should generally use it in preference to a purpose-built functional interface.

- There are forty-three interfaces in java.util.Function. You can’t be expected to remember them all, but if you remember six basic interfaces, you can derive the rest when you need them.
  The basic interfaces operate on object reference types.
    The Operator interfaces : represents functions whose result and argument types are the same.
    The Predicate interface : represents a function that takes an argument and returns a boolean.
    The Function interface : represents a function whose argument and return types differ.
    The Supplier interface : represents a function that takes no arguments and returns (or “supplies”) a value.
    The Consumer interface : represents a function that takes an argument and returns nothing, essentially consuming its argument.

- six basic functional interfaces
  Interface         Function Signature      Example
  UnaryOperator<T>  T apply(T t)            String::toLowerCase
  BinaryOperator<T> T apply(T t1, T t2)     BigInteger::add
  Predicate<T>      boolean test(T t)       Collection::isEmpty
  Function<T,R>     R apply(T t)            Arrays::asList
  Supplier<T>       T get()                 Instant::now
  Consumer<T>       void accept(T t)        System.out.println

- There are also three variants of each of the six basic interfaces to operate on the primitive types int, long, and double.
  (IntPredicate, LongBinaryOperator, LongFunction<int[]>)

- Bi-<> : takes multiple argument
  ex) BiPredicate<T,U>, BiFunction<T,U,R>, BiConsumer<T,U>

- ToIntBifunction<T,u>, ToLongBiFunction<T,U>, ToDoubleBiFUnction<T,U>

- Take 1 object referenct and one premitive type
    - ObjDoubleConsumer<T>, ObjIntConsumer<T>, ObjLongConsumer<T>

- BooleanSupplier interface

- nine additional variants of the Function interface, for use when the result type is primitive.
    - The source and result types are primitive -> LongToIntFunction
    - source is a primitive and the result is an object reference -> DoubleToObjFunction

- Always annotate your functional interfaces with the @FunctionalInterface annotation.


SUMMARY
In summary, now that Java has lambdas, it is imperative that you design your APIs with lambdas in mind.
Accept functional interface types on input and return them on output.
It is generally best to use the standard interfaces provided in java.util.function,
but keep your eyes open for the relatively rare cases where you would be better off writing your own functional interface.