import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Drivers class for driver object creation
public class Drivers {

    static String drivName;
    static String drivLocation;
    static String drivLoad;
    public static void driver(String loc) {
        File driverText = new File("driver-info.txt");
        Scanner driverTextSc = null;
        int smallestLoad = Integer.MAX_VALUE;
      //find all drivers with the same location as the restaurant before finding
      //the driver with the lowest load
        try {
            driverTextSc = new Scanner(driverText);
            while (driverTextSc.hasNext()) {
                String line = driverTextSc.nextLine();
                if (line.contains(loc)) {
                    String[] splitLine = line.split(",");
                    int load = Integer.parseInt(splitLine[2].trim());
                    if (load < smallestLoad) {
                        smallestLoad = load;
                        drivName = splitLine[0];
                        drivLocation = splitLine[1];
                        drivLoad = splitLine[2];
                    }
                }
            }
            driverTextSc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading driver-info.txt");
        }
    }
}