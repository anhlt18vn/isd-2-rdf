package insight.dev.noaa2rdf;

import insight.dev.noaa2rdf.vocabulary.Geo;
import insight.dev.noaa2rdf.vocabulary.Namespace;
import insight.dev.noaa2rdf.vocabulary.SOSA;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDF;

import java.io.PrintStream;

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
public class Station {


  private Resource stationResource;



//  private Resource temSensor;
//  private Resource windSensor;
//  private Resource windDirectionSensor;
//  private Resource atmPressureSensor;
//  private Resource atmVisibilitySensor;

  private String stationName;
  private String stationId;
  private String countryCode;
  private String lat;
  private String lon;


  private Sensor windSpeedSensor;
  private Sensor windDirectionSensor;
  private Sensor temperatureSensor;
  private Sensor airConditionSensor;
  private Sensor atmosphereSensor;

  private Location location;

  public Station(){
    location  = new Location();
    windSpeedSensor = new Sensor(this, Sensor.SensorType.WINDSPEEDSENSOR);
    windDirectionSensor = new Sensor(this, Sensor.SensorType.WINDDIRECTIONSENSOR);
    temperatureSensor = new Sensor(this, Sensor.SensorType.TEMPERATURESENSOR);
    airConditionSensor = new Sensor(this, Sensor.SensorType.AIRCONDITIONSENSOR);
    atmosphereSensor = new Sensor(this, Sensor.SensorType.ATMOSHPERESENSOR);
  }


  public void setStationId(String stationId){
    this.stationId = stationId;
    location.setLocationId(stationId);
  }

  public String getStationId(){
    return stationId;
  }

  public void setStationName(String stationName){
    location.setName(stationName);
  }

  public Location getLocation(){
    return this.location;
  }


  public void setCountryCode(String countryCode){
    location.setCountryCode(countryCode);
  }

  public void setLat(String lat){
    location.setLat(lat);
  }

  public void setLon(String lon){
    location.setLon(lon);
  }

  public Resource getStationResource(){
    return stationResource != null ? stationResource : createStationResource();
  }

  private Resource createStationResource(){
    this.stationResource =  ResourceFactory.createResource(Namespace.iot_station + this.stationId + "/");
    return this.stationResource;
  }


  private Model createModel(Model model){
    model.add(getStationResource(), RDF.type, SOSA.Platform);

    model.add(getStationResource(), Geo.hasLocation, location.getLocationResouce());
    model = location.addToModel(model);

    //add temperature Sensor

    //add windSpeedSensor
    model.add(getStationResource(), SOSA.hosts, windSpeedSensor.getSensorResource());
    model.add(windSpeedSensor.getSensorResource(), SOSA.isHostedBy, getStationResource());
    model = windSpeedSensor.addToModel(model);

    //add windSpeedSensor
    model.add(getStationResource(), SOSA.hosts, windDirectionSensor.getSensorResource());
    model.add(windDirectionSensor.getSensorResource(), SOSA.isHostedBy, getStationResource());
    model = windDirectionSensor.addToModel(model);

    //add temperature
    model.add(getStationResource(), SOSA.hosts, temperatureSensor.getSensorResource());
    model.add(temperatureSensor.getSensorResource(), SOSA.isHostedBy, getStationResource());
    model = temperatureSensor.addToModel(model);

    //add windSpeedSensor
    model.add(getStationResource(), SOSA.hosts, airConditionSensor.getSensorResource());
    model.add(airConditionSensor.getSensorResource(), SOSA.isHostedBy, getStationResource());
    model = airConditionSensor.addToModel(model);

    //add windSpeedSensor
    model.add(getStationResource(), SOSA.hosts, atmosphereSensor.getSensorResource());
    model.add(atmosphereSensor.getSensorResource(), SOSA.isHostedBy, getStationResource());
    model = atmosphereSensor.addToModel(model);

    return model;
  }


  public void viewStationInRDF(){
    Model model = ModelFactory.createDefaultModel();
          model = createModel(model);
          model.write(System.out, "N3");
  }

  private Model addToModel(){
    Model model = ModelFactory.createDefaultModel();
    model = createModel(model);
    return model;
  }

  public void serialiseToNTriples(PrintStream printStream){
    serialise(printStream, "N-Triples");
  }

  public void serialise(PrintStream printStream, String lang){
    Model model = addToModel();
    model.write(printStream, lang);
  }



  public String toString(){
    return stationId + " " + stationName + " " + countryCode + " " + lat + " " + lon;
  }


  public static void main(String[] args){
    Station station = new Station();
            station.setStationId("0000001");
            station.setStationName("ABC");
            station.setLon("1");
            station.setLat("1");
            station.setCountryCode("aaa");
            station.viewStationInRDF();
  }
}
