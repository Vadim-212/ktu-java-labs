package kz.ktu.lab6.ex2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final String FILE_EXTENSION = ".java";
        Scanner scanner = new Scanner(System.in);
        String filename;

        System.out.println("Введите путь до файла, в котором требуется заменить \"public\" на \"private\":");
        filename = scanner.next();

        if (filename != null) {
            File file;
            if (filename.contains(FILE_EXTENSION))
                file = new File(filename);
            else
                file = new File(filename + FILE_EXTENSION);
            FileInputStream inputStream = null;
            FileOutputStream outputStream = null;
            try {
                inputStream = new FileInputStream(file);
                String fileText = new String(inputStream.readAllBytes());
                fileText = fileText.replaceAll("(public)(?! class)", "private");
                outputStream = new FileOutputStream(file);
                outputStream.write(fileText.getBytes());
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            }
        } else {
            System.out.println("Ошибка: имя файла не может быть пустым.");
        }
    }
}
