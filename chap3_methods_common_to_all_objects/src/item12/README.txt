ITEM 12: ALWAYS OVERRIDE TOSTRING

- The general contract for toString says that the returned string should be “a concise but informative representation that is easy for a person to read.”

- When practical, the toString method should return all of the interesting information contained in the object

- Whether or not you decide to specify the format, you should clearly document your intentions.

SUMMARY
To recap, override Object’s toString implementation in every instantiable class you write, unless a superclass has already done so.
It makes classes much more pleasant to use and aids in debugging.
The toString method should return a concise, useful description of the object, in an aesthetically pleasing format.