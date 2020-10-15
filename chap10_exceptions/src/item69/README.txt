ITEM 69: USE EXCEPTIONS ONLY FOR EXCEPTIONAL CONDITIONS

• Because exceptions are designed for exceptional circumstances, there is little incentive for JVM implementors to make them as fast as explicit tests.
• Placing code inside a try-catch block inhibits certain optimizations that JVM implementations might otherwise perform.
• The standard idiom for looping through an array doesn’t necessarily result in redundant checks. Many JVM implementations optimize them away.

- If there is a bug in the loop, the use of exceptions for flow control can mask the bug, greatly complicating the debugging process.
-　Exceptions are, as their name implies, to be used only for exceptional conditions; they should never be used for ordinary control flow.

- A well-designed API must not force its clients to use exceptions for ordinary control flow.

- Here are some guidelines to help you choose between a state-testing method and an optional or distinguished return value.
  - If an object is to be accessed concurrently without external synchronization or is subject to externally induced state transitions,
    you must use an optional or distinguished return value, as the object’s state could change in the interval between the invocation of a state-testing method and its state-dependent method.

SUMMARY
In summary, exceptions are designed for exceptional conditions.
Don’t use them for ordinary control flow, and don’t write APIs that force others to do so.

