ITEM 30: FAVOR GENERIC METHODS


- On occasion, you will need to create an object that is immutable but applicable to many different types.
Because generics are implemented by erasure (Item 28), you can use a single object for all required type parameterizations,
but you need to write a static factory method to repeatedly dole out the object for each requested type parameterization.
This pattern, called the generic singleton factory, is used for function objects (Item 42) such as Collections.reverseOrder, and occasionally for collections such as Collections.emptySet.

- It is permissible, though relatively rare, for a type parameter to be bounded by some expression involving that type parameter itself.
  This is what’s known as a recursive type bound. A common use of recursive type bounds is in connection with the Comparable interface, which defines a type’s natural ordering

- The type bound <E extends Comparable<E>> may be read as “any type E that can be compared to itself,


SUMMARY
In summary, generic methods, like generic types, are safer and easier to use than methods requiring their clients
to put explicit casts on input parameters and return values.
Like types, you should make sure that your methods can be used without casts, which often means making them generic.
And like types, you should generify existing methods whose use requires casts.
This makes life easier for new users without breaking existing clients