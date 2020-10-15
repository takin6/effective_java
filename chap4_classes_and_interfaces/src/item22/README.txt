ITEM 22: USE INTERFACES ONLY TO DEFINE TYPES

- The constant interface pattern is a poor use of interfaces.
    - If you want to export constants, there are several reasonable choices. If the constants are strongly tied to an existing class or interface, you should add them to the class or interface.


SUMMARY
In summary, interfaces should be used only to define types. They should not be used merely to export constants.