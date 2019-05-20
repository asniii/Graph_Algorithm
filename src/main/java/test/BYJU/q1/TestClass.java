package test.BYJU.q1;

import java.io.*;
import java.util.*;


public class TestClass {
    static class Node{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String arrray[] = br.readLine().split(" ");
            int N = Integer.parseInt(arrray[0].trim());
            TestClass.N = N;
            int M = Integer.parseInt(arrray[1].trim());
            TestClass.M = M;
            int[][] A = new int[N][M];
            for(int i_A=0; i_A<N; i_A++)
            {
                String[] arr_A = br.readLine().split(" ");
                for(int j_A=0; j_A<arr_A.length; j_A++)
                {
                    A[i_A][j_A] = Integer.parseInt(arr_A[j_A]);
                }
            }

            String start[] = br.readLine().split(" ");
            int sx = Integer.parseInt(start[0].trim());
            int sy = Integer.parseInt(start[1].trim());
            int Q = Integer.parseInt(br.readLine().trim());
            //String[] arr_x = br.readLine().split(" ");
            int[] x = new int[Q];
            //String[] arr_y = br.readLine().split(" ");
            int[] y = new int[Q];

            for(int i=0; i<Q; i++)
            {
                String arr_x[] = br.readLine().split(" ");
                x[i] = Integer.parseInt(arr_x[0].trim());
                y[i] = Integer.parseInt(arr_x[1].trim());
            }


            int[] out_ = solve(A, x, sy, sx, y);
            for(int i_out_=0; i_out_<out_.length; i_out_++)
            {
                System.out.print(out_[i_out_]+"\n");
            }
        }

        wr.close();
        br.close();
    }
    static int[] solve(int[][] A, int[] x, int sy, int sx, int[] y) {
        // Write your code here
        sx--;
        sy--;
        int sol[][] = new int[N][M];

        /* Initialization of solution matrix */
        for (int z1 = 0; z1 < N; z1++){
            for (int z2 = 0; z2 < M; z2++) {
                sol[z1][z2] = -1;
            }
        }


        Node start = new Node(sx,sy,0);

        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).addLast(start);

        while(!queue.isEmpty()){
            Node n = ((LinkedList<Node>) queue).removeFirst();

            int xx = n.x;
            int yy = n.y;
            int count = n.count;

            if(sol[xx][yy] == -1){

                sol[xx][yy] = count;

                int value = A[xx][yy];

                for(int z3 = 0;z3<=value;z3++){

                    int x1 = z3;
                    int y1 = value-z3;
                    if(isSafe(xx+x1,yy+y1,sol)){

                        ((LinkedList<Node>) queue).addLast(new Node(xx+x1,yy+y1,count + 1));
                    }
                    if(isSafe(xx-x1,yy+y1,sol)){
                        ((LinkedList<Node>) queue).addLast(new Node(xx-x1,yy+y1,count+1));
                    }
                    if(isSafe(xx+x1,yy-y1,sol)){
                        ((LinkedList<Node>) queue).addLast(new Node(xx+x1,yy-y1,count+1));
                    }
                    if (isSafe(xx-x1,yy-y1,sol)){
                        ((LinkedList<Node>) queue).addLast(new Node(xx-x1,yy-y1,count+1));
                    }
                }

            }
        }

        int output[] = new int[x.length];
        for(int i = 0;i<x.length;i++){
            output[i] = sol[x[i]-1][y[i] -1];
        }
        return output;
    }





    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 &&
                y < M && sol[x][y] == -1);
    }
}