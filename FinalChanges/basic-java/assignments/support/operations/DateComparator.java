package assignments.support.operations;

import java.time.LocalDateTime;


public class DateComparator {
    LocalDateTime firstDateTime , secondDateTime;
    
    public DateComparator(LocalDateTime firstDateTime ,LocalDateTime secondDateTime) {
        this.firstDateTime = firstDateTime;
        this.secondDateTime = secondDateTime;
    }

    public String dateComparision(){

        if (firstDateTime.isEqual(secondDateTime)){
            return "Both Dates are equals";
        }
        else if (firstDateTime.isBefore(secondDateTime)){
            return " "+firstDateTime+" is Earlier than "+secondDateTime;
        }
        else{
            return " "+ firstDateTime +" is later than "+ secondDateTime;
        }
    }
}
