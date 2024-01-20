package com.example.donationTrack.service;

import com.example.donationTrack.entity.Donor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonorService {
    public List<Donor> getDonors();

    public Donor getDonorById(Long id);
    public Donor addDonor(Donor donor);

    void deleteDonorById(Long id);

    Donor updateDonorById(Long id, Donor donor);
}
