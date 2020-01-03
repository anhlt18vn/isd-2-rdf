package insight.dev.noaa2rdf.classes;

import insight.dev.noaa2rdf.classes.Station;
import insight.dev.noaa2rdf.vocabulary.Geo;
import insight.dev.noaa2rdf.vocabulary.Namespace;
import insight.dev.noaa2rdf.vocabulary.SOSA;
import insight.dev.noaa2rdf.vocabulary.SSN;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.tdb.sys.Names;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import javax.naming.Name;

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

  private Station station;
  private ObservableProperty observableProperty;

  private Resource sensorResource;
  private Resource observablePropertyResource;
  private Resource featureOfInterestResource;

  public Sensor(Station station, ObservableProperty observableProperty){
    this.station = station;
    this.observableProperty = observableProperty;
    this.sensorResource = createSensorResource(observableProperty);
    this.observablePropertyResource = observableProperty.getObservablePropertyResource();
    this.featureOfInterestResource  = createFeatureOfInterest(observableProperty);
  }

  private Resource createSensorResource(ObservableProperty observableProperty){
    return ResourceFactory.createResource(Namespace.iot_sensor + station.getStationId() + "/"  + observableProperty.getName() + "/");
  }

  public Resource getSensorResource(){
    return sensorResource;
  }

  private Resource createFeatureOfInterest(ObservableProperty observableProperty){
    return ResourceFactory.createResource(Namespace.iot_foi +  station.getStationId() + "/" + observableProperty.getName() + "/");
  }


  public Model addToModel(Model model){
    model.add(sensorResource, RDF.type , SOSA.Sensor);
    model.add(sensorResource, SOSA.isHostedBy, station.getStationResource());

    model.add(sensorResource, SOSA.observes, observablePropertyResource);
    model.add(this.observablePropertyResource, SOSA.isObservedBy, sensorResource);

    observableProperty.addToModel(model);

    model.add(featureOfInterestResource, SSN.hasProperty, observablePropertyResource);
    model.add(featureOfInterestResource, Geo.hasLocation, station.getLocation().getLocationResouce());
    model.add(featureOfInterestResource, RDF.type, SOSA.FeatureOfInterest);

    return model;
  }

  public Resource getObservablePropertyResource() {
    return observablePropertyResource;
  }

  public Resource getFeatureOfInterestResource() {
    return featureOfInterestResource;
  }

  public void setObservableProperty(ObservableProperty observableProperty) {
    this.observableProperty = observableProperty;
  }
}
