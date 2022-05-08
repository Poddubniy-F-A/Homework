package Lesson2_2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int i, int j) {
        System.out.println("Данные в ячейке " + i + "-" + j + " некорректны");
    }
}