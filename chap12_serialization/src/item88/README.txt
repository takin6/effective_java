ITEM 88: WRITE READOBJECT METHODS DEFENSIVELY

SUMMARY
To summarize, anytime you write a readObject method, adopt the mind-set that you are writing a public constructor that must produce a valid instance
regardless of what byte stream it is given.
Do not assume that the byte stream represents an actual serialized instance.
While the examples in this item concern a class that uses the default serialized form,
all of the issues that were raised apply equally to classes with custom serialized forms.
Here, in summary form, are the guidelines for writing a readObject method:

• For classes with object reference fields that must remain private, defensively copy each object in such a field. Mutable components of immutable classes fall into this category.

• Check any invariants and throw an InvalidObjectException if a check fails. The checks should follow any defensive copying.

• If an entire object graph must be validated after it is deserialized, use the ObjectInputValidation interface (not discussed in this book).

• Do not invoke any overridable methods in the class, directly or indirectly.


