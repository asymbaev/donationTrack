package com.example.donationTrack.entity;

import jakarta.persistence.*;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;

    private String charity;
    private String category;
    private String report;
    private String history;
    private int year;
    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donor")
    private Donor donor;

    public Donation(String charity, String category, String report, String history, int year, int amount, Donor donor) {
        this.charity = charity;
        this.category = category;
        this.report = report;
        this.history = history;
        this.year = year;
        this.amount = amount;
        this.donor = donor;
    }

    public Donation() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCharity() {
        return charity;
    }

    public void setCharity(String charity) {
        this.charity = charity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    //    public Donation(String charity, String category, String report, String history, int year, int amount, Donor donor) {
//        this.charity = new charity;
//
//        this.category = category;
//        this.report = report;
//        this.history = history;
//        this.year = year;
//        this.amount = amount;
//        this.donor = donor;
//    }
//
//    public Donation() {
//    }
//
//
//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }
//
//    public String getCharity() {
//        return charity;
//    }
//    public String setCharity(String charity) {
//        this.charity = charity;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public String getReport() {
//        return report;
//    }
//
//    public void setReport(String report) {
//        this.report = report;
//    }
//
//    public String getHistory() {
//        return history;
//    }
//
//    public void setHistory(String history) {
//        this.history = history;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//
//    public Donor getDonor() {
//        return donor;
//    }
//
//    public void setDonor(Donor donor) {
//        this.donor = donor;
//    }
}
