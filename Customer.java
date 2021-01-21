package assessment;

import java.util.ArrayList;

public class Customer {
	String name;
	Food food;
	Check check;
	ArrayList<Food> extraItems;
	ArrayList<Food> previousItems;
	//Constructor: This form of a customer only will order 1 item, so previous items and extra items are not necessary, but still initialized so as not to break code
	//Param: String name, Food food
	public Customer(String name, Food food) {
		this.name = name;
		this.food = food;
		this.check = new Check(this.name);
		this.previousItems = new ArrayList<Food>();
		this.extraItems = new ArrayList<Food>();
	}
	//Constructor: This form of a customer intends to order multiple items, but otherwise acts exactly the same
	//Param: String name, Food food, ArrayList<Food> extraItems
	public Customer(String name, Food food, ArrayList<Food> extraItems) {
		this.name = name;
		this.food = food;
		this.check = new Check(this.name);
		this.previousItems = new ArrayList<Food>();
		this.extraItems = extraItems;

	}
	//Method: deliverFood is called whenever a robot has brought the food to the customer. This method allows the customer to order additional items, or to complete their order
	//Param: none
	//Note: a value of null for food signals to the robot that the order is complete
	public void deliverFood() {
		previousItems.add(this.food);
		if(extraItems.size()>0) {
			this.food = extraItems.remove(0);
		} else {
			this.food = null;
		}
	}
}
