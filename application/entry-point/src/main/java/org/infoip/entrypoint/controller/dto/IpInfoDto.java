package org.infoip.entrypoint.controller.dto;

import org.infoip.core.entity.Location;

public class IpInfoDto {
    private String country;
    private String isoCode;
    private String isoName;
    private double latitude;
    private double longitude;
    private double distance;
    private Location location;
    private String localTime;
    private String utcTime;

    public IpInfoDto(
            final String country,
            final String isoCode,
            final String isoName,
            final double latitude,
            final double longitude,
            final double distance,
            final Location location,
            final String localTime,
            final String utcTime
    ) {
        this.country = country;
        this.isoCode = isoCode;
        this.isoName = isoName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
        this.location = location;
        this.localTime = localTime;
        this.utcTime = utcTime;
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

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(String utcTime) {
        this.utcTime = utcTime;
    }
}