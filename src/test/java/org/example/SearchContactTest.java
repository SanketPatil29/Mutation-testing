package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SearchContactTest {

    private List<Contact> contacts;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("John Doe", "1234567890", "john@example.com", "123 Elm St", "Springfield", "12345"));
        contacts.add(new Contact("Jane Smith", "0987654321", "jane@example.com", "456 Maple St", "Shelbyville", "54321"));
        contacts.add(new Contact("Alice Johnson", "1112223333", "alice@example.com", "789 Oak St", "Springfield", "12345"));

        // Redirect System.out for capturing output
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testSearchByNameExactMatch() {
        String input = "John Doe\n\n\n\n";
        Scanner scanner = new Scanner(input);

        SearchContact.searchContact(contacts, scanner);

        String output = outContent.toString();
        assertTrue(output.contains("Matching contact(s) found:"));
        assertTrue(output.contains("John Doe"));
    }

    @Test
    void testSearchByNameNotFound() {
        String input = "Nonexistent Name\n\n\n\n";
        Scanner scanner = new Scanner(input);

        SearchContact.searchContact(contacts, scanner);

        String output = outContent.toString();
        assertTrue(output.contains("No matching contact found"));
    }

    @Test
    void testSearchWithEmptyName() {
        String input = "\n\n\n\n";
        Scanner scanner = new Scanner(input);

        SearchContact.searchContact(contacts, scanner);

        String output = outContent.toString();
        assertTrue(output.contains("Invalid input. Name cannot be empty."));
    }

    @Test
    void testSearchByAllFields() {
        String input = "Alice Johnson\n789 Oak St\n12345\nSpringfield\n";
        Scanner scanner = new Scanner(input);

        SearchContact.searchContact(contacts, scanner);

        String output = outContent.toString();
        assertTrue(output.contains("Matching contact(s) found:"));
        assertTrue(output.contains("Alice Johnson"));
    }

    @Test
    void testSearchByNameAndMismatchedOptionalFields() {
        String input = "John Doe\n456 Maple St\n54321\nShelbyville\n";
        Scanner scanner = new Scanner(input);

        SearchContact.searchContact(contacts, scanner);

        String output = outContent.toString();
        assertTrue(output.contains("No matching contact found"));
    }

    @Test
    void testEmptyContactsList() {
        List<Contact> emptyContacts = new ArrayList<>();
        String input = "John Doe\n\n\n\n";
        Scanner scanner = new Scanner(input);

        SearchContact.searchContact(emptyContacts, scanner);

        String output = outContent.toString();
        assertTrue(output.contains("No contacts available to search."));
    }

    @Test
    void testMultipleMatchingContacts() {
        contacts.add(new Contact("Alice Johnson", "2223334444", "alice2@example.com", "789 Oak St", "Springfield", "12345"));
        String input = "Alice Johnson\n\n\nSpringfield\n";
        Scanner scanner = new Scanner(input);

        SearchContact.searchContact(contacts, scanner);

        String output = outContent.toString();
        assertTrue(output.contains("Matching contact(s) found:"));
        assertTrue(output.contains("Alice Johnson"));
        assertTrue(output.contains("alice2@example.com"));
    }

    @Test
    void testCaseInsensitiveSearch() {
        String input = "john doe\n\n\n\n";
        Scanner scanner = new Scanner(input);

        SearchContact.searchContact(contacts, scanner);

        String output = outContent.toString();
        assertTrue(output.contains("Matching contact(s) found:"));
        assertTrue(output.contains("John Doe"));
    }
}
