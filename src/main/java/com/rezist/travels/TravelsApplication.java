package com.rezist.travels;

import com.rezist.travels.entity.Activity;
import com.rezist.travels.entity.Country;
import com.rezist.travels.repository.ActivityRepository;
import com.rezist.travels.repository.CityRepository;
import com.rezist.travels.repository.CountryRepository;
import com.rezist.travels.repository.HotelRepository;
import com.rezist.travels.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class TravelsApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TravelsApplication.class, args);
        ActivityRepository activityRepository = context.getBean(ActivityRepository.class);
       // Activity beach = activityRepository.findByActivityName("Beach");
        //System.out.println(beach.getActivityName());

        //Activity activityById2 = activityRepository.findActivityById(2);
        //System.out.println(activityById2.getActivityName());

        //String activityNameByActivityId2 = activityRepository.getActivityNameByActivityId(2);
        //System.out.println(activityNameByActivityId2);

        /*String activityNameByOfferId1 = activityRepository.getActivityNameByOfferId(1);
        System.out.println(activityNameByOfferId1);

        HotelRepository hotelRepository= context.getBean(HotelRepository.class);
        String hotelNameByOfferId2 = hotelRepository.getHotelNameByOfferId(2);
        System.out.println(hotelNameByOfferId2);*/

        OfferService offerService=context.getBean(OfferService.class);
        //CountryRepository countryRepository= context.getBean(CountryRepository.class);
        //System.out.println(countryRepository.getCountryOfferById(1));
        //CityRepository cityRepository = context.getBean(CityRepository.class);
        //System.out.println(cityRepository.getCityNameByOfferId(1));

       System.out.println(offerService.getOfferDTOByOfferId(1));

    }
}
