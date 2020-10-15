ITEM 32: COMBINE GENERICS AND VARARGS JUDICIOUSLY


- Heap pollution occurs when a variable of a parameterized type refers to an object that is not of that type

- it is unsafe to store a value in a generic varargs array parameter.
- In essence, the SafeVarargs annotation constitutes a promise by the author of a method that it is typesafe.
- In other words, if the varargs parameter array is used only to transmit a variable number of arguments from the caller to the method—which is,
  after all, the purpose of varargs—then the method is safe.
- It is unsafe to give another method access to a generic varargs parameter array
    - with two exceptions:
        - it is safe to pass the array to another varargs method that is correctly annotated with @SafeVarargs,
        - it is safe to pass the array to a non-varargs method that merely computes some function of the contents of the array.
- Use @SafeVarargs on every method with a varargs parameter of a generic or parameterized type
- a generic varargs methods is safe if:
  1. it doesn’t store anything in the varargs parameter arrayß
  2. it doesn’t make the array (or a clone) visible to untrusted code. If either of these prohibitions is violated, fix it.

- that the SafeVarargs annotation is legal only on methods that can’t be overridden

SUMMARY
In summary, varargs and generics do not interact well because the varargs facility is a leaky abstraction built atop arrays,
and arrays have different type rules from generics.
Though generic varargs parameters are not typesafe, they are legal.
If you choose to write a method with a generic (or parameterized) varargs parameter,
first ensure that the method is typesafe,
and then annotate it with @SafeVarargs so it is not unpleasant to use.