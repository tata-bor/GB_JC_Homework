package lesson_4;

import java.util.ArrayList;
import java.util.HashSet;

public class Words {
    String[] words;

    public static void printUnic() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Aльфa");
        list.add("Бета");
        list.add("Aльфa");
        list.add("Этa");
        list.add("Гaммa");
        list.add("Эпсилон");
        list.add("Oмeгa");
        list.add("Гaммa");
        list.add("Oмeгa");
        list.add("Гaммa");

        HashSet<String> set = new HashSet<String>(list);
        System.out.println(set);

        for (String word : set) {
            int sum = 0;
            for (String word2 : list) {
                if (word == word2) {
                    sum++;
                }
            }
            System.out.println(word + " " + sum);
        }
    }
}




