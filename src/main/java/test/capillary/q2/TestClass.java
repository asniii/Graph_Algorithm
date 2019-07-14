package test.capillary.q2;

import java.util.ArrayList;
import java.util.Scanner;

class TestClass {

    static ArrayList<Node> nodes = new ArrayList<>();
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        String str[] = name.split(" ");
        int n = Integer.parseInt(str[0]);
        int q = Integer.parseInt(str[1]);

        String inputstr = s.nextLine();
        char charArr[] = inputstr.toCharArray();

        for(int i = 0;i<n;i++){
            nodes.add(new Node(i));
        }

        for(int i = 0;i<n-1;i++){
            String temp = s.nextLine();
            String tempArr[] = temp.split(" ");
            int start = Integer.parseInt(tempArr[0]);
            int end = Integer.parseInt(tempArr[1]);

            nodes.get(start-1).list.add(end-1);
        }
        rec(nodes.get(0),charArr);

        for(int i = 0;i<q;i++){
            String temp = s.nextLine();
            String tempArr[] = temp.split(" ");
            int node = Integer.parseInt(tempArr[0]);
            char ch = tempArr[1].charAt(0);

            System.out.println(nodes.get(node-1).arr[ch-97]);
        }
    }

    public static int[] rec(Node root,char[] charArr){
        char ch = charArr[root.id];
        root.arr[charArr[root.id]-97] = 1;

        for(int i = 0;i<root.list.size();i++){
            int temp[] = rec(nodes.get(root.list.get(i)),charArr);

            for(int j = 0;j<26;j++){
                root.arr[j] += temp[j];
            }
        }
        return root.arr;
    }
}
