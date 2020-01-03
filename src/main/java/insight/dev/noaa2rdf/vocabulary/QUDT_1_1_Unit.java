package insight.dev.noaa2rdf.vocabulary;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;

/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 1/3/20
 * PROJECT: noaa-2-rdf
 */
public class QUDT_1_1_Unit {
    public static Resource DegreeCelsisus = ResourceFactory.createResource(Namespace.qudt_1_1_unit + "DegreeCelsius");
    public static Resource Pascal = ResourceFactory.createResource(Namespace.qudt_1_1_unit + "Pascal");
    public static Resource DegreeAngle = ResourceFactory.createResource(Namespace.qudt_1_1_unit + "DegreeAngle");
    public static Resource MeterPerSecond = ResourceFactory.createResource(Namespace.qudt_1_1_unit + "MeterPerSecond");
    public static Resource Meter = ResourceFactory.createResource(Namespace.qudt_1_1_unit + "Meter");
}
