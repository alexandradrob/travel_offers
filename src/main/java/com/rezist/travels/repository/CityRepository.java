package com.rezist.travels.repository;

import com.rezist.travels.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("select c.cityName from City c join c.offers off where off.id =:id ")
    String getCityNameByOfferId(@Param("id") Integer off);

}
