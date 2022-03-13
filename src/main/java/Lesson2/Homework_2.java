package Lesson2;

public class Homework_2 {
    public static void main(String[] args) {
        System.out.println(sumChecking(16, 8));
        signChecking(-24);
        System.out.println(signChecking1Bool(-24));
        printString(8, "Эта строка напечатана " + 8 + " раз(а)");
        System.out.println(leapYearChecking(600));
    }

    public static boolean sumChecking(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void signChecking(int a) {
        if (a < 0) {
            System.out.println(a + " - отрицательное число");
        } else {
            System.out.println(a + " - положительное число");
        }
    }

    public static boolean signChecking1Bool(int a) {
        return a < 0;
    }

    public static void printString(int counter, String s) {
        while (counter > 0) {
            System.out.println(s);
            counter--;
        }
    }

    public static boolean leapYearChecking(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}