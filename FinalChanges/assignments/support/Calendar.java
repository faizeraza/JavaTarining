package assignments.support;

import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.DateComparator;
import assignments.support.operations.DateManipulation;
import assignments.support.operations.DueInBetween;
import assignments.support.operations.LeapYearDetector;
import assignments.support.operations.WeekendCounter;
import assignments.support.operations.WithZone;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;

public class Calendar {
    private LocalDateTime startDateParsed,endDateParsed;
    private ArrayList<LocalDateTime> holidayList;
    private int businessDays;
    private InputHandler inputHandler = new InputHandler();

    public Calendar() {
        this.startDateParsed = LocalDateTime.now(ZoneOffset.UTC);
        this.endDateParsed = LocalDateTime.now(ZoneOffset.UTC);
    }
    public Calendar(LocalDateTime startDate) {
        this.startDateParsed = startDate;

    }
    public Calendar(LocalDateTime startDate, LocalDateTime enDate) {
        this.startDateParsed = startDate;
        this.endDateParsed = enDate;
    }
    public Calendar(LocalDateTime startDateParsed, ArrayList<LocalDateTime> holidayList) {
        this.startDateParsed = startDateParsed;
        this.holidayList = holidayList;
    } 
    public Calendar(LocalDateTime startDateParsed, LocalDateTime endDateParsed, ArrayList<LocalDateTime> holidayList) {
        this.startDateParsed = startDateParsed;
        this.endDateParsed = endDateParsed;
        this.holidayList = holidayList;
    }
    public Calendar( ArrayList<LocalDateTime> holidayList, LocalDateTime startDateParsed, int businessDays) {
        this.startDateParsed = startDateParsed;
        this.holidayList = holidayList;
        this.businessDays = businessDays;
    }
    
    public void setStartDateParsed(LocalDateTime startDateParsed) {
        this.startDateParsed = startDateParsed;
    }
    public void setHolidayList(ArrayList<LocalDateTime> holidayList) {
        this.holidayList = holidayList;
    }

    public ArrayList<String> getCurrentDateTime(){
        // instead of passing the String manualluy,
        // created an array passing the patter string to formatter for object generation.
        return new DateManipulation().getDateInFormates(startDateParsed);
    }
    
    public ArrayList<String> getWithISTzone(){

        // instead of passing the String manualluy,
        // created an array passing the pattern string and formatter object generation.

        return new DateManipulation().getDateInFormates(startDateParsed);
    }

    // methode to get time with provided zone id
    public String getWithZone(){
        ZoneId zone = inputHandler.getZone();   // takes the input from user return thr ZoneId object
        return new WithZone(zone).getWithZone();    // calling the support class methode
    }

    // methode to find difference among two dates
    public HashMap<String, Integer> dueInBetween(){
        return new DueInBetween(startDateParsed, endDateParsed).dueInBetween();
    }

    // methopde to check if given date is leap year or not
    public boolean isInLeapYear(){
      return new LeapYearDetector(startDateParsed).isInLeapYear();
    }

    // to compare the dates
    public String dateComparision(){
       return new DateComparator(startDateParsed, endDateParsed).dateComparision();
    }

    // to count weekends
    public int countWeekEnds(){
        return new WeekendCounter(startDateParsed, endDateParsed).countWeekEnds();
    }

    // ccheck if working day or not 
    public boolean isWorkingDay() throws NullPointerException{
            DayOfWeek day = startDateParsed.getDayOfWeek();
        return !(holidayList.contains(startDateParsed) || day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY));
    }

    // count working days for user
    public int countWorkingDays(){
        int count = 0;
        LocalDateTime day = startDateParsed;    // day tracker 

        
        do{ // while day is earlier than end date
            if (isWorkingDay()){    //if it is saturday or sunday increament count
                count++;    //counter
            }
            day = day.plusDays(1);
            startDateParsed = day;
        }
        while (!day.isAfter(endDateParsed));
        return count;
    }

    // methode to calculate relative date based on the business days provided 
    public LocalDateTime getRelativeDate(){
        LocalDateTime temp = startDateParsed;   // store the surrent startDatePares as we will be manipulating it with isWorkingDay()
        LocalDateTime relativeDate;             // to store final calculated relative date
        int dayDirection = businessDays>0? 1 : -1 ;         //if working days are +ve set dayDirection as 1 else -1
        while(businessDays!=0){                             // until businessDays gets 0
            startDateParsed = startDateParsed.plusDays(dayDirection);   //increasment or derement days based on drection will be increamenting anyways
            if (isWorkingDay())                         // check if day current day is working day we will
                businessDays-=dayDirection;             // decrement businessDays by direction which can be -1/+1
        }
        relativeDate = startDateParsed;     // store current result
        setStartDateParsed(temp);           // set back the startDateParsed
        return relativeDate;    
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

}
