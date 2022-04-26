package com.springfeatures.springrestservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeToCross {

    private final int time;

    public TimeToCross(@JsonProperty("timeToCross") int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TimeToCross that = (TimeToCross) o;

        return time == that.time;
    }

    @Override
    public int hashCode() {
        return time;
    }

    @Override
    public String toString() {
        return "TimeToCross{" +
                "time=" + time +
                '}';
    }
}
