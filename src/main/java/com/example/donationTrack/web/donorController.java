package com.example.donationTrack.web;

import com.example.donationTrack.entity.Donor;
import com.example.donationTrack.service.DonorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/donor")
public class donorController {

    private final DonorService donorService;

    public donorController(DonorService donorService) {
        this.donorService = donorService;
    }
    @GetMapping("/donors")
    public ResponseEntity<List<Donor>> getDonors() {
        return new ResponseEntity<>(donorService.getDonors(), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonorById (@PathVariable Long id) {
        return new ResponseEntity<>(donorService.getDonorById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Donor> addDonor (@RequestBody Donor donor) {
        return new ResponseEntity<>(donorService.addDonor(donor), HttpStatus.CREATED);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Donor> deleteDonorById(@PathVariable Long id) {
        donorService.deleteDonorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Donor> updateDonorById (@PathVariable Long id, @RequestBody Donor donor) {
        return new ResponseEntity<>(donorService.updateDonorById(id, donor), HttpStatus.ACCEPTED);
    }
}
