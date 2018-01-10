package com.example.codeclan.summit;

import java.io.Serializable;

/**
 * Created by sophiemullins on 06/01/2018.
 */

public class Summit implements Serializable {

    private String name;
    private Integer height;
    private String range;
    private String country;
    private Boolean climbed;

    public Summit(String name, Integer height, String range, String country) {
        this.name = name;
        this.height = height;
        this.range = range;
        this.country = country;
        this.climbed = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getClimbed() { return climbed; }

    public void setClimbed() {this.climbed = true; }

    public void setNotClimbed() {this.climbed = false; }


}
