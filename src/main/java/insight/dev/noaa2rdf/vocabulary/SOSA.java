package insight.dev.noaa2rdf.vocabulary;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;

/**
 * insight.dev.noaa2rdf
 * <p>
 * TODO: Add class description
 * <p>
 * Author:  Anh Le-Tuan
 * <p>
 * Email:   anh.letuan@insight-centre.org
 * <p>
 * Date:  07/06/18.
 */
public class SOSA {

  public static Resource Platform     = ResourceFactory.createResource(Namespace.sosa + "Platform");
  public static Resource Observation  = ResourceFactory.createResource(Namespace.sosa + "Observation");
  public static Resource FeatureOfInterest    = ResourceFactory.createResource(Namespace.sosa + "FeatureOfInterest");
  public static Resource Sensor               = ResourceFactory.createResource(Namespace.sosa + "Sensor");
  public static Resource Result               = ResourceFactory.createResource(Namespace.sosa + "Result");


  public static Property hosts                = ResourceFactory.createProperty(Namespace.sosa + "hosts");
  public static Property isHostedBy           = ResourceFactory.createProperty(Namespace.sosa + "isHostedBy");
  public static Property isObservedBy         = ResourceFactory.createProperty(Namespace.sosa + "isObservedBy");
  public static Property hasFeatureOfInterest = ResourceFactory.createProperty(Namespace.sosa + "hasFeatureOfInterest");
  public static Property isFeatureOfInterestOf = ResourceFactory.createProperty(Namespace.sosa + "isFeatureOfInterestOf");
  public static Property madeBySensor         = ResourceFactory.createProperty(Namespace.sosa + "madebySensor");
  public static Property madeObservation      = ResourceFactory.createProperty(Namespace.sosa + "madeObservation");
  public static Property resultTime           = ResourceFactory.createProperty(Namespace.sosa + "resultTime");
  public static Property hasResult            = ResourceFactory.createProperty(Namespace.sosa + "hasResult");
  public static Property hasSimpleResult      = ResourceFactory.createProperty(Namespace.sosa + "hasSimpleResult");
  public static Property observes             = ResourceFactory.createProperty(Namespace.sosa + "observes");
  public static Property ObservableProperty   = ResourceFactory.createProperty(Namespace.sosa + "ObservableProperty");
}
