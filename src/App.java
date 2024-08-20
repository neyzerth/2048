import java.util.Scanner;

public class App {
    public static void imprimirNumeros(int a, int b) {

        a = a > b ? -a : a;
        for (int i = a; i <= b; i++) {
            System.out.println(Math.abs(i));
        }
    }
    public static void main(String[] args) throws Exception {
        Table test = new Table(4,8,1);
        Scanner scan = new Scanner(System.in);
        
        
        while(true){
            Text.clear();
            test.print();
            System.out.print(Color.cyan(Color.bold("\n←[A] ↑[W] →[D] ↓[S]: ")));
            test.chooseMove(scan.next().toLowerCase().charAt(0));
            //Text.waitEnter();
        }
    }
}
