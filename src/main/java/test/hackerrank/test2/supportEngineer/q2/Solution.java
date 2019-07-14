package test.hackerrank.test2.supportEngineer.q2;

public class Solution {

    public static void main(String args[]){
        Solution.lastLetters("APPLE");
    }

    public static String lastLetters(String word) {
        // Write your code here

        char ch1 = word.charAt(word.length() -1);
        char ch2 = word.charAt(word.length() -2);

        String output = ch1+" " + ch2;
        System.out.println(output);
        return output;

    }
}
