package lesson_4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // задание 1
        Words.printUnic();

        // задание 2
        Phonebook phonebook = new Phonebook();
        phonebook.add("Петров", "+74950006776");
        phonebook.add("Петров", "+74950005556");
        phonebook.add("Сидоров", "+7495000986");
        phonebook.add("Иванов", "+74950004536");

        ArrayList <String> x = phonebook.get("Петров");
        System.out.println(x);

    }
}
