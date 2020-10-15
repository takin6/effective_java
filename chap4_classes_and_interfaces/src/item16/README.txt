ITEM 16: IN PUBLIC CLASSES, USE ACCESSOR METHODS, NOT PUBLIC FIELDS
Occasionally, you may be tempted to write degenerate classes that serve no purpose other than to group instance fields:

- if a class is accessible outside its package, provide accessor methods
    - it is less harmful if the fields are immutable
- if a class is package-private or is a private nested class, there is nothing inherently wrong with exposing its data field


SUMMARY
In summary, public classes should never expose mutable fields.
It is less harmful, though still questionable, for public classes to expose immutable fields.
It is, however, sometimes desirable for package-private or private nested classes to expose fields, whether mutable or immutable.