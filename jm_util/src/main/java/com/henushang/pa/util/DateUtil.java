package com.henushang.pa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtil {
    
    private static final Logger logger = Logger.getLogger(DateUtil.class);
    private static final String baseDayFormat = "yyyy-MM-dd";

    public static String today() {
        return after(0);
    }

    /**
     * 计算day天以后的日期，若为负数，则表示day天以前
     * 
     * @param day
     * @return
     */
    public static String after(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        SimpleDateFormat format = new SimpleDateFormat(baseDayFormat);
        return format.format(calendar.getTime());
    }

    
    public static Date toDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat(baseDayFormat);
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            logger.error("Parse to Date error! Param time:" + time, e);
        }
        return date;
    }
}
