public class Square {
    private String color;
    private int iterator;

    public Square(){
        this.iterator = 0;
        this.defColor();
    }

    public boolean merge(Square sq){
        if (sq == null || this.iterator != sq.iterator)
            return false;

        this.iterator++;
        this.defColor();
        sq.setIterator(0);
        return true;
    }

    private void defColor(){
        String [] color = {
            "",
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
        this.color = color[iterator];
    }

    public String getColor(){
        return this.color;
    }

    public int getIterator(){
        return this.iterator;
    }

    public int getValue(){
        return (int) Math.pow(2, iterator);
    }

    public void  setIterator(int iterator){
        this.iterator = iterator;
        this.defColor();
    }


    
}
