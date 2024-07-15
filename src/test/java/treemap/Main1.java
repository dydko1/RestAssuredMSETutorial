package treemap;

import java.util.Map;
import java.util.TreeMap;

public class Main1 {
    public static void main(String[] args) {

        Map<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("A", 1);
        treeMap.put("B", 2);
        treeMap.put("C", 3);

        treeMap.remove("B");

        for (String key : treeMap.keySet()) {
            System.out.println("Key: " + key + " value: " + treeMap.get(key));
        }
    }
}
