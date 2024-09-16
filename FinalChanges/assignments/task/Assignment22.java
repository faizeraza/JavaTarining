package assignments.task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import assignments.support.Calendar;
import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.BasicDateOperations;

public class Assignment22 implements Task<String> {
    private ArrayList<LocalDateTime> dates; // List to store holiday dates

    // Override the execute method from the Task interface
    @Override
    public String execute() {

        // Create an instance of InputHandler to handle user inputs
        InputHandler inputHandler = new InputHandler();
        
        // Create an instance of BasicDateOperations for handling date parsing and formatting
        BasicDateOperations dateOperations = new BasicDateOperations();

        // Prompt the user to enter holiday dates and store them in the dates list
        dates = inputHandler.getDateList("Enter Holiday Date: ", dateOperations);

        String[] dateData;
        
        // Get the starting date and its format using getDate method from InputHandler
        dateData = inputHandler.getDate("Enter Starting date : ", dateOperations);
        String firstDate = dateData[0]; // Extract the date as a string
        String firstDateFormat = dateData[1]; // Extract the date format
        
        // Get the ending date and its format using getDate method from InputHandler
        dateData = inputHandler.getDate("Enter Ending date : ", dateOperations);
        String secondDate = dateData[0]; // Extract the date as a string
        String secondDateFormat = dateData[1]; // Extract the date format

        // Convert the start and end date strings into LocalDateTime using the detected formats
        LocalDateTime startDateParsed = dateOperations.convertToStandardFormat(firstDate, firstDateFormat);
        LocalDateTime endDateParsed = dateOperations.convertToStandardFormat(secondDate, secondDateFormat);

        // Create a Calendar instance with the parsed start date, end date, and list of holidays
        Calendar calendar = new Calendar(startDateParsed, endDateParsed, dates);

        // Return the number of working days between the start and end dates, excluding holidays
        return "Number of working days are: " + calendar.countWorkingDays();
    }
}
