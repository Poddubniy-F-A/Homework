package Lesson7;

public class Homework_7 {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Барсик", 35);
        cats[1] = new Cat("Васька", 40);
        cats[2] = new Cat("Кузька", 30);
        cats[3] = new Cat("Мурзик", 5);
        cats[4] = new Cat("Снежок", 25);
        Plate plate = new Plate(75);
        plate.increaseFood(25);
        plate.info();
        for (int i = 0; i < 5; i++) {
            cats[i].eat(plate);
            cats[i].info();
            plate.info();
        }
    }
}
