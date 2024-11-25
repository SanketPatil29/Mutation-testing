package org.example;

import java.util.List;

public class PrintContacts {
    public static void printContacts(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("-------- Contact List --------");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
            System.out.println("------------------------------");
        }
    }
}
