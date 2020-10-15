ITEM 71: AVOID UNNECESSARY USE OF CHECKED EXCEPTIONS

- overuse of checked exceptions in APIs can make them far less pleasant to use.
- The easiest way to eliminate a checked exception is to return an optional of the desired result type
-

SUMMARY
In summary, when used sparingly, checked exceptions can increase the reliability of programs; when overused, they make APIs painful to use.
If callers won’t be able to recover from failures, throw unchecked exceptions.
If recovery may be possible and you want to force callers to handle exceptional conditions, first consider returning an optional.
Only if this would provide insufficient information in the case of failure should you throw a checked exception.

