package Lesson1_2;

public class Wall implements Obstacle{
    protected final int height;

    public Wall(int Height) {
        height = Height;
    }

    @Override
    public int size() {
        return height;
    }
}
