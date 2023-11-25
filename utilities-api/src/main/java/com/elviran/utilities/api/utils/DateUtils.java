package com.elviran.utilities.api.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
    /**
     * Get start date of a given year
     * @param year
     * @return
     */
    public static String startOfYear(Integer year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_YEAR, 1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * Get end date of a given year
     * @param year
     * @return
     */
    public static String endOfYear(Integer year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, 12);
        cal.set(Calendar.DAY_OF_YEAR, 1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }
}
