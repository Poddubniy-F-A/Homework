package Lesson3;

import java.util.Arrays;

import java.util.Scanner;

public class Homework_3 {
    private static Scanner scanner = new Scanner (System.in);

    public static int[] creatingArray (int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static boolean checkBalance (int[] array) {
        int array_len = array.length, sum = 0, i;
        for (i = 0; i < array_len; i++) {
            sum += array [i];
        }
        int current_sum = 0;
        for (i = 0; i < array_len; i++) {
            current_sum += (array [i] * 2);
            if (current_sum == sum) {
                return true;
            }
        }
        return false;
    }

    public static void arrayShift (int[] array, int n) {
        int array_len = array.length;
        n %= array_len;
        if (n < 0) {
            n += array_len;
        }
        n = array_len - n;
        if (array_len % n != 0 && array_len % (array_len - n) != 0) {
            int save = array[0];
            for (int i = 0; i < array_len - 1; i++) {
                array[(i * n) % array_len] = array [((i + 1) * n) % array_len];
            }
            array[array_len - n] = save;
        } else {
            int repeats = array_len - n;
            if (array_len % n == 0) {
                repeats = n;
            }
            int length = array_len / repeats;
            for (int i = 0; i < repeats; i++) {
                int save = array[i];
                for (int j = 0; j < length - 1; j++) {
                    array[(i + j * n) % array_len] = array[(i + (j + 1) * n) % array_len];
                }
                array[(i + (length - 1) * n) % array_len] = save;
            }
        }
    }

    public static void main(String[] args) {
        int i;

        int[] array_1 = new int[10];
        for (i = 0; i < 10; i++) {
            array_1 [i] = ((int)(Math.random()*10))%2;
        }
        System.out.println ("\n1) Изначальный массив:  " + Arrays.toString(array_1));
        for (i = 0; i < 10; i++) {
            if (array_1[i] == 0) {
                array_1[i] = 1;
            } else {
                array_1[i] = 0;
            }
        }
        System.out.println ("Преобразованный массив: " + Arrays.toString(array_1));

        int[] array_2 = new int[100];
        for (i = 0; i < 100; i++) {
            array_2[i] = i + 1;
        }
        System.out.println ("\n2) Массив с элементами от 1 до 100: " + Arrays.toString(array_2));

        int[] array_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println ("\n3) Изначальный массив:   " + Arrays.toString(array_3));
        for (i = 0; i < 12; i++) {
            if (array_3[i] < 6) {
                array_3[i] *= 2;
            }
        }
        System.out.println ("Преобразованный массив: " + Arrays.toString(array_3));

        int[][] array_4 = new int[10][10];
        for (i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array_4[i][j] = (int)(Math.random()*10);
            }
        }
        System.out.println ("\n4) Изначальный массив          Преобразованный массив");
        for (i = 0; i < 10; i++) {
            System.out.print (Arrays.toString(array_4[i]) + " ");
            array_4[i][i] = 1;
            array_4[i][9-i] = 1;
            System.out.println (Arrays.toString(array_4[i]));
        }

        System.out.println ("\n5) Введите длину массива и значение его элементов: ");
        int array_5_len = scanner.nextInt(), array_5_value = scanner.nextInt();
        System.out.println (Arrays.toString(creatingArray (array_5_len, array_5_value)));

        int min = 99, max = 0;
        for (i = 0; i < 10; i++) {
            array_1 [i] = (int)(Math.random()*100);
            if (array_1 [i] < min) {
                min = array_1 [i];
            }
            if (array_1 [i] > max) {
                max = array_1 [i];
            }
        }
        System.out.println ("\n6) Массив: " + Arrays.toString(array_1) +
                "\nМинимальный элемент равен " + min + ", максимальный элемент равен "+ max);

        System.out.println ("\n7) Введите длину массива: ");
        int array_7_len = scanner.nextInt();
        int[] array_7 = new int [array_7_len];
        System.out.println ("Введите элементы массива (" + array_7_len + "):");
        for (i = 0; i < array_7_len; i++) {
            array_7[i] = scanner.nextInt();
        }
        System.out.println ("Результат проверки: " + checkBalance (array_7));

        System.out.println ("\n8) Введите длину массива: ");
        int array_8_len = scanner.nextInt();
        int[] array_8 = new int [array_8_len];
        System.out.println ("Введите элементы массива (" + array_8_len + "):");
        for (i = 0; i < array_8_len; i++) {
            array_8[i] = scanner.nextInt();
        }
        System.out.println ("Введите значение сдвига: ");
        int shift = scanner.nextInt();
        scanner.close();
        arrayShift (array_8, shift);
        System.out.println ("Преобразованный массив: " + Arrays.toString(array_8));
    }
}