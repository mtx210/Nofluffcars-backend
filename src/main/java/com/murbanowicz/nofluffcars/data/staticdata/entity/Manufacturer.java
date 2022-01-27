package com.murbanowicz.nofluffcars.data.staticdata.entity;

import javax.persistence.*;

@Entity
@Table(name = "manufacturers", schema = "nofluffcars_data")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "IDcountry")
    private Long idCountry;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long ID) {
        this.id = ID;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long ID_country) {
        this.idCountry = ID_country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}