package com.murbanowicz.nofluffcars.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "IDcountry")
    private Long idCountry;

    @Column(name = "name")
    private String name;

    public Manufacturer() {
    }

    public Manufacturer(Long id, Long idCountry, String name) {
        this.id = id;
        this.idCountry = idCountry;
        this.name = name;
    }

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