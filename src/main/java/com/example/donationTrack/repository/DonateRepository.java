package com.example.donationTrack.repository;

import com.example.donationTrack.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonateRepository extends JpaRepository<Donation, Long> {

}
