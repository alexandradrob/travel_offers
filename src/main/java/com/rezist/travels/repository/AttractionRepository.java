package com.rezist.travels.repository;

import com.rezist.travels.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Integer> {

    @Query("select a.attractionName from Attraction a where a.city.id =:id")
    List<String> getAttractionByCity_Id(@Param("id") Integer cityId);

    @Query("select a.attractionName from Attraction a where a.city.cityName =:cityName")
    List<String> getAttractionByCity_CityName(@Param("cityName") String cityName);

    @Query(value= "select a.attraction_name from attractions a inner join cities ci on a.city_id= ci.city_id inner join offers o on ci.city_id=o.city_id where o.offer_id=:id",nativeQuery=true)
    List<String> getAttractionByOfferId(@Param("id")Integer offerId);


}
