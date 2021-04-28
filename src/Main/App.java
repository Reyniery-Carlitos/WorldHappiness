package Main;

import LeerCSV.*;

public class App {
    public static void main(String[] args){
        LeerCSV archivo = new LeerCSV();
        archivo.Leer();

        // Si desea ver la informacion general de todas las regiones solamente debera escribir "TODAS"
        Region region1 = new Region();
        region1.PromedioRegion("SOUTHEAST ASIA");

        // CREANDO LOS OBJETOS PARA MANDAR A IMPRIMIR
        CreandoCSV csv1 = new CreandoCSV();
        CreandoCSV csv2 = new CreandoCSV();
        CreandoCSV csv3 = new CreandoCSV();
        CreandoCSV csv4 = new CreandoCSV();
        CreandoCSV csv5 = new CreandoCSV();
        CreandoCSV csv6 = new CreandoCSV();
        CreandoCSV csv7 = new CreandoCSV();
        CreandoCSV csv8 = new CreandoCSV();
        CreandoCSV csv9 = new CreandoCSV();
        CreandoCSV csv10 = new CreandoCSV();

        // ESTABLECIENDO LAS REGIONES
        csv1.setPromedio("Western europe");
        csv2.setPromedio("SUB-SAHARAN AFRICA");
        csv3.setPromedio("LATIN AMERICA AND CARIBBEAN");
        csv4.setPromedio("MIDDLE EAST AND NORTH AFRICA");
        csv5.setPromedio("SOUTH ASIA");
        csv6.setPromedio("SOUTHEAST ASIA");
        csv7.setPromedio("COMMONWEALTH OF INDEPENDENT STATES");
        csv8.setPromedio("CENTRAL AND EASTERN EUROPE");
        csv9.setPromedio("EAST ASIA");
        csv10.setPromedio("NORTH AMERICA AND ANZ");

        // ESTABLECIENDO LAS REGIONES
        csv1.setRuta("/home/carlitos/Descargas/ArchivosCSV/WesternEurope.csv");
        csv2.setRuta("/home/carlitos/Descargas/ArchivosCSV/Sub-SaharanAfrica.csv");
        csv3.setRuta("/home/carlitos/Descargas/ArchivosCSV/LatinAmericaAndCaribbean.csv");
        csv4.setRuta("/home/carlitos/Descargas/ArchivosCSV/MiddleEastAndNorthAfrica.csv");
        csv5.setRuta("/home/carlitos/Descargas/ArchivosCSV/SouthAsia.csv");
        csv6.setRuta("/home/carlitos/Descargas/ArchivosCSV/SoutheastAsia.csv");
        csv7.setRuta("/home/carlitos/Descargas/ArchivosCSV/CommonwealthOfIndependentStates.csv");
        csv8.setRuta("/home/carlitos/Descargas/ArchivosCSV/CentralAndEasternEurope.csv");
        csv9.setRuta("/home/carlitos/Descargas/ArchivosCSV/EastAsia.csv");
        csv10.setRuta("/home/carlitos/Descargas/ArchivosCSV/NorthAmericaAndANZ.csv");

        // ESTABLECIENDOLE RAPIDEZ DE IMPRESION
        csv1.setRapidez(500);
        csv2.setRapidez(1000);
        csv3.setRapidez(500);
        csv4.setRapidez(1000);
        csv5.setRapidez(500);
        csv6.setRapidez(1000);
        csv7.setRapidez(500);
        csv8.setRapidez(1000);
        csv9.setRapidez(500);
        csv10.setRapidez(1000);

        // INICIANDO LA EJECUCION
        csv1.start();
        csv2.start();
        csv3.start();
        csv4.start();
        csv5.start();
        csv6.start();
        csv7.start();
        csv8.start();
        csv9.start();
        csv10.start();
    }
}
