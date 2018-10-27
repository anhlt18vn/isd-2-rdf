package insight.dev.noaa2rdf.vocabulary;

import org.apache.jena.rdf.model.Property;
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
 * Date:  27/10/18.
 */
public class Geo {
  public static final Property geoCountry   = ResourceFactory.createProperty(Namespace.geo + "countryCode");
  public static final Property geoname      = ResourceFactory.createProperty(Namespace.geo + "name");
  public static final Property hasLocation  = ResourceFactory.createProperty(Namespace.dul + "hasLocation");
}
