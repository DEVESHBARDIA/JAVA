package programs;

import java.util.Scanner;

public class Knapsack {
	public static void main(String[] args) {
		Greedy greedy = new Greedy();
		greedy.setItems();
		greedy.collectItems();
		greedy.printBagItems();
	}
}

class Item {
	String name;
	int weight, value, index;
	float unitValue;
	
	Item(String name, int weight, int value, int index, float unitValue) {
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.index = index;
		this.unitValue = unitValue;
	}
}

class Greedy {
	
	int n;
	Item[] items;
	Item[] bag;
	
	Scanner sc = new Scanner(System.in);

	public void sort() {
		for (int i=1;i<items.length;i++)
			for (int j=0;j<items.length-1;j++)
				if (items[j].unitValue < items[j+1].unitValue) {
					Item temp = items[j];
					items[j] = items[j+1];
					items[j+1] = temp;
				}
	}
	
	public void setItems() {
		System.out.print("Enter the number of items: ");
		n = sc.nextInt();
		
		items = new Item[n];
		
		for (int i=0;i<n;i++) {
			System.out.println("Details of item "+(i+1));
			System.out.print("Enter item name: ");
			String name = sc.next();
			System.out.print("Enter the weight: ");
			int weight = sc.nextInt();
			System.out.print("Enter the value: ");
			int value = sc.nextInt();
			System.out.println();
			items[i] = new Item(name, weight, value, i, (float)value/weight);
		}
		sort();
	}
	
	public void collectItems() {
		System.out.print("Enter bag size: ");
		int space = sc.nextInt();
		bag = new Item[space];
		for (int i=0;i<items.length;i++) {
			int weight = 0;
			while (items[i].weight != 0 && space > 0) {
				items[i].weight--;
				weight++;
				space--;
			}
			bag[i] = new Item(items[i].name, weight, items[i].value, items[i].index, items[i].unitValue);
			
			if (space == 0)
				break;
		}
	}
	
	public void printBagItems() {
		for (int i=0;i<bag.length;i++) {
			if (bag[i] == null)
				break;
			System.out.println("Item "+(i+1)+": [Name: "+bag[i].name+" | Weight: "+bag[i].weight+" | Value: "+bag[i].value+" | Unit Value: "+bag[i].unitValue);
		}
	}
}
