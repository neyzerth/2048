public class App {
    public static void main(String[] args) throws Exception {
        Table test = new Table(4,8,1);
        
        
        while(true){
            Text.clear();
            test.print();
            test.moveRight();
            Text.waitEnter();
        }
    }
}
