import java.util.Scanner;

public class Hamiltonian {

	public static void main(String[] args) {
		hamilcycle cycle = new hamilcycle();
		cycle.read_graph();
		cycle.find_cycle();
	}
}

class hamilcycle{
	int n,cycle_count;
	int adj[][];
	
	public void read_graph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes: ");
		this.n = sc.nextInt();
		this.adj = new int[n][n];
		System.out.println("Enter adjacency matrix: ");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				this.adj[i][j] = sc.nextInt();
	}
	public void find_cycle() {
		int i,u;
		cycle_count = 0;
		int sol_array[] = new int[n];
		int visited[] = new int[n];
		for(i=0;i<n;i++)
			visited[i] = 0;
		visited[0] = 1;
		sol_array[0] = 0;
		find_rec(0,sol_array,visited);
		if(cycle_count == 0)
			System.out.println("No Hamiltonian cycle found!");
	}
	void find_rec(int length, int arr[], int visited[]) {
		int j,i;
		if(length==n-1 && adj[arr[length]][arr[0]] == 1)
			print_cycle(arr);
		else
		{
			for(j=0;j<n;j++)
			{
				if(visited[j] == 0 && adj[arr[length]][j] == 1)
				{
					visited[j] = 1;
					arr[length+1] = j;
					find_rec(length+1, arr, visited);
					visited[j] = 0;
				}
			}
		}
	}
	void print_cycle(int sol_arr[])
	{
		cycle_count++;
		System.out.println("Cycle no"+cycle_count+" : ");
		for(int i=0;i<n;i++)
			System.out.print((sol_arr[i] + 1) + "-->");
		System.out.println(sol_arr[0]+1);
	}
}




//0 1 1 1 0 0
//1 0 1 0 0 1
//1 1 0 1 1 0
//1 0 1 0 1 0
//0 0 1 1 0 1
//0 1 0 0 1 0


//output : 

//Cycle no1 : 
//1-->2-->6-->5-->3-->4-->1
//Cycle no2 : 
//1-->2-->6-->5-->4-->3-->1
//Cycle no3 : 
//1-->3-->2-->6-->5-->4-->1
//Cycle no4 : 
//1-->3-->4-->5-->6-->2-->1
//Cycle no5 : 
//1-->4-->3-->5-->6-->2-->1
//Cycle no6 : 
//1-->4-->5-->6-->2-->3-->1
