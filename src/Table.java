import java.util.Random;

public class Table {
    private Square [][] rows = new Square[4][4];

    public Table(){
        randomSquare();
        randomSquare();
    }

    public void randomSquare(){
        Random rd = new Random();
        boolean empty;
        do {
            int r1 = rd.nextInt(4);
            int r2 = rd.nextInt(4);
            empty = this.rows[r1][r2] == null;

            if(!empty)
                continue;
            
            this.rows[r1][r2] = new Square();
            this.rows[r1][r2].setIterator(1);;
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

            for (int i = 0; i < 5; i++) {
                for (Square sq : row) {

                    String color = sq == null ? "" : sq.getColor();
                    String squarePart = "";

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

    private String numFormat(int number){
        int numLong = String.valueOf(number).length();
        int second = 5 - numLong;
        int first = numLong > 2 ? 2 : 3;
        String row = "|"+ Text.spacing(first) + number + Text.spacing(second) + "|";


        return row;
    }
    
}
