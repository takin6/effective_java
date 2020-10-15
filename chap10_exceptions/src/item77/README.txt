ITEM 77: DON’T IGNORE EXCEPTIONS

- An empty catch block defeats the purpose of exceptions
- If you choose to ignore an exception, the catch block should contain a comment explaining why it is appropriate to do so,
  and the variable should be named ignored:

- The advice in this item applies equally to checked and unchecked exceptions