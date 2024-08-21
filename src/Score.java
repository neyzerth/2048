import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Score {
    private int points;
    private int bestScore;
    private static String route = "scores.txt"; // Ruta del archivo
    
    public Score(){
        this.points = 0;
        this.bestScore = points;
    }
    
    
    public Score(int bestScore){
        this.points = 0;
        this.bestScore = bestScore;
    }

    public int points(){
        return this.points;
    }

    public void addScore(int points){
        this.points += points;
        bestScore = Math.max(this.points, bestScore);
    }

    public void setBestScore(int points){
        this.bestScore = points;
    }
    public int getBestScore(){
        return this.bestScore;
    }

    public static void newBestScore(Player p){
        try (PrintWriter writer = new PrintWriter(Score.route)) {
            writer.println(p.score.getBestScore() + " " + p.getName());
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static void newScore(Player p){
        try (PrintWriter writer = new PrintWriter(new FileWriter(Score.route, true))) {
            writer.println(p.score.getBestScore() + " " + p.getName());
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }


    public static String[] allBestScore() {
        String[] scoreData = new String[2];

        File file = new File(route);
        if (!file.exists()) {
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println("0 -");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo");
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scoreData = line.split(" ");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        return scoreData;
    }
    
}
