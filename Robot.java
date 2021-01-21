package assessment;

public class Robot {
	Chef chef;
	Customer customer;
	int tab;
	//Constructor: Robot takes a chef, which it is assigned to by the restaurant upon construction, and also initializes a customer of null
	//Param: Chef chef
	//Note: A null customer represents an available robot
	public Robot(Chef chef) {
		this.chef = chef;
		this.customer = null;
		this.tab = 0;
	}
	//Method: assignCustomer() is used to assign a new Customer to a robot, removing null from customer field
	//Param: Customer is the customer being assigned to this robot
	public void assignCustomer(Customer customer) {
		this.customer = customer;
		handToChef();
	}
	//Method: handToChef() is used by assignCustomer to hand information needed by the chef in order to create the order
	//Param: none
	public void handToChef() {
		chef.addOrder(customer.food);
		customer.check.addToCheck(customer.food, customer.food.price);
	}
	//Method: handle() allows a robot to check whether or not food has finished cooking
	//Param: none	
	//Tab is added only when the food has been cooked and handed to customer, handled by restaurant in separate method
	public void handle() {
		if(customer.food.checkIfCooked()) {
			customer.deliverFood();
			if(customer.food==null) {
				tab += customer.check.total;
				clearCustomer();
			} else {
				handToChef();
			}
			
			
		}
	}
	//Method: clearCustomer clears a robot after it has successfully served its customer
	//Param: none
	//Note: A null customer represents an available robot
	public void clearCustomer() {
		customer.check.orderComplete();
		customer = null;
	}
	//Method: handleTab allows the restaurant to collect earnings from the robot
	//Param: none
	public int handleTab() {
		int toReturn = tab;
		this.tab = 0;
		return toReturn;
	}
}
