//Customer class for customer object creation
public class Customer {
	//Attributes
	String cusName;
	String cusContactNumber;
	String cusAddress;
	String cusLocation;
	String cusEmailAdd;
	// Methods
	public Customer(String cusName, String cusContactNumber, String cusAddress, 
							String cusLocation, String cusEmailAdd) {
		this.cusName = cusName;
		this.cusContactNumber = cusContactNumber;
		this.cusAddress = cusAddress;
		this.cusLocation = cusLocation;
		this.cusEmailAdd = cusEmailAdd;
	}
	public String toString() {
		  String output = "Name: " + cusName;
		  output += "\nContact Number: " + cusContactNumber;
		  output += "\nAddress: " + cusAddress;
		  output += "\nCity: " + cusLocation;
		  output +="\nEmail-Address: " + cusEmailAdd;
		  return output;
	}
}