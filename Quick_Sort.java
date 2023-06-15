import java.util.Random;
import java.util.Scanner;

public class Quick_Sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		long time,start,end;
		qsort sort_object = new qsort();
		System.out.println("Enter the number of elements: ");
		n = sc.nextInt();
		sort_object.create_array(n, 2);
//		System.out.println("The generated array is :");
//		sort_object.print_array();
		start = System.nanoTime();
		sort_object.quickSort(0, n-1);
		end = System.nanoTime();
//		System.out.println("The Sorted array is: ");
//		sort_object.print_array();
		time = (end-start)/1000000L;
		System.out.println("The time taken to sort an array of "+n+"numbers is: "+time+" ms");

	}

}


class qsort{
	int n;
	int arr[];
	
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void create_array(int n, int choice)
	{
		this.n=n;
		arr = new int[n+1];
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
		arr[n] = 99999999;
	}
	
	private int partition(int[] arr, int l, int r)
	{
		int pivot = arr[l];
		int i = l;
		int j = r;
		while(i<=j)
		{
			while(arr[i]<=pivot)
			{
				i++;
			}
			while(arr[j]>pivot)
			{
				j--;
			}
			swap(arr, i, j);
		}
		swap(arr, i, j);
		swap(arr, l, j);
		return j;
	}
	
	
	
	public void quickSort(int l, int r)
	{
		if(l<r)
		{
			int p = partition(arr, l, r);
			quickSort(l, p-1);
			quickSort(p+1, r);
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



















