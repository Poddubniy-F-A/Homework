package Lesson6;

public class Cat extends Animal {
    protected String name;
    static int catsCounter = 0;

    public Cat(String name) {
        super(name);
        this.name = name;
        catsCounter++;
    }

    @Override
    public void run(int length) {
        if (length < 200) {
            System.out.println(super.name + " пробежал(а) " + length + " м");
        } else {
            System.out.println(super.name + " пробежал(а) " + 200 + " м");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Кошки боятся воды");
    }
}
