ITEM 21: DESIGN INTERFACES FOR POSTERITY

- In the presence of default methods, existing implementations of an interface may compile without error or warning but fail at runtime

- The moral is clear. Even though default methods are now a part of the Java platform, it is still of the utmost importance to design interfaces with great care.

SUMMARY
Therefore, it is critically important to test each new interface before you release it.
Multiple programmers should implement each interface in different ways.
At a minimum, you should aim for three diverse implementations.
Equally important is to write multiple client programs that use instances of each new interface to perform various tasks.
This will go a long way toward ensuring that each interface satisfies all of its intended uses.
These steps will allow you to discover flaws in interfaces before they are released, when you can still correct them easily.
While it may be possible to correct some interface flaws after an interface is released, you cannot count on it.