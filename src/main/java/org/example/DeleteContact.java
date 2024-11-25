package org.example;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DeleteContact {

    public static void deleteContact(List<Contact> contacts, Scanner input) {
        if (contacts == null) { // Handle null contacts list
            System.out.println("Contact list is null.");
            return;
        }

        if (contacts.isEmpty()) { // Handle empty contacts list
            System.out.println("No contacts available to delete.");
            return;
        }

        // Ask for the name (required for identifying the contact)
        System.out.print("Enter name to delete: ");
        String name = input.nextLine().trim();

        // Edge case: Empty name input
        if (name.isEmpty()) {
            System.out.println("Invalid input. Name cannot be empty.");
            return;
        }

        // Ask for additional optional details
        System.out.print("Enter street name (optional): ");
        String streetName = input.nextLine().trim();

        System.out.print("Enter zip code (optional): ");
        String zipCode = input.nextLine().trim();

        System.out.print("Enter city (optional): ");
        String city = input.nextLine().trim();

        // Find matching contact(s) with the provided details
        Optional<Contact> contact = contacts.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name) &&
                        (streetName.isBlank() || c.getStreetName().equalsIgnoreCase(streetName)) &&
                        (zipCode.isBlank() || c.getZipcode().equalsIgnoreCase(zipCode)) &&
                        (city.isBlank() || c.getCity().equalsIgnoreCase(city)))
                .findFirst();

        // Handle cases for deletion
        if (contact.isPresent()) {
            contacts.remove(contact.get());
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found with the provided details.");
        }
    }
}
