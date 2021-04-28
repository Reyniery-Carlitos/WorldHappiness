package LeerCSV;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Region{
    ArrayList<String> paises = new ArrayList<>();
    float f;
    float g;
    float h;
    float k;
    float l;
    float sumaSocialSupport;
    float sumaHealthyLifeExpentacy;
    float sumaFreedomToMakeLifeChoices;
    float sumaGenerosity;
    float sumaPerceptionsOfCorrupcion;
    float promedioSocialSupport;
    float promedioHealthyLifeExpentacy;
    float promedioFreedomToMakeLifeChoices;
    float promedioGenerosity;
    float promedioPerceptionsOfCorrupcion;
    float mayorCorrupcion;
    float mayorGenerosidad;
    String paisMasGenerosidad;
    String paisMasCorrupcion;
    String todo = "todas";
    String country = "Regional indicator";

    // LEER REGION PARA CALCULAR INFORMACION DEL PROMEDIO DE LA REGION
    public void PromedioRegion(String promedio){
        // Linea que leera la ruta donde se encuentra el archivo
        Path filePath = Paths.get("/home/carlitos/Descargas/world-happiness-report-2021.csv");

        try{
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;

            // Iteracion para iniciar la lectura del documento siempre y cuando el documento CSV exista.
            while ((linea = br.readLine()) != null){
                String[] datosDeLinea = linea.split(",");

                // Validar que la region del pais sea igual a la region anterior a la lista e imprima solo los datos solicitados del programa.
                for (int i = 0; i < 1; i++) {
                    if (datosDeLinea[1].equals(country)) {
                        System.out.println(" ");
                    } else if (datosDeLinea[1].toLowerCase().equals(promedio.toLowerCase()) || promedio.toLowerCase().equals(todo)) {
                        // CONVERTIR DE LA CADENA DE STRING A FLOAT
                        f = Float.parseFloat(datosDeLinea[7]);
                        g = Float.parseFloat(datosDeLinea[8]);
                        h = Float.parseFloat(datosDeLinea[9]);
                        k = Float.parseFloat(datosDeLinea[10]); // Generosidad
                        l = Float.parseFloat(datosDeLinea[11]); // Corrupcion

                        // CALCULANDO EL PAIS CON MAYOR GENEROSIDAD
                        if (k >= mayorGenerosidad) {
                            mayorGenerosidad = k;
                            paisMasGenerosidad = datosDeLinea[0];
                        }

                        // CALCULANDO EL PAIS CON MAYOR INDICE DE CORRUPCION
                        if (l >= mayorCorrupcion) {
                            mayorCorrupcion = l;
                            paisMasCorrupcion = datosDeLinea[0];
                        }

                        // SUMAR LOS VALORES DE CADA PAIS PERTENECIENTE A LA REGION
                        sumaSocialSupport += f;
                        sumaHealthyLifeExpentacy += g;
                        sumaFreedomToMakeLifeChoices += h;
                        sumaGenerosity += k;
                        sumaPerceptionsOfCorrupcion += l;
                        paises.add(datosDeLinea[0]);

                        // CALCULAR EL PROMEDIO
                        promedioSocialSupport = (sumaSocialSupport / paises.size());
                        promedioHealthyLifeExpentacy = (sumaHealthyLifeExpentacy / paises.size());
                        promedioFreedomToMakeLifeChoices = (sumaFreedomToMakeLifeChoices / paises.size());
                        promedioGenerosity = (sumaGenerosity / paises.size());
                        promedioPerceptionsOfCorrupcion = (sumaPerceptionsOfCorrupcion / paises.size());
                    }
                }
            }

            // IMPRIMIR LOS DATOS FINALES DEL PROMEDIO
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t ================> INFORMACION: " + promedio.toUpperCase() + " <================");
            System.out.println("\t\t\t\t =====================================================> PROMEDIO <=====================================================");
            System.out.println("Promedio Social Support | Promedio Healthy Life Expentacy | Promedio Freedom To Make Life Choices | Promedio Generosity | Promedio Perception Of Corruption");
            System.out.println(promedioSocialSupport + "\t\t\t\t\t | " + promedioHealthyLifeExpentacy + "\t\t\t\t\t\t | " + promedioFreedomToMakeLifeChoices + "\t\t\t\t\t\t | " + promedioGenerosity + "\t\t\t\t\t\t | " + promedioPerceptionsOfCorrupcion);

            // IMPRIMIR EL PAIS CON MAS GENEROSIDAD Y MAS PERCEPCION DE CORRUPCION
            System.out.println("\t\t\t\t\t\t\t\t\t\t ====================================================================");
            System.out.println("\t\t\t\t\t\t\t\t\t\t PAIS CON MAYOR INDICE DE GENEROSIDAD: " + paisMasGenerosidad + " INDICE: " + mayorGenerosidad);
            System.out.println("\t\t\t\t\t\t\t\t\t\t PAIS CON MAYOR INDICE DE PERCEPCION DE CORRUPCION: " + paisMasCorrupcion + " INDICE: " + mayorCorrupcion);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}