package org.infoip.dataprovider.client.ipdata.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.infoip.core.entity.Language;
import org.infoip.core.entity.Location;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IpInfoResponse {

    @JsonProperty("country_name")
    private String country;

    @JsonProperty("country_code")
    private String isoCode;

    @JsonProperty("continent_name")
    private String isoName;

    @JsonProperty("languages")
    private List<Language> languages = new ArrayList<>();

    @JsonProperty("location")
    private Location location;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("radius")
    private double distance;

    @JsonProperty("formattedLocalTime")
    private String formattedLocalTime;

    @JsonProperty("formattedUtcTime")
    private String formattedUtcTime;

    public IpInfoResponse() {}

    public IpInfoResponse(String country, String isoCode, String isoName, List<Language> languages, double latitude, double longitude, double distance, Location location, String formattedLocalTime, String formattedUtcTime) {
        this.country = country;
        this.isoCode = isoCode;
        this.isoName = isoName;
        this.languages = languages;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
        this.location = location;
        this.formattedLocalTime = formattedLocalTime;
        this.formattedUtcTime = formattedUtcTime;
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

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public String getFormattedLocalTime() {
        return formattedLocalTime;
    }

    public void setFormattedLocalTime(String formattedLocalTime) {
        this.formattedLocalTime = formattedLocalTime;
    }

    public String getFormattedUtcTime() {
        return formattedUtcTime;
    }

    public void setFormattedUtcTime(String formattedUtcTime) {
        this.formattedUtcTime = formattedUtcTime;
    }
}
