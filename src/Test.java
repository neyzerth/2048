import java.io.PrintWriter;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        String ruta = "archivo.txt"; // Ruta del archivo
        String contenido = "Este es el contenido del archivo."; // Contenido a escribir en el archivo

        try (PrintWriter writer = new PrintWriter(ruta)) {
            writer.println(contenido);
            System.out.println("Archivo creado y contenido escrito con éxito.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
    }

    
}
