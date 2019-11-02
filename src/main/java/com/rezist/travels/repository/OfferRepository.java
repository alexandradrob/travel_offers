package com.rezist.travels.repository;

import com.rezist.travels.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer>{


    @Query("select o.startDate from Offer o where o.id=:id" )
    Date getStartDateByOfferId(@Param("id") Integer offerId  );

    @Query("select o.endDate from Offer o where o.id=:id" )
    Date getEndDateByOfferId(@Param("id") Integer offerId  );

    @Query("select o.description from Offer o where o.id=:id" )
    String getDescriptionByOfferId(@Param("id") Integer offerId  );

    @Query("select o.price from Offer o where o.id=:id" )
    Integer getPriceByOfferId(@Param("id") Integer offerId  );

    @Query(value="select * from offers o join cities c on o.city_id=c.city_id where c.city_name:cityName%", nativeQuery = true)
    List<Offer> getOfferByPartialCityName(@Param("cityName") String cityName  );
}
