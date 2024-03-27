package com.ppp;
import java.time.LocalDateTime;
public class CashDonation extends Donation {
    private LocalDateTime donationDate;

    public CashDonation(String donorName, double amount, LocalDateTime donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

    public LocalDateTime getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDateTime donationDate) {
        this.donationDate = donationDate;
    }

    @Override
    public void recordDonation() {
        System.out.println("Cash donation recorded on " + donationDate + " by " + getDonorName() + " of amount $" + getAmount());
    }
}