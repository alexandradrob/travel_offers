package com.rezist.travels.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="attractions")
public class Attraction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="attraction_id")
    private Integer id;

    @Column(name="attraction_name")
    private String attractionName;


    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    public Attraction() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "id=" + id +
                ", attractionName='" + attractionName + '\'' +
                ", city=" + city +
                '}';
    }
}
