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

    public void chooseMove(char letter){
        Square [][] temp = new Square[4][4];
        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 4; j++)
                temp[i][j] = this.rows[i][j]; 
        
        for (int i = 0; i < 4; i++) {
                switch (letter) {
                    case 'a': moveLeft(i);
                        break;
                    case 'w': moveUp(i);
                        break;
                    case 'd': moveRight(i);
                        break;
                    case 's': moveDown(i);
                        break;
                
                    default:
                        break;
                }
        }

        if(!compareTable(temp)) 
        randomSquare();

    }

    public Square [] move(Square [] row, int first){
        int last = first + 4;

        for (int i = first; i < last; i++) {
            //guarda el cuadro iterado
            Square sq = row[Math.abs(i)];

            //si es null, no hace nada
            if(sq == null) continue;


            int k = i; //contador para recorrer los cuadros a su derecha
            //recorre hasta llegar a un cuadro no vacio
            while(k > first && row[Math.abs(k-1)] == null)
                k--;

            
            //deja vacio la posicion anterior
            row[Math.abs(i)] = null;

            //si no esta en la ultima posicion, intenta combinarse con el siguiente
        
            if(!(k > first) || !sq.merge(row[Math.abs(k-1)])){
                row[Math.abs(k)] = sq;
                continue;
            }
            row[Math.abs(k)] = null;
            row[Math.abs(k-1)] = sq;
        }
        return row;

    }

    public void moveRight(int i){
        Square [] row = this.rows[i];
        move(row,-3);
    }
    
    public void moveLeft(int i){
        Square [] row = this.rows[i];
        move(row, 0);
    }

    public void moveUp(int i){
        Square [] row = new Square[4];
        for (int j = 0; j < row.length; j++) 
            row[j] = this.rows[j][i];
        Square [] newColum = move(row,0);

        for (int j = 0; j < row.length; j++)
            this.rows[j][i] = newColum[j];
    }
    
    public void moveDown(int i){
        Square [] row = new Square[4];
        for (int j = 0; j < row.length; j++) 
            row[j] = this.rows[j][i];
    
        Square [] newColum = move(row,-3);
        
        for (int j = 0; j < row.length; j++)
            this.rows[j][i] = newColum[j];
    }
    

    private boolean compareTable(Square[][] table){
        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 4; j++) 
                if (table[i][j] != this.rows[i][j])
                    return false;
            
        
        return true;
    }


    

    

    private String numFormat(int number){
        int numLong = String.valueOf(number).length();
        int first = numLong > 2 ? 2 : 3;
        int second = 5 - numLong;
        String row = "|"+ Text.spacing(first) + number + Text.spacing(second) + "|";


        return row;
    }
    
}
