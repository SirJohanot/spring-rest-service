package com.patiun.springrestservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TravelResponse {

    private final int time;
    private final int responseNumber;

    public TravelResponse(@JsonProperty int time, @JsonProperty int responseNumber) {
        this.time = time;
        this.responseNumber = responseNumber;
    }

    public int getTime() {
        return time;
    }

    public int getResponseNumber() {
        return responseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TravelResponse that = (TravelResponse) o;

        if (time != that.time) {
            return false;
        }
        return responseNumber == that.responseNumber;
    }

    @Override
    public int hashCode() {
        int result = time;
        result = 31 * result + responseNumber;
        return result;
    }

    @Override
    public String toString() {
        return "TravelResponse{" +
                "time=" + time +
                ", responseNumber=" + responseNumber +
                '}';
    }
}
