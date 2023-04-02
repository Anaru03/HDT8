package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Controller {

    private long startTime; // Nuevo campo para el tiempo de inicio del programa

    public Controller() {
        startTime = System.currentTimeMillis(); // Inicializar startTime en el momento de la creación del objeto Controller
    }

    public static void main(String[] args) {
        Controller controller = new Controller(); // Crear un objeto Controller
        PriorityQueue<Proceso> procesos = new PriorityQueue<>();

        try {
            File file = new File("src\\proceso.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] linea = scanner.nextLine().split(",");

                Proceso proceso = new Proceso(linea[0], linea[1], Integer.parseInt(linea[2]));

                procesos.offer(proceso);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado.");
            e.printStackTrace();
        }

        while (!procesos.isEmpty()) {
            Proceso proceso = procesos.poll();
            System.out.println(proceso.toString() + " - Tiempo transcurrido: " + controller.tiempoTranscurrido() + " ms");
        }
    }

    // Nuevo método para calcular el tiempo transcurrido desde el inicio del programa
    private long tiempoTranscurrido() {
        return System.currentTimeMillis() - startTime;
    }
}
