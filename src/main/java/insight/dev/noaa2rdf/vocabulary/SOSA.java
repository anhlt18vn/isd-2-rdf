package insight.dev.noaa2rdf.vocabulary;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
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
 * Date:  07/06/18.
 */
public class SOSA {

  public static Resource Platform     = ResourceFactory.createResource(Namespace.sosa + "Platform");
  public static Resource Observation  = ResourceFactory.createResource(Namespace.sosa + "Observation");

  public static Property hosts                = ResourceFactory.createProperty(Namespace.sosa + "hosts");
  public static Property isHostedBy           = ResourceFactory.createProperty(Namespace.sosa + "isHostedBy");
  public static Property isObservedBy         = ResourceFactory.createProperty(Namespace.sosa + "isObservedBy");
  public static Property hasFeatureOfInterest = ResourceFactory.createProperty(Namespace.sosa + "hasFeatureOfInterest");
  public static Property madeBySensor         = ResourceFactory.createProperty(Namespace.sosa + "madebySensor");
  public static Property madeObservation      = ResourceFactory.createProperty(Namespace.sosa + "madeObservation");
  public static Property resultTime           = ResourceFactory.createProperty(Namespace.sosa + "resultTime");
  public static Property hasSimpleResult      = ResourceFactory.createProperty(Namespace.sosa + "hasSimpleResult");



  public static Resource FeatureOfInterest    = ResourceFactory.createResource(Namespace.sosa + "FeatureOfInterest");
  public static Resource Sensor               = ResourceFactory.createResource(Namespace.sosa + "Sensor");
  public static Property observes             = ResourceFactory.createProperty(Namespace.sosa + "observes");
  public static Resource ObservableProperty   = ResourceFactory.createResource(Namespace.sosa + "ObservableProperty");


//  public static Resource tempObservableProperty =           ResourceFactory.createResource("http://insight.org/sample/noaa/ObservableProperty/Temp/");
//  public static Resource windObservableProperty =           ResourceFactory.createResource("http://insight.org/sample/noaa/ObservableProperty/Wind/");
//  public static Resource windDirectionObservableProperty =  ResourceFactory.createResource("http://insight.org/sample/noaa/ObservableProperty/WindDirection/");
//  public static Resource amtPressureObservableProperty =    ResourceFactory.createResource("http://insight.org/sample/noaa/ObservableProperty/ATMPressure/");
//  public static Resource amtVisibilityObservableProperty =  ResourceFactory.createResource("http://insight.org/sample/noaa/ObservableProperty/ATMVisibility/");


