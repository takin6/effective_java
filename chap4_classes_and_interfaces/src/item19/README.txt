ITEM 19: DESIGN AND DOCUMENT FOR INHERITANCE OR ELSE PROHIBIT IT

- First, the class must document precisely the effects of overriding any method.
  In other words, the class must document its self-use of overridable methods.

- Designing for inheritance involves more than just documenting patterns of self-use.
  To allow programmers to write efficient subclasses without undue pain, a class may have to provide hooks into its internal workings in the form of judiciously chosen protected methods

- Implementation Requirements: This implementation gets a list iterator positioned before fromIndex and repeatedly calls ListIterator.next followed by ListIterator.remove,
  until the entire range has been removed.
  Note: If ListIterator.remove requires linear time, this implementation requires quadratic time.

- Constructors must not invoke overridable methods, directly or indirectly


SUMMARY
In summary, designing a class for inheritance is hard work.
You must document all of its self-use patterns, and once you’ve documented them, you must commit to them for the life of the class.
If you fail to do this, subclasses may become dependent on implementation details of the superclass and may break if the implementation of the superclass changes.
To allow others to write efficient subclasses, you may also have to export one or more protected methods.
Unless you know there is a real need for subclasses, you are probably better off prohibiting inheritance by declaring your class final or ensuring that there are no accessible constructors.







