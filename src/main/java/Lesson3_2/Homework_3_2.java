package Lesson3_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Homework_3_2 {
    public static void main(String[] args) {
        String[] stringArray = {
                "У", "попа", "была", "собака", "он", "ее", "любил", "она", "съела", "кусок", "мяса", "он", "ее", "убил"
        };
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 14; i++) {
            Integer repeats = map.getOrDefault(stringArray[i], 0);
            map.put(stringArray[i], repeats + 1);
        }
        for (Map.Entry<String, Integer> element : map.entrySet()) {
            System.out.println("Слово '" + element.getKey() + "' встречается " + element.getValue() + " раз(а)");
        }

        System.out.println();

        Telephone_Directory telephone_directory = new Telephone_Directory();
        Telephone_Directory.add("Радин", "+7 900 890 7428");
        Telephone_Directory.add("Мельников", "+7 905 237 4682");
        Telephone_Directory.add("Андреев", "+7 916 983 4278");
        Telephone_Directory.add("Мулендеев", "+7 916 495 8239");
        Telephone_Directory.add("Чинейкин", "+7 926 092 4389");
        Telephone_Directory.add("Мельников", "+7 905 237 4681");
        Telephone_Directory.add("Мулендеев", "+7 916 495 8230");
        Set<String> surnames = Telephone_Directory.surnamesSet();
        for (String surname : surnames) {
            System.out.print(surname + ": ");
            telephone_directory.get(surname);
        }
    }
}
