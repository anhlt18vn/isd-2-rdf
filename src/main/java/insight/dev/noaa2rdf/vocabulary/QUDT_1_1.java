package insight.dev.noaa2rdf.vocabulary;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;

/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 1/3/20
 * PROJECT: noaa-2-rdf
 */
public class QUDT_1_1 {
    public static Resource QuantityValue = ResourceFactory.createResource(Namespace.qudt_1_1 + "QuantityValue");

    public static Property unit = ResourceFactory.createProperty(Namespace.qudt_1_1 + "unit");
    public static Property numericValue = ResourceFactory.createProperty(Namespace.qudt_1_1 + "numericValue");



}
