package Lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return true;
        } else {
            System.out.println("Для кошки недосаточно еды в миске");
            return false;
        }
    }

    public void increaseFood(int n) {
        food += n;
    }

    public void info() {
        System.out.println("Миска: " + food);
    }
}
