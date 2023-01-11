import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;
import java.util.ArrayList;

public class Contacts {
    public static void main(String[] args) throws IOException {
        // Define the file path
        Path path = Paths.get(".", "contacts.txt");
        Scanner sc = new Scanner(System.in);
        List<String> contactList = new ArrayList<>();
        try {
            // read contact list from file
            contactList = Files.readAllLines(path);
        } catch (IOException e) {
            // If file does not exists, it creates a new file
            Files.createFile(path);
            System.out.println("contacts.txt file created. Add new contact to begin.");
        }

        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("1. View Contacts");
            System.out.println("2. Add a new contact");
            System.out.println("3. Search a contact by name");
            System.out.println("4. Delete an existing contact");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");

            int caseSwitch = -1;
            try {
                caseSwitch = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Invalid input, please enter a valid number.");
                continue;
            }

            switch (caseSwitch) {
                case 1:
                    // view contacts
                    // .isEmpty method is used throughtout project to check if the input string is empty or not
                    if (contactList.isEmpty()) {
                        System.out.println("No contacts available to view.");
                        break;
                    }
                    System.out.println("Contacts:");
                    for (String contact : contactList) {
                        System.out.println(contact);
                    }
                    break;
                case 2:
                    // add new contact
                    //.trim method eliminates leading and trailing spaces- checking before and after string.
                    // nextline() method uses util scanner , scans current position until it finds a line seperator, returns String from current position to end of line.
                    System.out.print("Enter a name: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Name should not be empty.");
                        break;
                    }
                    System.out.print("Enter a phone number: ");
                    String phoneNumber = sc.nextLine().trim();
                    if (phoneNumber.isEmpty()) {
                        System.out.println("Phone number should not be empty.");
                        break;
                    }
                    //.contains() method checks whether a string contains a sequence of chars. Returns true if chars. exist
                    //.adds() method of java collection interface inserts specified element in this collection. It returns a boolean value true
                    String newContact = name.toLowerCase() + " " + phoneNumber.toLowerCase();
                    if (contactList.contains(newContact)) {
                        System.out.println("This contact already exists.");
                    } else {
                        contactList.add(newContact);
                        System.out.println("Contact added successfully.");
                    }
                    break;
                case 3:
                    // search contact by name
                    System.out.print("Enter a name to search: ");
                    String searchName = sc.nextLine().trim();
                    if (searchName.isEmpty()) {
                        System.out.println("Name should not be empty.");
                        break;
                    }
                    boolean userFound = false;
                    for (String contact : contactList) {
                        if (contact.toLowerCase().contains(searchName.toLowerCase())) {
                            System.out.println(contact);
                            userFound = true;
                        }
                    }
                    if (!userFound) {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    // delete contact
                    System.out.print("Enter a name to delete: ");
                    String deleteName = sc.nextLine().trim();
                    if (deleteName.isEmpty()) {
                        System.out.println("Name should not be empty.");
                        break;
                    }
                    //.get() return value of var name.
                    boolean isDeleted = false;
                    for (int i = 0; i < contactList.size(); i++) {
                        if (contactList.get(i).toLowerCase().contains(deleteName.toLowerCase())) {
                            contactList.remove(i);
                            System.out.println("Contact deleted successfully.");
                            isDeleted = true;
                            break;
                        }
                    }
                    if (!isDeleted) {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 0:
                    // exit
                    System.out.println("Goodbye!");
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Invalid input, please enter a valid option.");
                    break;
            }
            // write the updated contact list back to file
            Files.write(path, contactList);
        }
    }
}


