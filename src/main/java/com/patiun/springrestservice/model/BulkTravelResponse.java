package com.patiun.springrestservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BulkTravelResponse {

    private final List<Integer> timesList;
    private final int responseNumber;
    private final int inputParametersNumber;
    private final int invalidInputParametersNumber;
    private final int maximumCalculatedTime;
    private final int minimumCalculatedTime;
    private final int mostPopularCalculatedTime;

    public BulkTravelResponse(@JsonProperty List<Integer> timesList, @JsonProperty int responseNumber, @JsonProperty int inputParametersNumber, @JsonProperty int invalidInputParametersNumber, @JsonProperty int maximumCalculatedTime, @JsonProperty int minimumCalculatedTime, @JsonProperty int mostPopularCalculatedTime) {
        this.timesList = timesList;
        this.responseNumber = responseNumber;
        this.inputParametersNumber = inputParametersNumber;
        this.invalidInputParametersNumber = invalidInputParametersNumber;
        this.maximumCalculatedTime = maximumCalculatedTime;
        this.minimumCalculatedTime = minimumCalculatedTime;
        this.mostPopularCalculatedTime = mostPopularCalculatedTime;
    }

    public List<Integer> getTimesList() {
        return timesList;
    }

    public int getResponseNumber() {
        return responseNumber;
    }

    public int getInputParametersNumber() {
        return inputParametersNumber;
    }

    public int getInvalidInputParametersNumber() {
        return invalidInputParametersNumber;
    }

    public int getMaximumCalculatedTime() {
        return maximumCalculatedTime;
    }

    public int getMinimumCalculatedTime() {
        return minimumCalculatedTime;
    }

    public int getMostPopularCalculatedTime() {
        return mostPopularCalculatedTime;
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
