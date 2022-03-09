package Lesson2;

import java.util.Scanner;

public class Homework_2 {
    private static Scanner scanner = new Scanner (System.in);

    public static boolean sumChecking (int a, int b) {
        int sum = a + b;
        return (sum >= 10 && sum <= 20);
    }

    public static void signChecking (int a) {
        if (a < 0) {
            System.out.println (a + " - отрицательное число");
        } else {
            System.out.println (a + " - положительное число");
        }
    }

    public static boolean signChecking1Bool (int a) {
        return (a < 0);
    }

    public static void printString (int counter, String s) {
        while (counter > 0) {
            System.out.println (s);
            counter--;
        }
    }

    public static boolean leapYearChecking (int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    public static void main(String[] args) {
        System.out.println ("\n1) Введите числа a и b:");
        int a = scanner.nextInt(), b = scanner.nextInt();
        System.out.println ("Сумма a и b лежит на отрезке от 10 до 20 - " + sumChecking (a, b));

        System.out.println ("\n2) Введите число, знак которого хотите узнать:");
        a = scanner.nextInt();
        signChecking (a);

        System.out.println ("\n3) Введите число, о знаке которого хотите узнать:");
        a = scanner.nextInt();
        System.out.println ("Введенно отрицательное число - " + signChecking1Bool (a));

        System.out.println ("\n4) Введите число раз, которое вы хотите, чтобы напечаталась строка:");
        a = scanner.nextInt();
        printString (a, "Эта строка напечатана " + a + " раз(а)");

        System.out.println ("\n5) Введите год:");
        a = scanner.nextInt();
        scanner.close();
        System.out.println ("Введен високосный год - " + leapYearChecking (a));
    }
}