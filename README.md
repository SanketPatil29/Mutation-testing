# Mutation Testing on Address Book Management System

**Address Book Management System**, a simple Java-based console application to manage personal contacts. This application allows users to add, search, view, edit, and delete contact information, including details like name, phone number, email, and address.

---

## Features

1. **Add Contact**  
   - Add a new contact with the following details:
     - Name (unique and non-empty)
     - Phone number (digits only, minimum 7 characters)
     - Email address (valid format)
     - Address details: Street name, city, and zipcode (5 digits)
   - Prevents duplicate names.

2. **Search Contact**  
   - Search for a contact by name.  
   - Optionally refine search using street name, city, or zipcode.

3. **View Contacts**  
   - Display all saved contacts.

4. **Edit Contact**  
   - Modify existing contact details.

5. **Delete Contact**  
   - Remove a contact by name.

6. **Error Handling**  
   - Provides clear error messages for invalid or missing inputs.

---

## Prerequisites

- Java Development Kit (JDK) 8 or later
- Any Java IDE (IntelliJ IDEA, Eclipse, etc.) or a simple text editor with a terminal

---

## How to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/SanketPatil29/Mutation-testing.git
   cd Mutation-testing
