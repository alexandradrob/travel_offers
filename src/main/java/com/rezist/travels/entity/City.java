package com.rezist.travels.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cities")
public class City {
    @Id
    @Column(name="city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="city_name")
    private String cityName;

    @Column(name="city_description")
    private String cityDescription;

    @OneToMany(mappedBy = "city")
    private List<Attraction> attractions;

    @OneToMany(mappedBy = "cityO")
    private List<Offer> offers;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;


    public City() {

    }

    public City(String cityName, String cityDescription) {
        this.cityName = cityName;
        this.cityDescription = cityDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }



    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", cityDescription='" + cityDescription + '\'' +
                '}';
    }
}
