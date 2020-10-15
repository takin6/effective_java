ITEM 23: PREFER CLASS HIERARCHIES TO TAGGED CLASSES

-  In short, tagged classes are verbose, error-prone, and inefficient.
- A tagged class is just a pallid imitation of a class hierarchy.

SUMMARY
In summary, tagged classes are seldom appropriate.
If you’re tempted to write a class with an explicit tag field, think about whether the tag could be eliminated and the class replaced by a hierarchy.
When you encounter an existing class with a tag field, consider refactoring it into a hierarchy.

