import Model.PriorityQueueWithHeap;
import Model.Proceso;
import Model.txtReader;

import java.util.ArrayList;

public class ProcesController {

    private static long startTime; // Nuevo campo para el tiempo de inicio del programa

    private static PriorityQueueWithHeap<Integer,Proceso> pq = new PriorityQueueWithHeap<>();
    private static UI ui = new UI();

    /**
     * Inicializar startTime en el momento de la creación del objeto Controller
     */
    public ProcesController() {
        startTime = System.currentTimeMillis();
    }

    /**
     * orden de ejecucion usando PriorityQueue con Heap
     *
     * ¡¡¡¡Al descargar el archivo txt, se debe de escribir la direccion exacta del
     * archivo donde se descargó para el funcionamiento del programa!!!!
     */
    public static void printQueue(){
        txtReader txtreader = new txtReader("D:\\EstructuraDeDatosUVG\\HDT8\\src\\proceso.txt");
        ArrayList<Proceso> arr = txtreader.returnArrProceso();
        for (Proceso proceso: arr) {
            pq.Insert(proceso.getPR(),proceso);
        }
        ui.print("Proceso en orden de ejecución usando PriorityQueue con Heap: ");
        while (!pq.isEmpty()){
            ui.print(pq.get().toString()+" time: "+ String.valueOf(tiempoTranscurrido()));
            pq.remove();
        }
    }

    /**
     * Método para calcular el tiempo transcurrido desde el inicio del programa
     * @return retorna la diferencia entre el momento actual del sistema y el valor de la variable startTime
     */
    private static long tiempoTranscurrido() {
        return System.currentTimeMillis() - startTime;
    }
}
