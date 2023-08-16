package practice;
import java.util.Scanner;

class graphMST{
	int n, n_edges;
	int adj[][];
	int[][] edges;
	static final int inf = 999;
	
//	Creating a graph
	public void create_graph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entetr the number of nodes in graph: ");
		n = sc.nextInt();
		int i,j,k=0;
		adj = new int[n][n];
		edges = new int[n*n][3];
		System.out.println("Enter cost of adjacency matrix: ");
		System.out.println("If two nodes are not connected than enter 999");
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
			{
				adj[i][j] = sc.nextInt();
				edges[k][0] = i;
				edges[k][1] = j;
				edges[k++][2] = adj[i][j];
			}
	}
	int find(int x, int parent[]) {
		while(parent[x]>=0)
			x = parent[x];
		return x;
	}
	
	void setunion(int x, int y, int parent[]) {
		parent[x] = y;
	}
	
	public void find_mst() {
		java.util.Arrays.sort(edges, new java.util.Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[2], b[2]); 
			}
		});
		int i,x,y,cost=0,ecount=0;
		int[] parent = new int[n];
		for(i=0;i<n;i++)
			parent[i] = -1;
		i = 0;
		int[][] mst = new int[n][2];
		while (i<(n*n) && ecount<n-1) {
			if(edges[i][2] == 999)
				break;
			x = find(edges[i][0], parent);
			y = find(edges[i][1], parent);
			if(x!=y)
			{
				cost = cost + edges[i][2];
				mst[ecount][0] = edges[i][0];
				mst[ecount++][1] = edges[i][1];
				setunion(x,y,parent);
			}
			i++;
		}
		if(ecount<n-1)
			System.out.println("The minimum spanning tree could not be found!");
		else {
			System.out.println("The minimla spanning tree cost:"+cost);
			System.out.println("The minimla spanning tree is: ");
			for(i=0;i<n-1;i++)
				System.out.println(mst[i][0]+"-"+mst[i][1]);
		}
	}
}

//Driver code
public class kruskal {
	public static void main(String[] args) {
		graphMST graph = new graphMST();
		graph.create_graph();
		graph.find_mst();
	}
}