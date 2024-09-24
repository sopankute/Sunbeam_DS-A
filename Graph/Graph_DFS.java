public class Graph_DFS{
	public int vertices;
	public int adjMat[][];
	public int visited[];

	public Graph_DFS(int n){
		vertices = n;
		adjMat = new int[n][n];
		visited = new int[vertices];
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
		System.out.println("OutDegree : "+count);
	}

	public void display(){
		System.out.println("\nGraph Adjacency Matrix : \n");
		for(int i=0; i<vertices; i++){
			for(int j=0; j<vertices; j++)
				System.out.print("  "+adjMat[i][j]+"  ");
			System.out.println("\n");
		}
	}

	public void traverseDFS(int start_v){

		if(visited[start_v] == 0){
			System.out.print(start_v+"  ");
			visited[start_v] = 1;

			for(int j=0; j<vertices; j++){
				if(adjMat[start_v][j] == 1 && visited[j] == 0)
					traverseDFS(j);
			}
		}
	}

	public static void main(String[] args) {
		Graph_DFS g = new Graph_DFS(7);

		g.insertEdge(0, 1, 1);
		g.insertEdge(0, 5, 1);
		g.insertEdge(0, 6, 1);

		g.insertEdge(1, 0, 1);
		g.insertEdge(1, 2, 1);
		g.insertEdge(1, 5, 1);
		g.insertEdge(1, 6, 1);

		g.insertEdge(2, 3, 1);
		g.insertEdge(2, 4, 1);
		g.insertEdge(2, 6, 1);

		g.insertEdge(3, 4, 1);

		g.insertEdge(4, 2, 1);
		g.insertEdge(4, 5, 1);
		
		g.insertEdge(5, 2, 1);
		g.insertEdge(5, 3, 1);

		g.insertEdge(6, 3, 1);

		System.out.print("DFS : ");
		g.traverseDFS(0);				// DFS : 0  1  2  3  4  5  6

	}
}