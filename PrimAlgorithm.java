package practice;
import java.util.*;

class PrimAlgorithm {
    // Helper class to represent an edge between two vertices
    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Function to find the Minimum Spanning Tree using Prim's algorithm
    static List<Edge> primMST(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        List<Edge> mstEdges = new ArrayList<>();

        // Choose the starting vertex (can be any vertex, here choosing the first one)
        visited[0] = true;

        // Run the algorithm until all vertices are included in the MST
        while (mstEdges.size() < V - 1) {
            int minWeight = Integer.MAX_VALUE;
            Edge minEdge = null;

            // Loop through all visited vertices and find the minimum weight edge
            for (int src = 0; src < V; src++) {
                if (visited[src]) {
                    for (int dest = 0; dest < V; dest++) {
                        if (!visited[dest] && graph[src][dest] != 0 && graph[src][dest] < minWeight) {
                            minWeight = graph[src][dest];
                            minEdge = new Edge(src, dest, minWeight);
                        }
                    }
                }
            }

            // Add the minimum weight edge to the MST
            if (minEdge != null) {
                mstEdges.add(minEdge);
                visited[minEdge.dest] = true;
            }
        }

        return mstEdges;
    }

    public static void main(String[] args) {
        // Example graph represented by an adjacency matrix (0 means no edge)
        int[][] graph = {
            {0, 2, 2, 0},
            {2, 0, 0, 1},
            {2, 0, 0, 5},
            {0, 1, 5, 0}
        };

        List<Edge> mst = primMST(graph);

        // Print the edges of the Minimum Spanning Tree
        System.out.println("Edges of the Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " weight: " + edge.weight);
        }
        
    }
}
