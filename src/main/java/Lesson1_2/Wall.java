package Lesson1_2;

public class Wall implements Obstacle{
    protected final int height;

    public Wall(int Height) {
        height = Height;
    }

    @Override
    public boolean overcoming(Participant participant) {
        if (height <= participant.maxObstacleHeight()) {
            System.out.println(participant.name() + " has jumped " + height + " sm high");
            return true;
        } else {
            System.out.println(participant.name() + " has stopped");
            return false;
        }
    }
}
