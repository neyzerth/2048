import java.util.Random;
import java.util.Scanner;

public class Table {
    private Square [][] rows = new Square[4][4];
    public int biggestValue;
    public Player p;
    public Player best;

    public static String logo =
        Color.blue( Color.bold(
            "\t ___   ___  _  _   ___  \n" + //
            "\t|__ \\ / _ \\| || | / _ \\ \n" + //
            "\t   ) | | | | || || (_) |\n" + //
            "\t  / /| | | |__   _> _ < \n" + //
            "\t / /_| |_| |  | || (_) |\n" + //
            "\t|____|\\___/   |_| \\___/\n "
        )
    );

    public Table(){
        // Generate 2 random squares
        randomSquare();
        randomSquare();
        String[] best = Score.allBestScore();
        this.p = new Player();
        this.best = new Player(best[1], Integer.parseInt(best[0]));
        biggestValue = 0;
    }
    
    // Constructor if you want to start with specific positions
    public Table(int... pos){
        int x,y;
        // Positions: 
        // 1  2  3  4 
        // 5  6  7  8 
        // 9  10 11 12 
        // 13 14 15 16
        for (int i : pos) {
            x = i <= 4 ? 0 : 
                i <= 8 ? 1 : 
                i <= 12 ? 2 : 
                i <= 16 ? 3 : -1;
            
            y = i - (x * 4) - 1;
            
            rows[x][y] = new Square();
        }
        
        String[] best = Score.allBestScore();
        this.p = new Player();
        this.best = new Player(best[1], Integer.parseInt(best[0]));
        biggestValue = 0;
    }
    
    @SuppressWarnings("resource")
    public void play(){
        Scanner scan = new Scanner(System.in);

        while (true) {
            Text.clear();
            System.out.println(Table.logo);
            System.out.println(Color.bold("Score : " + Color.green(p.score.points()+"")));
            System.out.println(Color.bold("Best Score : " + Color.green(best.score.getBestScore()+" ")) + Color.cyan("("+best.getName()+")"));
            System.out.println();

            print();
            System.out.print(Color.red(Color.bold("\n[Q] Quit: ")));
            System.out.print(Color.cyan(Color.bold("\n←[A] ↑[W] →[D] ↓[S]: ")));

            char opt = 0;
            try {
                opt = scan.nextLine().toLowerCase().charAt(0);
            } catch (Exception e) {}
            chooseMove(opt);

            if(opt  == 'q'){
                Text.clear();
                System.out.print (
                    Color.red(
                    "\nAre you sure you want to quit the game?")+
                        Color.bold("\nYES[y] NO[ANOTHER KEY]: "
                    )
                );

                if(scan.nextLine().toLowerCase().equals("y")) break;
            }
            
            if(this.biggestValue == 10){
                winnerScreen();
                break;
            }

        }
        if(best == p){
            System.out.println();
            System.out.println("New Best Score: " + best.score.points());
            System.out.print("Write your name: ");
            p.setName(scan.nextLine().replace(" ",""));
            Score.newBestScore(p);
        }

    }
    public void randomSquare(){
        Random rd = new Random();
        boolean empty;
        do {
            int i = rd.nextInt(4);
            int j = rd.nextInt(4);
            empty = this.rows[i][j] == null;

            if(!empty) continue; // Iterate again if the square isn't empty
            
            this.rows[i][j] = new Square();
        } while(!empty);
    }

    public void print(){
        String[] squareLn = {
            "+--------+",
            "|        |",
            "|        |",
            "|        |",
            "+--------+"
        };
        
        for (Square[] row : this.rows) {
            // For each line of squareLn
            // First, print each line with its color
            for (int i = 0; i < 5; i++) {
                for (Square sq : row) {

                    String color = sq == null ? "" : sq.getColor();
                    
                    String squarePart = "";

                    // Print the number in the middle of the square
                    if(i == 2 && sq != null)
                        squarePart = numFormat(sq.getValue());
                    else
                        squarePart = squareLn[i];
                        
                    System.out.print(Color.colorText(color, squarePart) + " ");
                }
                System.out.println();
            }
        }
    }

    public void chooseMove(char letter){
        // Save the previous move
        Square [][] old = new Square[4][4];
        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 4; j++)
                old[i][j] = this.rows[i][j]; 
        
