import java.util.*;

/**
 * Created by monir on 5/20/2017.
 */
public class WeightedGraph extends Graph {

    //constructor
    public WeightedGraph(List<Vertex> r, List<Edge> edges) {
        super(r, edges);
    }


    //prints the whole graph information.also adds to string builder for UI.
    public String printWeightedEdges() {
        str.append("All edges are: " + "\n");
        for (int i = 0; i < getSize(); i++) {
            str.append("Vertex(" + i + ") : ");
            for (Edge edge : neighbors.get(i)) {
                str.append(" ( " + edge.start + ","
                        + edge.end + ", weight: " + edge.weight + " )");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public boolean addEdge(int start, int end, double weight) {
        return addEdge(new Edge(start, end, weight));
    }

    //BFS algorithm
    public Short bfs(int root) {
        List<Integer> path = new ArrayList<>();
        int[] parent = new int[r.size()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(root);
        seen.add(root);

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            path.add(poll);
            for (Edge y : neighbors.get(poll)) {
                if (!seen.contains(y.end)) {
                    queue.offer(y.end);
                    parent[y.end] = poll;
                    seen.add(y.end);
                }
            }
        }


        return new Short(root, parent, path);
    }




    //Dfs algorithm
    public Short dfs(int root) {
        List<Integer> path = new ArrayList<>();
        int[] parent = new int[r.size()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1;
        Set<Integer> seen = new HashSet<>();
        dfs(root, parent, path, seen);
        return new Short(root, parent, path);
    }

    private void dfs(int u, int[] parent, List<Integer> path, Set<Integer> seen) {
        path.add(u);
        seen.add(u);
        for (Edge y : neighbors.get(u)) {
            if (!seen.contains(y.end)) {
                parent[y.end] = u;
                dfs(y.end, parent, path, seen);
            }
        }

    }


    //Inner class short
    public class Short {

        private int root;
        private int[] parent;
        private List<Integer> searchOrder;
        private double[] cost;
        protected List<Vertex> r = new ArrayList<>();

        public Short(int source, int[] parent, List<Integer> searchOrder) {
            this.root = source;
            this.searchOrder = searchOrder;
            this.parent = parent;
        }

        public List<Integer> getSearchOrder() {
            return searchOrder;
        }

    }




}
