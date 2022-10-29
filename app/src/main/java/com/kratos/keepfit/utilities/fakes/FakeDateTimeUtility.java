package com.kratos.keepfit.utilities.fakes;

import com.kratos.keepfit.utilities.interfaces.DateTimeUtility;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;

/** Fake DateTimeUtility implementation class. */
public class FakeDateTimeUtility implements DateTimeUtility {

    /** Constructs a new instance. */
    @Inject
    public FakeDateTimeUtility() {

    }

    @Override
    public long numberOfDaysBetween(Date firstDate, Date secondDate) {
        return 0;
    }

    @Override
    public String getAppropriateGreeting() {
        String appropriateGreeting;
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay < 12){
            appropriateGreeting = "Good Morning";
        }
        else if(timeOfDay < 16){
            appropriateGreeting = "Good Afternoon";
        }
        else {
            appropriateGreeting = "Good Evening";
        }
        return appropriateGreeting;
    }
}

