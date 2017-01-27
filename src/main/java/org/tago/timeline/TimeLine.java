package org.tago;

import java.time.LocalDate;
import java.util.Date;
import java.util.TreeMap;

/**
 * Created by gvtaras on 12/21/2016.
 */
public class TimeLine {

    private TreeMap<LocalDate, TimeLineValue> line = new TreeMap<>();

    public void put(LocalDate date, TimeLineValue value) {
        TimeLineValue existed = line.get(date);
        if (existed != null) {
            line.put(date, existed.merge(value));
        } else {
            line.put(date, value);
        }
    }

    public TimeLineValue get(LocalDate date){
        return line.get(date);
    }

    public TimeLine merge(TimeLine toMerge){
        if (toMerge != null && !toMerge.line.isEmpty()) {
            toMerge.line.entrySet().forEach(entry -> put(entry.getKey(), entry.getValue()));
        }
        return this;
    }

}
