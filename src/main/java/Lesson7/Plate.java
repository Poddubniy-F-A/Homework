package Lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean isEnoughFood(int volume) {
        return food >= volume;
    }

    public void decreaseFood(int volume) {
        food -= volume;
    }

    public void increaseFood(int volume) {
        food += volume;
    }

    public void info() {
        System.out.println("Миска: " + food);
    }
}
