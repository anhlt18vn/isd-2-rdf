package insight.dev.noaa2rdf;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

/**
 * insight.dev.noaa2rdf
 * <p>
 * TODO: Add class description
 * <p>
 * Author:  Anh Le-Tuan
 * <p>
 * Email:   anh.letuan@insight-centre.org
 * <p>
 * Date:  09/06/18.
 */
public class Station2RDF
{

  public static void main(String[] args){

    try
    {
      Reader in = new FileReader("/home/anhlt185/isd-history.csv");

      Iterable<CSVRecord> csvRecords = CSVFormat.EXCEL.parse(in);

      int i = 0;

      for (CSVRecord csvRecord:csvRecords){
        if (i == 0) {
          i++;
          continue;
        }

        i++;

        Station station = new Station();

        String USAF    = csvRecord.get(0);
        String WBAN    = csvRecord.get(1);
        station.setStationId(USAF);

        String stationName  = csvRecord.get(2);
        if (stationName != null) station.setStationName(stationName);

        String countryCode  = csvRecord.get(3);
        if (countryCode != null) station.setCountryCode(countryCode);

        String lat          = csvRecord.get(6);
        if (lat.length() != 0) station.setLat(lat);

        String lon          = csvRecord.get(7);
        if (lon.length() != 0) station.setLon(lon);

        station.viewStationInRDF();

        System.out.println(i);

        break;

      }
    } catch (IOException e){

    }
  }
}
