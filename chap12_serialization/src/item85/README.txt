ITEM 85: PREFER ALTERNATIVES TO JAVA SERIALIZATION

- A fundamental problem with serialization is that its attack surface is too big to protect, and constantly growing
  Object graphs are deserialized by invoking the readObject method on an ObjectInputStream.

- Java deserialization is a clear and present danger as it is widely used both directly by applications and indirectly by Java subsystems such as RMI


SUMMARY
In summary, serialization is dangerous and should be avoided.
If you are designing a system from scratch, use a cross-platform structured-data representation such as JSON or protobuf instead.
Do not deserialize untrusted data. If you must do so, use object deserialization filtering, but be aware that it is not guaranteed to thwart all attacks.
Avoid writing serializable classes. If you must do so, exercise great caution.