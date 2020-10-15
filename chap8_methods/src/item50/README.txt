ITEM 50: MAKE DEFENSIVE COPIES WHEN NEEDED

- In a safe language, it is possible to write classes and to know with certainty that their invariants will hold,
  no matter what happens in any other part of the system.
- You must program defensively, with the assumption that clients of your class will do their best to destroy its invariants.

- defensive copies are made before checking the validity of the parameters (Item 49), and the validity check is performed on the copies rather than on the originals.
  It protects the class against changes to the parameters from another thread during the window of vulnerability between the time the parameters are checked and the time they are copied.

- do not use the clone method to make a defensive copy of a parameter whose type is subclassable by untrusted parties.

- Arguably, the real lesson in all of this is that you should, where possible, use immutable objects as components of your objects so that you don’t have to worry about defensive copying

SUMMARY
In summary, if a class has mutable components that it gets from or returns to its clients, the class must defensively copy these components.
If the cost of the copy would be prohibitive and the class trusts its clients not to modify the components inappropriately,
then the defensive copy may be replaced by documentation outlining the client’s responsibility not to modify the affected components.