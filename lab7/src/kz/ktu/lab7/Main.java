package kz.ktu.lab7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    String numberStr;
        ObjStack<Integer> digitStack = new ObjStack<>();

        System.out.println("Введите число: ");
        numberStr = scanner.next();

        try {
            Integer.parseInt(numberStr);
        } catch (NumberFormatException ex) {
            System.out.println("Неоходимо ввести число.");
            ex.printStackTrace();
        }

        for (int i = 0; i < numberStr.length(); i++) {
            digitStack.addToStack(Integer.parseInt(String.valueOf(numberStr.charAt(i))));
        }

        System.out.println("Стек: ");
        digitStack.printStack();
    }
}
