package com.eric.education.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author liuyang
 * @create 2018-06-01 17:26
 * @desc
 */
public class DateUtils {

    /**
     * 当天起始时间   2018-06-01 00:00:00
     * @return
     */
    public static Date getTodayStartTime() {
        return getStartTime(-12);
    }

    /**
     * 当天结束时间   2018-06-01 23:59:59
     * @return
     */
    public static Date getTodayEndTime() {
        return getEndTime(11);
    }

    /**
     * 前一天起始时间   2018-06-01 00:00:00
     * @return
     */
    public static Date getPreDayStartTime() {

        return getStartTime(-36);
    }

    /**
     * 前一天结束时间   2018-06-01 23:59:59
     * @return
     */
    public static Date getPreDayEndTime() {

        return getEndTime(-13);
    }



    public static Date getEndTime(int num){
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR, num);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static Date getStartTime(int num) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR, num);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

}
