public class Player {
    private String name;
    public Score score;

    public Player(){
        this.name = "You";
        this.score = new Score();
    }

    public Player(String name){
        this();
        this.name = name;
    }

    public Player(String name, int score){
        this(name);
        this.score = new Score();
        this.score.setBestScore(score);
    }



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Score score) {
        this.score = score;
    }



    
}
