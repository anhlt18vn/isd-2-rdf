package insight.dev.noaa2rdf;

import com.sun.org.apache.xml.internal.utils.NameSpace;
import insight.dev.noaa2rdf.vocabulary.Namespace;
import insight.dev.noaa2rdf.vocabulary.SOSA;
import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.datatypes.xsd.XSDDateTime;
import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDF;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;


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
public class Observation {

    private String date;
    private String time;

    private String wndDirect;
    private String wndSpeed;
    private String visDistance;
    private String temp;
    private String pressure;
    private String skyCeiling;

    private Station station;
    private Sensor sensor;

    Calendar calendar;



    Observation() {
        station = new Station();
        calendar = new GregorianCalendar();
    }



    //================Wind Direction================================================================================================================//
    private Model createWndDirectAngle(Model model) {
        Sensor sensor = new Sensor(this.station, Sensor.SensorType.WINDDIRECTIONSENSOR);
        if (wndDirect.equals("999")) return model;
        Resource windObservation = ResourceFactory.createResource(Namespace.iot_observation + "/" + station.getStationId() + "/" + date + time + "/WindDirectAngle/");
        model.add(windObservation, SOSA.madeBySensor, sensor.getSensorResource());
        model.add(sensor.getSensorResource(), SOSA.madeObservation, windObservation);
        model.add(windObservation, RDF.type, SOSA.Observation);
        model.add(windObservation, SOSA.hasFeatureOfInterest, sensor.createFOI());
        model.add(sensor.createFOI(), SOSA.hasFeatureOfInterest, windObservation);
        model.add(windObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(this.wndDirect));
        model.add(windObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(new XSDDateTime(dateTime())).toString(), XSDDatatype.XSDdateTime);
        return model;
    }



    private Model createTMP(Model model) {
        Sensor sensor = new Sensor(this.station, Sensor.SensorType.TEMPERATURESENSOR);
        if (wndDirect.equals("999")) return model;
        Resource tempObservation = ResourceFactory.createResource(Namespace.iot_observation + "/" + station.getStationId() + "/" + date + time + "/Temperature/");
        model.add(tempObservation, SOSA.madeBySensor, sensor.getSensorResource());
        model.add(sensor.getSensorResource(), SOSA.madeObservation, tempObservation);
        model.add(tempObservation, RDF.type, SOSA.Observation);
        model.add(tempObservation, SOSA.hasFeatureOfInterest, sensor.createFOI());
        model.add(sensor.createFOI(), SOSA.hasFeatureOfInterest, tempObservation);
        model.add(tempObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(this.temp));
        model.add(tempObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(new XSDDateTime(dateTime())).toString(), XSDDatatype.XSDdateTime);
        return model;
    }



    private Model createWndSpeedRate(Model model) {
        Sensor sensor = new Sensor(this.station, Sensor.SensorType.WINDSPEEDSENSOR);
        if (wndSpeed.equals("9999")) return model;
        Resource windSpeedObservation = ResourceFactory.createResource(Namespace.iot_observation + "/" + station.getStationId() + "/" + date + time + "/WindSpeedRate/");
        model.add(windSpeedObservation, SOSA.madeBySensor, sensor.getSensorResource());
        model.add(sensor.getSensorResource(), SOSA.madeObservation, windSpeedObservation);
        model.add(windSpeedObservation, RDF.type, SOSA.Observation);
        model.add(windSpeedObservation, SOSA.hasFeatureOfInterest, sensor.createFOI());
        model.add(sensor.createFOI(), SOSA.hasFeatureOfInterest, windSpeedObservation);
        model.add(windSpeedObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(this.wndSpeed));
        model.add(windSpeedObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(new XSDDateTime(dateTime())).toString(), XSDDatatype.XSDdateTime);
        return model;
    }



