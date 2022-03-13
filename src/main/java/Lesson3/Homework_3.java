package Lesson3;

public class Homework_3 {
    public static void main(String[] args) {
        array01Changing(randomArrayCreating(10, 2));

        trueArrayCreating(100);

        int[] array_1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        arrayChanging(array_1);

        int len = 10;
        int[][] array_2 = new int[len][len];
        for (int i = 0; i < len; i++) {
            array_2[i] = randomArrayCreating(len, 10);
        }
        arrayDiagonalFilling(array_2);

        equalArrayCreating(3, 5);

        minMaxFinding(randomArrayCreating(10, 100));

        balanceChecking(randomArrayCreating(10, 100));

        arrayShifting(trueArrayCreating(8), -19);
    }

    public static int[] randomArrayCreating(int len, int range) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = (int) (Math.random() * range);
        }
        return array;
    }

    public static void array01Changing(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            array[i] = 1 - array[i] % 2;
        }
    }

    public static int[] trueArrayCreating(int len) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static void arrayChanging(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    public static void arrayDiagonalFilling(int[][] array) {
        int right_element_index = array.length - 1;
        for (int i = 0; i < right_element_index; i++) {
            array[i][i] = 1;
            array[i][right_element_index - 1 - i] = 1;
        }
    }

    public static int[] equalArrayCreating(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void minMaxFinding(int[] array) {
        int len = array.length, min = array[0], max = array[0];
        for (int i = 1; i < len; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println(min + ", " + max);
    }

    public static boolean balanceChecking(int[] array) {
        int len = array.length, sum = 0, i;
        for (i = 0; i < len; i++) {
            sum += array[i];
        }
        int current_sum = 0;
        for (i = 0; i < len; i++) {
            current_sum += (array[i] * 2);
            if (current_sum == sum) {
                return true;
            }
        }
        return false;
    }

    public static void trueShifting(int[] array, int n) {
        int len = array.length, save = array[0];
        for (int i = 0; i < len - 1; i++) {
            array[(i * n) % len] = array[((i + 1) * n) % len];
        }
        array[len - n] = save;
    }

    public static void piecemealShifting(int[] array, int n) {
        int len = array.length, parts = len - n;
        if (len % n == 0) {
            parts = n;
        }
        int part_length = len / parts;
        for (int i = 0; i < parts; i++) {
            int save = array[i];
            for (int j = 0; j < part_length - 1; j++) {
                array[(i + j * n) % len] = array[(i + (j + 1) * n) % len];
            }
            array[(i + (part_length - 1) * n) % len] = save;
        }
    }

    public static void arrayShifting(int[] array, int n) {
        int len = array.length;
        n %= len;
        if (n < 0) {
            n += len;
        }
        n = len - n;
        if (len % n != 0 && len % (len - n) != 0) {
            trueShifting(array, n);
        } else {
            piecemealShifting(array, n);
        }
    }
}