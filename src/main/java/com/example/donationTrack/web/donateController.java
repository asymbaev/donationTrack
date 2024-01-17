package com.example.donationTrack.web;

import com.example.donationTrack.entity.Donation;
import com.example.donationTrack.service.DonationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/donation")
public class donateController {

    private final DonationService donationService;

    public donateController(DonationService donationService) {
        this.donationService = donationService;
    }
    @GetMapping("/donations")
    public ResponseEntity<List<Donation>> getDonation() {
        return new ResponseEntity<>(donationService.getDonation(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable Long id) {
        return new ResponseEntity<>(donationService.getDonationById(id), HttpStatus.OK);
    }
}
