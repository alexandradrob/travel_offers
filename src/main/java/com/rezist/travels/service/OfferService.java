package com.rezist.travels.service;

import com.rezist.travels.dto.OfferDTO;
import com.rezist.travels.dto.OfferDetailsDTO;
import com.rezist.travels.entity.Offer;
import com.rezist.travels.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OfferService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private AttractionRepository attractionRepository;

    public OfferDTO getOfferDTOByOfferId(Integer id) {
        if (id != null && id != 0) {
            OfferDTO offerDTO = new OfferDTO();
            offerDTO.setOfferId(id);
            offerDTO.setCity(cityRepository.getCityNameByOfferId(id));
            offerDTO.setCountry(countryRepository.getCountryOfferById(id));
            offerDTO.setStartDate(offerRepository.getStartDateByOfferId(id).toString());
            offerDTO.setEndDate(offerRepository.getEndDateByOfferId(id).toString());
            offerDTO.setOfferDescription(offerRepository.getDescriptionByOfferId(id));
            offerDTO.setOfferPrice(offerRepository.getPriceByOfferId(id).toString());
            offerDTO.setOfferActivity(activityRepository.getActivityNameByOfferId(id));

            return offerDTO;
        }
        return null;


    }

    public OfferDTO createOfferDTOFromOfferEntity(Offer offer) {
        OfferDTO offerDTO = new OfferDTO();
        offer.getId();
        offer.getCityO().getCityName();
        offerDTO.setCountry(countryRepository.getCountryOfferById(offer.getId()));
        offer.getStartDate().toString();
        offer.getEndDate().toString();
        offer.getDescription();
        offer.getPrice().toString();
        offer.getActivity().getActivityName();
        return offerDTO;

    }


    public OfferDetailsDTO getOfferDetailsDTOByOfferId(Integer id) {
        if (id != null && id != 0) {
            OfferDetailsDTO offerDetailsDTO = new OfferDetailsDTO(getOfferDTOByOfferId(id));
            offerDetailsDTO.setHotelName(hotelRepository.getHotelNameByOfferId(id));
            offerDetailsDTO.setAttractionNames(attractionRepository.getAttractionByOfferId(id));
            return offerDetailsDTO;
        }
        return null;


    }


    public List<OfferDTO> getOfferDTOs() {
        long count = offerRepository.count();
        List<OfferDTO> list = new ArrayList();
        for (int i = 1; i <= count; i++) {
            list.add(getOfferDTOByOfferId(i));
        }
        return list;

    }

    public List<OfferDTO> getOfferDTOsByPartialCityName(String cityName) {
        List<Offer> offersByPartialCityName = offerRepository.getOfferByPartialCityName(cityName);
        List<OfferDTO> list = new ArrayList();
        for (int i = 0; i <= offersByPartialCityName.size(); i++) {
            list.add(createOfferDTOFromOfferEntity(offersByPartialCityName.get(i)));
        }
        return list;

    }
}
