package Lesson1_2;

public class Track implements Obstacle{
    protected final int length;

    public Track(int Length) {
        length = Length;
    }

    @Override
    public int size() {
        return length;
    }
}
