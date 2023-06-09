package Model;
// Código extraído de: https://github.com/DiegovalExe/DiccionarioArbolesBinarios/blob/master/src/model/txtReader.java

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Lector de archivos de texto con información de procesos
 */
public class txtReader {

    public String fileUrl;
    public ArrayList<Proceso> proceso = new ArrayList<>();

    /**
     * @param path ruta del archivo de texto
     */
    public txtReader(String path){
        this.fileUrl = path;
    }

    /**
     *¡¡¡¡Al descargar el archivo txt, se debe de escribir la direccion exacta del
     * archivo donde se descargó para el funcionamiento del programa!!!!
     */
    public txtReader(){
        this.fileUrl = "C:\\JAVAUVG\\HDT8\\src\\proceso.txt";
    }

    /**
     * @return regresa un ArrayList
     */
    public ArrayList<Proceso> returnArrProceso(){
        try{
            File myObj = new File(fileUrl);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] line = myReader.nextLine().split(",");
                proceso.add(new Proceso(line[0].trim(), line[1].trim(), Integer.parseInt(line[2].trim())));
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return proceso;
    }
}
