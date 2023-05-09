import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Drivers class for driver object creation
public class Drivers {

    static String dName;
    static String dLocation;
    static String dLoad;
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
                        dName = splitLine[0];
                        dLocation = splitLine[1];
                        dLoad = splitLine[2];
                    }
                }
            }
            driverTextSc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading driver-info.txt");
        }
    }
}