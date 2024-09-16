package assignments.support.ioHandling;

import assignments.support.operations.BasicDateOperations;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputHandler {
    private final Scanner scanner; // declare new Scanner

    public InputHandler() {
        this.scanner = new Scanner(System.in);  // init scanner
    }

    // the input methode 
    public String getInput() {
        System.out.println("\u001B[32m"); // Change the color of text while taking input by user
        String input = scanner.nextLine();
        System.out.println("\u001B[37m"); // Revert Back to white text after taking input
        return input;
    }

    // @Override
    // public String validateInput(String input) {
    //     // Implement basic validation, e.g., non-empty input
    //     if (input == null || input.trim().isEmpty()) {
    //         System.out.println("Invalid input. Please try again.");
    //         return null;
    //     }
    //     return input;
    // }

    public String getStringInput(String message) {
        while (true) {           // Infinite loop to continuously prompt the user until valid input is received              
                System.out.println("\u001B[34m"+message+"\u001B[37m"); // Print the message to the user in blue text 34m is for blue
                return getInput();      // Get input from the user
        }
    }

    // converts the string into integer also prints the essential message/ guide
    public int getIntInput(String message) { // Applied recurssion here
            try {
                System.out.println("\u001B[34m"+message+"\u001B[37m");
                return Integer.parseInt(getInput()); // parse string to integer
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid number. Please enter a valid integer.\u001B[37m");
            }
            return getIntInput(message);
    }

    // to return input as double parses the input from String to Double
    public double getDoubleInput(String message) {
        while (true) {
            try {
                System.out.println("\u001B[34m"+message+"\u001B[37m");
                return Double.parseDouble(getInput());      // parse string to double
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid number. Please enter a valid decimal number.\u001B[37m");
            }
        }
    }

    // to return input as float parses the input from String >> Float
    public float getFloatInput(String message) {
        while (true) {
            try {
                System.out.println("\u001B[34m"+message+"\u001B[37m");
                return Float.parseFloat(getInput());    // parse string to float
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid number. Please enter a valid Float number.\u001B[37m");
            }
        }
    }

    public ArrayList<Float> getListInput(String message) {
        ArrayList<Float> numbers = new ArrayList<>();      //ArrayList to store the integer inputs from the user
        while (true) {
            System.out.println("\u001B[34m"+message+"\u001B[37m");
            String input = getInput();
            if (input.equalsIgnoreCase("proceed"))                  // If the user types "proceed", return the list of numbers
                return numbers;
            try {   // Try to parse the input as an integer and add it to the list
                numbers.add((Float.valueOf(input)));
            } catch (NumberFormatException e) {     // If the input is not a valid integer, print an error message in red
                System.out.println("\u001B[31m Invalid number. Please enter a valid Float number.\u001B[37m");
            }
        }
    }

     public ZoneId getZone() {
        String zone;    // Variable to store the user's zone input
        Set<String> zoneList = ZoneId.getAvailableZoneIds();     // Retrieves all available Zone IDs
        for(String zoneString : zoneList){ // prints available zone
            System.out.println(zoneString);
        }
        while (true) { // until user dont put correct zoneid
            System.out.println("\u001B[34mNote :::: Zone Id are case Sensitive\u001B[37m");
            System.out.println("Enter proper Zone Id from the above list EX :- \u001B[33mAsia/Kolkata\u001B[37m ");
            zone = getInput();
            if(zoneList.contains(zone)){    // Check if the input matches any of the available Zone IDs
                return ZoneId.of(zone);        // Return the valid Zone ID
            }
            System.out.println("\u001B[31mEnter your choice in a proper format\u001B[37m");
        }

    }

    public String[] getDate(String message, BasicDateOperations dateops){
        String[] date = new String[2];  // Array to store the input date string and its detected format
        while (true) {
                System.out.println("Supported Formate are: \n dd MMM yyyy, \n MMM dd, yyyy, \n yyyy-MM-dd,\n yyy-MM-dd'T'HH:mm:ss'Z',\n EEEE, dd MMMM yyyy, \n yyyy-MM-dd HH:mm:ss");
                System.out.println("\u001B[34m"+message+"\u001B[37m");
                date[0] =  getInput();  // Get the user's date input
                String formate = dateops.detectDateTimeFormat(date[0]); // Detect the format of the entered date string using the provided DateOperations instance
                if (formate!=null){ // If a valid format is detected
                    date[1]= formate;   // Store the detected format in the array
                    return date;    // // Return the date array containing the input string and its format
                }
                System.out.println("\u001B[31mEnter your Date in a proper format\u001B[37m");
        }
    }

    public ArrayList<LocalDateTime> getDateList(String message, BasicDateOperations dateops){
        ArrayList<LocalDateTime> dates = new ArrayList<>();      //ArrayList to store the integer inputs from the user
        while (true) {
                System.out.println("Supported Formate are: \n dd MMM yyyy, \n MMM dd, yyyy, \n yyyy-MM-dd,\n yyy-MM-dd'T'HH:mm:ss'Z',\n EEEE, dd MMMM yyyy, \n yyyy-MM-dd HH:mm:ss");
                System.out.println("\u001B[34m"+message+"\u001B[37m");
                String date =  getInput();  // Get the user's date input
                if (date.equalsIgnoreCase("proceed")){
                    return dates;
                }
                String formate = dateops.detectDateTimeFormat(date); // Detect the format of the entered date string using the provided DateOperations instance
                BasicDateOperations basicDateOps = new BasicDateOperations();
                if (formate!=null){ // If a valid format is detected
                    dates.add(basicDateOps.convertToStandardFormat(date, formate)) ;  // Store the detected format in the array
                }
                else{
                    System.out.println("\u001B[31mEnter your Date in a proper format\u001B[37m");
                }
        }
    }

    public HashSet<String> getWords(String message, String regex){
        HashSet<String> names = new HashSet<>();
        while (true) {           // Infinite loop to continuously prompt the user until valid input is received              
            System.out.println("\u001B[34m"+message+"\u001B[37m"); // Print the message to the user in blue text 34m is for blue
            String name = getInput();      // Get input from the user
            if (name.equalsIgnoreCase("done")){
                return names;
            }
            try {   
            if (!name.matches(regex)){
                throw new Exception("\u001B[31mEntered Name contains unalphabetical characters\u001B[37m");
            }
            names.add(name);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    // the resource must get free
    public void free() {
        scanner.close();
    }
}
