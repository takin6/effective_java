ITEM 90: CONSIDER SERIALIZATION PROXIES INSTEAD OF SERIALIZED INSTANCES

SUMMARY
In summary, consider the serialization proxy pattern whenever you find yourself having to write a readObject or writeObject method on a class that is not extendable by its clients.
This pattern is perhaps the easiest way to robustly serialize objects with nontrivial invariants.