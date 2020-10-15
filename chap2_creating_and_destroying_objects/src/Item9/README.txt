The Java libraries include many resources that must be closed manually by invoking a close method.
Examples include InputStream, OutputStream, and java.sql.Connection.
Closing resources is often overlooked by clients, with predictably dire performance consequences.
While many of these resources use finalizers as a safety net, finalizers don’t work very well



- All of these problems were solved in one fell swoop when Java 7 introduced the try-with-resources statement.
To be usable with this construct, a resource must implement the AutoCloseable interface, which consists of a single void-returning close method.
Many classes and interfaces in the Java libraries and in third-party libraries now implement or extend AutoCloseable.
If you write a class that represents a resource that must be closed, your class should implement AutoCloseable too.


- If exceptions are thrown by both the readLine call and the (invisible) close,
  the latter exception is suppressed in favor of the former.

- You can put catch clauses on try-with-resources statements, just as you can on regular try-finally statements.

SUMMARY
The lesson is clear: Always use try-with-resources in preference to try-finally when working with resources that must be closed.
The resulting code is shorter and clearer, and the exceptions that it generates are more useful. The try-with-resources statement makes it easy to write correct code using resources that must be closed, which was practically impossible using try-finally.