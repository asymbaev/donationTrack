package com.example.donationTrack.service;

import com.example.donationTrack.entity.Donation;
import com.example.donationTrack.repository.DonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public List<Donation> getDonation() {
        return donationRepository.findAll();
    }

    @Override
    public Donation getDonationById(Long id) {
        Optional<Donation> optionalDonation = donationRepository.findById(id);

        if (optionalDonation.isPresent()) {
            return optionalDonation.get();
        } else {
            throw new RuntimeException("Car with " + id + "not found ");
        }
    }

    @Override
    public Donation addDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    @Override
    public void deleteDonationById(Long id) {
        donationRepository.deleteById(id);
    }

    @Override
    public Donation updateDonationById(Long id, Donation donation) {
        Donation existingDonation = getDonationById(id);
        existingDonation.setReport(donation.getReport());
        existingDonation.setHistory(donation.getHistory());
        existingDonation.setCategory(donation.getCategory());
        existingDonation.setDonor(donation.getDonor());
        existingDonation.setAmount(donation.getAmount());
        existingDonation.setYear(donation.getYear());
        donationRepository.save(existingDonation);
        return existingDonation;
    }

    @Override
    public List<Donation> getDonationListByCharity(String charity) {
        return donationRepository.getAllDonationByCharity(charity);
    }
}
