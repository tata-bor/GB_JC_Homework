package lesson_1;

public class Main {
    public static void main(String[] args) {
        Course course = new Course("123", new Obstacle[]{
                new Obstacle("obs1", 100),
                new Obstacle("obs2", 50),
                new Obstacle("obs3", 70)});

        Team team = new Team("Red Hats", new Athlete[] {
                new Athlete("Vasiliy"),
                new Athlete("Petr"),
                new Athlete("Ivan"),
                new Athlete("Valeriy")});

        course.doIt(team);
        team.print();
    }
}
