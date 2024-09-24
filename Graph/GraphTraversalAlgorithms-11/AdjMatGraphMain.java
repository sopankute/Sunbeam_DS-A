/* Implementation of Graph Traversal Algorithms
    1. DFS Traversal
    2. BFS Traversal
====================================================================================== */

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;


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

    void dfsTraversal(int start){

        Stack<Integer> s = new Stack<Integer>();
        boolean [] marked =  new boolean[ this.vertCount ];

        //initially all vertices are unmarked
        for( int v = 0 ; v < this.vertCount ; v++ ){
            marked[ v ] = false;
        }

        //step-1: push starting vertex onto the stack and mark it
        s.push(start);
        marked[ start ] = true;

        System.out.print("dfs traversal is : ");
        while( !s.empty() ){
            //step-2: pop vertex from the stack, catch it into trav and visit it
            int trav = s.peek(); s.pop();
            System.out.printf("%4d", trav);

            //step-3: push all its adjacent but unmarked vertices onto the stack and mark them
            for( int v = 0 ; v < this.vertCount ; v++ ){
                if( mat[ trav ][ v ] != 0 && marked[ v ] == false ){
                    s.push(v);
                    marked[ v ] = true;
                }
            }
        }//step-4: repeat step-2 & step-3 till stack not becomes empty 
        System.out.println();
    }


    void bfsTraversal(int start){

        Queue<Integer> q = new LinkedList<Integer>();

        boolean [] marked =  new boolean[ this.vertCount ];

        //initially all vertices are unmarked
        for( int v = 0 ; v < this.vertCount ; v++ ){
            marked[ v ] = false;
        }

        //step-1: push starting vertex into the queue and mark it
        q.offer(start);
        marked[ start ] = true;

        System.out.print("bfs traversal is : ");
        while( !q.isEmpty() ){
            //step-2: pop vertex from the queue, catch it into trav and visit it
            int trav = q.poll();
            System.out.printf("%4d", trav);

            //step-3: push all its adjacent but unmarked vertices into the queue and mark them
            for( int v = 0 ; v < this.vertCount ; v++ ){
                if( mat[ trav ][ v ] != 0 && marked[ v ] == false ){
                    q.offer(v);
                    marked[ v ] = true;
                }
            }
        }//step-4: repeat step-2 & step-3 till queue not becomes empty 
        System.out.println();
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

        //accept starting vertex from user
        System.out.print("enter starting vertex: ");
        int start = sc.nextInt();
        g1.dfsTraversal(start);
        g1.bfsTraversal(start);

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