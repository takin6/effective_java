ITEM 33: CONSIDER TYPESAFE HETEROGENEOUS CONTAINERS

- parameterize the key instead of the container
- A Favorites instance is typesafe: it will never return an Integer when you ask it for a String.
  It is also heterogeneous: unlike an ordinary map, all the keys are of different types. Therefore, we call Favorites a typesafe heterogeneous container.

- When a class literal is passed among methods to communicate both compile-time and runtime type information, it is called a type token

- The type tokens used by Favorites are unbounded: getFavorite and put-Favorite accept any Class object.
  Sometimes you may need to limit the types that can be passed to a method. This can be achieved with a bounded type token,
  which is simply a type token that places a bound on what type can be represented, using a bounded type parameter (Item 29) or a bounded wildcard

  ex of bounded type token)
  public <T extends Annotation>
      T getAnnotation(Class<T> annotationType);
  The argument, annotationType, is a bounded type token representing an annotation type.
  The method returns the element’s annotation of that type, if it has one, or null, if it doesn’t.

SUMMARY
In summary, the normal use of generics, exemplified by the collections APIs, restricts you to a fixed number of type parameters per container.
You can get around this restriction by placing the type parameter on the key rather than the container.
You can use Class objects as keys for such typesafe heterogeneous containers.
A Class object used in this fashion is called a type token. You can also use a custom key type.
For example, you could have a DatabaseRow type representing a database row (the container), and a generic type Column<T> as its key.