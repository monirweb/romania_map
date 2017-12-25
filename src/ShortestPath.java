import java.util.HashSet;
import java.util.Set;

/**
 * Created by monir on 5/30/2017.
 */
public class ShortestPath {
    static StringBuilder str=new StringBuilder();
    final int V = 20;

    int minDistance(int dist[], Set<Integer> sptSet) {
        int min = 9999, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet.contains(v) && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[], int n) {
        str.append("Vertex   Distance from Source"+"\n");
        for (int i = 0; i < V; i++)
            str.append(i + " \t\t " + dist[i]+"\n");
    }

    void dijkstra(int graph[][], int src) {
        int cost[] = new int[V];

        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < V; i++) {
            cost[i] = 9999;   //means a big number !
            seen.remove(i);
        }
        cost[src] = 0;

        for (int k = 0; k < V - 1; k++) {
            int u = minDistance(cost, seen);
            seen.add(u);
            for (int v = 0; v < V; v++)
                if (!seen.contains(v) && graph[u][v] != 0 &&
                        cost[u] != 9999 &&
                        cost[u] + graph[u][v] < cost[v])
                    cost[v] = cost[u] + graph[u][v];
        }
        printSolution(cost, V);
    }

}
