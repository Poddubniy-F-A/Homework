package Lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            satiety = true;
        }
    }

    public void info() {
        System.out.println(name + " наелся(ась): " + satiety);
    }
}
