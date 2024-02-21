import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraWithTurnsAndNodes {
    static final int INF = Integer.MAX_VALUE;

    public static List<List<Integer>> dijkstra(int[][] graph, int start, int destination) {
        int vertices = graph.length;
        int[] dist = new int[vertices];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.offer(new Node(start, 0, 0));

        List<List<Integer>> paths = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int u = node.vertex;
            int currentDist = node.distance;
            int turns = node.turns;

            if (currentDist > dist[u]) {
                continue;
            }

            for (int v = 0; v < vertices; v++) {
                int weight = graph[u][v];

                if (weight != 0) {
                    int newDist = dist[u] + weight;
                    int newTurns = turns + 1;

                    if (newDist < dist[v] || (newDist == dist[v] && newTurns < turns)) {
                        dist[v] = newDist;
                        minHeap.offer(new Node(v, newDist, newTurns));

                        // Update paths
                        List<Integer> newPath = new ArrayList<>(paths.get(u));
                        newPath.add(u);
                        paths.add(newPath);
                    }
                }
            }
        }

        // Add the destination node to all paths
        for (List<Integer> path : paths) {
            path.add(destination);
        }

        return paths;
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;
        int turns;

        public Node(int vertex, int distance, int turns) {
            this.vertex = vertex;
            this.distance = distance;
            this.turns = turns;
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance != other.distance) {
                return Integer.compare(this.distance, other.distance);
            } else {
                return Integer.compare(this.turns, other.turns);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 4, 0, 0, 0, 4},
                {1, 0, 2, 3, 1, 0, 0, 0},
                {0, 2, 0, 1, 3, 1, 0, 0},
                {4, 3, 1, 0, 5, 0, 0, 0},
                {0, 1, 3, 5, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0, 2, 0},
                {0, 0, 0, 0, 0, 2, 0, 4},
                {4, 0, 0, 0, 0, 0, 4, 0}
        };

        int startVertex = 0;
        int destinationVertex = 5;

        List<List<Integer>> paths = dijkstra(graph, startVertex, destinationVertex);

        System.out.println("Paths with the least number of nodes:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}


sample Graph:

       0
      / \
     1 - 2
      \ |
       3 - 4
        \|
         5


output : 
Paths with the least number of nodes:
[0, 1, 2, 3, 4, 5]
[0, 1, 2, 3, 5]
[0, 1, 2, 4, 5]
[0, 2, 3, 4, 5]
[0, 2, 3, 5]
[0, 2, 4, 5]

