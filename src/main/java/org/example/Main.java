package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int exit = 0;
        int answer;

        do {
            System.out.println("--------Welcome to Address Book---------");
            System.out.println("Enter '1' to Add contact");
            System.out.println("Enter '2' to Search contact");
            System.out.println("Enter '3' to Print contacts");
            System.out.println("Enter '4' to Edit contact");
            System.out.println("Enter '5' to Delete contact");
            System.out.println("Enter '0' to Exit");

            answer = input.nextInt();
            input.nextLine(); // Consume newline

            switch (answer) {
                case 1:
                    AddContact.addContact(contacts, input);
                    break;
                case 2:
                    SearchContact.searchContact(contacts, input);
                    break;
                case 3:
                    PrintContacts.printContacts(contacts);
                    break;
                case 4:
                    EditContact.editContact(contacts, input);
                    break;
                case 5:
                    DeleteContact.deleteContact(contacts, input);
                    break;
                case 0:
                    System.out.println("Application terminating...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (answer != exit);
    }
}
