import java.util.Scanner;

public class Subset_Sum {

	public static void main(String[] args) {
		subset s = new subset();
		s.read_data();
		s.find_set();
	}

}

class subset{
	int s[],x[];
	int d,n;
	void read_data() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		n = sc.nextInt();
		s= new int[n+1];
		x = new int[n+1];
		System.out.println("Enter the set: ");
		for(int i=1;i<=n;i++)
			s[i] = sc.nextInt();
		System.out.println("Enter subset sum value: ");
		d= sc.nextInt();
	}
	void find_set() {
		int sum = 0;
		for(int i=1;i<=n;i++)
			sum = sum + s[i];
		if(sum<d)
			System.out.println("Subset is not possible!");
		else
			System.out.println("The sets are:");
		subset_fun(0,1,sum);
	}
	void subset_fun(int S,int k, int r) {
		x[k] = 1;
		if((S+s[k]) == d)
		{
			for(int i=1;i<=k;i++)
				if(x[i]==1)
					System.out.println(+s[i]+" ");
			System.out.println();
		}
		else if(S+s[k]+s[k+1]<=d)
			subset_fun(S+s[k],k+1,r-s[k]);
		
		if((S+r-s[k]>=d)&&(S+s[k+1]<=d))
		{
			x[k] = 0;
			subset_fun(S,k+1,r-s[k]);
		}
	}
}