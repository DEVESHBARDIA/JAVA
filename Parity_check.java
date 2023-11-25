package Program;

import java.util.Scanner;

public class Parity_check {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num,count=0;
		String n;
		System.out.println("Enter the bit to be checked in binary: ");
		num = sc.nextInt();
		n = Integer.toString(num);
		while (num != 0) {
			int l = num % 10;
			if (l == 1)
				count++;
			num /= 10;
		}
		if(count%2==0)
		{
			n = n + '0';
		}
		else
			n = n + '1';
		System.out.println(n);
		

	}

}
