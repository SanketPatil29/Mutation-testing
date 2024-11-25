package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AddContactTest {

    private List<Contact> contacts;

    @BeforeEach
    void setUp() {
        contacts = new ArrayList<>();
    }

    @Test
    void testAddValidContact() {
        String input = "Alice\n1234567890\nalice@example.com\n123 Elm St\nSpringfield\n98765\n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertEquals(1, contacts.size());
        assertEquals("Alice", contacts.get(0).getName());
        assertEquals("1234567890", contacts.get(0).getPhone());
        assertEquals("alice@example.com", contacts.get(0).getEmail());
        assertEquals("123 Elm St", contacts.get(0).getStreetName());
        assertEquals("Springfield", contacts.get(0).getCity());
        assertEquals("98765", contacts.get(0).getZipcode());
    }

    @Test
    void testAddContactWithEmptyName() {
        String input = "\n1234567890\nalice@example.com\n123 Elm St\nSpringfield\n98765\n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertTrue(contacts.isEmpty());
    }

    @Test
    void testAddContactWithDuplicateName() {
        contacts.add(new Contact("Alice", "9876543210", "alice@example.com", "123 Elm St", "Springfield", "98765"));
        String input = "Alice\n1234567890\nnewalice@example.com\n456 Oak St\nShelbyville\n54321\n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertEquals(1, contacts.size()); // No new contact should be added
        assertEquals("Alice", contacts.get(0).getName());
    }

    @Test
    void testAddContactWithInvalidPhone() {
        String input = "Bob\nabc123\nbob@example.com\n123 Main St\nSmalltown\n12345\n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertTrue(contacts.isEmpty());
    }

    @Test
    void testAddContactWithInvalidEmail() {
        String input = "Charlie\n9876543210\ninvalid-email\n123 Maple St\nTownsville\n67890\n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertTrue(contacts.isEmpty());
    }

    @Test
    void testAddContactWithEmptyPhone() {
        String input = "Diana\n\nvalid@example.com\n123 Pine St\nUptown\n54321\n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertTrue(contacts.isEmpty()); // Contact should not be added
    }

    @Test
    void testAddContactWithEmptyEmail() {
        String input = "Eve\n1234567890\n\n123 Oak St\nMidtown\n98765\n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertTrue(contacts.isEmpty()); // Contact should not be added
    }

    @Test
    void testAddContactWithEmptyStreetName() {
        String input = "Frank\n1234567890\nfrank@example.com\n\nSpringfield\n98765\n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertTrue(contacts.isEmpty()); // Contact should not be added
    }

    @Test
    void testAddContactWithEmptyCity() {
        String input = "Grace\n1234567890\ngrace@example.com\n456 Elm St\n\n98765\n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertTrue(contacts.isEmpty()); // Contact should not be added
    }

    @Test
    void testAddContactWithInvalidZipcode() {
        String input = "Hannah\n1234567890\nhannah@example.com\n789 Oak St\nBigtown\nabcde\n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertTrue(contacts.isEmpty()); // Invalid zipcode should prevent addition
    }

    @Test
    void testAddContactTrimsWhitespace() {
        String input = "  Frank  \n  1234567890  \n  frank@example.com  \n  123 Elm St  \n  Springfield  \n  98765  \n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertEquals(1, contacts.size());
        assertEquals("Frank", contacts.get(0).getName());
        assertEquals("1234567890", contacts.get(0).getPhone());
        assertEquals("frank@example.com", contacts.get(0).getEmail());
        assertEquals("123 Elm St", contacts.get(0).getStreetName());
        assertEquals("Springfield", contacts.get(0).getCity());
        assertEquals("98765", contacts.get(0).getZipcode());
    }

    @Test
    void testAddContactCaseInsensitiveDuplicateName() {
        contacts.add(new Contact("Alice", "9876543210", "alice@example.com", "123 Elm St", "Springfield", "98765"));
        String input = "alice\n1234567890\nnewalice@example.com\n456 Oak St\nShelbyville\n54321\n";
        Scanner scanner = new Scanner(input);

        AddContact.addContact(contacts, scanner);

        assertEquals(1, contacts.size()); // No new contact should be added
        assertEquals("Alice", contacts.get(0).getName());
    }
}
