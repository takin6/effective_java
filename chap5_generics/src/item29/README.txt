ITEM 29: FAVOR GENERIC TYPES

Generigying a class
1. The first step in generifying a class is to add one or more type parameters to its declaration
2. replace all the uses of the type Object with the appropriate type parameter
3.


Stack Class
the first technique requires only a single cast (where the array is created),
while the second requires a separate cast each time an array element is read.

SUMMARY
In summary, generic types are safer and easier to use than types that require casts in client code.
When you design new types, make sure that they can be used without such casts.
This will often mean making the types generic.
If you have any existing types that should be generic but aren’t, generify them.
This will make life easier for new users of these types without breaking existing clients.