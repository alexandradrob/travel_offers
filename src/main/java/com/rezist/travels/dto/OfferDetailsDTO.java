package com.rezist.travels.dto;

import java.util.List;

public class OfferDetailsDTO extends OfferDTO {
    private List<String> attractionNames;
    private String hotelName;


    public OfferDetailsDTO(OfferDTO offerDTO) {
        setCity(offerDTO.getCity());
        setCountry(offerDTO.getCountry());
        setStartDate(offerDTO.getStartDate());
        setEndDate(offerDTO.getEndDate());
        setOfferDescription(offerDTO.getOfferDescription());
        setOfferPrice(offerDTO.getOfferPrice());
        setOfferActivity(offerDTO.getOfferActivity());


    }

    public List<String> getAttractionNames() {
        return attractionNames;
    }

    public void setAttractionNames(List<String> attractionNames) {
        this.attractionNames = attractionNames;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
