package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EditContactTest {
    private List<Contact> contacts;

    @BeforeEach
    void setUp() {
        contacts = new ArrayList<>();
        // Populate with sample contacts
        contacts.add(new Contact("John", "1234567890", "john@example.com", "123 Elm St", "Springfield", "12345"));
        contacts.add(new Contact("Alice", "9876543210", "alice@example.com", "456 Oak St", "Shelbyville", "67890"));
    }

    @Test
    void testEditContactSuccessfully() {
        String input = "John\n9876543210\njohn_new@example.com\n456 Pine St\nNew Springfield\n54321\n";
        Scanner scanner = new Scanner(input);

        EditContact.editContact(contacts, scanner);

        Contact updatedContact = contacts.get(0); // Get the first contact
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("john_new@example.com", updatedContact.getEmail());
        assertEquals("456 Pine St", updatedContact.getStreetName());
        assertEquals("New Springfield", updatedContact.getCity());
        assertEquals("54321", updatedContact.getZipcode());
    }

    @Test
    void testEditContactWithPartialUpdates() {
        String input = "Alice\n\n\n123 Oak St\n\n\n";
        Scanner scanner = new Scanner(input);

        EditContact.editContact(contacts, scanner);

        Contact updatedContact = contacts.get(1); // Get the second contact
        assertEquals("9876543210", updatedContact.getPhone()); // Unchanged
        assertEquals("alice@example.com", updatedContact.getEmail()); // Unchanged
        assertEquals("123 Oak St", updatedContact.getStreetName()); // Updated
        assertEquals("Shelbyville", updatedContact.getCity()); // Unchanged
        assertEquals("67890", updatedContact.getZipcode()); // Unchanged
    }

    @Test
    void testEditContactInvalidPhoneNumber() {
        String input = "John\ninvalidPhone\n\n\n\n\n";
        Scanner scanner = new Scanner(input);

        EditContact.editContact(contacts, scanner);

        Contact contact = contacts.get(0); // Get the first contact
        assertEquals("1234567890", contact.getPhone()); // Phone remains unchanged
    }

    @Test
    void testEditContactInvalidEmail() {
        String input = "Alice\n\ninvalidEmail\n\n\n\n";
        Scanner scanner = new Scanner(input);

        EditContact.editContact(contacts, scanner);

        Contact contact = contacts.get(1); // Get the second contact
        assertEquals("alice@example.com", contact.getEmail()); // Email remains unchanged
    }

    @Test
    void testEditContactEmptyList() {
        contacts.clear(); // Empty the contact list
        String input = "John\n\n\n\n\n\n";
        Scanner scanner = new Scanner(input);

        EditContact.editContact(contacts, scanner);

        assertTrue(contacts.isEmpty()); // List should remain empty
    }

    @Test
    void testEditContactNotFound() {
        String input = "NonExistent\n\n\n\n\n\n";
        Scanner scanner = new Scanner(input);

        EditContact.editContact(contacts, scanner);

        assertEquals(2, contacts.size()); // No contact was edited
        assertTrue(contacts.stream().noneMatch(c -> c.getName().equalsIgnoreCase("NonExistent")));
    }

    @Test
    void testEditContactNoChanges() {
        String input = "John\n\n\n\n\n\n";
        Scanner scanner = new Scanner(input);

        EditContact.editContact(contacts, scanner);

        Contact contact = contacts.get(0); // Get the first contact
        assertEquals("1234567890", contact.getPhone()); // Unchanged
        assertEquals("john@example.com", contact.getEmail()); // Unchanged
        assertEquals("123 Elm St", contact.getStreetName()); // Unchanged
        assertEquals("Springfield", contact.getCity()); // Unchanged
        assertEquals("12345", contact.getZipcode()); // Unchanged
    }

    @Test
    void testEditContactCaseInsensitiveName() {
        String input = "john\n9999999999\njohn_case@example.com\n987 New St\nOld City\n12346\n";
        Scanner scanner = new Scanner(input);

        EditContact.editContact(contacts, scanner);

        Contact updatedContact = contacts.get(0); // Get the first contact
        assertEquals("9999999999", updatedContact.getPhone()); // Updated
        assertEquals("john_case@example.com", updatedContact.getEmail()); // Updated
        assertEquals("987 New St", updatedContact.getStreetName()); // Updated
        assertEquals("Old City", updatedContact.getCity()); // Updated
        assertEquals("12346", updatedContact.getZipcode()); // Updated
    }
}
