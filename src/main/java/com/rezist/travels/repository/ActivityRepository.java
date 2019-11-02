package com.rezist.travels.repository;

import com.rezist.travels.TravelsApplication;
import com.rezist.travels.entity.Activity;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    Activity findByActivityName(String ActivityName);

    Activity findActivityById(Integer Id);

    @Query("SELECT a.activityName from Activity a where a.id=:id")
    String getActivityNameByActivityId(@Param("id") Integer activityId);



    @Query("SELECT a.activityName FROM Activity a join a.offers o where o.id=:id")
    String getActivityNameByOfferId(@Param("id") Integer offerId);
}
