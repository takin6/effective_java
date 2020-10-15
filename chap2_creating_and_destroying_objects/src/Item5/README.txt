ITEM 5: PREFER DEPENDENCY INJECTION TO HARDWIRING RESOURCES

Many classes depend on one or more underlying resources.
For example, a spell checker depends on a dictionary.
It is not uncommon to see such classes implemented as static utility classesg

""Static utility classes and singletons are inappropriate for classes
  whose behavior is parameterized by an underlying resource.""
  (ie. spellchecker's behavior is parameterized by dictionaries)

=> What is required is the ability to support multiple instances of the class (in our example, SpellChecker),
   each of which uses the resource desired by the client (in our example, the dictionary).
   A simple pattern that satisfies this requirement is to pass the resource into the constructor when creating a new instance.
   This is one form of dependency injection: the dictionary is a dependency of the spell checker and is injected into the spell checker when it is created.


In summary, do not use a singleton or static utility class to implement a class that depends on one or more underlying resources whose behavior affects that of the class,
and do not have the class create these resources directly.
Instead, pass the resources, or factories to create them, into the constructor (or static factory or builder).
This practice, known as dependency injection, will greatly enhance the flexibility, reusability, and testability of a class