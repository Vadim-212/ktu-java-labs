package kz.ktu.lab4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String str = "Lorem ipsum dolor sit amet, 8ee77d8c-30fa-4979-9d21-de72c3e34057 consectetur adipiscing elit. " +
                "Quisque viverra dolor vel nibh posuere e4ac57c6-28fc-426d-b2ec-6d93cce6fb58 convallis. Morbi " +
                "vulputate in arcu sed semper. Cras et 56b77c43-b969-4602-b15c-0aaed278c628 tellus vitae velit " +
                "hendrerit vehicula a non.";
        String regex = "[A-z0-9]{8}-[A-z0-9]{4}-[A-z0-9]{4}-[A-z0-9]{4}-[A-z0-9]{12}";
        Pattern pattern = null;
        Matcher matcher = null;
        Integer matchesCount = 0;
        try {
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(str);
        } catch (Exception e) {
            System.out.println("Регулярное выражение или строка равны null.");
            e.printStackTrace();
        }
        if(matcher != null) {
            System.out.println("Найденные GUID в строке:");
            try {
                while (matcher.find()) {
                    System.out.println(str.substring(matcher.start(), matcher.end()));
                    matchesCount++;
                }
                if(matchesCount == 0)
                    throw new Exception("Совпадений с регулярным выражением в строке нет");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Quisque viverra dolor vel nibh posuere convallis. Morbi vulputate in arcu sed semper. " +
                "Cras et tellus vitae velit hendrerit vehicula a non.";
        regex = "([A-z])\\w+";
        matchesCount = 0;
        try {
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(str);
        } catch (Exception e) {
            System.out.println("Регулярное выражение или строка равны null.");
            e.printStackTrace();
        }
        if(matcher != null) {
            StringBuilder word;
            System.out.println("Строка:\n" + str);
            try {
                while (matcher.find()) {
                    word = new StringBuilder(str.substring(matcher.start(), matcher.end()));
                    str = str.substring(0, matcher.start()) + word.reverse().toString() + str.substring(matcher.end());
                    matchesCount++;
                }
                if (matchesCount == 0)
                    throw new Exception("Совпадений с регулярным выражением в строке нет");
                System.out.println("Изменённая строка:\n" + str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
