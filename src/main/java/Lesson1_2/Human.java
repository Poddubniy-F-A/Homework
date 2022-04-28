package Lesson1_2;

public class Human implements Participant {
    private final String name;
    private final int maxObstacleHeight;
    private final int maxObstacleLength;

    public Human(String name, int maxObstacleHeight, int maxObstacleLength) {
        this.name = name;
        this.maxObstacleHeight = maxObstacleHeight;
        this.maxObstacleLength = maxObstacleLength;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int maxObstacleHeight() {
        return maxObstacleHeight;
    }

    @Override
    public int maxObstacleLength() {
        return maxObstacleLength;
    }
}
