import Model.Proceso;
import Model.txtReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class Controller {
    private static ProcesController procesController = new ProcesController();

    private static UI ui = new UI();

    /**
     * @param args main
     */
    public static void main(String[] args) {
        ProcesController.printQueue();
        printProcesUsingUtil();
    }

    /**
     * Orden de ejecucion usando PriorityQueue de java collection framework
     *
     *¡¡¡¡Al descargar el archivo txt, se debe de escribir la direccion exacta del
     * archivo donde se descargó para el funcionamiento del programa!!!!
     */
    public static void printProcesUsingUtil(){
       PriorityQueue<Proceso> pq = new PriorityQueue<>(Collections.reverseOrder());
        txtReader txtreader = new txtReader("D:\\EstructuraDeDatosUVG\\HDT8\\src\\proceso.txt");
        ArrayList<Proceso> arr = txtreader.returnArrProceso();
        pq.addAll(arr);
        for (Proceso proceso: arr) {
            pq.add(proceso);
        }
        ui.print("Proceso en orden de ejecución usando PriorityQueue de java collection framework: ");
        while (!pq.isEmpty()){
            ui.print(pq.poll().toString());
            pq.remove();
        }
    }
}
