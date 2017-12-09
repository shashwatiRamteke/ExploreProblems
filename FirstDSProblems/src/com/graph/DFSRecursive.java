package com.graph;

import java.util.ArrayList;

public class DFSRecursive {

    static class Graph{
        int V;
        ArrayList<Integer> adj[];
        boolean[] visited;

        public Graph(int v)
        {
            this.V =v;
            adj = new ArrayList[v];
            visited = new boolean[V];
            for(int i =0;i<v;i++){
                adj[i] = new ArrayList<Integer>();
                visited[i] = false;
            }
        }
        void addEdge(int v, int w)
        {
            adj[v].add(w);    // Add w to v's list.
        }

        void DFSUtil(int i){
            visited[i] = true;
            System.out.print(i);

            adj[i].forEach(element -> {
                if (!visited[element]){
                    DFSUtil(element);
                }
            });
        }

        void DFS()
        {
            // Mark all the vertices as not visited(set as
            // false by default in java)
            //boolean visited[] = new boolean[V];
              setVisitedFalse();
            // Call the recursive helper function to print DFS traversal
            // starting from all vertices one by one
//            for (int i=0; i<V; ++i)
//                if (visited[i] == false)
                    DFSUtil(0);
        }

        void setVisitedFalse() {
            for (int i = 0; i < V; i++){
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);


        System.out.println("Following is Depth First Traversal");

        g.DFS();
    }
}
