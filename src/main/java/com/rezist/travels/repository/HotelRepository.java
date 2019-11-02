package com.rezist.travels.repository;

import com.rezist.travels.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query("SELECT h.hotelName FROM Hotel h join h.offers o where o.id=:id")
    String getHotelNameByOfferId(@Param("id") Integer offerId);
}
