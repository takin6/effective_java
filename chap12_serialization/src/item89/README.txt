ITEM 89: FOR INSTANCE CONTROL, PREFER ENUM TYPES TO READRESOLVE

SUMMARY
To summarize, use enum types to enforce instance control invariants wherever possible.
If this is not possible and you need a class to be both serializable and instance-controlled,
you must provide a readResolve method and ensure that all of the class’s instance fields are either primitive or transient.

