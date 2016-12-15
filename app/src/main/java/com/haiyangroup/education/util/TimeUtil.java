package com.haiyangroup.education.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Administrator on 2016/1/29.
 */
public class TimeUtil {

    static String DEFAULT_PATTERN="yyyy-MM-dd HH:mm:ss";

    public static String timestamp2str(Timestamp time, String pattern) {
        if (time == null) {
            throw new IllegalArgumentException("Timestamp is null");
        }
        if (pattern != null && !"".equals(pattern)) {
            if (!"yyyyMMddHHmmss".equals(pattern)
                    && !"yyyy-MM-dd HH:mm:ss".equals(pattern)
                    && !"yyyy-MM-dd".equals(pattern)
                    && !"MM/dd/yyyy".equals(pattern)){
                throw new IllegalArgumentException("Date format ["+pattern+"] is invalid");
            }
        }else{
            pattern = DEFAULT_PATTERN;
        }

        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        cal.setTime(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(cal.getTime());
    }

    public static void main(String[] args){
        Long i=new Long("1453791599000");
        System.out.println(timestamp2str(new Timestamp(i),""));
    }
}
