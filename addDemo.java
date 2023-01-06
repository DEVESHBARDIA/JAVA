public class addDemo {

	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
		add s1 =new add();
		s1.area(5);
		s1.print();
		s1.area(5,8);
		s1.print();
		s1.area(5.0,5.0);
		s1.print();
	}

}

class add {

	double ans;
	double area(int p1){
		ans=p1*p1;
		return ans;
	}
	double area(double x, double y){
		ans= (x*y)/2;
		return ans;
	}
	double area(int p1, int p2){
		ans= p1*p2;
		return ans;
	}
	void print() {
		System.out.println("Area is= "+ans);
	}
}
