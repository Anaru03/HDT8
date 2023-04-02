import Model.PriorityQueueWithHeap;
import Model.Proceso;
import Model.txtReader;

import java.util.ArrayList;

public class ProcesController {
    private static long startTime; // Nuevo campo para el tiempo de inicio del programa
    private static PriorityQueueWithHeap<Integer,Proceso> pq = new PriorityQueueWithHeap<>();
    private static UI ui = new UI();
    public ProcesController() {
        startTime = System.currentTimeMillis(); // Inicializar startTime en el momento de la creación del objeto Controller
    }

    public static void printQueue(){
        txtReader txtreader = new txtReader("D:\\EstructuraDeDatosUVG\\HDT8\\src\\proceso.txt");
        ArrayList<Proceso> arr = txtreader.returnArrProceso();
        for (Proceso proceso: arr) {
            pq.Insert(proceso.getPR(),proceso);
        }
        ui.print("Proceso en orden de ejecucion: ");
        for (Proceso proceso : arr){
            ui.print(pq.get().toString()+" time: "+ String.valueOf(tiempoTranscurrido()));
            pq.remove();
        }


    }
    // Nuevo método para calcular el tiempo transcurrido desde el inicio del programa
    private static long tiempoTranscurrido() {
        return System.currentTimeMillis() - startTime;
    }
}
