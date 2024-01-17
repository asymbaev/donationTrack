package com.example.donationTrack.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handles"})
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long donorID;
    private String lastName;
    private String firstName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donor")
    @JsonIgnore
    private List<Donation> donations;

    public Donor() {
    }

    public Donor(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;

    }

    public Long getDonorID() {
        return donorID;
    }

    public void setDonorID(Long donorID) {
        this.donorID = donorID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
