ITEM 74: DOCUMENT ALL EXCEPTIONS THROWN BY EACH METHOD

SUMMARY
In summary, document every exception that can be thrown by each method that you write.
This is true for unchecked as well as checked exceptions, and for abstract as well as concrete methods.
This documentation should take the form of @throws tags in doc comments.
Declare each checked exception individually in a method’s throws clause, but do not declare unchecked exceptions.
If you fail to document the exceptions that your methods can throw, it will be difficult or impossible for others to make effective use of your classes and interfaces.
