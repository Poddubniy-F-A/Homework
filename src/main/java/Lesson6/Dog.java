package Lesson6;

public class Dog extends Animal {
    protected String name;
    static int dogsCounter = 0;

    public Dog(String name) {
        super(name);
        this.name = name;
        dogsCounter++;
    }

    @Override
    public void run(int length) {
        if (length < 500) {
            System.out.println(super.name + " пробежал(а) " + length + " м");
        } else {
            System.out.println(super.name + " пробежал(а) " + 500 + " м");
        }
    }

    @Override
    public void swim(int length) {
        if (length < 10) {
            System.out.println(super.name + " пробежал(а) " + length + " м");
        } else {
            System.out.println(super.name + " пробежал(а) " + 10 + " м");
        }
    }
}
