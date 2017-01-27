package org.tago.timeline;

import org.junit.Test;
import org.tago.timeline.TimeLine;
import org.tago.timeline.TimeLineValue;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by gvtaras on 1/27/2017.
 */
public class TimeLineTest {

    @Test
    public void singlePut(){
        TimeLine line = new TimeLine();
        line.put(LocalDate.now(), new TimeLineValue(10));
        assertEquals(new TimeLineValue(10), line.get(LocalDate.now()));
    }

    @Test
    public void multiplePut(){
        TimeLine line = new TimeLine();
        line.put(LocalDate.now(), new TimeLineValue(10));
        line.put(LocalDate.now(), new TimeLineValue(3));
        assertEquals(new TimeLineValue(13), line.get(LocalDate.now()));
    }



}