ITEM 82: DOCUMENT THREAD SAFETY

- The presence of the synchronized modifier in a method declaration is an implementation detail, not a part of its API.

- To enable safe concurrent use, a class must clearly document what level of thread safety it supports.

- The following list summarizes levels of thread safety
    - Immutable
    - Unconditionally thread-safe: Instances of this class are mutable, but the class has sufficient internal synchronization that its instances can be used concurrently without the need for any external synchronization.
    - Conditionally thread-safe: some methods require external synchronization for safe concurrent use
    - Not thread-safe
    - Thread-hostile: unsafe for concurrent use even if every method invocation is surrounded by external synchronization

- Lock fields should always be declared final.

SUMMARY
To summarize, every class should clearly document its thread safety properties with a carefully worded prose description or a thread safety annotation.
The synchronized modifier plays no part in this documentation. Conditionally thread-safe classes must document which method invocation sequences require external synchronization
and which lock to acquire when executing these sequences.
If you write an unconditionally thread-safe class, consider using a private lock object in place of synchronized methods.
This protects you against synchronization interference by clients and subclasses and gives you more flexibility
to adopt a sophisticated approach to concurrency control in a later release.

