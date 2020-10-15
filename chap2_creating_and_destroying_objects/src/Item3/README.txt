ITEM 3: ENFORCE THE SINGLETON PROPERTY WITH A PRIVATE CONSTRUCTOR OR AN ENUM TYPE

- Making a class a singleton can make it difficult to test its clients
  because it’s impossible to substitute a mock implementation for a singleton
  unless it implements an interface that serves as its type.

- a single-element enum type is often the best way to implement a singleton.
