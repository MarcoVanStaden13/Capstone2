//Restaurant class for restaurant object creation
public class Restaurant {
	
	//Attributes
	String resName;
	String resContactNumber;
	static String resLocation;
	
	// Methods
	@SuppressWarnings("static-access")
	public Restaurant(String resName, String resContactNumber, String resLocation) {
		this.resName = resName;
		this.resContactNumber = resContactNumber;
		this.resLocation = resLocation;
	}
	   public String toString() {
	      String output = "Name: " + resName;
	      output += "\nContact Details: " + resContactNumber;
	      output +="\nLocation: " + resLocation;
	      return output;
	   }
}