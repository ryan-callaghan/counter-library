package com.maxeta;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CounterTests{

    private Counter counter;

    @Before
    public void setUp(){
        counter = new Counter();
    }

    @Test
    public void testIncrementSecond(){
        counter = new Counter(0, 0, 30);
        counter.incrementSecond();
        assertEquals("Seconds should increment by 1", 31, counter.getSeconds());
    }

    @Test
    public void testIncrementSecond2(){
        counter = new Counter(0, 0, 59);
        counter.incrementSecond();
        assertEquals("Minutes should increment by 1", 1, counter.getMinutes());
    }

    @Test
    public void testIncrementSecond3(){
        counter = new Counter(0, 59, 59);
        counter.incrementSecond();
        assertEquals("Hours should increment by 1", 1, counter.getHours());
    }
    
    @Test
    public void testDecrementSecond(){
        counter = new Counter(0,0,1);
        counter.decrementSecond();
        assertEquals("Seconds should decrement by 1", 0, counter.getSeconds());
    }

    @Test
    public void testIncrementMinute(){
        counter = new Counter(0, 30, 0);
        counter.incrementMinute();
        assertEquals("Minutes should increment by 1", 31, counter.getMinutes());
    }

    @Test
    public void testIncrementMinute2(){
        counter = new Counter(0, 59, 0);
        counter.incrementMinute();
        assertEquals("Minutes should increment to 0", 0, counter.getMinutes());
    }

    @Test
    public void testIncrementMinute3(){
        counter = new Counter(0, 59, 0);
        counter.incrementMinute();
        assertEquals("Hours should increment by 1", 1, counter.getHours());
    }

    @Test
    public void testDecrementMinute(){
        counter = new Counter(0,1,0);
        counter.decrementMinute();
        assertEquals("Minutes should decrement by 1", 0, counter.getMinutes());
    }
    
    @Test
    public void testIncrementHour(){
        counter = new Counter(1,0,0);
        counter.incrementHour();
        assertEquals("Hours should increment by 1", 2, counter.getHours());
    }

    @Test
    public void testIncrementHour2(){
        counter = new Counter(23,0,0);
        counter.incrementHour();
        assertEquals("Hours should increment to 0", 0, counter.getHours());
    }

    @Test
    public void testDecrementHour(){
        counter = new Counter(1,0,0);
        counter.decrementHour();
        assertEquals("Hours should decrement by 1", 0, counter.getHours());
    }

    @Test
    public void testToStandard(){
        counter = new Counter(16, 45, 30);
        counter.toStandard();
        String s = counter.toString();
        assertEquals("Should be converted to 04:45:30 PM", "04:45:30 PM", s);
    }

    @Test
    public void testToStandard2(){
        counter = new Counter(11, 30, 15);
        counter.toStandard();
        String s = counter.toString();
        assertEquals("Should be converted to 11:30:15 AM", "11:30:15 AM", s);
    }

    @Test
    public void testToStandard3(){
        counter = new Counter(0,0,0);
        counter.toStandard();
        String s = counter.toString();
        assertEquals("Should be converted to 12:00:00 AM", "12:00:00 AM", s);
    }

    @Test
    public void testToMilitary(){
        counter = new Counter(9, 15, 30);
        counter.toMilitary();
        String s = counter.toString();
        assertEquals("Should be converted to 09:15:30", "09:15:30", s);
    }

}

