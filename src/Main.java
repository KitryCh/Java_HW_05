import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иванов", "11111111111");
        addContact(phoneBook, "Петров", "11111111111");
        addContact(phoneBook, "Сидоров", "11111111111");
        addContact(phoneBook, "Черемных", "11111111111");
        addContact(phoneBook, "Иванов", "22222222222");
        addContact(phoneBook, "Петров", "22222222222");
        addContact(phoneBook, "Сидоров", "22222222222");
        addContact(phoneBook, "Сидоров", "33333333333");
        addContact(phoneBook, "Иванов", "33333333333");
        addContact(phoneBook, "Петров", "33333333333");
        addContact(phoneBook, "Черемных", "22222222222");
        addContact(phoneBook, "Филиппов", "11111111111");
        addContact(phoneBook, "Иванов", "44444444444");
        addContact(phoneBook, "Петров", "44444444444");
        addContact(phoneBook, "Иванов", "55555555555");

        printPhoneBook(phoneBook);
    }

    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {

        if (phoneBook.containsKey(name)) {

            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {

            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {

        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}