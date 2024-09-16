package assignments.task;

import assignments.support.Calendar;
import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.BasicDateOperations;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Assignment23 implements Task<String>{
    private ArrayList<LocalDateTime> dates;
    @Override
    public String execute() {
                String[] dateData;                                                  // Temporary Array created for storing ConsoleInputHandler.getDate() methode output
                InputHandler inputHandler = new InputHandler();
                BasicDateOperations dateOperations = new BasicDateOperations();
        
                dates = inputHandler.getDateList("Enter Holiday Date: ", dateOperations);
                // Geting Start Date and detecting its formate
                dateData = inputHandler.getDate("Enter date to find its relative date: ",dateOperations);    // Calling getDate methode from support class which returns date and its formate 
                String date = dateData[0];
                String dateFormat = dateData[1];
                
        
                // for this problem time duration is mendatory so adding default 00:00:00 into dates if not provided
                LocalDateTime dateTime = dateOperations.convertToStandardFormat(date, dateFormat);   
                
                // get business days from user
                int businessDays = inputHandler.getIntInput("Enter Businress Days: ");

                Calendar calendar = new Calendar(dates,dateTime,businessDays);  // initialize the constructor with businessDays
                return "The Relative Date Excluding Weekends from "+dateTime.toLocalDate()+" is "+calendar.getRelativeDate().toLocalDate();
    }
}
