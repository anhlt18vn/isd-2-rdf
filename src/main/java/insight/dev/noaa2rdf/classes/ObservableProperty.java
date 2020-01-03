package insight.dev.noaa2rdf.classes;

import insight.dev.noaa2rdf.vocabulary.Namespace;
import insight.dev.noaa2rdf.vocabulary.SOSA;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;


/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 1/3/20
 * PROJECT: noaa-2-rdf
 */
public class ObservableProperty {

    public static ObservableProperty windSpeed = new ObservableProperty("windSpeed");
    public static ObservableProperty windDirection = new ObservableProperty("windDirection");
    public static ObservableProperty temperature = new ObservableProperty("temperature");
    public static ObservableProperty atmosphere = new ObservableProperty("atmosphere");
    public static ObservableProperty airCondition = new ObservableProperty("airCondition");

    private String name;
    private Resource observablePropertyResource;

    public ObservableProperty(String name) {
        this.name = name;
        this.observablePropertyResource = getObservablePropertyResource();
    }

    public String getName() {
        return name;
    }

    public Resource getObservablePropertyResource() {
        if (observablePropertyResource == null) {
            return observablePropertyResource = ResourceFactory.createResource(Namespace.iot_observable +  this.name + "/");
        }
        return observablePropertyResource;
    }

    public Model addToModel(Model model){
        model.add(observablePropertyResource, RDF.type, SOSA.ObservableProperty);
        model.add(observablePropertyResource, RDFS.label, name);
        return  model;
    }
}
