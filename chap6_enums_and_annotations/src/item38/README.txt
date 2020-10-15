ITEM 38: EMULATE EXTENSIBLE ENUMS WITH INTERFACES


SUMMARY
In summary, while you cannot write an extensible enum type,
you can emulate it by writing an interface to accompany a basic enum type that implements the interface.
This allows clients to write their own enums (or other types) that implement the interface.
Instances of these types can then be used wherever instances of the basic enum type can be used, assuming APIs are written in terms of the interface.