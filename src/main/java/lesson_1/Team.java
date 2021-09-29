package lesson_1;

public class Team {
    String teamName;
    Athlete [] athletes;


    public Team(String teamName, Athlete[] athletes) {
        this.teamName = teamName;
        this.athletes = athletes;
        };

    public void print () {
        System.out.println("Team " + teamName);
        for (int k =0; k < athletes.length; k++) {
            athletes[k].print();
        }
    }
}
