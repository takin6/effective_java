ITEM 87: CONSIDER USING A CUSTOM SERIALIZED FORM

SUMMARY
To summarize, if you have decided that a class should be serializable (Item 86), think hard about what the serialized form should be.
Use the default serialized form only if it is a reasonable description of the logical state of the object;
otherwise design a custom serialized form that aptly describes the object.
You should allocate as much time to designing the serialized form of a class as you allocate to designing an exported method (Item 51).
Just as you can’t eliminate exported methods from future versions, you can’t eliminate fields from the serialized form;
they must be preserved forever to ensure serialization compatibility.
Choosing the wrong serialized form can have a permanent, negative impact on the complexity and performance of a class.