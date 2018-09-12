package insight.dev.noaa2rdf;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

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
  private final String stationNameSpace = "http://insight.org/sample/noaa/station/";

  private Resource stationResource;
  private Resource temSensor;
  private Resource windSensor;
  private Resource windDirectionSensor;
  private Resource atmPressureSensor;
  private Resource atmVisibilitySensor;

  private String stationName;
  private String stationId;
  private String countryCode;
  private String lat;
  private String lon;

  public Station(){}

  public void setStationId(String stationId){
    this.stationId = stationId;
  }

  public void setStationName(String stationName){
    this.stationName = stationName;
  }

  public void setCountryCode(String countryCode){
    this.countryCode = countryCode;
  }

  public void setLat(String lat){
    this.lat = lat;
  }

  public void setLon(String lon){
    this.lon = lon;
  }

  public Resource getStationResource(){
    return stationResource != null ? stationResource : createStationResource();
  }

  private Resource createStationResource(){
    this.stationResource =  ResourceFactory.createResource(stationNameSpace + this.stationId + "/");
    return this.stationResource;
  }


  public Resource getTemSensorResource() {
    return temSensor != null ? temSensor : createTemperatureSensor();
  }

  private Resource createTemperatureSensor(){
    this.temSensor = ResourceFactory.createResource(stationNameSpace + this.stationId + "/temperatureSensor/");
    return this.temSensor;
  }

  public Resource getWindSensorResource() {
    return windSensor != null ? windSensor : createWindSensorResource();
  }

  public Resource createWindSensorResource(){
    this.windSensor =  ResourceFactory.createResource(stationNameSpace + this.stationId + "/windSensor/");
    return this.windSensor;
  }

  public Resource getWindDirectionSensorResource() {
    return windDirectionSensor != null ? windDirectionSensor : createWindDirectionSensor();
  }

  private Resource createWindDirectionSensor(){
    this.windDirectionSensor =  ResourceFactory.createResource(stationNameSpace + this.stationId + "/windDirectionSensor/");
    return this.windDirectionSensor;
  }

  public Resource getATMPressureSensor() {
    return atmPressureSensor != null ? atmPressureSensor : createATMPressureSensor();
  }

  public Resource createATMPressureSensor(){
    this.atmPressureSensor = ResourceFactory.createResource(stationNameSpace + this.stationId + "/atmosphericPressureSenor/");
    return this.atmPressureSensor;
  }

  public Resource getATMPVisibleSensor() {
    return atmVisibilitySensor != null ? atmVisibilitySensor : createATMPVisibleSensor();
  }

  private Resource createATMPVisibleSensor(){
    this.atmVisibilitySensor = ResourceFactory.createResource(stationNameSpace + this.stationId + "/atmosphereVisibilitySensor/");
    return this.atmVisibilitySensor;
  }

  private Model addTemperatureSensor(Model model){
    model.add(getStationResource(), SSN.hasSubSystem, getTemSensorResource());
    model.add(getTemSensorResource(), RDF.type, SOSA.Sensor);
    model.add(getTemSensorResource(), RDFS.label, "Temperature Sensor");
    model.add(getTemSensorResource(), SOSA.observes,  SOSA.tempObservableProperty);
    model.add(SOSA.tempObservableProperty, RDF.type, SOSA.ObservableProperty);
    model.add(SOSA.tempObservableProperty, RDFS.label, "Temperature");
    model.add(SOSA.tempObservableProperty, SOSA.isObservedBy,getTemSensorResource());
    return model;
  }

  private Model addWindSensor(Model model){
    model.add(getStationResource(), SSN.hasSubSystem, getWindSensorResource());
    model.add(getWindSensorResource(), RDF.type, SOSA.Sensor);
    model.add(getWindSensorResource(), RDFS.label, "Wind Speed Sensor");
    model.add(getWindSensorResource(), SOSA.observes, SOSA.windObservableProperty);
    model.add(SOSA.windObservableProperty, RDF.type, SOSA.ObservableProperty);
    model.add(SOSA.windObservableProperty, RDFS.label, "Wind");
    model.add(SOSA.windObservableProperty, SOSA.isObservedBy, getWindSensorResource());
    return model;
  }

  private Model addWindDirectionSensor(Model model){
    model.add(getStationResource(), SSN.hasSubSystem, getWindDirectionSensorResource());
    model.add(getWindDirectionSensorResource(), RDF.type, SOSA.Sensor);
    model.add(getWindDirectionSensorResource(), RDFS.label, "Wind Direction Sensor");
    model.add(getWindSensorResource(), SOSA.observes, SOSA.windDirectionObservableProperty);
    model.add(SOSA.windDirectionObservableProperty, RDF.type, SOSA.ObservableProperty);
    model.add(SOSA.windDirectionObservableProperty, RDFS.label, "Wind Direction");
    model.add(SOSA.windDirectionObservableProperty, SOSA.isObservedBy, getWindDirectionSensorResource());
    return model;
  }

  private Model addATMPressureSensor(Model model){
    model.add(getStationResource(), SSN.hasSubSystem, getATMPressureSensor());
    model.add(getATMPressureSensor(), RDF.type, SOSA.Sensor);
    model.add(getATMPressureSensor(), RDFS.label, "Atmosphere Pressure Sensor");
    model.add(getATMPressureSensor(), SOSA.observes, SOSA.amtPressureObservableProperty);
    model.add(SOSA.amtPressureObservableProperty, RDF.type, SOSA.ObservableProperty);
    model.add(SOSA.amtPressureObservableProperty, RDFS.label, " Pressure ");
    model.add(SOSA.amtPressureObservableProperty, SOSA.isObservedBy, getATMPressureSensor());
    return model;
  }

  private Model addATMVisibilitySensor(Model model){
    model.add(getStationResource(), SSN.hasSubSystem, getATMPVisibleSensor());
    model.add(getATMPVisibleSensor(), RDF.type, SOSA.Sensor);
    model.add(getATMPVisibleSensor(), RDFS.label, "Atmosphere Visibility Sensor");
    model.add(getATMPVisibleSensor(), SOSA.observes, SOSA.amtVisibilityObservableProperty);
    model.add(SOSA.amtVisibilityObservableProperty, RDF.type, SOSA.ObservableProperty);
    model.add(SOSA.amtVisibilityObservableProperty, RDFS.label, " Visibility ");
    model.add(SOSA.amtVisibilityObservableProperty, SOSA.isObservedBy, getATMPVisibleSensor());
    return model;
  }

  private Model addStation(Model model){
    model.add(getStationResource(), RDF.type, SSN.System);
    return model;
  }

  private Model addPlace(Model model){
    Resource place = ResourceFactory.createResource(stationNameSpace + stationId + "/place");
    Property name  = ResourceFactory.createProperty("http://purl.org/goodrelations/v1#name");
    Property hasLocation = ResourceFactory.createProperty("http://www.loa-cnr.it/ontologies/DUL.owl#hasLocation");

    model.add(place, RDF.type, GEO.Feature);

    if (lat!=null){
      model.add(place, GEO.lat, ResourceFactory.createTypedLiteral(lat, XSDDatatype.XSDdouble));
    }

    if (lon!=null){
      model.add(place, GEO.lon, ResourceFactory.createTypedLiteral(lon, XSDDatatype.XSDdouble));
    }

    if (countryCode != null){
      model.add(place, GEO.countryCode, countryCode);
    }

    model.add(getTemSensorResource(), hasLocation, place);
    model.add(getWindSensorResource(), hasLocation, place);
    model.add(getWindDirectionSensorResource(), hasLocation, place);
    model.add(getATMPressureSensor(), hasLocation, place);
    model.add(getATMPVisibleSensor(), hasLocation, place);

    if (stationName != null){
      model.add(getStationResource(), name, stationName);
    }

    return model;
  }

  public void viewStationInRDF(){
    Model model = ModelFactory.createDefaultModel();
          model = addStation(model);
          model = addTemperatureSensor(model);
          model = addWindSensor(model);
          model = addWindDirectionSensor(model);
          model = addATMPressureSensor(model);
          model = addATMVisibilitySensor(model);
          model = addPlace(model);
          model.write(System.out, "N-Triples");
  }

  private Model addToModel(){
    Model model = ModelFactory.createDefaultModel();
    model = addStation(model);
    model = addTemperatureSensor(model);
    model = addWindSensor(model);
    model = addWindDirectionSensor(model);
    model = addATMPressureSensor(model);
    model = addATMVisibilitySensor(model);
    model = addPlace(model);
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
}
