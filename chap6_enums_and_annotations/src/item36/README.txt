ITEM 36: USE ENUMSET INSTEAD OF BIT FIELDS


SUMMARY
In summary, just because an enumerated type will be used in sets, there is no reason to represent it with bit fields.
The EnumSet class combines the conciseness and performance of bit fields with all the many advantages of enum types described in Item 34.
The one real disadvantage of EnumSet is that it is not, as of Java 9, possible to create an immutable EnumSet,
but this will likely be remedied in an upcoming release. In the meantime, you can wrap an EnumSet with Collections.unmodifiableSet, but conciseness and performance will suffer.