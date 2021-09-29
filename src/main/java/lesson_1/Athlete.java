package lesson_1;

public class Athlete {
    public String name;
    public int distance;

    public Athlete(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void print () {
        System.out.println(name + " : " + distance);
    }
}
