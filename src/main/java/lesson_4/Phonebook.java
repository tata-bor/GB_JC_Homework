package lesson_4;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    HashMap<String, ArrayList <String>> phonebook = new HashMap<>();


    public static void workWithPhonebook() {
        HashMap<String, ArrayList <String>> hm = new HashMap<>();
    }

    public void add (String surname, String phone) {
        if (phonebook.containsKey(surname)) {
            phonebook.get(surname).add(phone);
        }
        else {
            ArrayList <String> phoneArray = new ArrayList<>();
            phoneArray.add(phone);
            phonebook.put(surname,phoneArray);
        }
    }

    public ArrayList<String> get(String surname) {
        if (phonebook.containsKey(surname)) {
            return phonebook.get(surname);
        }
        else {
            return new ArrayList<>();
        }
    }
}
