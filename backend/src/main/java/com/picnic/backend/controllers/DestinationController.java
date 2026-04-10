package com.picnic.backend.controllers;

import com.picnic.backend.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/destinations")
public class DestinationController {


    private DestinationService destinationService;

    @PostMapping("/adddestination")
    public void setDestinationService(){


    }



}
