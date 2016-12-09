package com.assist.service.controller;

import com.assist.service.domain.Business;
import com.assist.service.domain.BusinessDAO;
import com.assist.service.domain.BusinessRegion;
import com.assist.service.domain.YelpRequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sindhya on 10/31/16.
 */

@CrossOrigin
@RestController
public class AssistRestaurantController {

    @RequestMapping(value="/assist/location",method= RequestMethod.POST)
    public BusinessRegion business(@RequestBody YelpRequestBody yelpRequestBody){

        BusinessDAO business = new BusinessDAO();
        BusinessRegion businessList=business.businessList(yelpRequestBody);
        return businessList;

    }

}