  //=====================================WIND-OBSERVATION==================================================//
//  private static Resource wndDirectAngleFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/WindDirection/Angle");
//
//  public static Model addWDNDirectAngleFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, wndDirectAngleFOI);
//    model.add(wndDirectAngleFOI, RDF.type, FeatureOfInterest);
//    model.add(wndDirectAngleFOI, RDFS.label, "WIND-OBSERVATION direction angle");
//    model.add(wndDirectAngleFOI, RDFS.comment, "The angle, measured in a clockwise direction, between true north and the direction from which the wind is blowing");
//    return model;
//  }
//
//  private static Resource wndDirectAngleQCFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/WindDirection/QCode");
//
//  public static Model addWDNDirectAngleQCFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, wndDirectAngleQCFOI);
//    model.add(wndDirectAngleQCFOI, RDF.type, FeatureOfInterest);
//    model.add(wndDirectAngleQCFOI, RDFS.label, "WIND-OBSERVATION direction quality code");
//    model.add(wndDirectAngleQCFOI, RDFS.comment, "The code that denotes a quality status of a reported WIND-OBSERVATION direction angle");
//    return model;
//  }
//
//  public static Resource wndDirectAngleTypeCFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/WindDirection/TypeCode");
//
//  public static Model addWDNDirectAngleTCFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, wndDirectAngleTypeCFOI);
//    model.add(wndDirectAngleQCFOI, RDF.type, FeatureOfInterest);
//    model.add(wndDirectAngleTypeCFOI, RDFS.label, "WIND-OBSERVATION direction type code");
//    model.add(wndDirectAngleTypeCFOI, RDFS.comment, "The code that denotes the character of the WIND-OBSERVATION");
//    return model;
//  }
//
//  public static Resource wndRateSpeedFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/Wind/Speed");
//
//  public static Model addWNDRateSpeedFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, wndRateSpeedFOI);
//    model.add(wndDirectAngleQCFOI, RDF.type, FeatureOfInterest);
//    model.add(wndRateSpeedFOI, RDFS.label, "WIND-OBSERVATION speed rate");
//    model.add(wndRateSpeedFOI, RDFS.comment, "The rate of horizontal travel of air past a fixed point");
//    return model;
//  }
//
//  public static Resource wndRateQCFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/Wind/Speed/QCode");
//
//  public static Model addWNDRateQCFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, wndRateQCFOI);
//    model.add(wndDirectAngleQCFOI, RDF.type, FeatureOfInterest);
//    model.add(wndRateQCFOI, RDFS.label, "WIND-OBSERVATION speed quality code");
//    model.add(wndRateQCFOI, RDFS.comment, "The code that denotes a quality status of a reported WIND-OBSERVATION speed rate");
//    return model;
//  }
//
//  //=====================================VISIBILITY-OBSERVATION is abbreviated as column header VIS ====================//
//
//  public static Resource visDistanceFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/VIS/Distance");
//
//  public static Model addVISDistanceFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, visDistanceFOI);
//    model.add(wndDirectAngleQCFOI, RDF.type, FeatureOfInterest);
//    model.add(visDistanceFOI, RDFS.label,"VISIBILITY-OBSERVATION distance dimension");
//    model.add(visDistanceFOI, RDFS.comment,"The horizontal distance at which an object can be seen and identified.");
//    return model;
//  }
//
//  public static Resource visQCFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/VIS/QCode");
//
//  public static Model addVISQCFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, visQCFOI);
//    model.add(wndDirectAngleQCFOI, RDF.type, FeatureOfInterest);
//    model.add(visQCFOI, RDFS.label, "VISIBILITY-OBSERVATION distance quality code");
//    model.add(visQCFOI, RDFS.comment, "The code that denotes a quality status of a reported distance of a visibility observation.");
//    return model;
//  }
//
//  public static Resource visVCFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/VIS/VCode");
//
//  public static Model addVISVCFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, visVCFOI);
//    model.add(wndDirectAngleQCFOI, RDF.type, FeatureOfInterest);
//    model.add(visVCFOI, RDFS.label, "VISIBILITY-OBSERVATION variability code");
//    model.add(visVCFOI, RDFS.comment, "The code that denotes whether or not the reported visibility is variable");
//    return model;
//  }
//
//  public static Resource visQVCFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/VIS/QVCode");
//
//  public static Model addVISQVCFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, visQVCFOI);
//    model.add(wndDirectAngleQCFOI, RDF.type, FeatureOfInterest);
//    model.add(visQVCFOI, RDFS.label, "VISIBILITY-OBSERVATION quality variability code");
//    model.add(visQVCFOI, RDFS.comment, "The code that denotes a quality status of a reported VISIBILITY-OBSERVATION variability code.");
//    return model;
//  }
//
//  //=====================================SKY-CONDITION-OBSERVATION======================================================//
//  public static Resource skyConditionFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/SkyCondition/");
//
//  public Model addSkyConditionFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, skyConditionFOI);
//    model.add(wndDirectAngleQCFOI, RDF.type, FeatureOfInterest);
//    model.add(skyConditionFOI, RDFS.label, "SKY-CONDITION-OBSERVATION ceiling height dimension");
//    model.add(
//        skyConditionFOI,
//        RDFS.comment,
//        "The height above ground level (AGL) of the lowest cloud or obscuring phenomena layer aloft with 5/8 or more summation total sky"
//            + "cover, which may be predominantly opaque, or the vertical visibility into a surface-based obstruction");
//    return model;
//  }
//
//  public static Resource skyConditionQCFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/SkyCondition/QCode");
//
//  public Model addSkyConditionQCFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, skyConditionQCFOI);
//    model.add(skyConditionQCFOI, RDF.type, FeatureOfInterest);
//    model.add(skyConditionQCFOI, RDFS.label, "SKY-CONDTION-OBSERVATION ceiling quality code");
//    model.add(skyConditionQCFOI, RDFS.comment, "The code that denotes a quality status of a reported ceiling height dimension");
//    return model;
//  }
//
//  public static Resource skyConditionDCFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/SkyCondition/DCode");
//
//  public Model addSkyConditionDCFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, skyConditionDCFOI);
//    model.add(skyConditionDCFOI, RDF.type, FeatureOfInterest);
//    model.add(skyConditionDCFOI, RDFS.label, "SKY-CONDITION-OBSERVATION ceiling determination code");
//    model.add(skyConditionDCFOI, RDFS.comment, "The code that denotes the method used to determine the ceiling");
//    return model;
//  }
//
//  public static Resource skyConditionCAVOKFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/SkyCondition/CAVOK");
//
//  public Model addSKYConditionCAVOKFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, skyConditionCAVOKFOI);
//    model.add(skyConditionCAVOKFOI, RDF.type, FeatureOfInterest);
//    model.add(skyConditionCAVOKFOI, RDFS.label, "SKY-CONDITION-OBSERVATION CAVOK code");
//    model.add(skyConditionCAVOKFOI, RDFS.comment, "The code that represents whether the 'Ceiling and Visibility Okay' (CAVOK) condition has been reported.");
//    return model;
//  }
//
//  //=====================================AIR-TEMPERATURE======================================================//
//  public static Resource airTempFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/AirTemp/");
//
//  public static Model addAirTempFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, airTempFOI);
//    model.add(airTempFOI, RDF.type, FeatureOfInterest);
//    model.add(airTempFOI, RDFS.label, "AIR-TEMPERATURE-OBSERVATION air temperature");
//    model.add(airTempFOI, RDFS.comment,"The temperature of the air");
//    return model;
//  }
//
//  public static Resource airTempQCFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/AirTemp/QCode");
//
//  public static Model addAirTempQCFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, airTempQCFOI);
//    model.add(airTempQCFOI, RDF.type, FeatureOfInterest);
//    model.add(airTempQCFOI, RDFS.label, "AIR-TEMPERATURE-OBSERVATION air temperature quality code");
//    model.add(airTempQCFOI, RDFS.comment, "The code that denotes a quality status of an AIR-TEMPERATURE-OBSERVATION.");
//    return model;
//  }
//
//  //=====================================AIR-DEW-TEMPERATURE======================================================//
//  public static Resource airTempDewFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/AirTemp/Dew");
//
//  public static Model addAirTempDewFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, airTempDewFOI);
//    model.add(airTempDewFOI, RDF.type, FeatureOfInterest);
//    model.add(airTempDewFOI, RDFS.label, "AIR-TEMPERATURE-OBSERVATION dew point temperature");
//    model.add(airTempDewFOI, RDFS.comment,"The temperature to which a given parcel of air must be cooled at constant pressure and water vapor content in order for saturation to occur");
//    return model;
//  }
//
//  public static Resource airTempDewQCFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/AirTemp/Dew/QCode");
//
//  public static Model addAirTempDewQCFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, airTempDewQCFOI);
//    model.add(airTempDewQCFOI, RDF.type, FeatureOfInterest);
//    model.add(airTempDewQCFOI, RDFS.label, "AIR-TEMPERATURE-OBSERVATION dew point quality code");
//    model.add(airTempDewQCFOI, RDFS.comment, "The code that denotes a quality status of the reported dew point temperature.");
//    return model;
//  }
//
//  //=====================================ATMOSPHERIC-PRESSURE-OBSERVATION ======================================================//
//  public static Resource atmPressureFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/ATMPressure/");
//
//  public static Model addATMPressureFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, atmPressureFOI);
//    model.add(atmPressureFOI, RDF.type, FeatureOfInterest);
//    model.add(atmPressureFOI, RDFS.label, "AIR-TEMPERATURE-OBSERVATION dew point temperature");
//    model.add(atmPressureFOI, RDFS.comment,"The temperature to which a given parcel of air must be cooled at constant pressure and water vapor content in order for saturation to occur");
//    return model;
//  }
//
//  public static Resource atmPressureQCFOI = ResourceFactory.createResource("http://insight.org/sample/noaa/FeatureOfInterest/ATMPressure/QCode");
//
//  public static Model addATMPressureQCFOI(Model model, Resource observation){
//    model.add(observation, SOSA.hasFeatureOfInterest, atmPressureQCFOI);
//    model.add(atmPressureQCFOI, RDF.type, FeatureOfInterest);
//    model.add(atmPressureQCFOI, RDFS.label, "AIR-TEMPERATURE-OBSERVATION dew point quality code");
//    model.add(atmPressureQCFOI, RDFS.comment, "The code that denotes a quality status of the reported dew point temperature.");
//    return model;
//  }
}
