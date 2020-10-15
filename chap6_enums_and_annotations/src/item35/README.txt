ITEM 35: USE INSTANCE FIELDS INSTEAD OF ORDINALS

- Never derive a value associated with an enum from its ordinal; store it in an instance field instead:

SUMMARY
The Enum specification has this to say about ordinal:
“Most programmers will have no use for this method.
It is designed for use by general-purpose enum-based data structures such as EnumSet and EnumMap.”
Unless you are writing code with this character, you are best off avoiding the ordinal method entirely.