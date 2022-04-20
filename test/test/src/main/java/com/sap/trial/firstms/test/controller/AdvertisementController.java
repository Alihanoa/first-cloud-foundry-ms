package com.sap.trial.firstms.test.controller;

import com.sap.trial.firstms.test.entity.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class AdvertisementController {

    private HashMap <Long, String> advertisements = new HashMap<>();

    @Autowired
    public AdvertisementController() {

    }

    @GetMapping("/advertisements")
    public Iterable<Advertisement> getAllAdvertisements() {
        ArrayList<Advertisement> list = new ArrayList<>();
        for(Long id : advertisements.keySet()) {
            Advertisement advertisement = new Advertisement(id, advertisements.get(id));
            list.add(advertisement);

        }
        return list;
    }

    @GetMapping("/advertisements/{id}")
    public Advertisement getAdvertisement(@PathVariable Long id) {
        advertisements.get(id);
        Advertisement advertisement = new Advertisement(id, advertisements.get(id));

        return advertisement;
    }


    @PostMapping("/advertisements/{id}/{title}")
    public void createAdvertisement(@PathVariable("id") long id, @PathVariable("title") String title) {
        System.out.println("Advertisement " + title + " created successfully");
        advertisements.put(id, title);
    }

}
