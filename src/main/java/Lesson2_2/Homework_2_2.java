package Lesson2_2;

public class Homework_2_2 {
    public static void main(String[] args) {
        String[][] array = {
                {"531", "7", "-3", "14" },
                {"-68", "8", "0", "1" },
                {"2", "3", "4", "5" },
                {"6", "7", "8", "9" }
        };
        try {
            System.out.println(Summation(array));
        } catch (MyArraySizeException | MyArrayDataException e) {

        }
    }

    public static int Summation(String[][] array) {
        checkSize(array);
        int total = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    total += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i + 1, j + 1);
                }
            }
        }
        return total;
    }

    public static void checkSize(String[][] array) {
        if (array.length != 4) {
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < 4; i++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
    }
}