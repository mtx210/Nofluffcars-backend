package com.murbanowicz.nofluffcars.dto.response;

public class ManufacturerResponse {

    private String manufacturer;
    private String country;

    public ManufacturerResponse(String manufacturer, String country) {
        this.manufacturer = manufacturer;
        this.country = country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}