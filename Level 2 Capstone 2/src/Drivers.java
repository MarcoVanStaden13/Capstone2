import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Drivers class for driver object creation
public class Drivers {

    static String drivName; // The name of the driver.
    static String drivLocation; // The location of the driver.
    static String drivLoad; // The current load of the driver.
    public static void driver(String loc) {
    	// Open the driver-info.txt file to read the driver information.
        File driverText = new File("driver-info.txt");
        Scanner driverTextSc = null;
        int smallestLoad = Integer.MAX_VALUE;
      //find all drivers with the same location as the restaurant before finding
      //the driver with the lowest load
        try {
            // Create a scanner object to read the driver-info.txt file.
            driverTextSc = new Scanner(driverText);

            // Read each line of the file and find the driver with the lowest load in the given location.
            while (driverTextSc.hasNext()) {
                String line = driverTextSc.nextLine();
                if (line.contains(loc)) { // If the line contains the given location.
                    String[] splitLine = line.split(","); // Split the line by comma.
                    int load = Integer.parseInt(splitLine[2].trim()); // Parse the load as an integer.
                    if (load < smallestLoad) { // If the load is smaller than the smallest load found so far.
                        smallestLoad = load; // Update the smallest load.
                        drivName = splitLine[0]; // Update the driver name.
                        drivLocation = splitLine[1]; // Update the driver location.
                        drivLoad = splitLine[2]; // Update the driver load.
                    }
                }
            }
            driverTextSc.close(); // Close the scanner object.
        } catch (FileNotFoundException e) {
            System.out.println("Error reading driver-info.txt"); // If the file is not found, print an error message.
        }
    }
}