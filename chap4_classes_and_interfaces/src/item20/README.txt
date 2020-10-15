ITEM 20: PREFER INTERFACES TO ABSTRACT CLASSES

- Existing classes can easily be retrofitted to implement a new interface.
- Interfaces are ideal for defining mixins
    -  mixin is a type that a class can implement in addition to its “primary type,” to declare that it provides some optional behavior.
    ex) comparable

- Interfaces allow for the construction of nonhierarchical type frameworks.

- Interfaces enable safe, powerful functionality enhancements via the wrapper class idiom

- You can, however, combine the advantages of interfaces and abstract classes by providing an abstract skeletal implementation class to go with an interface.
    =>  skeletal implementation classes are called AbstractInterface,

SUMMARY
To summarize, an interface is generally the best way to define a type that permits multiple implementations.
If you export a nontrivial interface, you should strongly consider providing a skeletal implementation to go with it.
To the extent possible, you should provide the skeletal implementation via default methods on the interface so that all implementors of the interface can make use of it.
That said, restrictions on interfaces typically mandate that a skeletal implementation take the form of an abstract class.