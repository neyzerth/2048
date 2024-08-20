import java.util.Arrays;
import java.util.Random;

public class Table {
    private Square [][] rows = new Square[4][4];

    public Table(){
        //generate 2 random squares
        randomSquare();
        randomSquare();
    }

    public Table(int... pos){
        int x,y;

        for (int i : pos) {
            x = i <= 4 ? 0 : 
                i <= 8 ? 1 : 
                i <= 12 ? 2 : 
                i <= 16 ? 3 : -1;
                
            y = i - (x * 4) - 1;


            rows[x][y] = new Square();
        }
    }
    public void randomSquare(){
        Random rd = new Random();
        boolean empty;
        do {
            int i = rd.nextInt(4);
            int j = rd.nextInt(4);
            empty = this.rows[i][j] == null;

            if(!empty) continue; //iterate again if isn't empty
            
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

    public void moveRight(){
        Square [][] temp = new Square[4][4];
        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 4; j++)
                temp[i][j] = this.rows[i][j]; 

        for (int i = 0; i < 4; i++) {
            Square [] row = rows[i];

            for (int j = 3; j >= 0; j--) {
                //guarda el cuadro iterado
                Square sq = row[j];

                //si es null, no hace nada
                if(sq == null) continue;

    
                int k = j; //contador para recorrer los cuadros a su derecha
                //recorre hasta llegar a un cuadro no vacio
                while((k) < 3 && row[k+1] == null)
                    k++;

                
                //deja vacio la posicion anterior
                row[j] = null;

                //si no esta en la ultima posicion, intenta combinarse con el siguiente
            
                if(!(k < 3) || !sq.merge(row[k+1])){
                    row[k] = sq;
                    continue;
                }
                row[k] = null;
                row[k+1] = sq;
            
                                
            }

        }
        if(!compareTable(temp)) 
            randomSquare();
    }

    private boolean compareTable(Square[][] table){
        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 4; j++) 
                if (table[i][j] != this.rows[i][j])
                    return false;
            
        
        return true;
    }

    public void moveLeft(){
        Square [][] temp = new Square[4][4];
        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 4; j++)
                temp[i][j] = this.rows[i][j]; 

        for (int i = 0; i < 4; i++) {
            Square [] newRow = new Square[4];

            newRow = rows[i];
            for (int j = 0; j < 4; j++) {
                //guarda el cuadro iterado
                Square sq = rows[i][j];

                //si es null, no hace nada
                if(sq == null) continue;

    
                int k = j; //contador para recorrer los cuadros a su derecha
                //recorre hasta llegar a un cuadro no vacio
                while((k) > 0 && rows[i][k-1] == null)
                    k--;

                //deja vacio la posicion anterior
                newRow[j] = null;

                //si no esta en la ultima posicion, intenta combinarse con el siguiente
                if((k) > 0 && sq.merge(newRow[k-1])){
                    newRow[k] = null;
                    newRow[k-1] = sq;
                } else {
                    newRow[k] = sq;
                }
                                
                rows[i] = newRow;
            }

        }
        if(!Arrays.equals(this.rows, temp)) 
            randomSquare();

    }

    

    private String numFormat(int number){
        int numLong = String.valueOf(number).length();
        int first = numLong > 2 ? 2 : 3;
        int second = 5 - numLong;
        String row = "|"+ Text.spacing(first) + number + Text.spacing(second) + "|";


        return row;
    }
    
}
