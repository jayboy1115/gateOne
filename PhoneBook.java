import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    public static ArrayList<String> phoneBook = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printDisplayMenu();
            System.out.println("WELCOME TO JOHNSON PHONEBOOK RECORD");
            System.out.println("Choose an option");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    findContactByPhoneNumber();
                    break;
                case 4:
                    findContactByFirstName();
                    break;
                case 5:
                    findContactByLastName();
                    break;
                case 6:
                    editContact();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addContact() {
        System.out.println("Enter first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();
        phoneBook.add(firstName + " " + lastName + " " + phoneNumber);
        System.out.println("Contact added successfully!");
    }

    public static void removeContact() {
        System.out.println("Enter first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name");
        String lastName = scanner.nextLine();
        for (String contact : phoneBook) {
            if (contact.contains(firstName + " " + lastName)) {
                phoneBook.remove(contact);
                System.out.println("Contact removed successfully!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public static void findContactByPhoneNumber() {
        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();
        for (String contact : phoneBook) {
            if (contact.contains(phoneNumber)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public static void findContactByFirstName() {
        System.out.println("Enter first name");
        String firstName = scanner.nextLine();
        for (String contact : phoneBook) {
            if (contact.startsWith(firstName)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public static void findContactByLastName() {
        System.out.println("Enter last name");
        String lastName = scanner.nextLine();
        for (String contact : phoneBook) {
            if (contact.contains(" " + lastName)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public static void editContact() {
        System.out.println("Enter first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name");
        String lastName = scanner.nextLine();
        for (String contact : phoneBook) {
            if (contact.contains(firstName + " " + lastName)) {
                System.out.println("Enter new first name");
                String newFirstName = scanner.nextLine();
                System.out.println("Enter new last name");
                String newLastName = scanner.nextLine();
                System.out.println("Enter new phone number");
                String newPhoneNumber = scanner.nextLine();
                phoneBook.remove(contact);
                phoneBook.add(newFirstName + " " + newLastName + " " + newPhoneNumber);
                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public static void printDisplayMenu() {
        System.out.println("1. Add Contact");
        System.out.println("2. Remove Contact");
        System.out.println("3. Find Contact by Phone Number");
        System.out.println("4. Find Contact by First Name");
        System.out.println("5. Find Contact by Last Name");
        System.out.println("6. Edit Contact");
        System.out.println("7. Exit");
    }
}

