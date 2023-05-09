//Restaurant class for restaurant object creation
public class Restaurant {
	
	//Attributes
	String resName;	//The name of the restaurant
	String resContactNumber;	//The contact number of the restaurant
	static String resLocation;	//The location of the restaurant
	
	// This is the constructor method for the Restaurant class.
	// Initializes the instance variables with the values provided as arguments.
	@SuppressWarnings("static-access")
	public Restaurant(String resName, String resContactNumber, String resLocation) {
		this.resName = resName;
		this.resContactNumber = resContactNumber;
		this.resLocation = resLocation;
	}
	
	//toString method returns a String representation of the restaurant object.
	   public String toString() {
	      String output = "Name: " + resName;
	      output += "\nContact Details: " + resContactNumber;
	      output +="\nLocation: " + resLocation;
	      return output;
	   }
}