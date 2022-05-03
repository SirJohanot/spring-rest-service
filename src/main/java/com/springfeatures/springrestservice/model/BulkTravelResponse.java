package com.springfeatures.springrestservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BulkTravelResponse {

    private final List<Integer> timesList;
    private final int responseNumber;

    public BulkTravelResponse(@JsonProperty List<Integer> timesList, @JsonProperty int responseNumber) {
        this.timesList = timesList;
        this.responseNumber = responseNumber;
    }

    public List<Integer> getTimesList() {
        return timesList;
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

        BulkTravelResponse that = (BulkTravelResponse) o;

        if (responseNumber != that.responseNumber) {
            return false;
        }
        return timesList != null ? timesList.equals(that.timesList) : that.timesList == null;
    }

    @Override
    public int hashCode() {
        int result = timesList != null ? timesList.hashCode() : 0;
        result = 31 * result + responseNumber;
        return result;
    }

    @Override
    public String toString() {
        return "BulkTravelResponse{" +
                "timesList=" + timesList +
                ", responseNumber=" + responseNumber +
                '}';
    }
}
