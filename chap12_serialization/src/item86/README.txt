ITEM 86: IMPLEMENT SERIALIZABLE WITH GREAT CAUTION

- A major cost of implementing Serializable is that it decreases the flexibility to change a class’s implementation once it has been released.

- A second cost of implementing Serializable is that it increases the likelihood of bugs and security holes

- A third cost of implementing Serializable is that it increases the testing burden associated with releasing a new version of a class.

- Implementing Serializable is not a decision to be undertaken lightly.

- Classes designed for inheritance (Item 19) should rarely implement Serializable, and interfaces should rarely extend it.

SUMMARY
To summarize, the ease of implementing Serializable is specious.
Unless a class is to be used only in a protected environment where versions will never have to interoperate and servers will never be exposed to untrusted data,
implementing Serializable is a serious commitment that should be made with great care.
Extra caution is warranted if a class permits inheritance.

