package org.infoip.core.entity;

public class ApiLog {
    private String country;
    private double distance;

    public ApiLog(
            final String country,
            final double distance
    ) {
        this.country = country;
        this.distance = distance;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
