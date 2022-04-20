package com.sap.trial.firstms.test.repository;

import com.sap.trial.firstms.test.entity.Advertisement;

import java.util.List;

public interface AdvertisementDAO {

    List<Advertisement> getAllAdvertisements();

    Advertisement getAdvertisement(long id);

    void addAdvertisement(Advertisement advertisement);

    void updateAdvertisement(Advertisement advertisement);

    void deleteAdvertisement(long id);
}
