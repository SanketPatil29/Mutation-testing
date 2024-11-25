package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    void testAddContact() {
        String input = "1\nJohn\n1234567890\njohn@example.com\n123 Elm St\nSpringfield\n12345\n0\n";
        provideInput(input);

        Main.main(new String[] {});

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Contact added successfully!"));
        assertTrue(output.contains("Application terminating..."));
    }

  // serach testcase

    @Test
    void testPrintContacts() {
        String input = "1\nBob\n5555555555\nbob@example.com\n789 Pine St\nSmalltown\n11223\n3\n0\n";
        provideInput(input);

        Main.main(new String[] {});

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Name: Bob"));
        assertTrue(output.contains("789 Pine St"));
        assertTrue(output.contains("Smalltown"));
        assertTrue(output.contains("11223"));
    }

    @Test
    void testEditContact() {
        String input = "1\nCharlie\n6666666666\ncharlie@example.com\n123 Maple St\nLakeside\n54321\n4\nCharlie\n7777777777\nnewcharlie@example.com\n456 Birch St\nRiverside\n98765\n3\n0\n";
        provideInput(input);

        Main.main(new String[] {});

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Contact updated successfully!"));
        assertTrue(output.contains("Name: Charlie"));
        assertTrue(output.contains("7777777777"));
        assertTrue(output.contains("newcharlie@example.com"));
        assertTrue(output.contains("456 Birch St"));
        assertTrue(output.contains("Riverside"));
        assertTrue(output.contains("98765"));
    }

    @Test
    void testDeleteContact() {
        String input = "1\nEve\n1231231234\neve@example.com\n321 Birch St\nDowntown\n54321\n5\nEve\n321 Birch St\n54321\nDowntown\n3\n0\n";
        provideInput(input);

        Main.main(new String[] {});

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Contact deleted successfully!"));
        assertTrue(!output.contains("Eve")); // Ensure the contact is not in the print output
    }

    @Test
    void testInvalidChoice() {
        String input = "7\n0\n"; // Invalid input followed by exit
        provideInput(input);

        Main.main(new String[] {});

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Invalid choice, please try again."));
    }

    @Test
    void testExitApplication() {
        String input = "0\n"; // Exit directly
        provideInput(input);

        Main.main(new String[] {});

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Application terminating..."));
    }
}
