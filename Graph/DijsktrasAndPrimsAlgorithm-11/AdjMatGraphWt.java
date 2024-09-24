/*
    # "dijsktra's algorithm": 
    to find shortest distance of all vertices from given source vertex this algo is also used 
    to find shortest distance of all vertices from all vertices
====================================================================================================*/
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

    /* this function returns such a vertex which is having min key value i.e. min distance and
    not yet added into the SPT set of vertices */
    public int getMinKeyVertex(int [] dist, boolean [] marked){
        int minIndex = 0;
        int minDistance = INF;
        for( int i = 0 ; i < vertCount ; i++ ){
            if( marked[ i ] == false && dist[ i ] < minDistance ){
                minIndex = i;
                minDistance = dist[ i ];
            }
        }
        return minIndex;
    }


    void dijkstras(int source){

        int [] dist = new int[ this.vertCount ];
        boolean [] marked = new boolean[ this.vertCount ];
        int sptVertexCount = 0;
        //initially distance of all vertices from given source vertex is INF & all vertices are unmarked
        //i.e. not yet added into SPT set of vertices => initially SPT set of vertices is empty
        for( int v = 0 ; v < this.vertCount ; v++ ){
            dist[ v ] = INF;
            marked[ v ] = false;
        }

        //distance of source vertex from itself is 0
        dist[ source ] = 0;

        System.out.print("SPT Set of Vertices is : { ");
        while( sptVertexCount < vertCount ){
            //get minKeyVertex and add it into MST set of vertices i.e. mark it
            int minKeyVertex = getMinKeyVertex(dist, marked);
            marked[ minKeyVertex ] = true;
            sptVertexCount++;

            System.out.printf("%4d", minKeyVertex);

            //update all its adjacent but unmarked vertices to the min distance
            for( int v = 0 ; v < vertCount ; v++ ){
                if( mat[ minKeyVertex ][ v ] != INF && marked[ v ] == false &&
                    dist[ v ] > dist[ minKeyVertex] + mat[ minKeyVertex ][ v ] ){
                        dist[ v ] = dist[ minKeyVertex] + mat[ minKeyVertex ][ v ];
                  }
            }
        }//end of while loop
        System.out.println(" } ");

        System.out.println("distance of all vertices from given source vertex is : ");
        for( int v = 0 ; v < vertCount ; v++ ){
            System.out.printf("distance[ %d ] from %d is : %d\n", v, source, dist[ v ] );
        }
    }

    void prims(int root){
        boolean [] marked = new boolean[ vertCount ];
        int [] vertKey = new int[ vertCount ];
        int mst_vert_cnt=0;
        int [] parent = new int[ vertCount ]; 
        int weightMST = 0;

        //initially key value of all vertices is INF and parent of each vertex is -1 
        //all vertices are unmarked i.e. not yet added into the MST set of vertices
        for( int v = 0 ; v < vertCount ; v++ ){
            vertKey[ v ] = INF;
            marked[ v ] = false;
            parent[ v ] = -1;
        }

        //key value of root vertext is 0 & parent of root vertex is root itself
        vertKey[ root ] = 0;
        parent[ root ] = root;

        System.out.print("MST SET OF VERTICES: { ");
        while( mst_vert_cnt < vertCount ){
            int min_key_vert = getMinKeyVertex(vertKey, marked);
            System.out.print(min_key_vert+" ");
            //mark "min_key_vert" as added into the MST set of vertices and increment the counter
            marked[ min_key_vert ] = true;
            mst_vert_cnt++;


            //update key values of all its adjancent but unmarked vertices to the min weigh
            for( int v = 0 ; v < vertCount ; v++ ){
                if( mat[ min_key_vert ][ v] != INF && marked[v] == false &&
                    mat[min_key_vert][v] < vertKey[v] ) {
                    vertKey[ v ] = mat[ min_key_vert ][ v ] ;
                    parent[ v ] = min_key_vert;
                }
            }
        }//end of while loop
        System.out.println(" } ");
        System.out.println("edge set of MST is : ");
        for( int i = 0 ; i < vertCount ; i++ ){
            if( i != root ){
                System.out.println(i +" -> "+ parent[i] + " : " + mat[ i ][ parent[i] ]);
                weightMST += mat[ i ][ parent[i] ];
            } 
        }

        System.out.println("Weight of MST is : "+weightMST);
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
        
        //accept source vertex from user
        System.out.print("enter source vertex : ");
        int source = sc.nextInt();
        g1.dijkstras(source);

        //accept root vertex from user
        System.out.print("enter root vertex : ");
        int root = sc.nextInt();
        g1.prims(root);

    }
}

/*

9
14
0 1 4
0 7 8
1 2 8
1 7 11
2 3 7
2 5 4
2 8 2
3 4 9
3 5 14
4 5 10
5 6 2
6 7 1
6 8 6
7 8 7

*/