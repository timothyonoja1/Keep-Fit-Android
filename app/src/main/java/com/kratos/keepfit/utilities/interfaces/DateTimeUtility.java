package com.kratos.keepfit.utilities.interfaces;

import java.util.Date;

public interface DateTimeUtility {

    long numberOfDaysBetween(Date firstDate, Date secondDate);

    String getAppropriateGreeting();
}
