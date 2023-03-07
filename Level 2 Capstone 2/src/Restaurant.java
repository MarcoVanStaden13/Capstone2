//Restaurant class for restaurant object creation
public class Restaurant {
	
	//Attributes
	String rName;
	String rContactNumber;
	static String rLocation;
	
	// Methods
	@SuppressWarnings("static-access")
	public Restaurant(String rName, String rContactNumber, String rLocation) {
		this.rName = rName;
		this.rContactNumber = rContactNumber;
		this.rLocation = rLocation;
	}
	   public String toString() {
	      String output = "Name: " + rName;
	      output += "\nContact Details: " + rContactNumber;
	      output +="\nLocation: " + rLocation;
	      return output;
	   }
}