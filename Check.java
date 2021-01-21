package assessment;

import java.util.ArrayList;

public class Check {
	//Fields
	String check;
	ArrayList<Food> food;
	ArrayList<Integer> prices;
	int total;
	
	//Constructor: The Check class admits the name of the customer to appear on the check, and initializes lists for food and their prices, as well as a total
	//Method: String name
	public Check(String name) {
		this.check = name + "'s Check:\n";
		this.food = new ArrayList<Food>();
		this.prices = new ArrayList<Integer>();
		this.total = 0;
	}
	//Method: addToCheck is called by the robot whenever he hands an order to the chef, and adds the desried item as well as its price to the check
	//Param: Food food, int price
	public void addToCheck(Food food, int price) {
		this.check += food.name + ": $" + price + "\n";
		this.food.add(food);
		this.prices.add(price);
		this.total += price;
	}
	//Method: orderComplete is called by the robot when a customers order has been fulfilled, and it prints out the resulting check
	//Param: none
	public void orderComplete() {
		System.out.println(check);
	}
}
