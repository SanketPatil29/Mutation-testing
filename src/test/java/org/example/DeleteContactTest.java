package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DeleteContactTest {
    private List<Contact> contacts;

    @BeforeEach
    void setUp() {
        contacts = new ArrayList<>();
        // Populate with sample contacts
        contacts.add(new Contact("John", "1234567890", "john@example.com", "123 Elm St", "Springfield", "12345"));
        contacts.add(new Contact("Alice", "9876543210", "alice@example.com", "456 Oak St", "Shelbyville", "67890"));
    }

    @Test
    void testDeleteContactWithNullContactsList() {
        String input = "John\n\n\n\n";
        Scanner scanner = new Scanner(input);

        // Should handle null list gracefully
        DeleteContact.deleteContact(null, scanner);
    }

    @Test
    void testDeleteContactSuccessfully() {
        String input = "John\n123 Elm St\n12345\nSpringfield\n";
        Scanner scanner = new Scanner(input);

        DeleteContact.deleteContact(contacts, scanner);

        // Verify the contact is deleted
        assertEquals(1, contacts.size());
        assertTrue(contacts.stream().noneMatch(c -> c.getName().equalsIgnoreCase("John")));
    }

    @Test
    void testDeleteContactWithPartialMatchFails() {
        String input = "Alice\nWrong Street\n\n\n"; // Partial but invalid match
        Scanner scanner = new Scanner(input);

        DeleteContact.deleteContact(contacts, scanner);

        // Verify no contact is deleted
        assertEquals(2, contacts.size());
    }

    @Test
    void testDeleteContactWithWhitespaceInputs() {
        String input = "  Alice  \n  \n  \nShelbyville\n"; // Include trailing spaces
        Scanner scanner = new Scanner(input);

        DeleteContact.deleteContact(contacts, scanner);

        // Verify the contact is deleted
        assertEquals(1, contacts.size());
        assertTrue(contacts.stream().noneMatch(c -> c.getName().equalsIgnoreCase("Alice")));
    }

    @Test
    void testDeleteContactWithCaseInsensitiveName() {
        String input = "JOHN\n\n\n\n"; // Name in uppercase
        Scanner scanner = new Scanner(input);

        DeleteContact.deleteContact(contacts, scanner);

        // Verify the contact is deleted
        assertEquals(1, contacts.size());
        assertTrue(contacts.stream().noneMatch(c -> c.getName().equalsIgnoreCase("John")));
    }

    @Test
    void testDeleteContactWithEmptyList() {
        contacts.clear();
        String input = "John\n\n\n\n";
        Scanner scanner = new Scanner(input);

        DeleteContact.deleteContact(contacts, scanner);

        // Verify no contact is deleted
        assertTrue(contacts.isEmpty());
    }

    @Test
    void testDeleteContactWithEmptyName() {
        String input = "\n\n\n\n";
        Scanner scanner = new Scanner(input);

        DeleteContact.deleteContact(contacts, scanner);

        // Verify no contact is deleted
        assertEquals(2, contacts.size());
    }
}
