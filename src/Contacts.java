import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;
import java.util.ArrayList;

public class Contacts {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get(".","contacts.txt");
        Scanner sc = new Scanner(System.in);
        List<String> contactList = new ArrayList<>();

        // read contact list from file
        contactList = Files.readAllLines(path);

        // menu
        System.out.println("1. View Contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("0. Exit");
        System.out.println("Enter your choice:");
        int caseSwitch = sc.nextInt();

        switch (caseSwitch) {
            case 1:
                // view contacts
                System.out.println("Contacts:");
                for (String contact : contactList) {
                    System.out.println(contact);
                }  break;
            case 2:
                // add new contact
                System.out.println("Enter a name:");
                String name = sc.nextLine();
                System.out.println("Enter a phone number:");
                String phoneNumber = sc.nextLine();
                contactList.add(name.toLowerCase() + " " + phoneNumber.toLowerCase());
                System.out.println("Contact added successfully");
                break;
            case 3:
                // search contact by name
                System.out.println("Enter a name to search:");
                String searchName = sc.nextLine();
                boolean userFound = false;
                for (String contact : contactList) {
                    if (contact.contains(searchName.toLowerCase())) {
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
                System.out.println("Enter a name to delete:");
                String deleteName = sc.nextLine();
                for (int i = 0; i < contactList.size(); i++) {
                    if (contactList.get(i).contains(deleteName.toLowerCase())) {
                        contactList.remove(i);
                        System.out.println("Contact deleted successfully.");
                        break;
                    }
                }
                break;
            case 0:
// exit
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input, please enter a valid option.");
                break;
        }
// write the updated contact list back to file
        Files.write(path, contactList);
    }
}
