package com.murbanowicz.nofluffcars.dto.response;

public class ManufacturerResponse {

    private String name;
    private String country;

    public ManufacturerResponse() {
    }

    public ManufacturerResponse(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}