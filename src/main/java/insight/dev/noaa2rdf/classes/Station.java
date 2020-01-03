package insight.dev.noaa2rdf.classes;

import insight.dev.noaa2rdf.vocabulary.Geo;
import insight.dev.noaa2rdf.vocabulary.Namespace;
import insight.dev.noaa2rdf.vocabulary.SOSA;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDF;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;


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
    private String stationId;
    private HashMap<ObservableProperty, Sensor> sensors;
    private Location location;


    public Station(String USAF) {
        this.stationId = USAF;
        this.location = new Location(USAF);
        sensors = new HashMap<>();
        this.stationResource = createStationResource();

        sensors.put(ObservableProperty.windSpeed, new Sensor(this, ObservableProperty.windSpeed));
        sensors.put(ObservableProperty.windDirection, new Sensor(this, ObservableProperty.windDirection));
        sensors.put(ObservableProperty.temperature, new Sensor(this, ObservableProperty.temperature));
        sensors.put(ObservableProperty.airCondition, new Sensor(this, ObservableProperty.airCondition));
        sensors.put(ObservableProperty.atmosphere, new Sensor(this, ObservableProperty.atmosphere));
    }

    public Location getLocation() {
        return this.location;
    }

    public Resource getStationResource() {
        return stationResource != null ? stationResource : createStationResource();
    }

    private Resource createStationResource() {
        this.stationResource = ResourceFactory.createResource(Namespace.iot_station + this.stationId + "/");
        return this.stationResource;
    }


    public Model createModel(Model model) {
        model.add(stationResource, RDF.type, SOSA.Platform);

        if (location != null) {
            model.add(stationResource, Geo.hasLocation, location.getLocationResouce());
            model = location.addToModel(model);
        }

        for (Map.Entry<ObservableProperty, Sensor> entry:sensors.entrySet()){
            model.add(stationResource, SOSA.hosts, entry.getValue().getSensorResource());
            model = entry.getValue().addToModel(model);
        }

        return model;
    }

    public void viewStationInRDF() {
        Model model = ModelFactory.createDefaultModel();
        model = createModel(model);
        model.write(System.out, "N-Triples");
    }

    private Model addToModel() {
        Model model = ModelFactory.createDefaultModel();
        model = createModel(model);
        return model;
    }

    public void serialiseToNTriples(PrintStream printStream) {
        serialise(printStream, "N-Triples");
    }

    public void writeToFile(String path2Output) {
        File file = new File((path2Output));
        if (!file.exists()) file.mkdirs();
        try {
            PrintStream printStream = new PrintStream(new File(path2Output + this.getStationId() + ".nt"));
            Model model = addToModel();
            model.write(printStream, "N-Triples");
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void serialise(PrintStream printStream, String lang) {
        Model model = addToModel();
        model.write(printStream, lang);
    }

    public void setName(String locationName) {
        this.location.setName(locationName);
    }

    public void setCountryCode(String countryCode) {
        this.location.setCountryCode(countryCode);
    }

    public void setLat(String lat) {
        this.location.setLat(lat);
    }

    public void setLon(String lon) {
        this.location.setLon(lon);
    }

    public String getStationId() {
        return stationId;
    }

    public HashMap<ObservableProperty, Sensor> getSensors() {
        return sensors;
    }
}
