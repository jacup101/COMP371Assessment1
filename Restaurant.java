package assessment;

import java.util.ArrayList;

public class Restaurant {
	Robot[] robots;
	Chef chef;
	ArrayList<Customer> queue;
	int earnings;
	//Constructor: Restaurant is constructed with a number of robots that it uses, initializes them, the chef, and the empty queue of customers
	//Param: int numRobots
	public Restaurant(int numRobots) {
		this.chef = new Chef();
		this.robots = new Robot[numRobots];
		for(int i = 0; i < numRobots; i++) robots[i] = new Robot(this.chef);
		
		this.queue = new ArrayList<Customer>();
		this.earnings = 0;
	}
	
	//Method: addCustomer will take in a name, foodType, cookTime, and price for a Food that a Customer wants to order (For only 1 item orders)
	//Param: String name, String foodType, int cookTime, int price
	public void addCustomer(String name, String foodType, int cookTime, int price) {
		//Create Customer and Food
		Food food = new Food(foodType, cookTime, price);
		Customer customer = new Customer(name, food);
		assignCustomer(customer);
	}
	//Method: addCustomer will take in a name, foodType, cookTime, and price for a Food that a Customer wants to order. This version of the method allows for a list of Food to be given in addition to the first item ordered, allowing for multiple items to be ordered
	//Param: String name, String foodType, int cookTime, int price, ArrayList<Food> extraItems
	public void addCustomer(String name, String foodType, int cookTime, int price, ArrayList<Food> extraItems) {
		Food food = new Food(foodType, cookTime, price);
		Customer customer = new Customer(name, food,extraItems);
		assignCustomer(customer);
	}
	//Method: assignCustomer will check whether or not the customer can be immediately attended or added to a queue
	private void assignCustomer(Customer customer) {
		//Check for available Robot
		int robot = findNearestRobot();
		//Assign Customer to Robot or to Queue
		if(robot > -1 && queue.size()==0) {
			robots[robot].assignCustomer(customer);
		}
		
		else queue.add(customer);
	}
	//Method: findNearestRobot will go through the list of robots to check for an available one and return its index. If none are found, it returns -1
	//Param: none
	private int findNearestRobot() {
		for(int i = 0; i < robots.length; i ++) {
			if(robots[i].customer == null) {
				return i;
			}
		}
		return -1;
	}
	//Method: handleRestaurant() is called by the main method, and handles every part of the restaurant, including the Chef, Robots, Customers
	//Param: none
	public void handleRestaurant() {
		//Handle Robots
		for(int i = 0; i < robots.length; i++) {
			if(robots[i].customer != null) {
				robots[i].handle();
			}
			if(robots[i].tab > 0 ) this.earnings += robots[i].handleTab();
		}
		//Handle Chef
		chef.makeOrders();
		
		
		//Handle Queue
		if(queue.size()>0) {
			int robot = findNearestRobot();
			if(robot > -1) {
				robots[robot].assignCustomer(queue.remove(0));
			}
		}
	}
	//Method: checkIfActive() is called by the main method to check if there are any customers still unattended
	//Param: none
	public boolean checkIfActive() {
		boolean toReturn = true;
		if(queue.size()>0) toReturn = false;
		for(int i = 0; i < robots.length; i ++) {
			if(robots[i].customer != null) {
				toReturn = false;
			}
		}
		return toReturn;
	}

	
	
	
}
