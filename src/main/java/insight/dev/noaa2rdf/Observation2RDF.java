//package insight.dev.noaa2rdf;
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVRecord;
//
//import java.io.*;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * insight.dev.noaa2rdf
// * <p>
// * TODO: Add class description
// * <p>
// * Author:  Anh Le-Tuan
// * <p>
// * Email:   anh.letuan@insight-centre.org
// * <p>
// * Date:  10/06/18.
// */
//public class Observation2RDF {
//
//  private static String outPath;
//
//  public static void main(String[] args){
//    //String path     = args[0];
//    //       outPath  = args[1];
//    String path = "/home/anhlt185/2017/";
//    outPath     = "/home/anhlt185/noaa/";
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
//  }
//
//
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
//        observation.serialiseToNTriples(printStream);
//
//        printStream.close();
//      }
//    }
//    catch (IOException e)
//    {
//      e.printStackTrace();
//    }
//  }
//}
