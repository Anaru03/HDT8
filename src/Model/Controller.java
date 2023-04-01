package Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {

        PriorityQueue<Proceso> procesos = new PriorityQueue<>();

        try {
            File file = new File("src\\proceso.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] linea = scanner.nextLine().split(",");

                Proceso proceso = new Proceso(linea[0], linea[1], Integer.parseInt(linea[2]));

                procesos.offer(proceso);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
