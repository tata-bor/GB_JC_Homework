package lesson_1;

public class Course {
    String name;
    Obstacle [] obstacles;

    public Course(String name, Obstacle[] obstacles) {
        this.name = name;
        this.obstacles = obstacles;
    }
    public void doIt (Team team){
        for (int i = 0; i < obstacles.length; i ++) {
            for (int y = 0; y < team.athletes.length; y ++) {
                obstacles[i].doIt(team.athletes[y]);
            }
        }
    }
}
