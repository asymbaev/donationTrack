package com.example.donationTrack.service;

import com.example.donationTrack.entity.Donation;

import java.util.List;

public interface DonationService {

    List<Donation> getDonation();

    Donation getDonationById(Long id);
}
