package org.example;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EditContact {
    public static void editContact(List<Contact> contacts, Scanner input) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available to edit.");
            return;
        }

        System.out.print("Enter name to edit: ");
        String name = input.nextLine().trim();

        // Edge case: Empty name input
        if (name.isEmpty()) {
            System.out.println("Invalid input. Name cannot be empty.");
            return;
        }

        // Find the contact to edit
        Optional<Contact> contact = contacts.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst();

        if (contact.isPresent()) {
            Contact foundContact = contact.get();

            // Edit phone number
            System.out.print("Enter new phone (leave blank to keep current): ");
            String newPhone = input.nextLine().trim();
            if (!newPhone.isEmpty()) {
                if (isValidPhone(newPhone)) {
                    foundContact.setPhone(newPhone);
                } else {
                    System.out.println("Invalid phone number format.");
                    return;
                }
            }

            // Edit email
            System.out.print("Enter new email (leave blank to keep current): ");
            String newEmail = input.nextLine().trim();
            if (!newEmail.isEmpty()) {
                if (isValidEmail(newEmail)) {
                    foundContact.setEmail(newEmail);
                } else {
                    System.out.println("Invalid email format.");
                    return;
                }
            }

            // Edit street name
            System.out.print("Enter new street name (leave blank to keep current): ");
            String newStreet = input.nextLine().trim();
            if (!newStreet.isEmpty()) {
                foundContact.setStreetName(newStreet);
            }

            // Edit city
            System.out.print("Enter new city (leave blank to keep current): ");
            String newCity = input.nextLine().trim();
            if (!newCity.isEmpty()) {
                foundContact.setCity(newCity);
            }

            // Edit zipcode
            System.out.print("Enter new zipcode (leave blank to keep current): ");
            String newZipcode = input.nextLine().trim();
            if (!newZipcode.isEmpty()) {
                foundContact.setZipcode(newZipcode);
            }

            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Helper method to validate phone number
    private static boolean isValidPhone(String phone) {
        return phone.matches("\\d{7,}"); // Phone must contain only digits and have a minimum length of 7
    }

    // Helper method to validate email
    private static boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"); // Simple regex for email validation
    }
}
