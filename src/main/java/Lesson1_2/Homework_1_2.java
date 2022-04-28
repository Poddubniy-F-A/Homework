package Lesson1_2;

public class Homework_1_2 {
    public static void main(String[] args) {
        Participant[] participants = new Participant[6];
        participants[0] = new Human("Alex", 70, 160);
        participants[1] = new Human("Bob", 75, 175);
        participants[2] = new Cat("Barsik", 40, 110);
        participants[3] = new Cat("Murzik", 45, 130);
        participants[4] = new Robot("T-800", 90, 180);
        participants[5] = new Robot("T-1000", 100, 200);
        Obstacle[] obstacles = new Obstacle[6];
        obstacles[0] = new Wall(40);
        obstacles[1] = new Track(120);
        obstacles[2] = new Wall(70);
        obstacles[3] = new Track(170);
        obstacles[4] = new Wall(80);
        obstacles[5] = new Track(190);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(!obstacles[j].overcoming(participants[i])) {
                    break;
                }
            }
            System.out.println();
        }
    }
}
