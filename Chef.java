package assessment;

import java.util.ArrayList;

public class Chef {

	ArrayList<Food> orders;
	
	public Chef() {
		orders = new ArrayList<Food>();
	}
	
	
	//Method: addOrder communicates with a robot to add a new order to the chefs queue
	//Param: none
	public void addOrder(Food food) {
		orders.add(food);
	}
	//Method: makeOrders runs through all orders to cook all of them. It first checks whether or not the order is already fully cooked and removes it if so
	//Param: none
	public void makeOrders() {
		for(int i = orders.size()-1; i >= 0; i--) {
			if(!orders.get(i).checkIfCooked()) {
				orders.get(i).cook();
			}
			if(orders.get(i).checkIfCooked()) {
				orders.remove(i);
			}
		}
	}
}
