import java.util.Scanner;

class animal {
	String name;
	String food;
	String sound;
	void read() {
		Scanner t=new Scanner(System.in);
		System.out.println("Enter the food: ");
		food = t.next();
		System.out.println("Enter the Sound: ");
		sound = t.next();
	}
	void display() {
		System.out.println("Food: "+food+"\nSound: "+sound);
	}
}

class Cat extends animal{
	
	void read() {
		System.out.println("Cat");
		super.read();
	}
	void display() {
		System.out.println("Cat");
		super.display();
	}
}

class Dog extends animal{
	void read() {
		System.out.println("Dog");
		super.read();
	}
	void display() {
		System.out.println("Dog");
		super.display();
	}
}

class Cow extends animal{
	void read() {
		System.out.println("Cow");
		super.read();
	}
	void display() {
		System.out.println("Cow");
		super.display();
	}
}
	

	
	public static void main(String[] args) {
		
	}

}
