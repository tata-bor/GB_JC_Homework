package lesson_5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppData {
    private String[] header;
    private int[][] data;


    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;

    }

    public AppData() {
        this.header = new String[0];
        this.data = new int[0][0];

    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void save() {
        try (FileOutputStream out = new FileOutputStream("example.csv")) {
            saveHeader(out);
            saveData(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveData(FileOutputStream out) throws IOException {
        for (int k = 0; k < data.length; k++) {
            for (int l = 0; l < data[k].length; l++) {
                String word = Integer.toString(data[k][l]);
                if (l != data[k].length - 1) {
                    word += ";";
                } else {
                    word += "\n";
                }

                byte[] outData = word.getBytes(StandardCharsets.UTF_8);
                out.write(outData);
            }
        }
    }

    private void saveHeader(FileOutputStream out) throws IOException {
        for (int i = 0; i < header.length; i++) {
            String word = header[i];
            if (i != header.length - 1) {
                word += ";";
            } else {
                word += "\n";
            }
            byte[] outData = word.getBytes(StandardCharsets.UTF_8);
            out.write(outData);
        }
    }

    public void load() {
        String fileString = loadFile();
        String[] lines = fileString.split("\n");

        // load header
        header = lines[0].split(";");

        data = new int[lines.length - 1][header.length];
        // load data
        for (int index = 1; index < lines.length; index++) {
            var list =
                    lines[index].split(";");
            for (int x = 0; x < list.length; x++) {
                data[index - 1][x] = Integer.parseInt(list[x]);
            }
        }
    }

    private String loadFile() {
        byte[] buf = new byte[20];
        String fileString = "";
        try (FileInputStream in = new FileInputStream("example.csv")) {
            int count;
            while ((count = in.read(buf)) > 0) {
                for (int i = 0; i < count; i++) {
                    fileString += ((char) buf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileString;
    }

    public static void main(String[] args) throws IOException {
        AppData data = new AppData(new String[]{"Value 1", "Value 2", "Value 3"}, new int[][]{{100, 200, 300}, {400, 500, 600}});
        data.save();
        AppData data2 = new AppData();
        data2.load();
    }
}