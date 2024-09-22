package com.maxeta;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Counter{
    
    //Decimal formatting
    private static DecimalFormat df = new DecimalFormat("00");
    
    //Hashmap for converting military time to standard time
    private static HashMap<Integer, Integer> standardTime;
    static{
        standardTime = new HashMap<>();
        standardTime.put(0,12);
        standardTime.put(1, 1);
        standardTime.put(2, 2);
        standardTime.put(3, 3);
        standardTime.put(4, 4);
        standardTime.put(5, 5);
        standardTime.put(6, 6);
        standardTime.put(7, 7);
        standardTime.put(8, 8);
        standardTime.put(9, 9);
        standardTime.put(10,10);
        standardTime.put(11, 11);
        standardTime.put(12, 12);
        standardTime.put(13, 1);
        standardTime.put(14, 2);
        standardTime.put(15, 3);
        standardTime.put(16, 4);
        standardTime.put(17, 5);
        standardTime.put(18, 6);
        standardTime.put(19, 7);
        standardTime.put(20, 8);
        standardTime.put(21, 9);
        standardTime.put(22,10);
        standardTime.put(23, 11);
    }
    //instance variables
    private int hours;
    private int minutes;
    private int seconds;
    private boolean isStandard;
    private int standardHours;
    

    public Counter(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        isStandard = false;
        this.standardHours = 0;
    }

    public Counter(int hours, int minutes, int seconds){
        
        if(hours < 0 || minutes < 0 || seconds < 0){
            throw new IllegalArgumentException("ERROR: cannot initialize a timer with negative values.");
        }

        if(hours > 23){
            throw new IllegalArgumentException("ERROR: Cannot initialize a timer beyond 23 hours.");
        }
        if(minutes > 60){
            throw new IllegalArgumentException("ERROR: Cannot initialize a timer beyond 59 minutes.");
        }
        if(seconds > 60){
            throw new IllegalArgumentException("ERROR: Cannot initialize a timer beyond 59 seconds.");
        }
        
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.standardHours = standardTime.get(hours);
    }

    public void incrementSecond(){
        this.seconds++;
        if(this.seconds == 60){
            this.seconds = 0;
            this.minutes++;
            if(this.minutes == 60){
                this.minutes = 0;
                this.hours++;
                if(this.hours == 24){
                    this.hours = 0;
                }
            }
        }
    }

    public void decrementSecond(){
        if(this.seconds > 0){
            this.seconds--;
            return;
        }else{
            throw new IllegalArgumentException("ERROR: Seconds are already at zero.");
        }
    }

    public void incrementMinute(){
        this.minutes++;
        if(this.minutes == 60){
            this.minutes = 0;
            this.hours++;
            if(this.hours == 24){
                this.hours = 0;
            }
        }
    }

    public void decrementMinute(){
        if(this.minutes > 0){
            this.minutes--;
            return;
        }else{
            throw new IllegalArgumentException("ERROR: Minutes are already at zero.");
        }
    }

    public void incrementHour(){
        this.hours++;
        if(this.hours == 24){
            this.hours = 0;
        }
        this.standardHours = standardTime.get(this.hours);
    }

    public void decrementHour(){
        if(this.hours > 0){
            this.hours--;
            this.standardHours = standardTime.get(this.hours);
        }else{
            throw new IllegalArgumentException("ERROR: hours are already at zero.");
        }
    }

    public void toStandard(){
        isStandard = true;
    }

    public void toMilitary(){
        isStandard = false;
    }

    public int getSeconds(){
        return this.seconds;
    }

    public int getMinutes(){
        return this.minutes;
    }

    public int getHours(){
        return this.hours;
    }

    public String toString(){
        
        String str = "";
        
        String hours = df.format(this.hours);
        String minutes = df.format(this.minutes);
        String seconds = df.format(this.seconds);
        String standardHours = df.format(this.standardHours);
        
        if(this.isStandard){
            str = str+standardHours+':'+minutes+':'+seconds;
            if(this.hours >= 12){
                str = str+" PM";
            }else{
                str = str+" AM";
            }
        }else{
            str = str+hours+':'+minutes+':'+seconds;
        }

        return str;
    }
}

 
