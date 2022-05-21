package Lesson3_2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Telephone_Directory {
    static Map<String, Set<String>> map = new TreeMap<>();

    public static void add(String surname, String number) {
        Set<String> numbers = map.get(surname);
        if (numbers == null) {
            Set<String> newNumbers = new HashSet<>();
            newNumbers.add(number);
            map.put(surname, newNumbers);
        } else {
            numbers.add(number);
            map.put(surname, numbers);
        }
    }

    public static Set<String> surnamesSet() {
        return map.keySet();
    }

    public void get(String surname) {
        System.out.println(map.get(surname));
    }
}