package com.sap.trial.firstms.test.service;

import com.sap.trial.firstms.test.entity.Advertisement;
import com.sap.trial.firstms.test.repository.AdvertisementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImplementation implements AdvertisementService {

    @Autowired
    AdvertisementDAO advertisementDAO;


    public List<Advertisement> getAllAdvertisements() {
        return advertisementDAO.getAllAdvertisements();
    }

    @Override
    public Advertisement getAdvertisementById(Long id) {
         return advertisementDAO.getAdvertisement(id);
    }


    public void addAdvertisement(Advertisement advertisement) {
        advertisementDAO.addAdvertisement(advertisement);
    }

    public void updateAdvertisement(Advertisement advertisement) {
        advertisementDAO.updateAdvertisement(advertisement);
    }

    @Override
    public void deleteAdvertisement(Long id) {
        advertisementDAO.deleteAdvertisement(id);
    }
}

