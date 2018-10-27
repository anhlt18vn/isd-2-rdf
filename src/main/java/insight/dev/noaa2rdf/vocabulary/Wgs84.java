package insight.dev.noaa2rdf.vocabulary;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.ResourceFactory;

/**
 * insight.dev.noaa2rdf.vocabulary
 * <p>
 * TODO: Add class description
 * <p>
 * Author:  Anh Le-Tuan
 * <p>
 * Email:   anh.letuan@insight-centre.org
 * <p>
 * Date:  27/10/18.
 */
public class Wgs84 {
  public static final Property wgs84point   = ResourceFactory.createProperty(Namespace.wgs84 + "Point");
  public static final Property wgs84lat     = ResourceFactory.createProperty(Namespace.wgs84 + "lat");
  public static final Property wgs84lon     = ResourceFactory.createProperty(Namespace.wgs84 + "lon");

}
