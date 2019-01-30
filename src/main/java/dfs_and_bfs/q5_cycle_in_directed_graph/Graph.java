package dfs_and_bfs.q5_cycle_in_directed_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int V)
    {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclic()
    {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (!visited[i]){
                if(!dfsUtil(i,visited)){
                    return true;
                }
            }

        return false;
    }
    private boolean dfsUtil(int node, boolean visited[]){
        if(visited[node]){
            return false;
        } else {
            visited[node] = true;
            for(Integer next: adj.get(node)){
                if(!dfsUtil(next,visited)){
                    return false;
                }
            }
        }
        return true;
    }

    // Driver code
    public static void main(String[] args)
    {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
