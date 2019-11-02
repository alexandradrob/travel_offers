package com.rezist.travels.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="hotels")
public class Hotel {

    @Id
    @Column(name="hotel_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="hotel_name")
    private String hotelName;

    @OneToMany(mappedBy = "hotel")
    private List<Offer> offers;

    public Hotel() {

    }
    public Hotel(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }
}
