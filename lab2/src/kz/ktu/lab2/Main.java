package kz.ktu.lab2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        final int ABITURIENT = 5;
        final int MARKS_COUNT = 10;
        ArrayList<Abiturient> abiturients = new ArrayList<>(ABITURIENT);

        // Инициализация элементов списка
        abiturients.add(new Abiturient("Иван", "Васильев", "Петрович", "г. Караганда, ул. 1, дом 9", List.of()));
        abiturients.add(new Abiturient("Петр", "Дмитриев", "Александрович", "г. Караганда, ул. 1, дом 12", List.of()));
        abiturients.add(new Abiturient("Александр", "Иванов", "Васильевич", "г. Караганда, ул. 3, дом 25", List.of()));
        abiturients.add(new Abiturient("Василий", "Петров", "Дмитриевич", "г. Караганда, ул. 4, дом 5", List.of()));
        abiturients.add(new Abiturient("Дмитрий", "Александров", "Иванович", "г. Караганда, ул. 5, дом 7", List.of()));

        // Заполнение оценок абитуриенов рандомными значениями
        ArrayList<Integer> randomMarks = new ArrayList<>();
        Random random = new Random();
        for (Abiturient abiturient : abiturients) {
            for (int i = 0; i < MARKS_COUNT; i++) {
                randomMarks.add(random.nextInt(MARKS_COUNT + 1));
            }
            abiturient.setMarks(randomMarks);
            randomMarks.clear();
        }

        System.out.println("Список абитуриентов:");
        for (Abiturient abiturient : abiturients)
            System.out.println(abiturient);
        System.out.println("\n\n");

        System.out.println("Список абитуриентов, имеющих неудовлетворительные оценки:");
        for (Abiturient abiturient : abiturients) {
            if(abiturient.getMarksSum() < 50)
                System.out.println(abiturient);
        }
        System.out.println("\n");

        Integer mark = 60;
        System.out.println("Список абитуриентов, сумма баллов у которых не меньше " + mark + ":");
        for (Abiturient abiturient : abiturients) {
            if(abiturient.getMarksSum() >= mark)
                System.out.println(abiturient);
        }
        System.out.println("\n");

        System.out.println("Абитуриент, имеющий самую высокую сумму баллов:");
        Abiturient abiturientWithMaxMarksSum = abiturients.get(0);
        for (Abiturient abiturient : abiturients) {
            if(abiturientWithMaxMarksSum.getMarksSum() < abiturient.getMarksSum())
                abiturientWithMaxMarksSum = abiturient;
        }
        System.out.println(abiturientWithMaxMarksSum + "\n");

        int abiturientsCount = 3;
        System.out.println("Абитуриенты (" + abiturientsCount + "), имеющие полупроходной балл:");
        abiturients.sort(new AbiturientReversedComparator());
        for (int i = 0; i < abiturientsCount; i++) {
            System.out.println(abiturients.get(i));
        }
    }
}
