package insight.dev.noaa2rdf;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
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
 * Date:  10/06/18.
 */
public class GEO {
  public static String nameSpace = "http://www.geonames.org/ontology#";

  public static Resource Feature      = ResourceFactory.createResource(nameSpace + "Feature");
  public static Property lat          = ResourceFactory.createProperty("http://www.w3.org/2003/01/geo/wgs84_pos#lat");
  public static Property lon          = ResourceFactory.createProperty("http://www.w3.org/2003/01/geo/wgs84_pos#long");
  public static Property countryCode  = ResourceFactory.createProperty(nameSpace + "countryCode");

}
