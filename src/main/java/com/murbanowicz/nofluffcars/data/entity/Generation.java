package com.murbanowicz.nofluffcars.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "generations")
public class Generation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "IDmodel")
    private long idModel;

    @Column(name = "name")
    private String name;

    @Column(name = "prod_year_start")
    private int prodYearStart;

    @Column(name = "prod_year_end")
    private int prodYearEnd;

    @Column(name = "bt_hatchback")
    private boolean btHatchback;

    @Column(name = "bt_sedan")
    private boolean btSedan;

    @Column(name = "bt_wagon")
    private boolean btWagon;

    @Column(name = "bt_coupe")
    private boolean btCoupe;

    @Column(name = "bt_convertible")
    private boolean btConvertible;

    @Column(name = "bt_suv")
    private boolean btSuv;

    @Column(name = "bt_van")
    private boolean btVan;

    @Column(name = "bt_other")
    private boolean btOther;

    public Generation() {
    }

    public Generation(long id, long idModel, String name, int prodYearStart, int prodYearEnd, boolean btHatchback, boolean btSedan,
                      boolean btWagon, boolean btCoupe, boolean btConvertible, boolean btSuv, boolean btVan, boolean btOther) {
        this.id = id;
        this.idModel = idModel;
        this.name = name;
        this.prodYearStart = prodYearStart;
        this.prodYearEnd = prodYearEnd;
        this.btHatchback = btHatchback;
        this.btSedan = btSedan;
        this.btWagon = btWagon;
        this.btCoupe = btCoupe;
        this.btConvertible = btConvertible;
        this.btSuv = btSuv;
        this.btVan = btVan;
        this.btOther = btOther;
    }
}