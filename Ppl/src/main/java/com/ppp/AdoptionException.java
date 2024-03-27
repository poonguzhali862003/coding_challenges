package com.ppp;
import java.util.*;
public class AdoptionException extends Exception {
    public AdoptionException(String message) {
        super(message);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.print("Enter pet age: ");
            int age = scanner.nextInt();
            if (age <= 0) {
                throw new InvalidPetAgeException("Age must be a positive integer.");
            }

            System.out.print("Enter donation amount: ");
            double donationAmount = scanner.nextDouble();
            if (donationAmount < 10.0) {
                throw new InsufficientFundsException("Donation amount must be at least $10.");
            }

            throw new FileHandlingException("File not found", null);

        } catch (InvalidPetAgeException e) {
            System.out.println("Invalid pet age: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds: " + e.getMessage());
        } catch (FileHandlingException e) {
            System.out.println("File handling error: " + e.getMessage());
        }
    }
}
