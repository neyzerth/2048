import java.util.Scanner;
public class App {
    static Player player = new Player();

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        while(true){
            Text.clear();
            System.out.println(Table.logo);
            System.out.println(Color.bold("Welcome to the game of "+Color.cyan("2048")));
            System.out.println();

            System.out.println("Choose an option:");
            String [] menu = {
                Color.green("Play"),
            };
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i+1) +". " + menu[i]);
            }

            System.out.println();
            System.out.print("> ");

            switch (scan.nextLine()) {
                case "1":
                    Table test = new Table();
                    test.play();
                    break;
            
                default:
                    System.out.println("Invalid option...");
                    break;
            }
        }
    }
}
