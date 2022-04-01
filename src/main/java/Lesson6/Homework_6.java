package Lesson6;

public class Homework_6 {
    public static void main(String[] args) {
        Cat Felix = new Cat("Феликс"), Snow = new Cat("Снежок");
        Dog Alfa = new Dog("Альфа"), Jack = new Dog("Джек"), Nancy = new Dog("Нэнси");
        Felix.run(87);
        Felix.swim(0);
        Snow.run(293);
        Snow.swim(8);
        Alfa.run(258);
        Alfa.swim(4);
        Jack.run(982);
        Jack.swim(9);
        Nancy.run(204);
        Nancy.swim(23);
        System.out.println("Создано " + Cat.catsCounter + " объектов типа Cat и " + Dog.dogsCounter + " объектов типа Dog");
    }
}
