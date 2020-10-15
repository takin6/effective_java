package item81;

import java.util.concurrent.*;

// Concurrent canonicalizing map atop ConcurrencyMap
public class Intern {
    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

//    // Concurrent canonicalizing map atop ConcurrentMap - not optimal
//    public static String intern(String s) {
//        String previousValue = map.putIfAbsent(s, s);
//        return previousValue == null ? s : previousValue;
//    }

    // Concurrent canonicalizing map atop ConcurrentMap - faster!
    public static String intern(String s) {
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null)
                result = s;
        }
        return result;
    }
}
