package com.github.sejoung.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author kim se joung
 *
 */
public abstract class DateUtils {
    
    private DateUtils() {
        throw new AssertionError();
    }

    public static String getCurrentDateTime(String pattern) {
        var time = LocalDateTime.now();
        return getFormatterDate(pattern, time);
    }

    public static String getFormatterDate(String pattern, LocalDateTime ldt) {
        var formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(ldt);
    }
    
    public static String getCurrentDateTime() {
        var time = LocalDateTime.now();
        return time.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
    
    public static String getCurrentDateTimeMinusDay(String pattern,long minusDay) {
        var time = LocalDateTime.now().minusDays(minusDay);
        return getFormatterDate(pattern, time);
    }

}
