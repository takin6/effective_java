package item53;

public class Varargs {
    static int sum(int... args) {
        int sum = 0;
        for (int arg: args) {
            sum += arg;
        }
        return sum;
    }

//    // The WRONG way to use varargs to pass one or more arguments!
//    // 1. if the client invokes this method with no arguments, it fails at runtime rather than compile time.
//    // 2. ugly
//    static int min(int... args) {
//        if (args.length == 0)
//            throw new IllegalArgumentException("Too few arguments");
//        int min = args[0];
//        for (int i=1; i<args.length; i++)
//            if (args[i] < min)
//                min = args[i];
//        return min;
//    }

    static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg: remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }
}
