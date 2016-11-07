package com.assist.service.controller;

import com.assist.service.domain.Business;
import com.assist.service.domain.BusinessDAO;
import com.assist.service.domain.BusinessRegion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sindhya on 10/31/16.
 */

@RestController
public class AssistRestaurantController {

    @RequestMapping(value="/search",method= RequestMethod.GET)
    public List business(@RequestParam String location){

        BusinessDAO business = new BusinessDAO();
        List<BusinessRegion> businessList=business.list(location);
        return businessList;

    }
}
