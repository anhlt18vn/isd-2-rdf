package insight.dev.noaa2rdf.vocabulary;

/**
 * insight.dev.noaa2rdf
 * <p>
 * TODO: Add class description
 * <p>
 * Author:  Anh Le-Tuan
 * <p>
 * Email:   anh.letuan@insight-centre.org
 * <p>
 * Date:  27/10/18.
 */
public class Namespace {
  public static final String iot =  "http://insight.org/iot/data/noaa/";
  public static final String iot_sensor  = iot + "sensor/";
  public static final String iot_station = iot + "weatherStation/";
  public static final String iot_observation = iot + "observation/";
  public static final String iot_observable = iot + "observableProperty/";
  public static final String iot_location = iot + "location/";
  public static final String iot_point = iot + "point/";
  public static final String iot_foi = iot + "featureOfInterest/";
  public static final String iot_class = iot + "class/";

  public static final String wgs84 = "http://www.w3.org/2003/01/geo/wgs84_pos#";
  public static final String geo    ="http://www.geonames.org/ontology#";
  public static final String dul    = "http://www.loa-cnr.it/ontologies/DUL.owl#";
  public static final String sosa   = "http://www.w3.org/ns/sosa/";;
  public static final String ssn    = "http://www.w3.org/ns/ssn/";

}
