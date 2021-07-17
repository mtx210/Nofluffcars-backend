package com.murbanowicz.nofluffcars.dto;

public class ManufacturerDto {

    private Long ID;
    private String name;

    public ManufacturerDto() {
    }

    public ManufacturerDto(Long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}