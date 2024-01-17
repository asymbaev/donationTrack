package com.example.donationTrack.service;

import com.example.donationTrack.entity.Donation;

import java.util.List;

public interface DonationService {

    List<Donation> getDonation();

    Donation getDonationById(Long id);

    Donation addDonation(Donation donation);

    void deleteDonationById(Long id);

    Donation updateDonationById(Long id, Donation donation);

    List<Donation> getDonationListByCharity(String charity);
}
