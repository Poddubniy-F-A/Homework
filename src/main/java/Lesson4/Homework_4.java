package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Homework_4 {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        return map[x][y] == DOT_EMPTY;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    public static boolean checkHorizontalsAndVerticals(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            int counterH = 0, counterV = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symbol) {
                    counterH++;
                } else {
                    counterH = 0;
                }
                if (map[j][i] == symbol) {
                    counterV++;
                } else {
                    counterV = 0;
                }
                if (counterH == DOTS_TO_WIN || counterV == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDiagonals(char symbol) {
        for (int i = 0; i < SIZE - DOTS_TO_WIN + 1; i++) {
            int counter_lower_left = 0, counter_higher_left = 0, counter_higher_right = 0, counter_lower_right = 0;
            for (int j = 0; j < SIZE - i; j++) {
                if (map[i + j][j] == symbol) {
                    counter_lower_left++;
                } else {
                    counter_lower_left = 0;
                }
                if (map[j][SIZE - 1 - i - j] == symbol) {
                    counter_higher_left++;
                } else {
                    counter_higher_left = 0;
                }
                if (map[SIZE - 1 - i - j][SIZE - 1 - j] == symbol) {
                    counter_higher_right++;
                } else {
                    counter_higher_right = 0;
                }
                if (map[SIZE - 1 - j][i + j] == symbol) {
                    counter_lower_right++;
                } else {
                    counter_lower_right = 0;
                }
                if (counter_lower_left == DOTS_TO_WIN || counter_lower_right == DOTS_TO_WIN ||
                        counter_higher_left == DOTS_TO_WIN || counter_higher_right == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkWin(char symbol) {
        return checkHorizontalsAndVerticals(symbol) || checkDiagonals(symbol);
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        System.out.println("Компьютер пошел в точку " + (i + 1) + " " + (j + 1));
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер пошел в точку " + (x + 1) + " " + (y + 1));
        map[x][y] = DOT_O;
    }
}