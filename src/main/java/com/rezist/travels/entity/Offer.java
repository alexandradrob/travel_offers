package com.rezist.travels.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="offers")
public class Offer {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="offer_id")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name="start_date")
    private java.util.Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="end_date")
    private java.util.Date endDate;

    @Column(name="price")
    private Integer price;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City cityO;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;

    @OneToOne
    @JoinColumn(name="activity_id")
    private Activity activity;


    public Offer() {

    }

    public Offer(Date startDate, Date endDate, Integer price, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCityO() {
        return cityO;
    }

    public void setCityO(City cityO) {
        this.cityO = cityO;
    }

    public Hotel getHotelO() {
        return hotel;
    }

    public void setHotelO(Hotel hotelO) {
        this.hotel = hotel;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }




}
