package insight.dev.noaa2rdf.classes;


import insight.dev.noaa2rdf.vocabulary.Namespace;
import insight.dev.noaa2rdf.vocabulary.QUDT_1_1;
import insight.dev.noaa2rdf.vocabulary.QUDT_1_1_Unit;
import insight.dev.noaa2rdf.vocabulary.SOSA;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.datatypes.xsd.XSDDateTime;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;


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

    private Station station;
    private Calendar calendar;


    public Observation(Station station) {
        this.station = station;
        this.calendar = new GregorianCalendar();
    }


    public static Observation readObservationFrom(String string, HashMap<String, Station> stationHashMap) {
        String stationId = string.substring(4, 10);
        Station station = stationHashMap.get(stationId);

        Observation observation = new Observation(station);

        String date = string.substring(15, 23); //YYYYMMDD
        observation.setDate(date);

        String time = string.substring(23, 27); //HHMMM
        observation.setTime(time);

        //String lon = string.substring(28, 34);
        //System.out.println(lon);
        //System.out.println("station lat" + station.getLocation().getLon());

        //String lat = string.substring(34, 41);
        //System.out.println(lat);
        //System.out.println("station lat" + station.getLocation().getLat());
        //observation.setLat(lat);

        String windDirection = string.substring(61, 63);
        observation.setWndDirect(windDirection);

        String windSpeed = string.substring(66, 69);
        observation.setWndSpeed(windSpeed);

        String visibilityDistance = string.substring(79, 84);
        observation.setVisDistance(visibilityDistance);

        String temp = string.substring(87, 92);
        observation.setTemp(temp);

        String pressure = string.substring(99, 104);
        observation.setPressure(pressure);

        return observation;
    }


    public Model addToModel(Model model) {
        model = createObservation(model, ObservableProperty.windDirection, wndDirect, wndDirect + " degree angle", QUDT_1_1_Unit.DegreeAngle);
        model = createObservation(model, ObservableProperty.windSpeed, wndSpeed, wndSpeed + " meters per second", QUDT_1_1_Unit.DegreeAngle);
        model = createObservation(model, ObservableProperty.temperature, temp, temp + " degree Celsius", QUDT_1_1_Unit.DegreeCelsisus);
        model = createObservation(model, ObservableProperty.airCondition, visDistance, visDistance + " meters", QUDT_1_1_Unit.Meter);
        model = createObservation(model, ObservableProperty.atmosphere, pressure, pressure + " Pascal", QUDT_1_1_Unit.Pascal);
        return model;
    }


    private String dateTime() {
        int year = Integer.parseInt(this.date.substring(0, 4));
        int month = Integer.parseInt(this.date.substring(4, 6));
        int day = Integer.parseInt(this.date.substring(6, 8));
        int hour = Integer.parseInt(this.time.substring(0, 2));
        int min = Integer.parseInt(this.time.substring(2, 4));
        this.calendar.set(year, month, day, hour, min, 0);
        return new XSDDateTime(calendar).toString();
    }


    private Model createObservation(Model model, ObservableProperty observableProperty, String numericValue, String simpleValue, Resource unit) {
        if (wndDirect.equals("999")) return model;

        Resource observation = ResourceFactory.createResource(Namespace.iot_observation + station.getStationId() + "/" + observableProperty.getName() + "/" + date + time + "/");
        model.add(observation, RDF.type, SOSA.Observation);
        model.add(observation, SOSA.ObservableProperty, observableProperty.getObservablePropertyResource());

        Sensor sensor = this.station.getSensors().get(observableProperty);
        model.add(observation, SOSA.madeBySensor, sensor.getSensorResource());
        model.add(sensor.getSensorResource(), SOSA.madeObservation, observation);

        model.add(observation, SOSA.hasFeatureOfInterest, sensor.getFeatureOfInterestResource());
        model.add(sensor.getFeatureOfInterestResource(), SOSA.isFeatureOfInterestOf, observation);

        model.add(observation, SOSA.hasSimpleResult, simpleValue);

        Resource result = ResourceFactory.createResource(Namespace.iot_result + station.getStationId() + "/" + observableProperty.getName() + "/" + date + time + "/");
        model.add(observation, SOSA.hasResult, result);
        model.add(result, RDF.type, SOSA.Result);
        model.add(result, RDF.type, QUDT_1_1.QuantityValue);
        model.add(result, QUDT_1_1.unit, unit);
        model.add(result, QUDT_1_1.numericValue, numericValue);
        model.add(observation, SOSA.resultTime, ResourceFactory.createTypedLiteral(dateTime(), XSDDatatype.XSDdateTime));

        return model;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public String getWndDirect() {
        return wndDirect;
    }


    public void setWndDirect(String wndDirect) {
        this.wndDirect = wndDirect;
    }


    public String getWndSpeed() {
        return wndSpeed;
    }


    public void setWndSpeed(String wndSpeed) {
        this.wndSpeed = wndSpeed;
    }


    public String getVisDistance() {
        return visDistance;
    }


    public void setVisDistance(String visDistance) {
        this.visDistance = visDistance;
    }


    public String getTemp() {
        return temp;
    }


    public void setTemp(String temp) {
        this.temp = temp;
    }


    public String getPressure() {
        return pressure;
    }


    public void setPressure(String pressure) {
        this.pressure = pressure;
    }


    public Station getStation() {
        return station;
    }


    public void setStation(Station station) {
        this.station = station;
    }


    public void writeToFile(String path2Output) {
        File file = new File((path2Output));
        if (!file.exists()) file.mkdirs();
        try {
            PrintStream printStream = new PrintStream(new File(path2Output + this.station.getStationId() + this.date + this.time + ".nt"));
            Model model = ModelFactory.createDefaultModel();
            model = addToModel(model);
            model.write(printStream, "N-Triples");
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
