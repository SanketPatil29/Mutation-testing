# Mutation Testing on Address Book Management System using PIT

## Address Book Management System
A simple Java-based console application to manage personal contacts, including add, search, view, edit, and delete contact information.

## Features
1. **Add Contact**
   - Add a new contact with details:
     - Name (unique and non-empty)
     - Phone number (digits only, minimum 7 characters)
     - Email address (valid format)
     - Address details: Street name, city, zipcode (5 digits)
   - Prevents duplicate names

2. **Search Contact**
   - Search by name
   - Optional refinement using street name, city, or zipcode

3. **View Contacts**
   - Display all saved contacts

4. **Edit Contact**
   - Modify existing contact details

5. **Delete Contact**
   - Remove a contact by name

6. **Error Handling**
   - Clear error messages for invalid or missing inputs

## Prerequisites
- Java Development Kit (JDK) 8 or later
- Maven
- Any Java IDE (IntelliJ IDEA, Eclipse) or text editor

## Project Setup

### 1. Clone the Repository
```bash
git clone https://github.com/SanketPatil29/Mutation-testing.git
cd Mutation-testing
```

### 2. Install Dependencies
```bash
mvn clean install
```

## Mutation Testing with PIT

### 3. Install PIT Mutation Testing
PIT is already included in the project's `pom.xml`. No additional installation is required.

### 4. Run Mutation Tests
```bash
mvn org.pitest:pitest-maven:mutationCoverage
```

### 5. View Mutation Testing Report
After running the mutation tests, the report will be generated in:
```
target/pit-reports/[TIMESTAMP]/index.html
```

Open this HTML file in a web browser to view detailed mutation testing results.

### Interpreting the PIT Report
- **Survived Mutations**: Indicate potential weakness in test cases
- **Killed Mutations**: Show effective test coverage
- **Coverage Percentage**: Measures the thoroughness of your test suite
