import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Test extends Application  {

    Text tdfs=new Text();
    Text tbfs=new Text();
    Text tinfo=new Text();
    Text tbetween=new Text();
    Text tdij=new Text();
    Text tpath=new Text();
    StringBuilder spath=new StringBuilder(tdfs.getText());
    StringBuilder sdfs=new StringBuilder(tdfs.getText());
    StringBuilder sbfs=new StringBuilder(tbfs.getText());
    StringBuilder sinfo=new StringBuilder(tbfs.getText());
    StringBuilder sdijk=new StringBuilder(tdij.getText());

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        tdfs.setFont(new Font("Comic Sans Ms", 13));
        tdfs.setLayoutY(65);
        tdfs.setLayoutX(800);
        tbfs.setFont(new Font("Comic Sans Ms", 13));
        tbfs.setLayoutY(65);
        tbfs.setLayoutX(600);
        tinfo.setFont(new Font("Comic Sans Ms", 13));
        tinfo.setLayoutY(470);
        tinfo.setLayoutX(15);
        tpath.setFont(new Font("Comic Sans Ms", 13));
        tpath.setLayoutY(470);
        tpath.setLayoutX(700);
        tdij.setFont(new Font("Comic Sans Ms", 13));
        tdij.setLayoutY(65);
        tdij.setLayoutX(1000);

        Button bDfs=new Button("Simple DFS");
        bDfs.setLayoutX(800);
        bDfs.setLayoutY(20);
        bDfs.setStyle("-fx-background-color:lightsalmon");

        Button bBfs=new Button("Simple BFS");
        bBfs.setLayoutX(600);
        bBfs.setLayoutY(20);
        bBfs.setStyle("-fx-background-color:lightsalmon");

        Button info=new Button("Click for Graph info:");
        info.setLayoutX(15);
        info.setLayoutY(420);
        info.setStyle("-fx-background-color:lightsalmon");

        Button path=new Button("Click for path:");
        path.setLayoutX(700);
        path.setLayoutY(420);
        path.setStyle("-fx-background-color:lightsalmon");

        Button between=new Button("Dijkastra with lowest weight");
        between.setLayoutX(1000);
        between.setLayoutY(20);
        between.setStyle("-fx-background-color:lightsalmon");

        TextField tf1=new TextField();
        tf1.setMaxWidth(50);
        tf1.setLayoutX(680);
        tf1.setLayoutY(20);
        TextField tf2=new TextField();
        tf2.setMaxWidth(50);
        tf2.setLayoutX(880);
        tf2.setLayoutY(20);
        TextField tf3=new TextField();
        tf3.setMaxWidth(50);
        tf3.setLayoutX(1170);
        tf3.setLayoutY(20);
        TextField tf4=new TextField();
        tf4.setMaxWidth(50);
        tf4.setLayoutX(800);
        tf4.setLayoutY(420);
        Label to=new Label("to : ");
        to.setLayoutX(868);
        to.setLayoutY(424);
        TextField tf5=new TextField();
        tf5.setMaxWidth(50);
        tf5.setLayoutX(900);
        tf5.setLayoutY(420);

        Image img = new Image("map.png");
        ImageView imgView = new ImageView(img);
        imgView.setLayoutX(10);
        imgView.setLayoutY(10);
        root.getChildren().add(imgView);
        root.getChildren().add(tf1);
        root.getChildren().add(tf2);
        root.getChildren().add(tf3);
        root.getChildren().add(tf4);
        root.getChildren().add(tf5);
        root.getChildren().add(tdfs);
        root.getChildren().add(tbfs);
        root.getChildren().add(tdij);
        root.getChildren().add(tpath);
        root.getChildren().add(bDfs);
        root.getChildren().add(bBfs);
        root.getChildren().add(info);
        root.getChildren().add(tinfo);
        root.getChildren().add(between);
        root.getChildren().add(tbetween);
        root.getChildren().add(path);
        root.getChildren().add(to);


        bDfs.setOnAction(event -> {
            int src=Integer.parseInt(tf2.getText());
            testDfs(src);
        });


        bBfs.setOnAction(event -> {
            int src=Integer.parseInt(tf1.getText());
            testBfs(src);
        });

        info.setOnAction(event -> {
            printInfo();
        });


        between.setOnAction(event -> {
            int src=Integer.parseInt(tf3.getText());
            dijkstra(src);
        });

        path.setOnAction(event -> {
            int src=Integer.parseInt(tf4.getText());
            int des=Integer.parseInt(tf5.getText());
            printPath(src,des);
        });





        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(root);
        scrollPane.setPannable(true);
        Scene scene = new Scene(scrollPane, 1300, 650, Color.WHITE);
        primaryStage.getIcons().add(new Image("file:icon.png"));
        primaryStage.setTitle("Map : MONIR-Ayati");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public void printRaas(List<Vertex> r){
        sdfs.append("All vertices are : "+"\n");
        int x = 0;
        for (Vertex raas : r) {
            sdfs.append(x +":"+ raas.printString());
            x++;
        }
        sinfo.append("\n");
    }


    public void testDfs(int src){
        List<Vertex> r1=new ArrayList<>();
        r1.add(new Vertex("Oradea"));
        r1.add(new Vertex("Zerind"));
        r1.add(new Vertex("Arad"));
        r1.add(new Vertex("Timisoara"));
        r1.add(new Vertex("Lugoj"));
        r1.add(new Vertex("Mehadia"));
        r1.add(new Vertex("Drobeta"));
        r1.add(new Vertex("Sibiu"));
        r1.add(new Vertex("RimnicuVilcea"));
        r1.add(new Vertex("Craiova"));
        r1.add(new Vertex("Fagaras"));
        r1.add(new Vertex("Pitesti"));
        r1.add(new Vertex("Neamt"));
        r1.add(new Vertex("Iasi"));
        r1.add(new Vertex("Vaslui"));
        r1.add(new Vertex("Urziceni"));
        r1.add(new Vertex("Bucharest"));
        r1.add(new Vertex("Giurgiu"));
        r1.add(new Vertex("Hirsova"));
        r1.add(new Vertex("Eforie"));


        List<Edge> v1=new ArrayList<>();
        v1.add(new Edge(0,1,71));
        v1.add(new Edge(0,7,151));
        v1.add(new Edge(1,0,71));
        v1.add(new Edge(1,2,75));
        v1.add(new Edge(2,1,75));
        v1.add(new Edge(2,3,118));
        v1.add(new Edge(2,7,140));
        v1.add(new Edge(3,2,118));
        v1.add(new Edge(3,4,111));
        v1.add(new Edge(4,3,111));
        v1.add(new Edge(4,5,70));
        v1.add(new Edge(5,4,70));
        v1.add(new Edge(5,6,75));
        v1.add(new Edge(6,5,75));
        v1.add(new Edge(6,9,120));
        v1.add(new Edge(7,0,151));
        v1.add(new Edge(7,2,140));
        v1.add(new Edge(7,8,80));
        v1.add(new Edge(7,10,99));
        v1.add(new Edge(8,7,80));
        v1.add(new Edge(8,9,146));
        v1.add(new Edge(8,11,97));
        v1.add(new Edge(9,6,120));
        v1.add(new Edge(9,8,146));
        v1.add(new Edge(9,11,138));
        v1.add(new Edge(10,7,99));
        v1.add(new Edge(10,16,211));
        v1.add(new Edge(11,8,97));
        v1.add(new Edge(11,9,138));
        v1.add(new Edge(11,16,101));
        v1.add(new Edge(12,13,87));
        v1.add(new Edge(13,12,90));
        v1.add(new Edge(13,14,92));
        v1.add(new Edge(14,13,92));
        v1.add(new Edge(14,15,142));
        v1.add(new Edge(15,16,85));
        v1.add(new Edge(15,18,98));
        v1.add(new Edge(16,10,211));
        v1.add(new Edge(16,11,101));
        v1.add(new Edge(16,15,85));
        v1.add(new Edge(16,17,90));
        v1.add(new Edge(17,16,90));
        v1.add(new Edge(18,15,98));
        v1.add(new Edge(18,19,86));
        v1.add(new Edge(19,18,86));

        WeightedGraph g1=new WeightedGraph(r1,v1);
        WeightedGraph.Short s=g1.dfs(src);
        List<Integer> so=s.getSearchOrder();
        sdfs.append("Graph--->root "+src+" in Dfs order:"+"\n\n");
        for (int i=0;i<so.size();i++)
            sdfs.append(g1.getVertex(so.get(i)));
        tdfs.setText(sdfs.toString());

    }



    public void testBfs(int root){
        List<Vertex> r1=new ArrayList<>();
        r1.add(new Vertex("Oradea"));
        r1.add(new Vertex("Zerind"));
        r1.add(new Vertex("Arad"));
        r1.add(new Vertex("Timisoara"));
        r1.add(new Vertex("Lugoj"));
        r1.add(new Vertex("Mehadia"));
        r1.add(new Vertex("Drobeta"));
        r1.add(new Vertex("Sibiu"));
        r1.add(new Vertex("RimnicuVilcea"));
        r1.add(new Vertex("Craiova"));
        r1.add(new Vertex("Fagaras"));
        r1.add(new Vertex("Pitesti"));
        r1.add(new Vertex("Neamt"));
        r1.add(new Vertex("Iasi"));
        r1.add(new Vertex("Vaslui"));
        r1.add(new Vertex("Urziceni"));
        r1.add(new Vertex("Bucharest"));
        r1.add(new Vertex("Giurgiu"));
        r1.add(new Vertex("Hirsova"));
        r1.add(new Vertex("Eforie"));

        List<Edge> v1=new ArrayList<>();
        v1.add(new Edge(0,1,71));
        v1.add(new Edge(0,7,151));
        v1.add(new Edge(1,0,71));
        v1.add(new Edge(1,2,75));
        v1.add(new Edge(2,1,75));
        v1.add(new Edge(2,3,118));
        v1.add(new Edge(2,7,140));
        v1.add(new Edge(3,2,118));
        v1.add(new Edge(3,4,111));
        v1.add(new Edge(4,3,111));
        v1.add(new Edge(4,5,70));
        v1.add(new Edge(5,4,70));
        v1.add(new Edge(5,6,75));
        v1.add(new Edge(6,5,75));
        v1.add(new Edge(6,9,120));
        v1.add(new Edge(7,0,151));
        v1.add(new Edge(7,2,140));
        v1.add(new Edge(7,8,80));
        v1.add(new Edge(7,10,99));
        v1.add(new Edge(8,7,80));
        v1.add(new Edge(8,9,146));
        v1.add(new Edge(8,11,97));
        v1.add(new Edge(9,6,120));
        v1.add(new Edge(9,8,146));
        v1.add(new Edge(9,11,138));
        v1.add(new Edge(10,7,99));
        v1.add(new Edge(10,16,211));
        v1.add(new Edge(11,8,97));
        v1.add(new Edge(11,9,138));
        v1.add(new Edge(11,16,101));
        v1.add(new Edge(12,13,87));
        v1.add(new Edge(13,12,90));
        v1.add(new Edge(13,14,92));
        v1.add(new Edge(14,13,92));
        v1.add(new Edge(14,15,142));
        v1.add(new Edge(15,16,85));
        v1.add(new Edge(15,18,98));
        v1.add(new Edge(16,10,211));
        v1.add(new Edge(16,11,101));
        v1.add(new Edge(16,15,85));
        v1.add(new Edge(16,17,90));
        v1.add(new Edge(17,16,90));
        v1.add(new Edge(18,15,98));
        v1.add(new Edge(18,19,86));
        v1.add(new Edge(19,18,86));

        WeightedGraph g1=new WeightedGraph(r1,v1);
        WeightedGraph.Short s=g1.bfs(root);
        List<Integer> so=s.getSearchOrder();
        sbfs.append("Graph--->root "+root+" in Bfs order:"+"\n\n");
        for (int i=0;i<so.size();i++)
            sbfs.append(g1.getVertex(so.get(i)));



        tbfs.setText(sbfs.toString());
    }



    public void printInfo(){
        List<Vertex> r1=new ArrayList<>();
        r1.add(new Vertex("Oradea"));
        r1.add(new Vertex("Zerind"));
        r1.add(new Vertex("Arad"));
        r1.add(new Vertex("Timisoara"));
        r1.add(new Vertex("Lugoj"));
        r1.add(new Vertex("Mehadia"));
        r1.add(new Vertex("Drobeta"));
        r1.add(new Vertex("Sibiu"));
        r1.add(new Vertex("RimnicuVilcea"));
        r1.add(new Vertex("Craiova"));
        r1.add(new Vertex("Fagaras"));
        r1.add(new Vertex("Pitesti"));
        r1.add(new Vertex("Neamt"));
        r1.add(new Vertex("Iasi"));
        r1.add(new Vertex("Vaslui"));
        r1.add(new Vertex("Urziceni"));
        r1.add(new Vertex("Bucharest"));
        r1.add(new Vertex("Giurgiu"));
        r1.add(new Vertex("Hirsova"));
        r1.add(new Vertex("Eforie"));


        List<Edge> v1=new ArrayList<>();
        v1.add(new Edge(0,1,71));
        v1.add(new Edge(0,7,151));
        v1.add(new Edge(1,0,71));
        v1.add(new Edge(1,2,75));
        v1.add(new Edge(2,1,75));
        v1.add(new Edge(2,3,118));
        v1.add(new Edge(2,7,140));
        v1.add(new Edge(3,2,118));
        v1.add(new Edge(3,4,111));
        v1.add(new Edge(4,3,111));
        v1.add(new Edge(4,5,70));
        v1.add(new Edge(5,4,70));
        v1.add(new Edge(5,6,75));
        v1.add(new Edge(6,5,75));
        v1.add(new Edge(6,9,120));
        v1.add(new Edge(7,0,151));
        v1.add(new Edge(7,2,140));
        v1.add(new Edge(7,8,80));
        v1.add(new Edge(7,10,99));
        v1.add(new Edge(8,7,80));
        v1.add(new Edge(8,9,146));
        v1.add(new Edge(8,11,97));
        v1.add(new Edge(9,6,120));
        v1.add(new Edge(9,8,146));
        v1.add(new Edge(9,11,138));
        v1.add(new Edge(10,7,99));
        v1.add(new Edge(10,16,211));
        v1.add(new Edge(11,8,97));
        v1.add(new Edge(11,9,138));
        v1.add(new Edge(11,16,101));
        v1.add(new Edge(12,13,87));
        v1.add(new Edge(13,12,90));
        v1.add(new Edge(13,14,92));
        v1.add(new Edge(14,13,92));
        v1.add(new Edge(14,15,142));
        v1.add(new Edge(15,16,85));
        v1.add(new Edge(15,18,98));
        v1.add(new Edge(16,10,211));
        v1.add(new Edge(16,11,101));
        v1.add(new Edge(16,15,85));
        v1.add(new Edge(16,17,90));
        v1.add(new Edge(17,16,90));
        v1.add(new Edge(18,15,98));
        v1.add(new Edge(18,19,86));
        v1.add(new Edge(19,18,86));

        WeightedGraph g1=new WeightedGraph(r1,v1);

        sinfo.append("number of vertices are : "+(g1.getSize())+"\n");
        printRaas(r1);
        sinfo.append(g1.printWeightedEdges());
        tinfo.setText(sinfo.toString());
    }

    public void printPath(int src,int des){
        List<Vertex> r1=new ArrayList<>();
        r1.add(new Vertex("Oradea"));
        r1.add(new Vertex("Zerind"));
        r1.add(new Vertex("Arad"));
        r1.add(new Vertex("Timisoara"));
        r1.add(new Vertex("Lugoj"));
        r1.add(new Vertex("Mehadia"));
        r1.add(new Vertex("Drobeta"));
        r1.add(new Vertex("Sibiu"));
        r1.add(new Vertex("RimnicuVilcea"));
        r1.add(new Vertex("Craiova"));
        r1.add(new Vertex("Fagaras"));
        r1.add(new Vertex("Pitesti"));
        r1.add(new Vertex("Neamt"));
        r1.add(new Vertex("Iasi"));
        r1.add(new Vertex("Vaslui"));
        r1.add(new Vertex("Urziceni"));
        r1.add(new Vertex("Bucharest"));
        r1.add(new Vertex("Giurgiu"));
        r1.add(new Vertex("Hirsova"));
        r1.add(new Vertex("Eforie"));


        List<Edge> v1=new ArrayList<>();
        v1.add(new Edge(0,1,71));
        v1.add(new Edge(0,7,151));
        v1.add(new Edge(1,0,71));
        v1.add(new Edge(1,2,75));
        v1.add(new Edge(2,1,75));
        v1.add(new Edge(2,3,118));
        v1.add(new Edge(2,7,140));
        v1.add(new Edge(3,2,118));
        v1.add(new Edge(3,4,111));
        v1.add(new Edge(4,3,111));
        v1.add(new Edge(4,5,70));
        v1.add(new Edge(5,4,70));
        v1.add(new Edge(5,6,75));
        v1.add(new Edge(6,5,75));
        v1.add(new Edge(6,9,120));
        v1.add(new Edge(7,0,151));
        v1.add(new Edge(7,2,140));
        v1.add(new Edge(7,8,80));
        v1.add(new Edge(7,10,99));
        v1.add(new Edge(8,7,80));
        v1.add(new Edge(8,9,146));
        v1.add(new Edge(8,11,97));
        v1.add(new Edge(9,6,120));
        v1.add(new Edge(9,8,146));
        v1.add(new Edge(9,11,138));
        v1.add(new Edge(10,7,99));
        v1.add(new Edge(10,16,211));
        v1.add(new Edge(11,8,97));
        v1.add(new Edge(11,9,138));
        v1.add(new Edge(11,16,101));
        v1.add(new Edge(12,13,87));
        v1.add(new Edge(13,12,90));
        v1.add(new Edge(13,14,92));
        v1.add(new Edge(14,13,92));
        v1.add(new Edge(14,15,142));
        v1.add(new Edge(15,16,85));
        v1.add(new Edge(15,18,98));
        v1.add(new Edge(16,10,211));
        v1.add(new Edge(16,11,101));
        v1.add(new Edge(16,15,85));
        v1.add(new Edge(16,17,90));
        v1.add(new Edge(17,16,90));
        v1.add(new Edge(18,15,98));
        v1.add(new Edge(18,19,86));
        v1.add(new Edge(19,18,86));

        WeightedGraph g1=new WeightedGraph(r1,v1);
        AllPaths ap=new AllPaths(g1,src,des);
        spath.append(AllPaths.stringBuilder);
        tpath.setText(spath.toString());

    }


    public void dijkstra(int src) {

        int graph[][] = new int[][]{
                {0,71,0,0,0,0,0,151,0,0,0,0,0,0,0,0,0,0,0,0},
                {71,0,75,0,0,0,0,151,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,75,0,118,0,0,0,140,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,118,0,111,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,111,0,70,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,70,0,75,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,75,0,0,0,120,0,0,0,0,0,0,0,0,0,0},
                {151,0,140,0,0,0,0,0,80,0,99,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,80,0,146,0,97,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,120,0,146,0,0,138,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,99,0,0,0,0,0,0,0,0,211,0,0,0},
                {0,0,0,0,0,0,0,0,97,138,0,0,0,0,0,0,101,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,87,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,87,0,92,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,92,0,142,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,85,0,98,0},
                {0,0,0,0,0,0,0,0,0,0,211,101,0,0,0,85,0,90,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,90,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,98,0,0,0,86},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,86,0},
        };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, src);
        sdijk.append(ShortestPath.str);
        tdij.setText(sdijk.toString());
    }



    public static void main(String[] args)
    {
        launch(args);

    }








}


