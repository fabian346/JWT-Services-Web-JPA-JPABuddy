package com.kardex.api.commons.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
public class DateUtils {

    @Value("${jms.jwt.time-zone}")
    private String TIMEZONE;

    private SimpleDateFormat simpleDateFormat(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        return sdf;
    }
    public String getDateString(){
        Date now = new Date();
        return simpleDateFormat().format(now);
    }

    public long getDateMillis(){

        Date now = new Date();
        String date = simpleDateFormat().format(now);
        Date srcNow = new Date();

        try {
            srcNow = simpleDateFormat().parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return srcNow.getTime();
    }
}
