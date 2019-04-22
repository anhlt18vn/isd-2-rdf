package insight.dev.noaa2rdf;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * insight.dev.noaa2rdf
 * <p>
 * TODO: Add class description
 * <p>
 * Author:  Anh Le-Tuan
 * <p>
 * Email:   anh.letuan@insight-centre.org
 * <p>
 * Date:  10/06/18.
 */
public class Observation2RDF {

    private static String outPath;



    public static void main(String[] args) {
//    //String path     = args[0];
//    //       outPath  = args[1];
//    String path = "/home/anhlt185/2017/";
    outPath     = "/home/anh/Desktop/";
//
//    File folder = new File(path);
//    File[] files = folder.listFiles();
//
//    ExecutorService pool = Executors.newFixedThreadPool(8);
//
//
//    int i = 0;
//    for (File file:files)
//    {
//      //pool.execute(() -> Observation2RDF.observation2RDF(file));
//
//      Observation2RDF.observation2RDF(file);
//
//      i++;
//      if (i==100) break;
//    }

        File file = new File("/home/anh/Desktop/010010-99999-2018");
        Observation2RDF.observation2RDF(file);
    }



    public static void observation2RDF(File file) {

        Model model = ModelFactory.createDefaultModel();
        Observation observation = new Observation();
        String string;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            string = bufferedReader.readLine();
            while (string != null) {
                observation = readObservation(string);
                model = observation.createModel(model);
                string = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model = observation.getStation().createModel(model);


        File fileOut = new File(outPath + file.getName() + ".nt");
        try {
            PrintStream printStream = new PrintStream(fileOut);
            model.write(printStream, "N-Triples");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




    public static Observation readObservation(String string) {
        Observation observation = new Observation();
        String stationId = string.substring(4, 10);
        observation.setStationId(stationId);

        String date = string.substring(15, 23); //YYYYMMDD
        observation.setDate(date);

        String time = string.substring(23, 27); //HHMMM
        observation.setTime(time);

        String lon = string.substring(28, 34);
        observation.setLon(lon);

        String lat = string.substring(34, 41);
        observation.setLat(lat);

        String windDirection = string.substring(61, 63);
        observation.setWndDirect(windDirection);

        String windSpeed = string.substring(66, 69);
        observation.setWndSpeed(windSpeed);

        String skyCeiling = string.substring(70, 75);
        observation.setSkyCeiling(skyCeiling);

        String visibilityDistance = string.substring(79, 84);
        observation.setVisDistance(visibilityDistance);

        String temp = string.substring(87, 92);
        observation.setTemp(temp);

        String pressure = string.substring(99, 104);
        observation.setPressure(pressure);

        return observation;
    }


//  public static void observation2RDF(File file){
//    try{
//      Reader in = new FileReader(file);
//
//      Iterable<CSVRecord> csvRecords = CSVFormat.EXCEL.parse(in);
//
//      int observationId = 0;
//
//      System.out.println("File " + file.getName() + " is being processed");
//
//      for (CSVRecord csvRecord:csvRecords){
//        if (observationId == 0) { observationId ++; continue;}
//
//        observationId++;
//
//        Observation observation = new Observation();
//        observation.setObservationId(observationId);
//
//        String stationId = csvRecord.get(0);
//        observation.setStationId(stationId);
//        System.out.println(stationId);
//
//
//        String dateTime = csvRecord.get(1);
//        observation.setDateTime(dateTime);
//
//        String wnd = csvRecord.get(10);
//        observation.setWND(wnd);
//
//        String cig = csvRecord.get(11);
//        observation.setCIG(cig);
//
//        String vis = csvRecord.get(12);
//        observation.setVIS(vis);
//
//        String tmp = csvRecord.get(12);
//        observation.setTMP(tmp);
//
//        String dew = csvRecord.get(13);
//        observation.setDEW(dew);
//
//        String spl = csvRecord.get(14);
//        observation.setSPL(spl);
//
//        File folder  = new File(outPath + "/" + stationId.substring(0,2) + "/" + stationId + "/");
//        if (!folder.isDirectory()) folder.mkdirs();
//
//        File fileOut = new File(outPath + "/" + stationId.substring( 0, 2) + "/" + stationId + "/" + stationId+ "_" + observationId + ".nt");
//        PrintStream printStream = new PrintStream(fileOut);
//
//        printStream.close();
//      }
//    }
//    catch (IOException e)
//    {
//      e.printStackTrace();
//    }
//  }
}
