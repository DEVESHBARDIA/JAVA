import java.util.Scanner;
public class Quadratic {
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int a,b,c;
		float d,r1,r2,rpart,ipart;
		System.out.println("Enter the first coeff:");
		a = sc.nextInt();
		if(a == 0)
		{
			System.out.println("Invalid Roots");
		}
		else
		{
			System.out.println("Enter the second coeff:");
			b = sc.nextInt();
			System.out.println("Enter the third coeff:");
			c = sc.nextInt();
			d = (b*b)-(4*a*c);
			if(d == 0)
			{
				r1 = (-b)/(2*a);
				r2 = r1;
				System.out.println("The roots are real and equal");
				System.out.println("ROOTS ARE :");
				System.out.println("r1=r2="+r1);
			}
			else if (d>0)
			{
				r1 = (float) (((-b) + Math.sqrt(d))/(2*a));
				r2 = (float) (((-b) - Math.sqrt(d))/(2*a));
				System.out.println("The roots are real and distinct");
				System.out.println("ROOTS ARE :");
				System.out.println("r1="+r1);
				System.out.println("r2="+r2);
			}
			else
			{
				rpart = (-b)/(2*a);
				ipart = (float) (Math.sqrt(-d)/(2*a));
				System.out.println("The roots are imaginary");
				System.out.println("ROOTS ARE :");
				System.out.println("r1="+rpart + "+i"+ipart);
				System.out.println("r2="+rpart + "-i"+ipart);
			}
		}
	}
}