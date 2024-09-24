public class Graph_3{
	public int vertices;
	public int adjMat[][];

	public Graph_3(int n){
		vertices = n;
		adjMat = new int[n][n];
	}

	public void insertEdge(int u, int v, int w){
		adjMat[u][v] = w;						// weight assigned to edge by default w=1
	}

	public void removeEdge(int u, int v){
		adjMat[u][v] = 0;
	}

	public boolean exitEdge(int u, int v){
		return adjMat[u][v] != 0;
	}

	public void vertexCount(){
		System.out.println("No Of Vertices : "+vertices);
	}

	public void edgeCount(){
		int count = 0;
		for(int i=0; i<vertices; i++){
			for(int j=0; j<vertices; j++)
				if(adjMat[i][j] != 0)
					count++;
		}
		System.out.println("No Of Edges : "+count);
	}

	public void edges(){
		System.out.println("Edges : ");
		for(int i=0; i<vertices; i++){
			for(int j=0; j<vertices; j++)
				if(adjMat[i][j] != 0)
					System.out.println(i+"--"+j);
		}
	}

	public void outDegree(int v){
		int count = 0;
		for(int j=0; j<vertices; j++)
			if(adjMat[v][j] != 0)
				count++;
		System.out.println("OutDegree : "+count);
	}

	public void inDegree(int v){
		int count = 0;
		for(int i=0; i<vertices; i++)
			if(adjMat[i][v] != 0)
				count++;
		System.out.println("InDegree : "+count);
	}

	public void display(){
		System.out.println("\nGraph Adjacency Matrix : \n");
		for(int i=0; i<vertices; i++){
			for(int j=0; j<vertices; j++)
				System.out.print("  "+adjMat[i][j]+"  ");
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		Graph_3 g = new Graph_3(4);
		g.display();
		g.vertexCount();
		g.edgeCount();
		g.insertEdge(0, 1, 1);
		g.insertEdge(0, 2, 1);
		g.insertEdge(1, 2, 1);
		g.insertEdge(2, 3, 1);
		
		g.display();
		g.vertexCount();
		g.edgeCount();
		System.out.println("Edge Between 1--2 : "+g.exitEdge(1, 2));
		System.out.println("Edge Between 3--1 : "+g.exitEdge(3, 1));
		System.out.println("Edge Between 2--3 : "+g.exitEdge(2, 3));
		g.outDegree(1);
		g.inDegree(3);
		g.edges();
		g.removeEdge(1,2);
		g.display();
	}
}

// OUTPUT : Directed Graph

// Graph Adjacency Matrix :

//   0    1    1    0

//   0    0    1    0

//   0    0    0    1

//   0    0    0    0

// No Of Vertices : 4
// No Of Edges : 4
// Edge Between 1--2 : true
// Edge Between 3--1 : false
// Edge Between 2--3 : true
// OutDegree : 1
// InDegree : 1
// Edges :
// 0--1
// 0--2
// 1--2
// 2--3

// Graph Adjacency Matrix :

//   0    1    1    0

//   0    0    0    0

//   0    0    0    1

//   0    0    0    0
