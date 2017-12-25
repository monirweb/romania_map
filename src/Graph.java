import java.util.ArrayList;
import java.util.List;

/**
 * Created by monir on 5/20/2017.
 */
public class Graph {

    //ArrayList for saving vertices
    protected List<Vertex> r=new ArrayList<>();

    //creating a graph of vertices and edges
    protected List<List<Edge>> neighbors=new ArrayList<>();



    //this is for UI of project to show texts in main frame
    static StringBuilder str=new StringBuilder();


    //constructor
    protected Graph(){

    }
    //it adds vertices and edges to create the whole graph
    protected Graph(List<Vertex> r, List<Edge> edges){
        for(int i=0;i<r.size();i++)
            addVertex(r.get(i));
        for (Edge e:edges)
            addEdge(e.start,e.end ,e.weight);
    }


    //number of nodes (cities)
    public int getSize() {
        return r.size();
    }

    //list of vertices
    public List<Vertex> getVertices() {
        return r;
    }


    //it gets the node number and returns name of it(name of city)
    public String getVertex(int index) {
        return r.get(index).toString();
    }

    //gets the vertex object and returns its index
    public int getIndex(Vertex v) {
        return r.indexOf(v);
    }


    //this returns all the neighbours of a node
    //witch is all ends connected to the source node
    public List<Integer> getNeighbors(int index) {
        List<Integer> result=new ArrayList<>();
        for(Edge e:neighbors.get(index))
            result.add(e.end);
        return result;
    }

    //this adds a node(city)
    public boolean addVertex(Vertex v) {
        if(!r.contains(v)){

            r.add(v);
            neighbors.add(new ArrayList<Edge>());
            return true;
        }
        return false;
    }

    //this adds an edge
    public boolean addEdge(Edge e){
        if(e.start<0||e.start>getSize()-1)
            throw new IllegalArgumentException("No such index"+e.start);
        if(e.end<0||e.end>getSize()-1)
            throw new IllegalArgumentException("No such index"+e.end);
        if(!neighbors.get(e.start).contains(e))
        {
            neighbors.get(e.start).add(e);
            return true;
        }
        else return false;

    }

    //adding edge using start,end,weight
    public boolean addEdge(int start,int end ,double weight) {
        return addEdge(new Edge(start, end ,weight));
    }

}
