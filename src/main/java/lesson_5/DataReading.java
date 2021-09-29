package lesson_5;

import java.io.FileInputStream;
import java.io.IOException;

public class DataReading {
    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[20];
        try (FileInputStream in = new FileInputStream("word.csv")) {
            int count;
            while ((count = in.read(buf)) > 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print((char) buf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