        for (int i = 0; i < 4; i++) { // For each row
            switch (letter) {
                case 'a': moveLeft(i);
                    break;
                case 'w': moveUp(i);
                    break;
                case 'd': moveRight(i);
                    break;
                case 's': moveDown(i);
                    break;
            }
        }
        // Only spawn a random square if a different move was made
        if(!compareTable(old)) 
            randomSquare();
        
    }

    public void winnerScreen(){
        Text.clear();
        System.out.println(
            Color.green(Color.bold(
            "__          _______ _   _ _   _ ______ _____  _ _ \n" + //
            "\\ \\        / /_   _| \\ | | \\ | |  ____|  __ \\| | |\n" + //
            " \\ \\  /\\  / /  | | |  \\| |  \\| | |__  | |__) | | |\n" + //
            "  \\ \\/  \\/ /   | | | . ` | . ` |  __| |  _  /| | |\n" + //
            "   \\  /\\  /   _| |_| |\\  | |\\  | |____| | \\ \\|_|_|\n" + //
            "    \\/  \\/   |_____|_| \\_|_| \\_|______|_|  \\_(_|_)"
            ))
        );

        print();
        Text.waitEnter();
    }

    public Square [] move(Square [] row, int first){
        // The last position always has a difference of 4
        // Use the absolute value if negative to avoid errors in array positions

        int last = first + 4;

        for (int i = first; i < last; i++) {
            // Save the current square
            Square sq = row[Math.abs(i)];

            // If it's null, move to the next square
            if(sq == null) continue;

            int k = i; // Iterator for the next squares

            // Iterate until a non-null square is found or the end of the row is reached
            while(k > first && row[Math.abs(k-1)] == null)
                k--;

            // Make the previous position null
            row[Math.abs(i)] = null;

            // If not at the last position, try to merge with the next square
            // If the merge is unsuccessful, only update the new position
            if(!(k > first) || !sq.merge(row[Math.abs(k-1)])){
                row[Math.abs(k)] = sq;
                continue;
            }

            // If a merge is possible, "remove" the current position
            // and move the square to the next position
            row[Math.abs(k)] = null;
            row[Math.abs(k-1)] = sq;
            
            setBiggestValue(sq.getIterator());
            this.p.score.addScore(sq.getValue());
            bestScore();

        }

        return row;
    }
    
    public void moveLeft(int i){
        Square [] row = this.rows[i];
        // For moving left, the first position is 0
        move(row, 0);
    }

    public void moveRight(int i){
        Square [] row = this.rows[i];
        // For moving right, the first position is 3, so we need to
        // make the first position negative to avoid errors in loops
        move(row,-3);
    }
    

    public void moveUp(int i){
        Square [] row = new Square[4];
        // We need to convert the second dimension of the
        // rows array into a 1D array
        for (int j = 0; j < row.length; j++) 
            row[j] = this.rows[j][i];
        Square [] newColumn = move(row,0);

        for (int j = 0; j < row.length; j++)
            this.rows[j][i] = newColumn[j];
    }
    
    public void moveDown(int i){
        Square [] row = new Square[4];
        // We need to convert the second dimension of the
        // rows array into a 1D array
        for (int j = 0; j < row.length; j++) 
            row[j] = this.rows[j][i];
    
        Square [] newColumn = move(row,-3);
        
        for (int j = 0; j < row.length; j++)
            this.rows[j][i] = newColumn[j];
    }
    

    private boolean compareTable(Square[][] table){
        // Compare each value of a 2D array
        // with the corresponding rows of the table
        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 4; j++) 
                if (table[i][j] != this.rows[i][j])
                    return false;
        
        return true;
    }

    private String numFormat(int number){
        int numLen = String.valueOf(number).length();
        int first = numLen > 3 ? 2 : 3;
        int second = 5 - numLen;
        String row = "|"+ Text.spacing(first) + number + Text.spacing(second) + "|";

        return row;
    }

    private void setBiggestValue(int value){
        this.biggestValue = Math.max(value, biggestValue);
    }

    private void bestScore(){
        if(p.score.points() > best.score.getBestScore()){
            best = p;
            Score.newBestScore(p);
        }
    }

}
