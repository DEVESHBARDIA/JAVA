package projects;

import java.util.Scanner;
import java.util.Random;

public class otp_generator {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int otp=0;
		otp = rand.nextInt(100);
		System.out.println(otp);
		System.out.println("Enter the above otp: ");
		int get = sc.nextInt();
		if(get == otp)
		{
			System.out.println("Login Successfull!");
		}
		else
		{
			System.out.println("Login failed!");
		}

	}

}

