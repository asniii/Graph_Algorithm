package test.hackerrank.test1.solutionEngineer.q2;

import java.util.*;

public class Solution {

    public static void main(String args[]){
        Solution.arrange1("Here i come.");
    }

    public static String arrange(String sentence) {
        // Write your code here

        String input = sentence.toLowerCase();

        input = input.substring(0, input.length() - 1);

        String arr[] = input.split(" ");

        Map<String , Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            map.put(arr[i],i);
        }

        Arrays.sort(arr,(a,b)->{
            if(a.length() >b.length())
                return 1;
            if(a.length() <b.length())
                return -1;
            else
                return map.get(a) - map.get(b);
        });

        StringJoiner stringJoiner = new StringJoiner(" ","",".");
        for(int i = 0;i<arr.length;i++){
            stringJoiner.add(arr[i]);
        }
        String output = stringJoiner.toString();
        if(output.length()>=1){
            char ch = output.charAt(0);
            char ch1 = Character.toUpperCase(ch);
            output = ch1 + output.substring(1,output.length());
        }
        System.out.println(output);
        return output;
    }

    public static String arrange1(String sentence){
        if(sentence.charAt(sentence.length()-1)=='.')
            sentence = sentence.substring(0,sentence.length()-1).toLowerCase();
        else
            sentence = sentence.toLowerCase();
        String temp[] = sentence.split(" ");
        Map<Integer, List<String>> mapOfStrings = new HashMap<>();
        for (String s:temp) {
            int size = s.length();
            if(mapOfStrings.get(size)==null) {
                List<String> l = new ArrayList<>();
                mapOfStrings.put(size,l);
            }
            mapOfStrings.get(size).add(s);
        }

        StringJoiner stringJoiner = new StringJoiner(" ", "", ".");
        String result = "";
        mapOfStrings.entrySet();
        Integer iarr[] = (Integer[]) mapOfStrings.entrySet().toArray();
        List<Integer> l1 = Arrays.asList(iarr);
        Collections.sort(l1);
        for (Integer i : l1) {
            for (String s1:mapOfStrings.get(i))
                stringJoiner.add(s1);
        }
        result = stringJoiner.toString();
        result = result.substring(0,1).toUpperCase() + result.substring(1,result.length());
        return result;
    }
}
