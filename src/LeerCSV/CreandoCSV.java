package LeerCSV;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CreandoCSV extends Thread{
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
    float restaSocialSupport;
    float restaHealthyLifeExpentacy;
    float restaFreedomToMakeLifeChoices;
    float restaGenerosity;
    float restaPerceptionsOfCorrupcion;
    String promedio;
    int rapidez;
    String ruta;

    // ESTABLECER LAS REGIONES
    public void setRuta(String ruta){
        this.ruta = ruta;
    }

    // OBTENER LAS REGIONES
    public String getRuta(){
        return this.ruta;
    }

    // ESTABLECER LAS REGIONES
    public void setPromedio(String promedio){
        this.promedio = promedio;
    }

    // OBTENER LAS REGIONES
    public String getPromedio(){
        return this.promedio;
    }

    // METODO RAPIDEZ
    public void setRapidez(int rapidez){
        this.rapidez = rapidez;
    }

    // OBTENIENDO VALOR DE RAPIDEZ
    public int getRapidez(){
        return this.rapidez;
    }

    // METODO RUN
    public void run(){
        // Linea que leera la ruta donde se encuentra el archivo
        Path filePath = Paths.get("/home/carlitos/Descargas/world-happiness-report-2021.csv");
        // Array de 1 elemento para validar si un pais pertenece a tal region.
        ArrayList<String> paises = new ArrayList<>();

        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;

            // Iteracion para iniciar la lectura del documento siempre y cuando el documento CSV exista.
            String[] datosDeLinea = new String[0];
            while ((linea = br.readLine()) != null) {
                datosDeLinea = linea.split(",");

                // Validar que la region del pais sea igual a la region anterior a la lista e imprima solo los datos solicitados del programa.
                for (int i = 0; i < 1; i++) {
                    if (datosDeLinea[1].equals("Regional indicator")) {
//                        System.out.println();
                    } else if (datosDeLinea[1].toLowerCase().equals(getPromedio().toLowerCase())) {
                        // CONVERTIR DE LA CADENA DE STRING A FLOAT
                        f = Float.parseFloat(datosDeLinea[7]);
                        g = Float.parseFloat(datosDeLinea[8]);
                        h = Float.parseFloat(datosDeLinea[9]);
                        k = Float.parseFloat(datosDeLinea[10]);
                        l = Float.parseFloat(datosDeLinea[11]);

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
//            Promedio(promedioSocialSupport, promedioHealthyLifeExpentacy, promedioFreedomToMakeLifeChoices, promedioGenerosity, promedioPerceptionsOfCorrupcion);
        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;

            // Iteracion para iniciar la lectura del documento siempre y cuando el documento CSV exista.
            String[] datosDeLinea = new String[0];
            while ((linea = br.readLine()) != null) {
                datosDeLinea = linea.split(",");

                // Validar que la region del pais sea igual a la region anterior a la lista e imprima solo los datos solicitados del programa.
                for (int i = 0; i < 1; i++) {
                    if (datosDeLinea[1].equals("Regional indicator")) {
//                        System.out.println();
                    } else if (datosDeLinea[1].toLowerCase().equals(getPromedio().toLowerCase())) {
                        // CONVERTIR DE LA CADENA DE STRING A FLOAT
                        f = Float.parseFloat(datosDeLinea[7]);
                        g = Float.parseFloat(datosDeLinea[8]);
                        h = Float.parseFloat(datosDeLinea[9]);
                        k = Float.parseFloat(datosDeLinea[10]);
                        l = Float.parseFloat(datosDeLinea[11]);
                    }
                }

                // CALCULAR LA RESTA FINAL DEL PROMEDIO
                if (datosDeLinea[1].equals("Regional indicator")) {
                    EscribirEncabezadoCSV("Country name", "Regional indicator", "Soocial Support", "Healthy Life Expentancy", "Freedom To Make Choices", "Generosity", "Perception Of Corruption", getRuta());
                } else if (datosDeLinea[1].toLowerCase().equals(getPromedio().toLowerCase())) {
                    restaSocialSupport = (f - promedioSocialSupport);
                    restaHealthyLifeExpentacy = (g - promedioHealthyLifeExpentacy);
                    restaFreedomToMakeLifeChoices = (h - promedioFreedomToMakeLifeChoices);
                    restaGenerosity = (k - promedioGenerosity);
                    restaPerceptionsOfCorrupcion = (l - promedioPerceptionsOfCorrupcion);

                    EscribirCSV(datosDeLinea[0], datosDeLinea[1], restaSocialSupport, restaHealthyLifeExpentacy, restaFreedomToMakeLifeChoices, restaGenerosity, restaPerceptionsOfCorrupcion, getRuta());
                    Thread.sleep(500);
                }
            }
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }


    public void Promedio(float promedioSocialSupport, float promedioHealthyLifeExpentacy, float promedioFreedomToMakeLifeChoices, float promedioGenerosity, float promedioPerceptionsOfCorrupcion){
        // Linea que leera la ruta donde se encuentra el archivo
        Path filePath = Paths.get("/home/carlitos/Descargas/world-happiness-report-2021.csv");
        // Array de 1 elemento para validar si un pais pertenece a tal region.
        ArrayList<String> paises = new ArrayList<>();
    }

    // METODO PARA ESCRIBIR EL ENCABEZADO AL INICIO DEL DOCUMENTO
    public void EscribirEncabezadoCSV(String paises, String regiones, String socialSupport, String healthyLifeExpentacy, String freedomToMakeLifeChoices, String generosity, String perceptionOfCorruption, String ruta){
        try{
            FileWriter fw = new FileWriter(ruta,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(paises + "," + regiones + "," + socialSupport + "," + healthyLifeExpentacy + "," + freedomToMakeLifeChoices + "," + generosity + "," + perceptionOfCorruption);
            pw.flush();
            pw.close();
        } catch (Exception e){

        }
    }

    // METODO PARA ESCRIBIR ARCHIVOS CSV
    public void EscribirCSV(String paises, String regiones, float socialSupport, float healthyLifeExpentacy, float freedomToMakeLifeChoices, float generosity, float perceptionOfCorruption, String ruta){
        try{
            FileWriter fw = new FileWriter(ruta,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(paises + "," + regiones + "," + socialSupport + "," + healthyLifeExpentacy + "," + freedomToMakeLifeChoices + "," + generosity + "," + perceptionOfCorruption);
            pw.flush();
            pw.close();
        } catch (Exception e){

        }
    }
}