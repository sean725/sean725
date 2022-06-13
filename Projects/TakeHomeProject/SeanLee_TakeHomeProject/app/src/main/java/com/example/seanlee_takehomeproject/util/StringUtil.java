package com.example.seanlee_takehomeproject.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

    public static final String MSG_LIKE = "Liked ";
    public static final String MSG_UNLIKE = "Unliked ";
    private static Toast mToast;

    // display pop-up toast
    public static void displayToast(Context _context, String _businessName, String _text){
        if(mToast != null){ mToast.cancel(); }
        mToast = Toast.makeText(_context, _text + _businessName, Toast.LENGTH_SHORT);
        mToast.show();
    }

    // converts year-month-day to time difference
    public static String calculateTimeDiff(String _date){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = null;
        try{
            date = format.parse(_date);
        }catch (ParseException e){
            e.printStackTrace();
        }

        int value = 0;
        String unit = "";

        Date curr = new Date();
        Log.i("StringUtil.TAG", "date value: " + date);
        long diffLong = curr.getTime() - date.getTime();
        double diff = (double) diffLong;

        double seconds = diff / 1000;
        double minutes = seconds / 60;
        double hours = minutes / 60;
        double days = hours / 24;
        double weeks = days / 7;
        double months = weeks / 4;
        double years = months / 12;

        if(minutes < 1){ // less than a minute -> just now
            unit = "just now";
            value = 0;
        }else if(1 < minutes && hours < 1){ // less than an hour -> 31 min
            unit = " min ago";
            value = (int) Math.ceil(minutes);
        }else if(1 < hours && days < 1){ // less than a day -> 19 hrs
            unit = " hour(s) ago";
            value = (int) Math.ceil(hours);
        }else if(1 < days && weeks < 1){ // less than a week -> 3 days
            unit = " day(s) ago";
            //value = (int) Math.ceil(hours)
            value = (int) Math.ceil(days);
        }else if(1 < weeks && months < 1){ // less than a month -> 3 weeks
            unit = " week(s) ago";
            value = (int) Math.ceil(weeks);
        }else if(1 < months && years < 1){ // less than a year -> 5 months
            unit = " month(s) ago";
            value = (int) Math.ceil(months);
        }else if(1 < years){ // more than a year -> 3 years
            unit = " year(s) ago";
            value = (int) Math.ceil(years);
        }

        if(value == 0) return unit;
        else return value + unit;
    }
}
