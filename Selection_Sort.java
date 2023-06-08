import java.util.random.*;
import java.util.Random;
import java.util.Scanner;


public class Selection_Sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		long time,start,end;
		sort sort_object = new sort();
		System.out.println("Enter the number of elements: ");
		n = sc.nextInt();
		sort_object.create_array(n, 2);
		System.out.println("The generated array is :");
		sort_object.print_array();
		start = System.nanoTime();
		sort_object.sorting();
		end = System.nanoTime();
		System.out.println("The Sorted array is: ");
		sort_object.print_array();
		time = (end-start)/1000000L;
		System.out.println("The time taken to sort an array of "+n+"numbers is: "+time+" ms");
	}

}

class sort{
	int n;
	int arr[];
	
	public void create_array(int n, int choice)
	{
		this.n=n;
		arr = new int[n];
		if(choice == 0)
		{
			for(int i=0; i<n;i++)
				arr[i] = i;
		}
		else if(choice == 1)
		{
			for(int i=0; i<n;i++)
				arr[i] = n-i;
		}
		else
		{
			Random rand = new Random();
			for(int i=0;i<n;i++)
			{
				arr[i] = rand.nextInt(1000000);
			}
		}
	}
	
	public void sorting()
	{
		int i,j,temp;
		for(i=0;i<n-1;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if(arr[i] > arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public void print_array()
	{
		for(int i=0;i<n;i++)
		{
			System.out.println(arr[i]+"");
		}
	}
}







