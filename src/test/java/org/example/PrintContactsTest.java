package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintContactsTest {

    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testPrintContactsWithEmptyList() {
        // Arrange: Empty list
        List<Contact> contacts = new ArrayList<>();

        // Act
        PrintContacts.printContacts(contacts);

        // Assert
        String expectedOutput = "No contacts available.";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintContactsWithSingleContact() {
        // Arrange: List with one contact, including address
        List<Contact> contacts = List.of(new Contact("Alice", "1234567890", "alice@example.com", "123 Elm St", "Springfield", "12345"));

        // Act
        PrintContacts.printContacts(contacts);

        // Assert
        String lineSeparator = System.lineSeparator();
        String expectedOutput = "-------- Contact List --------" + lineSeparator +
                "1. Name: Alice, Phone: 1234567890, Email: alice@example.com, Street: 123 Elm St, City: Springfield, Zipcode: 12345" + lineSeparator +
                "------------------------------";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintContactsWithMultipleContacts() {
        // Arrange: List with multiple contacts, each having address info
        List<Contact> contacts = List.of(
                new Contact("Bob", "9876543210", "bob@example.com", "456 Oak St", "Shelbyville", "67890"),
                new Contact("Charlie", "5555555555", "charlie@example.com", "789 Pine St", "Springfield", "11111")
        );

        // Act
        PrintContacts.printContacts(contacts);

        // Assert
        String lineSeparator = System.lineSeparator();
        String expectedOutput = "-------- Contact List --------" + lineSeparator +
                "1. Name: Bob, Phone: 9876543210, Email: bob@example.com, Street: 456 Oak St, City: Shelbyville, Zipcode: 67890" + lineSeparator +
                "2. Name: Charlie, Phone: 5555555555, Email: charlie@example.com, Street: 789 Pine St, City: Springfield, Zipcode: 11111" + lineSeparator +
                "------------------------------";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintContactsWithEmptyFields() {
        // Arrange: List with contacts having empty phone, email, or address fields
        List<Contact> contacts = List.of(
                new Contact("Dave", "", "dave@example.com", "", "Springfield", "12345"),
                new Contact("Eve", "1231231234", "", "456 Oak St", "", "")
        );

        // Act
        PrintContacts.printContacts(contacts);

        // Assert
        String lineSeparator = System.lineSeparator();
        String expectedOutput = "-------- Contact List --------" + lineSeparator +
                "1. Name: Dave, Phone: , Email: dave@example.com, Street: , City: Springfield, Zipcode: 12345" + lineSeparator +
                "2. Name: Eve, Phone: 1231231234, Email: , Street: 456 Oak St, City: , Zipcode: " + lineSeparator +
                "------------------------------";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}
