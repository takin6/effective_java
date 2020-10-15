ITEM 34: USE ENUMS INSTEAD OF INT CONSTANTS

- The basic idea behind Java’s enum types is simple:
  they are classes that export one instance for each enumeration constant via a public static final field.

- enum types let you add arbitrary methods and fields and implement arbitrary interfaces.
  They provide high-quality implementations of all the Object methods (Chapter 3), they implement Comparable (Item 14) and Serializable

-  You can add or reorder constants in an enum type without recompiling its clients because the fields that export the constants provide a layer of insulation between an enum type and its client

- So why would you want to add methods or fields to an enum type?
    - you might want to associate data with its constants. Our Apple and Orange types, for example, might benefit from a method that returns the color of the fruit, or one that returns an image of it.
      You can augment an enum type with any method that seems appropriate. An enum type can start life as a simple collection of enum constants and evolve over time into a full-featured abstraction.

- To associate data with enum constants, declare instance fields and write a constructor that takes the data and stores it in the fields

- sometimes you need to associate fundamentally different behavior with each constant.

- Switches on enums are good for augmenting enum types with constant-specific behavior.

- When should you use enums?
    - Use enums any time you need a set of constants whose members are known at compile time.
    - It is not necessary that the set of constants in an enum type stay fixed for all time.

SUMMARY
In summary, the advantages of enum types over int constants are compelling.
Enums are more readable, safer, and more powerful.
Many enums require no explicit constructors or members,
but others benefit from associating data with each constant and providing methods whose behavior is affected by this data.
Fewer enums benefit from associating multiple behaviors with a single method.
In this relatively rare case, prefer constant-specific methods to enums that switch on their own values.
Consider the strategy enum pattern if some, but not all, enum constants share common behaviors.