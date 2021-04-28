package LeerCSV;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class LeerCSV{
    public void Leer(){
        // Linea que leera la ruta donde se encuentra el archivo
        Path filePath = Paths.get("/home/carlitos/Descargas/world-happiness-report-2021.csv");
        // Array de 1 elemento para validar si un pais pertenece a tal region.
        String[] region = new String[1];

        try{
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;

            // Iteracion para iniciar la lectura del documento siempre y cuando el documento CSV exista.
            while ((linea = br.readLine()) != null){
                String[] datosDeLinea = linea.split(",");

                // Validar que la region del pais sea igual a la region anterior a la lista e imprima solo los datos solicitados del programa.
                for (int i = 0; i < 1; i++){
                    if (datosDeLinea[1].equals(region[0])){
                        System.out.println(datosDeLinea[0] + " | " + datosDeLinea[7] + " | " + datosDeLinea[8] + " | " + datosDeLinea[9] + " | " + datosDeLinea[10] + " | " + datosDeLinea[11] + " | " + "\n");
                        region[0] = datosDeLinea[1];
                    } else if (datosDeLinea[1].equals("Regional indicator")){
                        System.out.println(datosDeLinea[0] + " | " + datosDeLinea[7] + " | " + datosDeLinea[8] + " | " + datosDeLinea[9] + " | " + datosDeLinea[10] + " | " + datosDeLinea[11] + " | " + " \n");
                        region[0] = datosDeLinea[1];
                    } else {
                        System.out.println("-----> REGION: " + datosDeLinea[1].toUpperCase());
                        System.out.println(datosDeLinea[0] + " | " + datosDeLinea[7] + " | " + datosDeLinea[8] + " | " + datosDeLinea[9] + " | " + datosDeLinea[10] + " | " + datosDeLinea[11] + " | " + "\n");
                        region[0] = datosDeLinea[1];
                        break;
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
