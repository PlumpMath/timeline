package org.tago.timeline;

import java.util.Arrays;

/**
 * Created by gvtaras on 12/27/2016.
 */

public class TimeLineValue {

    private int value;

    public TimeLineValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TimeLineValue merge(TimeLineValue toMerge){
        if (toMerge == null) return this;
        return new TimeLineValue(value + toMerge.value);
    }

    public TimeLineValue mergeAll(TimeLineValue ... toMerge){
        if (toMerge == null || toMerge.length == 0) return this;
        return new TimeLineValue(Arrays.stream(toMerge).mapToInt(v -> v.value).sum());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeLineValue that = (TimeLineValue) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
