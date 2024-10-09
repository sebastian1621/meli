package org.infoip.core.entity;

import java.time.ZonedDateTime;

public class IpInfo {
    private String country;
    private String isoCode;
    private String isoName;
    private double latitude;
    private double longitude;
    private double distance;
    private Location location;
    private ZonedDateTime localTime;

    public IpInfo(
            final String country,
            final String isoCode,
            final String isoName,
            final double latitude,
            final double longitude,
            final double distance,
            final Location location,
            final ZonedDateTime localTime
    ) {
        this.country = country;
        this.isoCode = isoCode;
        this.isoName = isoName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
        this.location = location;
        this.localTime = localTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getIsoName() {
        return isoName;
    }

    public void setIsoName(String isoName) {
        this.isoName = isoName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ZonedDateTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(ZonedDateTime localTime) {
        this.localTime = localTime;
    }
}
