package insight.dev.noaa2rdf;

import insight.dev.noaa2rdf.vocabulary.Geo;
import insight.dev.noaa2rdf.vocabulary.Namespace;
import insight.dev.noaa2rdf.vocabulary.SOSA;
import insight.dev.noaa2rdf.vocabulary.SSN;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

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
public class Sensor {

  public static enum SensorType{
    WINDSPEEDSENSOR,
    WINDDIRECTIONSENSOR,
    TEMPERATURESENSOR,
    ATMOSHPERESENSOR,
    AIRCONDITIONSENSOR
  };

  public static Resource windspeedSensor      = ResourceFactory.createResource(Namespace.iot_class + "windSpeedSensor/");
  public static Resource windDirectionSensor  = ResourceFactory.createResource(Namespace.iot_class + "windDirectionSensor/");
  public static Resource atmosphereSensor     = ResourceFactory.createResource(Namespace.iot_class + "atmosphereSensor/");
  public static Resource temperatureSensor    = ResourceFactory.createResource(Namespace.iot_class + "temperatureSensor/");
  public static Resource airConditionSensor   = ResourceFactory.createResource(Namespace.iot_class + "airConditionSensor/");

  public static Resource tempOP               = ResourceFactory.createResource(Namespace.iot_observable + "temperature/");
  public static Resource windSpeedOP          = ResourceFactory.createResource(Namespace.iot_observable + "windSpeed/");
  public static Resource windDirectionOP      = ResourceFactory.createResource(Namespace.iot_observable + "windDirection/");
  public static Resource atmOP                = ResourceFactory.createResource(Namespace.iot_observable + "atmospherePressure/");
  public static Resource airOP                = ResourceFactory.createResource(Namespace.iot_observable + "airCondition/");

  public SensorType sensorType;
  public Station station;


  public Sensor(Station station, SensorType sensorType){
    this.sensorType = sensorType;
    this.station = station;
  }


  public Resource getSensorResource(){
    Resource resource = null;
    switch (this.sensorType){
      case WINDSPEEDSENSOR:{
        resource = ResourceFactory.createResource(Namespace.iot_sensor + "windSpeed/" + station.getStationId() + "/");
        return resource;
      }

      case WINDDIRECTIONSENSOR:{
        resource = ResourceFactory.createResource(Namespace.iot_sensor + "windDirection/" + station.getStationId() + "/");
        return resource;
      }

      case TEMPERATURESENSOR:{
        resource = ResourceFactory.createResource(Namespace.iot_sensor + "temperature/" + station.getStationId() + "/");
        return resource;
      }

      case ATMOSHPERESENSOR:{
        resource = ResourceFactory.createResource(Namespace.iot_sensor + "atmosphere/" + station.getStationId() + "/");
        return resource;
      }

      case AIRCONDITIONSENSOR:{
        resource = ResourceFactory.createResource(Namespace.iot_sensor + "airCondition/" + station.getStationId() + "/");
        return resource;
      }


    };

    return resource;
  }


  public Resource createFOI(){
    Resource resource = null;
    switch (this.sensorType){
      case WINDSPEEDSENSOR:{
        resource = ResourceFactory.createResource(Namespace.iot_foi + "windSpeed/" + station.getStationId() + "/");
        return resource;
      }

      case WINDDIRECTIONSENSOR:{
        resource = ResourceFactory.createResource(Namespace.iot_foi + "windDirection/" + station.getStationId() + "/");
        return resource;
      }

      case TEMPERATURESENSOR:{
        resource = ResourceFactory.createResource(Namespace.iot_foi + "temperature/" + station.getStationId() + "/");
        return resource;
      }

      case ATMOSHPERESENSOR:{
        resource = ResourceFactory.createResource(Namespace.iot_foi + "atmosphere/" + station.getStationId() + "/");
        return resource;
      }

      case AIRCONDITIONSENSOR:{
        resource = ResourceFactory.createResource(Namespace.iot_foi + "airCondition/" + station.getStationId() + "/");
        return resource;
      }


    };

    return resource;
  }


  public Model addToModel(Model model){
    switch (this.sensorType){

      case WINDSPEEDSENSOR:{
         model.add(getSensorResource(), RDF.type, windspeedSensor);
         model.add(windspeedSensor, RDFS.subClassOf, SOSA.Sensor);
         model.add(getSensorResource(), SOSA.observes, windSpeedOP);
         model.add(windSpeedOP, SOSA.isObservedBy, getSensorResource());
         model.add(windSpeedOP, RDFS.subClassOf, SOSA.ObservableProperty);

         model.add(createFOI(), RDF.type, SOSA.FeatureOfInterest);
         model.add(createFOI(), Geo.hasLocation, station.getLocation().getLocationResouce());
         model.add(createFOI(), SSN.hasProperty, windSpeedOP);
         break;
      }

      case WINDDIRECTIONSENSOR:{
        model.add(getSensorResource(), RDF.type, windDirectionSensor);
        model.add(windDirectionSensor, RDFS.subClassOf, SOSA.Sensor);
        model.add(getSensorResource(), SOSA.observes, windDirectionOP);
        model.add(windDirectionOP, SOSA.isObservedBy, getSensorResource());
        model.add(windDirectionOP, RDFS.subClassOf, SOSA.ObservableProperty);

        model.add(createFOI(), RDF.type, SOSA.FeatureOfInterest);
        model.add(createFOI(), Geo.hasLocation, station.getLocation().getLocationResouce());
        model.add(createFOI(), SSN.hasProperty, windDirectionOP);

        break;
      }

      case TEMPERATURESENSOR:{
        model.add(getSensorResource(), RDF.type, temperatureSensor);
        model.add(temperatureSensor, RDFS.subClassOf, SOSA.Sensor);
        model.add(getSensorResource(), SOSA.observes, tempOP);
        model.add(tempOP, SOSA.isObservedBy, getSensorResource());
        model.add(tempOP, RDFS.subClassOf, SOSA.ObservableProperty);

        model.add(createFOI(), RDF.type, SOSA.FeatureOfInterest);
        model.add(createFOI(), Geo.hasLocation, station.getLocation().getLocationResouce());
        model.add(createFOI(), SSN.hasProperty, tempOP);

        break;
      }

      case ATMOSHPERESENSOR:{
        model.add(getSensorResource(), RDF.type, atmosphereSensor);
        model.add(atmosphereSensor, RDFS.subClassOf, SOSA.Sensor);
        model.add(getSensorResource(), SOSA.observes, atmOP);
        model.add(atmOP, SOSA.isObservedBy, getSensorResource());
        model.add(atmOP, RDFS.subClassOf, SOSA.ObservableProperty);

        model.add(createFOI(), RDF.type, SOSA.FeatureOfInterest);
        model.add(createFOI(), Geo.hasLocation, station.getLocation().getLocationResouce());
        model.add(createFOI(), SSN.hasProperty, atmOP);

        break;
      }

      case AIRCONDITIONSENSOR:{
        model.add(getSensorResource(), RDF.type, airConditionSensor);
        model.add(airConditionSensor, RDFS.subClassOf, SOSA.Sensor);
        model.add(getSensorResource(), SOSA.observes, airOP);
        model.add(airOP, SOSA.isObservedBy, getSensorResource());
        model.add(airOP, RDFS.subClassOf, SOSA.ObservableProperty);

        model.add(createFOI(), RDF.type, SOSA.FeatureOfInterest);
        model.add(createFOI(), Geo.hasLocation, station.getLocation().getLocationResouce());
        model.add(createFOI(), SSN.hasProperty, airOP);

        break;
      }

    }

    return model;
  }
}
