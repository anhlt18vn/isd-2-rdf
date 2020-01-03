package insight.dev.noaa2rdf;

import insight.dev.noaa2rdf.classes.Observation;
import insight.dev.noaa2rdf.classes.Station;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.*;
import java.util.HashMap;

/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 1/3/20
 * PROJECT: noaa-2-rdf
 */
public class NOAA2RDF {
    //public static String HOME = System.getProperty("user.home") + "/";
    private static HashMap<String, Station> stationHashMap;

    public static void main(String[] args){
        NOAA2RDF.stationHashMap = new HashMap<>();

        //convert station
        String path2stationInputFile = args[0] + "isd-history.csv";
        String path2stationOutputFolder = args[0] + "stations/";
        station2RDF(path2stationInputFile, path2stationOutputFolder);

        //convert observation
        File rawDataFolder = new File(args[0] + "rawdata/");
        for (File file:rawDataFolder.listFiles()){
            observation2RDF(file, args[0] + "observation");
        }
    }

    public static void observation2RDF(File fileInput, String outputFolder){

        try {
            Observation observation = null;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInput));
            String observationAsString = bufferedReader.readLine();

            while (observationAsString != null){
                observation = Observation.readObservationFrom(observationAsString, NOAA2RDF.stationHashMap);
                observation.writeToFile(outputFolder + "/" + fileInput.getName() + "/");
                observationAsString = bufferedReader.readLine();
            }

            if (observation != null)
            observation.getStation().writeToFile(outputFolder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void station2RDF(String path2StationFile, String path2StationOutputFolder){
        int i = 0;

        File file = new File(path2StationOutputFolder);
        if (!file.exists()) file.mkdirs();

        try
        {
            Reader in = new FileReader(path2StationFile);
            Iterable<CSVRecord> csvRecords = CSVFormat.EXCEL.parse(in);

            for (CSVRecord csvRecord:csvRecords){
                if (i == 0) {
                    i++;
                    continue;
                }

                String USAF    = csvRecord.get(0);
                String WBAN    = csvRecord.get(1);

                Station station = new Station(USAF);

                String locationName  = csvRecord.get(2);
                if (locationName != null) {
                    station.setName(locationName);
                }

                String countryCode  = csvRecord.get(3);
                if (countryCode != null) {
                    station.setCountryCode(countryCode);
                }

                String lat          = csvRecord.get(6);
                if (lat.length() != 0) {
                    station.setLat(lat);
                }

                String lon          = csvRecord.get(7);
                if (lon.length() != 0) {
                    station.setLon(lon);
                }

                stationHashMap.put(USAF, station);

                File stationOutputFile = new File(path2StationOutputFolder + "station_" + USAF + ".nt");
                PrintStream printStream = new PrintStream(stationOutputFile);
                station.serialiseToNTriples(printStream);
                printStream.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
