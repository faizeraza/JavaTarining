package assignments.task;

import assignments.support.Calendar;
// 16. Extend (14) to print supported timezones, and accept a valid timezone as input and print
// time as per the time zone selected by an end user.

public class Assignment16 implements Task<String>{
    public Assignment16() {
    }
    @Override
    public String execute() {
        Calendar withZone = new Calendar(); // init WithZone Support class 
        return withZone.getWithZone();  // call getWithZone methode
    }
}
