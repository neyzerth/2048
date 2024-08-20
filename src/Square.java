public class Square {
    private String color;
    //the times merged
    private int iterator;

    public Square(){
        //initialize the square (value is 2)
        this.iterator = 0;
        this.defColor();
    }


    public boolean merge(Square sq){
        //validate if its the same value
        if (sq == null || this.iterator != sq.iterator)
            return false;

        
        this.iterator++;
        Table.score += getValue();
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
