package com.assist.service.controller;

import com.assist.service.domain.Business;
import com.assist.service.domain.BusinessDAO;
import com.assist.service.domain.BusinessRegion;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sindhya on 10/31/16.
 */

@RestController
public class AssistRestaurantController {

    @RequestMapping(value="/assist/{location}",method= RequestMethod.GET)
    public List business(@PathVariable("location") String location, @RequestParam(value = "term", required = false) String term){

        BusinessDAO business = new BusinessDAO();
        List<BusinessRegion> businessList=business.list(location,term);
        return businessList;

    }

}
