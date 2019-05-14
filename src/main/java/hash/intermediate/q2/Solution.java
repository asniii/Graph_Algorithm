package hash.intermediate.q2;

import java.util.*;

public class Solution {

    static Map<String, Integer> result = new HashMap<String, Integer>();

    // Driver function
    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");

        populateResult(dataSet);
        System.out.println("result = " + result);
    }

    private static void populateResult(Map<String, String> dataSet) {

        Map<String, List<String>> map = new HashMap<>();
        Set<String> set = dataSet.keySet();

        for (String s : set) {
            String key = s;
            String value = dataSet.get(s);

            if (!map.containsKey(value)) {
                List<String> list = new ArrayList<>();
                list.add(key);
                map.put(value, list);
            } else {
                List<String> list = map.get(value);
                list.add(key);
            }
        }

        for (String s : set) {
            result.put(s, rec(map, s));
        }
    }

    private static int rec(Map<String, List<String>> map, String s) {
        int res = 0;
        if (map.containsKey(s)) {
            for (String s1 : map.get(s)) {
                if (s1 == s) {
                    res += 1;
                } else {
                    res += rec(map, s1);
                }
            }
            res += map.get(s).size();
        }
        return res;
    }


}
