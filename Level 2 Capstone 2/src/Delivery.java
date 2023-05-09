import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Delivery {
	//Attributes
	static Map<String, Integer> itemQuantityMap = new HashMap<>();
	static String instructions;
	static double totalCost;
	// Methods
	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		//Scanner objects retrieve data from user to be placed into all objects
		Scanner scanner = new Scanner(System.in);
		
		// Gets the customer details from user
		System.out.println("Enter your name: ");
		String inputCName = scanner.nextLine();
		
		System.out.println("Enter your number: ");
		String inputCNum = scanner.nextLine();
		
		System.out.println("Enter your address: ");
		String inputCAdd = scanner.nextLine();
		
		System.out.println("Enter your City: ");
		String inputCLoc = scanner.nextLine();
		
		System.out.println("Enter your E-mail: ");
		String inputCE= scanner.nextLine();
		
		// Gets the restaurant details from user
		System.out.println("Enter the restaurant name: ");
		String inputRName= scanner.nextLine();
		
		System.out.println("Enter the restaurant number: ");
		String inputRNum = scanner.nextLine();
		
		System.out.println("Enter the restaurant City: ");
		String inputRLoc= scanner.nextLine();
		
		//Prints the menu to the console for the customer to order from
		System.out.println("Menu Items:");
		System.out.println("1. Burger - R43.23");
		System.out.println("2. Ribs - R128.90");
		System.out.println("3. Soup - R65.00");
		System.out.println("4. Pizza - R74.00");
		System.out.println("5. Chips - R20.00");
		System.out.println("6. CocaCola - R21.99");
		System.out.println("7. Milk Shake - R35.00");
		System.out.println("8. IceCream - R35.50");
		System.out.println("9. Water - R8.00");
		
		//Prompts customer for the order detains such as which items and any special requests
		System.out.println("Enter your order (separated by spaces):");
		String order = scanner.nextLine();

		// Splits the order input and count the quantity of each item
		String[] items = order.split(" ");
		for (String item : items) {
		    int quantity = itemQuantityMap.getOrDefault(item, 0) + 1;// Gets the current quantity of the item, or 0 if it's not in the map, and increments it
		    itemQuantityMap.put(item, quantity); // Updates the map with the new quantity
		}
		
		// Calculates the total cost of the order
		 totalCost = 0.0;
		String[] costs = order.split(" ");
		for (String item : costs) {
		    if (item.equals("1")) {
		        totalCost += 43.23;
		    } else if (item.equals("2")) {
		        totalCost += 128.90;
		    } else if (item.equals("3")) {
		        totalCost += 65.00;
		    } else if (item.equals("4")) {
		        totalCost += 74.00;
		    } else if (item.equals("5")) {
		        totalCost += 20.00;
		    } else if (item.equals("6")) {
		        totalCost += 21.99;
		    } else if (item.equals("7")) {
		        totalCost += 35.00;
		    } else if (item.equals("8")) {
		        totalCost += 35.50;
		    } else if (item.equals("9")) {
		        totalCost += 8.00;
		    }
		}
		// Display the total cost
		System.out.println("Enter any special preparation instructions?:");
		instructions = scanner.nextLine();
		scanner.close();
		System.out.println("Your order has been recieved and your reciept has been generated");
		
		//New Customer, Restaurant and Driver Creation
		Customer newCustomerObj = new Customer(inputCName, inputCNum, inputCAdd, inputCLoc, 
							inputCE);
		Restaurant newRestaurantObj = new Restaurant(inputRName, inputRNum, inputRLoc);
		Drivers newDriverObj = new Drivers();
		
		newDriverObj.driver(newRestaurantObj.resLocation);
		printReciept(newCustomerObj, newRestaurantObj, newDriverObj);
	}
	@SuppressWarnings("static-access")
	
	//Receipt printer class
	public static void printReciept(Customer customer, Restaurant restaurant, Drivers driver) {
		if (customer.cusLocation.equals(driver.drivLocation.trim())) {
			//Writes customer information, restaurant information and driver information to
			//the "reciept.txt" document
			try {
				FileWriter recieptWriter = new FileWriter("reciept.txt");
				recieptWriter.write("Order number 1234");
				recieptWriter.write("\nCustomer: " + customer.cusName);
				recieptWriter.write("\nEmail: " + customer.cusEmailAdd);
				recieptWriter.write("Phone Number: " + customer.cusContactNumber);
				recieptWriter.write("\nLocation: " + customer.cusLocation);
				recieptWriter.write("\n\nYou have ordered the following from " +restaurant.resName + " in "
									+ restaurant.resLocation + ": \n");
				//for loop loops through map to find all corresponding objects and groups 
				//them in the final text document
				for (String item : itemQuantityMap.keySet()) {
				    int quantity = itemQuantityMap.get(item);
				    if (item.equals("1")) {
				    	recieptWriter.write("\n" + quantity + " x Burger (R43.23)");
				    } else if (item.equals("2")) {
				    	recieptWriter.write("\n" + quantity + " x Ribs (R128.90)");
				    } else if (item.equals("3")) {
				    	recieptWriter.write("\n" + quantity + " x Soup (R65.00)");
				    }else if (item.equals("4")) {
				    	recieptWriter.write("\n" + quantity + " x Pizza (R74.00)");
				    }else if (item.equals("5")) {
				    	recieptWriter.write("\n" + quantity + " x Chips (R20.00)");
				    }else if (item.equals("6")) {
				    	recieptWriter.write("\n" + quantity + " x CocaCola (R21.99)");
				    }else if (item.equals("7")) {
				    	recieptWriter.write("\n" + quantity + " x Milk Shake (R35.00)");
				    }else if (item.equals("8")) {
				    	recieptWriter.write("\n" + quantity + " x IceCream (R35.50)");
				    }else if (item.equals("9")) {
				    	recieptWriter.write("\n" + quantity + " x Water (R8.00)");
				    }
				}
				
				// Writes the special instructions, total cost, driver name and location, customer address and location,
				// and restaurant contact number to the receipt file
				recieptWriter.write("\n\nSpecial instructions: " + instructions);
				recieptWriter.write("\n\nTotal: R" + totalCost);
				recieptWriter.write("\n\n" + driver.drivName 
										+ " is nearest to the restaurant and so they will be delivering your");
				recieptWriter.write("\norder to you at:\n");
				recieptWriter.write("\n" + customer.cusAddress);
				recieptWriter.write("\n" + customer.cusLocation);
				recieptWriter.write("\n\nIf you need to contact the restaurant, their number is "
									+ restaurant.resContactNumber);
				
				// Closes the receipt file writer
				recieptWriter.close();
			} catch(IOException e) {
				 // Prints an error message if there was an issue writing to the receipt file
				System.out.println("Could not write to 'reciept.txt'");
			}
		} else {
			// Prints a message indicating that there are no drivers available to deliver to the customer's location
			System.out.println("Sorry! Our drivers are too far away from you" 
								+ " to be able to deliver to your location.");
		}
	}
}