package com.sap.trial.firstms.test.service;

import com.sap.trial.firstms.test.entity.Advertisement;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdvertisementService {

    List<Advertisement> getAllAdvertisements();

    Advertisement getAdvertisementById(Long id);

    void addAdvertisement(Advertisement advertisement);

    void updateAdvertisement(Advertisement advertisement);

    void deleteAdvertisement(Long id);
}
