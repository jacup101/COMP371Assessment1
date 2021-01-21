package assessment;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int timer = 0;
		Food food1 = new Food("pizza",27,20);
		Food food2 = new Food("sandwich",100,100);
		Food food3 = new Food("chinese food",100,100);
		ArrayList<Food> bigOrder = new ArrayList<Food>();
		bigOrder.add(food1); bigOrder.add(food2); bigOrder.add(food3);
				
		
		Restaurant restaurant = new Restaurant(2);
		restaurant.addCustomer("Person1", "water", 26, 18);
		restaurant.addCustomer("Person2", "food", 126, 42);
		restaurant.addCustomer("Person3", "pizza", 32, 21);
		restaurant.addCustomer("Person4", "candy", 5, 19);
		restaurant.addCustomer("Person5", "chicken", 2, 128);
		restaurant.addCustomer("Person6","cake",20,2,bigOrder);

		while(!restaurant.checkIfActive()) {
			restaurant.handleRestaurant();
			//Test That Customers Can Be Added Mid-Action
			timer++;
			if(timer==50) {
				restaurant.addCustomer("Person7", "quesadilla", 1000, 5);
			}
		}
		
		System.out.println("Total Earnings: $" + restaurant.earnings);
	}
	
	
}
