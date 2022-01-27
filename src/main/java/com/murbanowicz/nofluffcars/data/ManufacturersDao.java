package com.murbanowicz.nofluffcars.data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManufacturersDao {

    private final String FIND_ALL = "SELECT * FROM manufacturers";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ManufacturersDao(@Qualifier("dataJdbcTemplate") NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ManufacturerPOJO> findAll(){
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(ManufacturerPOJO.class));
    }

    public class ManufacturerPOJO {

        private Integer ID;
        private Integer IDcountry;
        private String name;

        public ManufacturerPOJO() {
        }

        public ManufacturerPOJO(Integer ID, Integer IDcountry, String name) {
            this.ID = ID;
            this.IDcountry = IDcountry;
            this.name = name;
        }

        public Integer getID() {
            return ID;
        }

        public void setID(Integer ID) {
            this.ID = ID;
        }

        public Integer getIDcountry() {
            return IDcountry;
        }

        public void setIDcountry(Integer IDcountry) {
            this.IDcountry = IDcountry;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}