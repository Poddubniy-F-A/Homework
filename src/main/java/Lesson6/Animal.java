package Lesson6;

public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int length) {
        System.out.println(this.name + " пробежал(а) " + length + " м");
    }

    public void swim(int length) {
        System.out.println(this.name + " проплыл(а) " + length + " м");
    }
}
