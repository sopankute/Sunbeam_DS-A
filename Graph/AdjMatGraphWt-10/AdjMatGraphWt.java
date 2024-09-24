/* Implementation of Adjacency Matrix Graph : "Undirected Weighted Graph" */

import java.util.Scanner;

class AdjMatGraph{
    private int [][] mat;
    int vertCount;
    int edgeCount;
    public static final int INF = 99999;

    AdjMatGraph(int vertCount){
        this.vertCount = vertCount;
        //allocate memory dynamically for matrix of size vertXCount * vertCount
        this.mat = new int [ this.vertCount ][ this.vertCount ];
        //initialise all entries in a matrix as INF
        for( int i = 0 ; i < this.vertCount ; i++ ){
            for( int j = 0 ; j < this.vertCount ; j++ ){
                mat[ i ][ j ] = INF;
            }
        }
    }

    void acceptGraph(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of edges : ");
        this.edgeCount = sc.nextInt();
        //accept edges from user => pairs of vertices
        for( int i = 0 ; i < this.edgeCount ; i++ ){
            System.out.print("enter an egde from to to & weight :  ");
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            
            mat[ from ][ to ] = weight;
            mat[ to ] [ from ] = weight;//this line will be in comment for di-graph

        }
    }

    void displayGraph(){
        System.out.println("input graph is : ");
        System.out.println("no. of vertices are : " + this.vertCount);
        System.out.println("no. of edges are: "+ this.edgeCount);
        System.out.println("============================================");
        for( int i = 0 ; i < this.vertCount ; i++ ){
            for( int j = 0 ; j < this.vertCount ; j++ ){
                if( mat[ i ][ j ] != INF )
                    System.out.printf("%4d", mat[ i ][ j ]);
                else
                    System.out.printf("%4s","#");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("============================================");
    }

}//end of AdjMatGraph class

public class AdjMatGraphWt{
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
Input:
5
7
0 1 3
0 2 5
0 3 4
1 2 7
1 4 1
2 3 5
3 4 6

*/