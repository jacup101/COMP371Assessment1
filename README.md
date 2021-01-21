# COMP371Assessment1
Author: Joshua Pulido
# Assumptions:
- There is one chef that can simulataneously cook all the food, and can cook anything ordered
- A restaurant will only have a small number of robots (<100)
- Unless otherwise specified (with a list of extra orders), a customer will only order 1 thing and then leave the restaurant
- All customers are assumed to be able to pay


# To Run:
- Compile code, then run Main (Main.java is set up to test some basic functionality, but the customers/restaurant can only be modified by changing the java file)
- To change the customers or add them, refer to the addCustomer() methods in Restaurant.java for parameters, or see as listed below:
- addCustomer(String name, String foodType, int cookTime, int price) OR addCustomer(String name, String foodType, int cookTime, int price,ArrayList<Food> extraItems)
