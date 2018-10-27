//package insight.dev.noaa2rdf;
//
//import org.apache.jena.datatypes.RDFDatatype;
//import org.apache.jena.datatypes.xsd.XSDDatatype;
//import org.apache.jena.graph.Node;
//import org.apache.jena.rdf.model.*;
//
//import java.io.PrintStream;
//import java.time.LocalDateTime;
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
// * Date:  07/06/18.
// */
//public class Observation {
//
//
//
//  private String wndDirectAngle;
//  private String wndDirectAngleQC;
//  private String wndDirectAngleTC;
//  private String wndSpeed;
//  private String wndSpeedQC;
//
//  private String visDistance;
//  private String visQC;
//  private String visVC;
//  private String visQVC;
//
//  private String cigCHD;
//  private String cigCQC;
//  private String cigCDC;
//  private String cigCAVOK;
//
//  private String temp;
//  private String tempQ;
//
//  private String tempDew;
//  private String tempDewQ;
//
//  private String pressure;
//  private String pressureQ;
//
//  private String stationId;
//  private String dateTime;
//  private String reportType;
//  private int observationId;
//
//  private Station station;
//
//  public Observation(){
//    station = new Station();
//  }
//
//  public void setObservationId(int observationId){
//    this.observationId = observationId;
//  }
//
//  public void setStationId(String stationId){
//    this.stationId = stationId;
//    station.setStationId(stationId);
//  }
//
//  public void setDateTime(String dateTime){
//    this.dateTime = dateTime;
//  }
//
//  public void setReportType(String reportType){
//    this.reportType = reportType;
//  }
//
//  public void setWND(String WND){
//    String[] wnd = WND.split(",");
//
//     wndDirectAngle     = wnd[0];
//     wndDirectAngleQC   = wnd[1];
//     wndDirectAngleTC   = wnd[2];
//     wndSpeed           = wnd[3];
//     wndSpeedQC         = wnd[4];
//  }
//
//  public void setCIG(String CIG){
//    String[] cig = CIG.split(",");
//    cigCHD       = cig[0];
//    cigCQC       = cig[1];
//    cigCDC       = cig[2];
//    cigCAVOK     = cig[3];
//  }
//
//  public void setVIS(String VIS){
//    String[] vis = VIS.split(",");
//    visDistance  = vis[0];
//    visQC        = vis[1];
//    visVC        = vis[2];
//    visQVC       = vis[3];
//  }
//
//  public void setTMP(String TMP){
//    String[] tmp = TMP.split(",");
//    temp = tmp[0];
//    tempQ = tmp[1];
//  }
//
//
//  public void setDEW(String DEW){
//    String[] dew = DEW.split(",");
//    tempDew = dew[0];
//    tempDewQ = dew[1];
//  }
//
//  public void setSPL(String SPL){
//    String[] spl = SPL.split(",");
//    pressure = spl[0];
//    pressureQ = spl[1];
//  }
//
//  //================Wind Direction================================================================================================================//
//  private Model createWndDirectAngle(Model model){
//    if (wndDirectAngle.equals("999")) return model;
//    Resource windObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/WindDirectAngle/");
//    model.add(windObservation, SOSA.madeBySensor, station.getWindDirectionSensorResource());
//    model.add(station.getWindDirectionSensorResource(), SOSA.madeObservation, windObservation);
//    model.add(windObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(windObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(wndDirectAngle));
//    model = SOSA.addWDNDirectAngleFOI(model, windObservation);
//    return model;
//  }
//
//  private Model createWndDirectAngleQC(Model model){
//    if (wndDirectAngleQC.equals("9")) return model;
//    Resource windObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/WindDirectAngleQC/");
//    model.add(windObservation, SOSA.madeBySensor, station.getWindDirectionSensorResource());
//    model.add(station.getWindDirectionSensorResource(), SOSA.madeObservation, windObservation);
//    model.add(windObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(windObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(wndDirectAngleQC));
//    model = SOSA.addWDNDirectAngleQCFOI(model, windObservation);
//    return model;
//  }
//
//  private Model createWndDirectAngleTC(Model model){
//    if (wndDirectAngleTC.equals("9")) return model;
//    Resource windObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/WindDirectAngleTC/");
//    model.add(windObservation, SOSA.madeBySensor, station.getWindDirectionSensorResource());
//    model.add(station.getWindDirectionSensorResource(), SOSA.madeObservation, windObservation);
//    model.add(windObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(windObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(wndDirectAngleTC));
//    model = SOSA.addWDNDirectAngleTCFOI(model, windObservation);
//    return model;
//  }
//
//  //================Wind Speed================================================================================================================//
//  private Model createWndSpeedRate(Model model){
//    if (wndSpeed.equals("9999")) return model;
//    Resource windObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/WindSpeedRate/");
//    model.add(windObservation, SOSA.madeBySensor, station.getWindSensorResource());
//    model.add(station.getWindSensorResource(), SOSA.madeObservation, windObservation);
//    model.add(windObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(windObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(wndSpeed));
//    model = SOSA.addWNDRateSpeedFOI(model, windObservation);
//    return model;
//  }
//
//  private Model createWndSpeedRateQC(Model model){
//    if (wndDirectAngleTC.equals("9999")) return model;
//    Resource windObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/WindSpeedRateQC/");
//    model.add(windObservation, SOSA.madeBySensor, station.getWindSensorResource());
//    model.add(station.getWindSensorResource(), SOSA.madeObservation, windObservation);
//    model.add(windObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(windObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(wndDirectAngleTC));
//    model = SOSA.addWNDRateQCFOI(model, windObservation);
//    return model;
//  }
//
//  //================VIS ================================================================================================================//
//
//  private Model createVISDistance(Model model){
//    if (visDistance.equals("999999")) return model;
//    Resource visObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/VISDistance/");
//    model.add(visObservation, SOSA.madeBySensor, station.getATMPVisibleSensor());
//    model.add(station.getATMPVisibleSensor(), SOSA.madeObservation, visObservation);
//    model.add(visObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(visObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(visDistance));
//    model = SOSA.addVISDistanceFOI(model, visObservation);
//    return model;
//  }
//
//  private Model createVISDistanceQC(Model model){
//    if (visQC.equals("9")) return model;
//    Resource visObservationQC = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/VISDistanceQC/");
//    model.add(visObservationQC, SOSA.madeBySensor, station.getATMPVisibleSensor());
//    model.add(station.getATMPVisibleSensor(), SOSA.madeObservation, visObservationQC);
//    model.add(visObservationQC, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(visObservationQC, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(visQC));
//    model = SOSA.addVISQCFOI(model, visObservationQC);
//    return model;
//  }
//
//  private Model createVISDistanceVC(Model model){
//    if (visVC.equals("9")) return model;
//    Resource visObservationVC = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/VISDistanceVC/");
//    model.add(visObservationVC, SOSA.madeBySensor, station.getATMPVisibleSensor());
//    model.add(station.getATMPVisibleSensor(), SOSA.madeObservation, visObservationVC);
//    model.add(visObservationVC, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(visObservationVC, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(visVC));
//    model = SOSA.addVISVCFOI(model, visObservationVC);
//    return model;
//  }
//
//  private Model createVISDistanceQVC(Model model){
//    if (visQVC.equals("9")) return model;
//    Resource visObservationQVC = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/VISDistanceQVC/");
//    model.add(visObservationQVC, SOSA.madeBySensor, station.getATMPVisibleSensor());
//    model.add(station.getATMPVisibleSensor(), SOSA.madeObservation, visObservationQVC);
//    model.add(visObservationQVC, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(visObservationQVC, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(visQVC));
//    model = SOSA.addVISQVCFOI(model, visObservationQVC);
//    return model;
//  }
//
//
////=========TMP=======================================================================================================//
//  private Model createTMP(Model model){
//    if (temp.equals("9999")) return model;
//    Resource tempObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/Temp/");
//    model.add(tempObservation, SOSA.madeBySensor, station.getTemSensorResource());
//    model.add(station.getTemSensorResource(), SOSA.madeObservation, tempObservation);
//    model.add(tempObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(tempObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(temp));
//    model = SOSA.addAirTempFOI(model, tempObservation);
//    return model;
//  }
//
//  private Model createTMPQ(Model model){
//    if (tempQ.equals("9")) return model;
//    Resource tempQObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/TempQ/");
//    model.add(tempQObservation, SOSA.madeBySensor, station.getTemSensorResource());
//    model.add(station.getTemSensorResource(), SOSA.madeObservation, tempQObservation);
//    model.add(tempQObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(tempQObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(tempQ));
//    model = SOSA.addAirTempQCFOI(model, tempQObservation);
//    return model;
//  }
//
//  private Model createTMPDew(Model model){
//    if (tempDew.equals("9999")) return model;
//    Resource tempObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/TempDew/");
//    model.add(tempObservation, SOSA.madeBySensor, station.getTemSensorResource());
//    model.add(station.getTemSensorResource(), SOSA.madeObservation, tempObservation);
//    model.add(tempObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(tempObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(tempDew));
//    model = SOSA.addAirTempDewFOI(model, tempObservation);
//    return model;
//  }
//
//  private Model createTMPDewQ(Model model){
//    if (tempDewQ.equals("9")) return model;
//    Resource tempQObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/tempDewQ/");
//    model.add(tempQObservation, SOSA.madeBySensor, station.getTemSensorResource());
//    model.add(station.getTemSensorResource(), SOSA.madeObservation, tempQObservation);
//    model.add(tempQObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(tempQObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(tempDewQ));
//    model = SOSA.addAirTempDewQCFOI(model, tempQObservation);
//    return model;
//  }
//
//  private Model createATMPressure(Model model){
//    if (pressure.equals("99999")) return model;
//    Resource tempObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/Pressure/");
//    model.add(tempObservation, SOSA.madeBySensor, station.getATMPressureSensor());
//    model.add(station.getATMPressureSensor(), SOSA.madeObservation, tempObservation);
//    model.add(tempObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(tempObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(pressure));
//    model = SOSA.addATMPressureFOI(model, tempObservation);
//    return model;
//  }
//
//  private Model createATMPressureQ(Model model){
//    if (pressureQ.equals("9")) return model;
//    Resource tempQObservation = ResourceFactory.createResource(observationNamespace + stationId + "/" + observationId + "/PressureQ/");
//    model.add(tempQObservation, SOSA.madeBySensor, station.getATMPressureSensor());
//    model.add(station.getATMPressureSensor(), SOSA.madeObservation, tempQObservation);
//    model.add(tempQObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime, XSDDatatype.XSDdateTime));
//    model.add(tempQObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(pressureQ));
//    model = SOSA.addATMPressureQCFOI(model, tempQObservation);
//    return model;
//  }
//
//
//  public Model createModel(){
//    Model model = ModelFactory.createDefaultModel();
//          model = createWndDirectAngle(model);
//          model = createWndDirectAngleQC(model);
//          model = createWndDirectAngleTC(model);
//          model = createWndSpeedRate(model);
//          model = createWndSpeedRateQC(model);
//          model = createTMP(model);
//          model = createTMPQ(model);
//          model = createTMPDew(model);
//          model = createTMPDewQ(model);
//          model = createATMPressure(model);
//          model = createATMPressureQ(model);
//          model = createVISDistance(model);
//          model = createVISDistanceQC(model);
//          model = createVISDistanceQVC(model);
//          model = createVISDistanceVC(model);
//
//          return model;
//  }
//
//  public void serialiseToNTriples(PrintStream printStream){
//    serialise(printStream, "N-Triples");
//  }
//
//  public void serialise(PrintStream printStream, String lang){
//    Model model = createModel();
//    model.write(printStream, lang);
//  }
//
//  public String toString(){
//    return stationId + " " + dateTime + " "
//                     + wndDirectAngle + " "
//                     + wndDirectAngleQC + " "
//                     + wndDirectAngleTC + " "
//                     + wndSpeed + " "
//                     + wndSpeedQC + " -- "
//                     + cigCHD + " "
//                     + cigCQC + " "
//                     + cigCDC + " "
//                     + cigCAVOK + " -- "
//                     + visDistance + " "
//                     + visQC + " "
//                     + visVC + " "
//                     + visQVC + " -- "
//                     + temp + " "
//                     + tempQ + " "
//                     + tempDew + " "
//                     + tempDewQ + " -- "
//                     + pressure + " "
//                     + pressureQ + " " ;
//  }
//
//
//  //===============================================================================================//
//
//}
