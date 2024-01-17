package com.example.donationTrack.web;

import com.example.donationTrack.entity.Donation;
import com.example.donationTrack.service.DonationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/add")
    public ResponseEntity<Donation> addDonation (@RequestBody Donation donation) {
        return new ResponseEntity<>(donationService.addDonation(donation), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Donation> deleteDonationById(@PathVariable Long id) {
        donationService.deleteDonationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Donation> updateDonationById (@PathVariable Long id, @RequestBody Donation donation) {
        return new ResponseEntity<>(donationService.updateDonationById(id, donation), HttpStatus.ACCEPTED);
    }
    @GetMapping("/charity{charity}")
    public ResponseEntity<List<Donation>> getDonationListByCharity (@PathVariable String charity) {
        return new ResponseEntity<>(donationService.getDonationListByCharity(charity),HttpStatus.OK);
    }
}
