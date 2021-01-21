package assessment;

public class Food {
	String name;
	final int cookTime;
	int cooking;
	int price;
	
	//Constructor: Food accepts a name, time to cook, and a price
	//Param: String name, int time, int price
	public Food(String name, int time, int price) {
		this.name = name;
		this.cookTime = time;
		this.cooking = time;
		this.price = price;
	}
	
	public void cook() {
		cooking--;
	}
	
	public boolean checkIfCooked() {
		return cooking <= 0;
	}
}
