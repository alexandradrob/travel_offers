package com.rezist.travels.repository;

import com.rezist.travels.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {


    @Query("select c.countryName from Country c join c.cities ci where ci.cityName=:cityName")
    String getCountryNameByCityName(@Param("cityName") String ci);

    @Query(value= "select co.country_name from countries co inner join cities ci on co.country_id= ci.country_id" +
            " inner join offers o on ci.city_id=o.city_id where o.offer_id=:id" , nativeQuery = true)
    String getCountryOfferById(@Param("id") Integer offerId);
}
