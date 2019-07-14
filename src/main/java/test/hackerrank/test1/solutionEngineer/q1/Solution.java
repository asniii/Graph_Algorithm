package test.hackerrank.test1.solutionEngineer.q1;

/** FizzBuzz
 *
 */
public class Solution {

    public static void main(String args[]){

        Solution.fizzBuzz(15);

    }


    public static void fizzBuzz(int n) {
        // Write your code here

        for(int i = 1;i<=n;i++){
            boolean flag = false;

            if(i%3 ==0){
                System.out.print("Fizz");
                flag = true;
            }
            if(i%5 == 0){
                System.out.print("Buzz");
                flag = true;
            }
            if(flag == false){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
