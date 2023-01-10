import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Contacts {
    public static void main(String[] args) {

            Path path = Paths.get(".","contacts.txt");
            Scanner sc = new Scanner(System.in);
            int caseSwitch = sc.nextInt();
            switch (caseSwitch) {
                case 1:
                    System.out.println("View Contacts");
                case 2:
                    System.out.println("Add a new contact");
                case 3:
                    System.out.println("Search a contact by name");
                case 4:
                    System.out.println("Delete an existing contact");
                    break;
                default:
                    System.out.println("Exit");
                    break;
            }
            System.out.println("Enter a name");
            String name = sc.nextLine();
            System.out.println("Enter a phone number ");
            String phoneNumber = sc.nextLine();
            List<String> contactList = Arrays.asList(name.toLowerCase(), phoneNumber.toLowerCase());
        Path Files.write(Path path, contactList<String> contactList[, StandardOpenOption option])
        }
}
