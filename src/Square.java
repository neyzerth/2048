import java.util.Random;

public class Square {
    private String color;
    //the times merged
    private int iterator;

    public Square(){
        Random rd = new Random();
        //2% chance that the square is initialized with 4(1) instead of 2(0)
        int probability = rd.nextInt(100);
        int value = probability < 2 ? 1 : 0;

        this.iterator = value;
        defColor();
    }

    public Square(int iterator){
        //initialize the square (value is 2)
        this.iterator = iterator;
        this.defColor();
    }

    public Square(Square sq){
        if(sq == null) return; 
        
        this.iterator = sq.getIterator();
        this.defColor();
    }

    public boolean merge(Square sq){
        //validate if its the same value
        if (sq == null || this.iterator != sq.iterator)
            return false;

        
        this.iterator++;
        this.defColor();

        //"kill" the second square merged
        sq = null;
        return true;
    }

    private void defColor(){
        //the 10 colors that  can be used
        String [] color = {
            Color.greenBackground,
            Color.blueBackground,
            Color.redBackground,
            Color.yellowBackground,
            Color.purpleBackground,
            Color.cyanBackground,
            Color.brightBlueBackground,
            Color.brightRedBackground,
            Color.brightYellowBackground,
            Color.brightPurpleBackground,
            Color.brightCyanBackground,
        };
        //return depends on the iteration
        this.color = color[iterator];
    }

    public String getColor(){
        return this.color;
    }

    public int getIterator(){
        return this.iterator;
    }

    public int getValue(){
        // 2, 4, 8, 16, 32, 64... 2048
        // 1, 2, 3, 4,  5,  6 ... 11
        return (int) Math.pow(2, iterator+1);
    }

    public void  setIterator(int iterator){
        this.iterator = iterator;

        //after change the iterator, def color again
        this.defColor();
    }


    
}
