import java.util.Scanner;

public class FloydWarshal {

	public static void main(String[] args) {
		floyd obj = new floyd();
		obj.create_graph();
		obj.find_path();

	}

}


class floyd{
	int n;
	int adj[][];
	public void create_graph()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes :");
		n = sc.nextInt();
		int i,j;
		adj = new int[n+1][n+1];
		System.out.println("Enter adjacency matrix for graph: ");
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
			{
				adj[i][j] = sc.nextInt();				
				if(i==j) adj[i][j] =0;
			}
	}
	public void find_path()
	{
		int j,k,i;
		int dmatrix[][] = new int[n+1][n+1];
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
				dmatrix[i][j] = adj[i][j];
		for(k=1;k<=n;k++)
			for(i=1;i<=n;i++)
				for(j=1;j<=n;j++)
					if(dmatrix[i][k]+dmatrix[k][j]<dmatrix[i][j])
						dmatrix[i][j] = dmatrix[i][k] + dmatrix[k][j];
		for(i=1;i<=n;i++)
			System.out.print("\t"+i);
		System.out.println();
		for(i=1;i<=n;i++)
		{
			System.out.print(i+"\t");
			for(j=1;j<=n;j++)
				System.out.print(dmatrix[i][j]+"\t");
			System.out.println();
		}
	}
}















