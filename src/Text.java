import java.io.IOException;
import java.util.Scanner;

public class Text {
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (System.getProperty("os.name").contains("Linux")) {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println();
            System.out.println(Color.red(" Error al limpiar la consola: " + ex.getMessage()));
        }
    }

    // iterando n espacios
    public static String spacing(int n) {
        String space = "";
        for (int i = 0; i < n; i++) {
            space += " ";
        }
        return space;
    }

    public static void waitEnter(String msg) {
        @SuppressWarnings("resource")
        Scanner enter = new Scanner(System.in);
        System.out.print(msg);
        System.out.print(Color.invisible);
        enter.nextLine();
        System.out.print(Color.reset);
    }

    public static void waitEnter(){
        waitEnter(Color.purple("\n Enter para continuar..."));
    }

    public static void waitTime(double sec) {
        int time = (int) (sec * 1000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
