package com.assist.service.domain;

import com.assist.service.yelp.YelpAPI;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.servlet.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sindhya on 10/31/16.
 */
public class BusinessDAO {

    BusinessRegion businessRegion =new BusinessRegion();

    public BusinessDAO(){

    }


    public BusinessRegion businessList(YelpRequestBody yelpRequestBody){
        YelpAPI yelpAPI=new YelpAPI();

        String searchResponse= yelpAPI.searchRestaurantByLocation(yelpRequestBody);

        BusinessRegion businessRegion=null;
        String outputResponse=null;
        ObjectMapper objectMapper=new ObjectMapper();
        try {

            businessRegion=objectMapper.readValue(searchResponse,BusinessRegion.class);
            //businessRegion=objectMapper
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
            //outputResponse=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(businessRegion);

            //businessList=businessRegion.businessList;
            System.out.println("business  :"+businessRegion.businessList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return businessRegion;
    }
}
