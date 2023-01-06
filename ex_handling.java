package exceptionHandling;

import java.util.Scanner;

public class ex_handling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,res;
		System.out.println("Enter two numbers: ");
		a = sc.nextInt();
		b = sc.nextInt();
		
		try {
			if(b==0)
			{
				throw new ArithmeticException();
			}
			res = a/b;
			System.out.println("Result is: "+res);
		}
		
		catch(ArithmeticException e)
		{
			e.printStackTrace();
		}

	}

}