    private Model createVISDistance(Model model) {
        Sensor sensor = new Sensor(this.station, Sensor.SensorType.AIRCONDITIONSENSOR);
        if (visDistance.equals("999999")) return model;
        Resource visDistanceObservation = ResourceFactory.createResource(Namespace.iot_observation + "/" + station.getStationId() + "/" + date + time + "/VISDistance/");
        model.add(visDistanceObservation, SOSA.madeBySensor, sensor.getSensorResource());
        model.add(sensor.getSensorResource(), SOSA.madeObservation, visDistanceObservation);
        model.add(visDistanceObservation, RDF.type, SOSA.Observation);
        model.add(visDistanceObservation, SOSA.hasFeatureOfInterest, sensor.createFOI());
        model.add(sensor.createFOI(), SOSA.hasFeatureOfInterest, visDistanceObservation);
        model.add(visDistanceObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(this.visDistance));
        model.add(visDistanceObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(new XSDDateTime(dateTime())).toString(), XSDDatatype.XSDdateTime);
        return model;
    }



    private Model createATMPressure(Model model) {
        Sensor sensor = new Sensor(this.station, Sensor.SensorType.ATMOSHPERESENSOR);
        if (visDistance.equals("999999")) return model;
        Resource atmObservation = ResourceFactory.createResource(Namespace.iot_observation + "/" + station.getStationId() + "/" + date + time + "/VISDistance/");
        model.add(atmObservation, SOSA.madeBySensor, sensor.getSensorResource());
        model.add(sensor.getSensorResource(), SOSA.madeObservation, atmObservation);
        model.add(atmObservation, RDF.type, SOSA.Observation);
        model.add(atmObservation, SOSA.hasFeatureOfInterest, sensor.createFOI());
        model.add(sensor.createFOI(), SOSA.hasFeatureOfInterest, atmObservation);
        model.add(atmObservation, SOSA.hasSimpleResult, ResourceFactory.createPlainLiteral(this.pressure));
        model.add(atmObservation, SOSA.resultTime, ResourceFactory.createTypedLiteral(new XSDDateTime(dateTime())).toString(), XSDDatatype.XSDdateTime);
        return model;
    }



    Model createModel(Model model) {
        createWndDirectAngle(model);
        createWndSpeedRate(model);
        createTMP(model);
        createATMPressure(model);
        createVISDistance(model);
        return model;
    }



    public String toString() {
        return station.getStationId() + " "
                + station.getLocation().getLat() + " "
                + station.getLocation().getLon() + " "
                + date + " "
                + time + " "
                + wndDirect + " "
                + wndSpeed + " "
                + skyCeiling + " "
                + visDistance + " "
                + temp + " "
                + pressure;
    }



    void setWndSpeed(String wndSpeed) {
        this.wndSpeed = wndSpeed;
    }



    void setVisDistance(String visDistance) {
        this.visDistance = visDistance;
    }



    void setTemp(String temp) {
        this.temp = temp;
    }



    void setPressure(String pressure) {
        this.pressure = pressure;
    }



    void setStationId(String stationId) {
        this.station.setStationId(stationId);
    }



    public void setDate(String date) {
        this.date = date;
    }



    void setTime(String time) {
        this.time = time;
    }



    void setWndDirect(String wndDirect) {
        this.wndDirect = wndDirect;
    }



    void setLat(String lat) {
        this.station.setLat(lat);
    }



    void setLon(String lon) {
        this.station.setLon(lon);
    }



    void setSkyCeiling(String skyCeiling) {
        this.skyCeiling = skyCeiling;
    }



    Station getStation() {
        return this.station;
    }



    private Calendar dateTime() {
        int year = Integer.parseInt(this.date.substring(0, 4));
        int month = Integer.parseInt(this.date.substring(4, 6));
        int day = Integer.parseInt(this.date.substring(6, 8));
        int hour = Integer.parseInt(this.time.substring(0, 2));
        int min = Integer.parseInt(this.time.substring(2, 4));
        this.calendar.set(year, month, day, hour, min, 0);
        return calendar;
    }

}
