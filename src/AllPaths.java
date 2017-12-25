import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by monir on 5/28/2017.
 */

public class AllPaths{

    static StringBuilder stringBuilder=new StringBuilder();

    // the current path
    private Stack<Integer> stack = new Stack<>();

    // the set of vertices on the path
    private Set<Integer> onPath = new HashSet<>();

    public AllPaths(WeightedGraph G, Integer s, Integer t) {
        enumerate(G,s,t);
    }

    // use DFS
    public void enumerate(Graph G, Integer v, Integer t) {

        stack.push(v);
        onPath.add(v);

        if (v.equals(t)){
            printStack(stack);
        }

        else {
            for (Edge y : G.neighbors.get(v)) {
                if (!onPath.contains(y.end))
                    enumerate(G, y.end, t);
            }
        }
        stack.pop();
        onPath.remove(v);
    }

    public void printStack(Stack<Integer> s){
        for (Integer i:s) {
            stringBuilder.append(i+"  -> ");
        }
        stringBuilder.append("\n");

    }

}