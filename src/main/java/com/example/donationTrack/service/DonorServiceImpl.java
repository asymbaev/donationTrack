package com.example.donationTrack.service;

import com.example.donationTrack.entity.Donor;
import com.example.donationTrack.repository.DonorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;

    public DonorServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public List<Donor> getDonors() {
        return (List<Donor>) donorRepository.findAll();
    }

    @Override
    public Donor getDonorById(Long id) {
        Optional<Donor> optionalDonor = donorRepository.findById(id);
        if (optionalDonor.isPresent()) {
            return optionalDonor.get();
        } else {
            throw new EntityNotFoundException("Donor with id " + id + " not found");
        }
    }

    @Override
    public Donor addDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public void deleteDonorById(Long id) {
        donorRepository.deleteById(id);

    }

    @Override
    public Donor updateDonorById(Long id, Donor donor) {
        Donor existingDonor = getDonorById(id);
        existingDonor.setDonorID(donor.getDonorID());
        existingDonor.setFirstName(donor.getFirstName());
        existingDonor.setLastName(donor.getLastName());
        donorRepository.save(existingDonor);
        return existingDonor;
    }
}
