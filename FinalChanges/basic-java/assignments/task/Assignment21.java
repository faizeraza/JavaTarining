package assignments.task;

import assignments.support.Calendar;
import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.BasicDateOperations;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Assignment21 implements Task<String> {
    private ArrayList<LocalDateTime> dates;
    @Override
    public String execute() {
        // dateData is temporary set for storing date and its formate
        String[] dateData;                                               // Temporary Array created for storing InputHandler.getDate() methode output
        InputHandler inputHandler = new InputHandler();                                     // Init InputHandler class for taking date as input
        BasicDateOperations dateOperations = new BasicDateOperations();                     // BasicDateOperations is to perform basic operation over date 

        dates = inputHandler.getDateList("Enter Holiday Date: ", dateOperations);
        // Geting Start Date and detecting its formate
        dateData = inputHandler.getDate("Enter date to check holiday: ",dateOperations);    // Calling getDate methode from support class which returns date and its formate 
        String date = dateData[0];
        String dateFormat = dateData[1];
        

        // for this problem time duration is mendatory so adding default 00:00:00 into dates if not provided
        LocalDateTime dateTime = dateOperations.convertToStandardFormat(date, dateFormat);        
        Calendar calender = new Calendar(dateTime,dates);           // init the concrete class
        try {
            if (calender.isWorkingDay()){                       // true if given date is working day else false
                return "Provided Date is Working Day! \n    No Hloiday!!";
            }
            return "Hurrey Holiday!";
        } catch (NullPointerException e) {
            return "No holiday date provided into list";
        }
    }
}
