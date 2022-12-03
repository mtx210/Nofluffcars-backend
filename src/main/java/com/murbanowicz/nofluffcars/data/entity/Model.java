package com.murbanowicz.nofluffcars.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "models")
@Getter
@Setter
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "IDmanufacturer")
    private Long idManufacturer;

    @Column(name = "name")
    private String name;
}