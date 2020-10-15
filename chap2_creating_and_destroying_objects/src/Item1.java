
// ITEM1: Consider static factory methods instead of Constructors
//- pubilc static factory method
//
//Advantages
//- unlike constructors, they have names
//    - [bad idea] Providing two constructors whose parameter lists differ noly in the order of their parameter types
//
//- unlike constructors, they are not required to create a new object each time they're invoked.
//    - never created an object, return the same object from repeated invokations
//    - Allow immutable classes to use preconstructed instances, or to cache instances as they’re constructed
//    - Boolean.valueOf(boolean)
//    - Similar to Flyweight Pattern
//
//- Unlike constructors, they can return an object of any subtype of their return type.
//
//- the class of the returned object can vary from call to call as a function of the input parameters.
//
//- The class of the reterned object need not exist when the class containing the method is written.

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.sql.Date;
import java.util.EnumSet;

public class Item1 {
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public static void main(String[] args) {
        System.out.println(Item1.valueOf(true));

        // Examples

        // from: type-conversion method
        // Date d = Date.from(instant);

        // of: aggregation method
        // Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);

        // verbose alternative of from and of
        BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
        System.out.println(prime);

        // instance || getInstance: described by its parameters
        // StackWalker luke = StackWaker.geInstance(options)
        // Object newArray = Array.newInstance(classobject, arrayLen)

        // getType: like getInstance, but used if the factory method is in a different class
        // FileStore fs = Files.getFileStore(path)
    }
}