/* Implementation of Adjacency Matrix Graph : "Undirected Unweighted Graph" */

import java.util.Scanner;

class AdjMatGraph{
    private int [][] mat;
    int vertCount;
    int edgeCount;

    AdjMatGraph(int vertCount){
        this.vertCount = vertCount;
        //allocate memory dynamically for matrix of size vertXCount * vertCount
        this.mat = new int [ this.vertCount ][ this.vertCount ];
        //initialise all entries in a matrix as 0
        for( int i = 0 ; i < this.vertCount ; i++ ){
            for( int j = 0 ; j < this.vertCount ; j++ ){
                mat[ i ][ j ] = 0;
            }
        }
    }

    void acceptGraph(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of edges : ");
        this.edgeCount = sc.nextInt();
        //accept edges from user => pairs of vertices
        for( int i = 0 ; i < this.edgeCount ; i++ ){
            System.out.print("enter an egde from to to : ");
            int from = sc.nextInt();
            int to = sc.nextInt();
            
            mat[ from ][ to ] = 1;
            mat[ to ] [ from ] = 1;//this line will be in comment for di-graph

        }
    }

    void displayGraph(){
        System.out.println("input graph is : ");
        System.out.println("no. of vertices are : " + this.vertCount);
        System.out.println("no. of edges are: "+ this.edgeCount);
        System.out.println("============================================");
        for( int i = 0 ; i < this.vertCount ; i++ ){
            for( int j = 0 ; j < this.vertCount ; j++ ){
                System.out.printf("%4d", mat[ i ][ j ]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("============================================");
    }

}//end of AdjMatGraph class

public class AdjMatGraphMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of vertices : ");
        int vertCount = sc.nextInt();
        
        AdjMatGraph g1 = new AdjMatGraph(vertCount);

        g1.acceptGraph();
        g1.displayGraph();        
    }
}

/*

5
7
0 1
0 2
0 3
1 2
1 4
2 3
3 4

*/