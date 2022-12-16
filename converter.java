import java.util.Scanner;
import currency_converter.conversion;
import distance_converter.distanceConversion;
import time_converter.timeConversion;


public class converter {

	public static void main(String[] args) {
		int ch=0;
		int ch1,ch2,ch3;
		
		Scanner sc=new Scanner(System.in);
		while(ch<=3)
		System.out.println("-------------Converter-------------");
		System.out.println("1.Currency\n2.Distance\n3.Time\n4.Exit\n");
		System.out.println("Enter your choice: ");
		ch = sc.nextInt();
		switch(ch)
		{
		case 1 : 
			System.out.println("a.Rs - Dollar\tb.Dollar - Rs\nc.Rs - Euro\td.Euro - Rs\ne.Rs - Yen\tf.Yen - Rs\n");
			System.out.println("Choose your conversion Type: ");
			ch1 = sc.nextInt();
		case 2 :
			System.out.println("a.meter - km\nb.miles - km\nc.km - meter\nd.km - miles\n");
			System.out.println("Choose your conversion Type: ");
			ch2 = sc.nextInt();
		case 3 :
			System.out.println("a.hrs - min\nb.hrs - sec\nc.sec - hrs\nd.min - hrs\n");
			System.out.println("Choose your conversion Type: ");
			ch3 = sc.nextInt();
		case 4 :
			System.out.println("Thanks for using!!!");
			System.exit(0);
		}
		
	}

}
