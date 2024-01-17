package com.example.donationTrack.repository;

import com.example.donationTrack.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

//    Donation getAllDonationByCharity(String charity);
    List<Donation> getAllDonationByCharity(String charity);
}
