ITEM 11: ALWAYS OVERRIDE HASHCODE WHEN YOU OVERRIDE EQUALS

You must override hashCode in every class that overrides equals.

• If two objects are equal according to the equals(Object) method, then calling hashCode on the two objects must produce the same integer result.

• If two objects are unequal according to the equals(Object) method, it is not required that calling hashCode on each of the objects must produce distinct results.
　However, the programmer should be aware that producing distinct results for unequal objects may improve the performance of hash tables.

Simple Recipe
1. Declare an int variable named result, and initialize it to the hash code c for the first significant field in your object,
2. For every remaining significant field f in your object, do the following:
    a. Compute an int hash code c for the field:
        i. If the field is of a primitive type, compute Type.hashCode(f), where Type is the boxed primitive class corresponding to f’s type.
        ii. If the field is an object reference and this class’s equals method compares the field by recursively invoking equals, recursively invoke hashCode on the field.
        iii. If the field is an array, treat it as if each significant element were a separate field.
    b. Combine the hash code c computed in step 2.a into result as follows:
    result = 31 * result + c;
3. Return result.

Don’t provide a detailed specification for the value returned by hashCode, so clients can’t reasonably depend on it; this gives you the flexibility to change it.

SUMMARY
In summary, you must override hashCode every time you override equals, or your program will not run correctly.
Your hashCode method must obey the general contract specified in Object and must do a reasonable job assigning unequal hash codes to unequal instances.
This is easy to achieve, if slightly tedious, using the recipe on page 51. As mentioned in Item 10, the AutoValue framework provides a fine alternative to writing equals and hashCode methods manually, and IDEs also provide some of this functionality.

