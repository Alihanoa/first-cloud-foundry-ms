package com.sap.trial.firstms.test.controller;

import com.sap.trial.firstms.test.entity.Advertisement;
import com.sap.trial.firstms.test.repository.AdvertisementRepository;
import com.sap.trial.firstms.test.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
public class AdvertisementController {


    @Autowired
    private AdvertisementService service;





    @GetMapping("/advertisements")
    public Iterable<Advertisement> getAllAdvertisements() {
        return this.service.getAllAdvertisements();
    }

    @GetMapping("/advertisements/{id}")
    public Advertisement getAdvertisement(@PathVariable  Long id) {
    try{
        return this.service.getAdvertisementById(id);
    }
    catch(Exception e){
        System.out.println(e.getCause());
        return null;
    }
    }


    @PostMapping("/advertisements/{id}/{title}")
    public void createAdvertisement(@PathVariable("id") long id, @PathVariable("title") String title) {
        System.out.println("Advertisement " + title + " created successfully");
        this.service.addAdvertisement(new Advertisement(id, title));
    }

}
