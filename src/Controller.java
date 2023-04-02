import Model.Proceso;
import Model.txtReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Controller {
    private static ProcesController procesController = new ProcesController();
    private static UI ui = new UI();
    public static void main(String[] args) {
        ProcesController.printQueue();
        printProcesUsingUtil();
    }
    public static void printProcesUsingUtil(){
       PriorityQueue<Proceso> pq = new PriorityQueue<>(Collections.reverseOrder());
        txtReader txtreader = new txtReader("D:\\EstructuraDeDatosUVG\\HDT8\\src\\proceso.txt");
        ArrayList<Proceso> arr = txtreader.returnArrProceso();
        pq.addAll(arr);
        for (Proceso proceso: arr) {
            pq.add(proceso);
        }
        ui.print("Proceso en orden de ejecucion Usando PriorityQueue de java collection framework: ");
        while (!pq.isEmpty()){
            ui.print(pq.poll().toString());
            pq.remove();
        }
    }

}
