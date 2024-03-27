package com.ppp;
import java.sql.*;
import java.util.Scanner;
public class PetAdoptionPlatform {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pet_pals";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "pookrish@2003";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            displayPetListings(connection);
            recordDonation(connection, scanner);
            manageAdoptionEvent(connection, scanner);
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connectivity error: " + e.getMessage());
        }
    }

    private static void displayPetListings(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pet");

            System.out.println("Available Pets:");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String breed = resultSet.getString("breed");
                System.out.println("Name: " + name + ", Age: " + age + ", Breed: " + breed);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving pet listings: " + e.getMessage());
        }
    }
    private static void recordDonation(Connection connection, Scanner scanner) {
        System.out.println("Record Cash Donation");
        try {
            System.out.print("Enter donor name: ");
            String donorName = scanner.nextLine();

            System.out.print("Enter donation amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount < 10.0) {
                throw new InsufficientFundsException("Donation amount must be at least $10.");
            }

            PreparedStatement statement = connection.prepareStatement("INSERT INTO donation (donor_name, amount) VALUES (?, ?)");
            statement.setString(1, donorName);
            statement.setDouble(2, amount);
            statement.executeUpdate();

            System.out.println("Donation recorded successfully.");
            statement.close();
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error recording donation: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void manageAdoptionEvent(Connection connection, Scanner scanner) {
        System.out.println("Manage Adoption Event");
        try {
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM adoptionevent");

            System.out.println("Upcoming Adoption Events:");
            while (resultSet.next()) {
                int eventId = resultSet.getInt("eventid");
                String eventName = resultSet.getString("eventname");
                System.out.println("Event ID: " + eventId + ", Event Name: " + eventName);
            }

            System.out.print("Enter your name: ");
            String participantName = scanner.nextLine();

            System.out.print("Enter event ID to register: ");
            int eventId = Integer.parseInt(scanner.nextLine());

            PreparedStatement registerStatement = connection.prepareStatement("INSERT INTO participant (participantname, eventid) VALUES (?, ?)");
            registerStatement.setString(1, participantName);
            registerStatement.setInt(2, eventId);
            registerStatement.executeUpdate();

            System.out.println("Registration successful.");
            resultSet.close();
            statement.close();
            registerStatement.close();
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error managing adoption event: " + e.getMessage());
        }
    }
}

    


