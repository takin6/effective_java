ITEM 54: RETURN EMPTY COLLECTIONS OR ARRAYS, NOT NULLS

- error-prone, because the programmer writing the client might forget to write the special-case code to handle a null return

- it is possible to return empty collections and arrays without allocating them.
  Here is the typical code to return a possibly empty collection. Usually, this is all you need:
  //The right way to return a possibly empty collection
  public List<Cheese> getCheeses() {
      return new ArrayList<>(cheesesInStock);
  }

- returning the same immutable empty collection repeatedly, as immutable objects may be shared freely
  Collections.emptyList, Collections.emptySet, Collections.emptyMap
  // Optimization - avoids allocating empty collections
  public List<Cheese> getCheeses() {
      return cheesesInStock.isEmpty() ? Collections.emptyList()
          : new ArrayList<>(cheesesInStock);
  }

- The situation for arrays
  //The right way to return a possibly empty array
  public Cheese[] getCheeses() {
      return cheesesInStock.toArray(new Cheese[0]);
  }

  // Optimization - avoids allocating empty arrays
  private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

  public Cheese[] getCheeses() {
      return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
  }

SUMMARY
In summary, never return null in place of an empty array or collection.
It makes your API more difficult to use and more prone to error, and it has no performance advantages.
