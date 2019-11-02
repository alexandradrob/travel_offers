package com.rezist.travels.controller;

import com.rezist.travels.dto.OfferDTO;
import com.rezist.travels.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/home")
    public String showOffers(Model model){
        model.addAttribute("offers", offerService.getOfferDTOs());
        return "home";

    }

    @GetMapping("/offerDetails/{id}")
    public String showOfferDetails (Model model, @PathVariable("id") Integer id){
        model.addAttribute("details", offerService.getOfferDetailsDTOByOfferId(id));
        return "offerDetails";
    }

    @GetMapping("/offers")
    public String getOffersByCityName(@RequestParam(name="city")String cityName,
                                      Model model){
        System.out.println(cityName);
        model.addAttribute("blankOffer", new OfferDTO());
        model.addAttribute("offers", offerService.getOfferDTOsByPartialCityName(cityName));
        return "home";
    }






}
