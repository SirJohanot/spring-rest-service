package com.patiun.springrestservice.model;

public class TravelRequest {

    private final int distance;
    private final int speed;

    public TravelRequest(int distance, int speed) {
        this.distance = distance;
        this.speed = speed;
    }

    public int getDistance() {
        return distance;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TravelRequest that = (TravelRequest) o;

        if (distance != that.distance) {
            return false;
        }
        return speed == that.speed;
    }

    @Override
    public int hashCode() {
        int result = distance;
        result = 31 * result + speed;
        return result;
    }

    @Override
    public String toString() {
        return "TravelParameters{" +
                "distance=" + distance +
                ", speed=" + speed +
                '}';
    }
}
