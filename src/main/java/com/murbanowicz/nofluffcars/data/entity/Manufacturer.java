package com.murbanowicz.nofluffcars.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "manufacturers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "IDcountry")
    private Long idCountry;

    @Column(name = "name")
    private String name;
}