//Customer class for customer object creation
public class Customer {
	//Attributes
	String cName;
	String cContactNumber;
	String cAddress;
	String cLocation;
	String cEmailAdd;
	// Methods
	public Customer(String cName, String cContactNumber, String cAddress, 
							String cLocation, String cEmailAdd) {
		this.cName = cName;
		this.cContactNumber = cContactNumber;
		this.cAddress = cAddress;
		this.cLocation = cLocation;
		this.cEmailAdd = cEmailAdd;
	}
	public String toString() {
		  String output = "Name: " + cName;
		  output += "\nContact Number: " + cContactNumber;
		  output += "\nAddress: " + cAddress;
		  output += "\nCity: " + cLocation;
		  output +="\nEmail-Address: " + cEmailAdd;
		  return output;
	}
}