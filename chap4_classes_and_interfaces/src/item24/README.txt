ITEM 24: FAVOR STATIC MEMBER CLASSES OVER NONSTATIC

-A nested class is a class defined within another class
- There are four kinds of nested classes:
    - static member classes
    - nonstatic member classes
    - anonymous classes
    - local classes

SUMMARY
To recap, there are four different kinds of nested classes, and each has its place.
If a nested class needs to be visible outside of a single method or is too long to fit comfortably inside a method, use a member class.
If each instance of a member class needs a reference to its enclosing instance, make it nonstatic; otherwise, make it static.
Assuming the class belongs inside a method, if you need to create instances from only one location and there is a preexisting type that characterizes the class, make it an anonymous class; otherwise, make it a local class.