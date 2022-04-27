package Lesson1_2;

public class Robot implements Participant {
    private final String name;
    private boolean isActive = true;
    private final int maxObstacleHeight;
    private final int maxObstacleLength;

    public Robot(String name, int maxObstacleHeight, int maxObstacleLength) {
        this.name = name;
        this.maxObstacleHeight = maxObstacleHeight;
        this.maxObstacleLength = maxObstacleLength;
    }

    @Override
    public void highJump(Obstacle wall) {
        if (isActive) {
            isActive = (wall.size() <= maxObstacleHeight);
        }
        if (isActive) {
            System.out.println(name + " has jumped " + wall.size() + " sm high");
        } else {
            System.out.println(name + " has stopped");
        }
    }

    @Override
    public void longJump(Obstacle track) {
        if (isActive) {
            isActive = (track.size() <= maxObstacleLength);
        }
        if (isActive) {
            System.out.println(name + " has jumped " + track.size() + " sm in length");
        } else {
            System.out.println(name + " has stopped");
        }
    }
}
