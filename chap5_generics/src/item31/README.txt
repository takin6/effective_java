ITEM 31: USE BOUNDED WILDCARDS TO INCREASE API FLEXIBILITY

- For maximum flexibility, use wildcard types on input parameters that represent producers or consumers.
- Here is a mnemonic to help you remember which wildcard type to use:
    PECS stands for producer-extends, consumer-super.
- Do not use bounded wildcard types as return types.
- If the user of a class has to think about wildcard types, there is probably something wrong with its API.

- Comparables are always consumers, so you should generally use Comparable<? super T> in preference to Comparable<T>.
  The same is true of comparators; therefore, you should generally use Comparator<? super T> in preference to Comparator<T>.

- There is a duality between type parameters and wildcards, and many methods can be declared using one or the other.
    - As a rule, if a type parameter appears only once in a method declaration, replace it with a wildcard.

SUMMARY
In summary, using wildcard types in your APIs, while tricky, makes the APIs far more flexible.
If you write a library that will be widely used, the proper use of wildcard types should be considered mandatory.
Remember the basic rule: producer-extends, consumer-super (PECS).
Also remember that all comparables and comparators are consumers.
