import java.util.ArrayList;
import java.util.Scanner;

class AdjListGraph{
    private ArrayList< ArrayList<Integer> > adjList;
    /* "adjList" is an object of ArrayList of ArrayList of Integer type of element */
    private int vertCount;
    private int edgeCount;

    AdjListGraph(int vertCount){
        this.vertCount = vertCount;
        adjList = new ArrayList< ArrayList<Integer> >( vertCount );

        //create vertCount no. of empty ArrayList objects and add then into addList (ArrayList)
        for( int i = 0 ; i < this.vertCount ; i++ ){
            adjList.add(i, new ArrayList<Integer>() );
        }
    }

    void acceptGraph(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of edges : ");
        this.edgeCount = sc.nextInt();

        //accept edgeCount no. of pairs of vertices from user
        for( int i = 0 ; i < this.edgeCount ; i++ ){
            System.out.print("enter an edge : from to to : ");
            int from = sc.nextInt();
            int to = sc.nextInt();
            
            adjList.get(from).add(to);//add node into adjList at index = from, having data part "to"
            adjList.get(to).add(from);//add node into adjList at index = to, having data part "from"
            //above line will be in comment for di-graph
        }
    }

    void displayList(){
        System.out.println("input graph is : ");
        System.out.println("no. of vertices : " + this.vertCount);
        System.out.println("no. of edges : " + this.edgeCount );
        System.out.println("*******************************************************************");

        for( int i = 0 ; i < adjList.size() ; i++ ){//outer for loop to scan adjList vertically
            System.out.print("adjList [ "+ i + " ] => ");
            for( int j = 0 ; j < adjList.get(i).size() ; j++ ){//inner for is used to scan ArrayList of Integer type of elements horizontally
                System.out.print( adjList.get(i).get(j) + " -> ");   
            }
            System.out.println("null");
        }
        System.out.println("*******************************************************************");
    }
}


public class AdjListGraphMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of vertices : ");
        int vertCount = sc.nextInt();
        AdjListGraph g1 = new AdjListGraph(vertCount);

        g1.acceptGraph();
        g1.displayList();

    }    
}
