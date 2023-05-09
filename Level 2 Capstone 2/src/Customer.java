//Customer class for customer object creation
public class Customer {
	//Customer attributes
	String cusName; // Name of the customer.
	String cusContactNumber; // Contact number of the customer.
	String cusAddress; // Address of the customer.
	String cusLocation; // City of the customer.
	String cusEmailAdd; // Email address of the customer.

	// This is the constructor method for the Customer class.
	// Initializes the instance variables with the values provided as arguments.
	public Customer(String cusName, String cusContactNumber, String cusAddress, 
							String cusLocation, String cusEmailAdd) {
		this.cusName = cusName;
		this.cusContactNumber = cusContactNumber;
		this.cusAddress = cusAddress;
		this.cusLocation = cusLocation;
		this.cusEmailAdd = cusEmailAdd;
	}
	
	//toString method returns a String representation of the customer object.
	public String toString() {
		  String output = "Name: " + cusName;
		  output += "\nContact Number: " + cusContactNumber;
		  output += "\nAddress: " + cusAddress;
		  output += "\nCity: " + cusLocation;
		  output +="\nEmail-Address: " + cusEmailAdd;
		  return output;
	}
}