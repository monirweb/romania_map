/**
 * Created by monir on 5/20/2017.
 */
public class Vertex {
   private String name;

    public Vertex(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name+"\n";
    }


    public String printString(){
        return name+" , ";
    }

}
