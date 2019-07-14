package test.hackerrank.test2.supportEngineer.q1;

/** HelloWorld
 *
 */
public class Solution {

    public static void main(String args[]){

        Solution.helloWorld(15);

    }


    public static void helloWorld(int n) {
        // Write your code here

        for(int i = 1;i<=n;i++){
            boolean flag = false;

            if(i%3 ==0){
                System.out.print("Hello");
                flag = true;
            }
            if(i%5 == 0){
                System.out.print("World");
                flag = true;
            }
            if(flag == false){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
