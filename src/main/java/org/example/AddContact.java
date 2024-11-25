package org.example;

import java.util.List;
import java.util.Scanner;

public class AddContact {

    public static void addContact(List<Contact> contacts, Scanner input) {
        // Validate name input
        System.out.print("Enter name: ");
        String name = input.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }

        // Check for duplicate name
        if (contacts.stream().anyMatch(contact -> contact.getName().equalsIgnoreCase(name))) {
            System.out.println("Error: Contact with this name already exists. Please use a unique name.");
            return;
        }

        // Validate phone input
        System.out.print("Enter phone: ");
        String phone = input.nextLine().trim();
        if (!isValidPhone(phone)) {
            System.out.println("Error: Invalid phone number. Please use only digits and ensure it's at least 7 characters.");
            return;
        }

        // Validate email input
        System.out.print("Enter email: ");
        String email = input.nextLine().trim();
        if (!isValidEmail(email)) {
            System.out.println("Error: Invalid email format. Please enter a valid email address.");
            return;
        }

        // Validate street name input
        System.out.print("Enter street name: ");
        String streetName = input.nextLine().trim();
        if (streetName.isEmpty()) {
            System.out.println("Error: Street name cannot be empty.");
            return;
        }

        // Validate city input
        System.out.print("Enter city: ");
        String city = input.nextLine().trim();
        if (city.isEmpty()) {
            System.out.println("Error: City cannot be empty.");
            return;
        }

        // Validate zipcode input
        System.out.print("Enter zipcode: ");
        String zipcode = input.nextLine().trim();
        if (!isValidZipcode(zipcode)) {
            System.out.println("Error: Invalid zipcode format. Please enter a valid zipcode.");
            return;
        }

        // Add the contact with street name, city, and zipcode
        contacts.add(new Contact(name, phone, email, streetName, city, zipcode));
        System.out.println("Contact added successfully!");
    }

    // Helper method to validate phone number
    private static boolean isValidPhone(String phone) {
        return phone.matches("\\d{7,}"); // Phone must contain only digits and have a minimum length of 7
    }

    // Helper method to validate email
    private static boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"); // Simple regex for email validation
    }

    // Helper method to validate zipcode
    private static boolean isValidZipcode(String zipcode) {
        return zipcode.matches("\\d{5}"); // Zipcode must be 5 digits
    }
}
