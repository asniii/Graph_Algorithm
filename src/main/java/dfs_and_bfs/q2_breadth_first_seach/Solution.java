package dfs_and_bfs.q2_breadth_first_seach;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    static class Graph {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; //Adjacency Lists

        // Constructor
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v,int w)
        {
            adj[v].add(w);
        }

        void BFS(int s){
            int visited[] = new int[V];
            List<Integer> queue = new LinkedList<Integer>();
            queue.add(s);
            visited[s] = 1;
            while(queue.size()>0){
                int current_node = ((LinkedList<Integer>) queue).removeFirst();
                System.out.print(current_node + "  ");
                for(Integer next: adj[current_node]){
                    if(visited[next] == 0){
                        visited[next] = 1;
                        queue.add(next);
                    }
                }
            }
        }

    }


    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);

    }
}
