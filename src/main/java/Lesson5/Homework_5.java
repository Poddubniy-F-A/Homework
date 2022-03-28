package Lesson5;

public class Homework_5 {
    public static void main(String[] args) {
        Employee[] staff = new Employee[5];
        staff[0] = new Employee("Радин Макар Витальевич", "Стажер",
                "chessPlayer@mail.ru", "+7 900 890 7428", 7500, 21);
        staff[1] = new Employee("Мельников Владимир Александрович", "Программист",
                "sobaka@yandex.ru", "+7 905 237 4682", 15000, 35);
        staff[2] = new Employee("Андреев Илья Анатольевич", "Системный администратор",
                "ia_Pozharskiy@gmail.com", "+7 916 983 4278", 27500, 33);
        staff[3] = new Employee("Мулендеев Евгений Денисович", "Начальник отдела",
                "valota@gmail.com", "+7 916 495 8239", 35000, 46);
        staff[4] = new Employee("Чинейкин Афанасий Максимович", "Бухгалтер",
                "BibopCB@yandex.com", "+7 926 092 4389", 22500, 49);
        for (int i = 0; i < 5; i++) {
            if (staff[i].age > 40) {
                staff[i].print();
                System.out.println();
            }
        }
    }
}
