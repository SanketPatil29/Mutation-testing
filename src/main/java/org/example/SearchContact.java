package org.example;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SearchContact {

    public static void searchContact(List<Contact> contacts, Scanner input) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available to search.");
            return;
        }

        // Ask for the name (required for identifying the contact)
        System.out.print("Enter name to search: ");
        String name = input.nextLine().trim();

        // Edge case: Empty name input
        if (name.isEmpty()) {
            System.out.println("Invalid input. Name cannot be empty.");
            return;
        }

        // Ask for additional optional details (street name, city, zip code)
        System.out.print("Enter street name (optional): ");
        String streetName = input.nextLine().trim();

        System.out.print("Enter zip code (optional): ");
        String zipCode = input.nextLine().trim();

        System.out.print("Enter city (optional): ");
        String city = input.nextLine().trim();

        // Find matching contact(s) with the provided details
        List<Contact> matchingContacts = contacts.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name) &&
                        (streetName.isEmpty() || c.getStreetName().equalsIgnoreCase(streetName)) &&
                        (zipCode.isEmpty() || c.getZipcode().equalsIgnoreCase(zipCode)) &&
                        (city.isEmpty() || c.getCity().equalsIgnoreCase(city)))
                .toList();

        // Handle cases for search results
        if (!matchingContacts.isEmpty()) {
            System.out.println("Matching contact(s) found:");
            matchingContacts.forEach(System.out::println);
        } else {
            System.out.println("No matching contact found with the provided details.");
        }
    }
}
