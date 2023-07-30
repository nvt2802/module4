package com.example.borrow_books.read_and_write_file;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ReadAndWriteFile {
    public static List<String> readFile(String path) {
        List<String> stringList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Read file exception");
        }
        return stringList;
    }

    public static void writeFile(String path, String string, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(path, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(string);
            bufferedWriter.write("\n");
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}
