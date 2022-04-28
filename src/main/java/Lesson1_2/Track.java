package Lesson1_2;

public class Track implements Obstacle{
    protected final int length;

    public Track(int Length) {
        length = Length;
    }

    @Override
    public boolean overcoming(Participant participant) {
        if (length <= participant.maxObstacleLength()) {
            System.out.println(participant.name() + " has run " + length + " m");
            return true;
        } else {
            System.out.println(participant.name() + " has stopped");
            return false;
        }
    }
}
