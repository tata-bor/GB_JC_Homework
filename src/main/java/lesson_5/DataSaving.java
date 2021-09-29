package lesson_5;

//Задание 1: Реализовать сохранение данных в csv файл

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DataSaving {
    public static void main (String[] args) throws FileNotFoundException {
        String word = "Hello";
        byte [] outData = word.getBytes(StandardCharsets.UTF_8);
        try (FileOutputStream out = new FileOutputStream("word.csv")){
            out.write(outData);

        } catch (IOException e) {
            e.printStackTrace();
                }
    }
}
