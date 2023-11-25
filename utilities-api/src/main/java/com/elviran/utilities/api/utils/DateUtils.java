package com.elviran.utilities.api.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    /**
     * Get start date of a given year
     *
     * @param year
     * @return
     */
    public static Date startOfYear(Integer year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    /**
     * Get end date of a given year
     *
     * @param year
     * @return
     */
    public static Date endOfYear(Integer year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, 12);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }
}
