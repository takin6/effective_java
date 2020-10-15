package item43;

import java.util.Map;
import java.util.TreeMap;

public class Freq {
    public static void main(String[] args) {
        Map<String, Integer> frequesncyTable = new TreeMap<>();

        for (String s : args)
            frequesncyTable.merge(s, 1, (count, incr) -> count + incr); // lambda
        System.out.println(frequesncyTable);

        frequesncyTable.clear();
        for (String s: args)
            frequesncyTable.merge(s, 1, Integer::sum); // Method reference
        System.out.println(frequesncyTable);
    }
}
