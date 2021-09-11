package lesson_1;

import java.util.Random;

public class Obstacle {
    String name;
    int length;

    public Obstacle(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public void doIt (Athlete athlete) {
       Random random = new Random();
       boolean result = random.nextBoolean();

        System.out.println(athlete.name + " " + this.name + " - " + result + " - " + length);

        if (result) {
            athlete.distance += this.length;
        }
    }
}

