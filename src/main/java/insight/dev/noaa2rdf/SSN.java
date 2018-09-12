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
 * Date:  07/06/18.
 */
public class SSN {

//  private static Model model = ModelFactory.createDefaultModel();

  public static String nameSpace = "http://www.w3.org/ns/ssn/";

  public static Resource System = ResourceFactory.createResource(nameSpace + "System");
  public static Property hasSubSystem = ResourceFactory.createProperty(nameSpace + "hashSubSystem");

//  public static Resource System = nameSpace + "System";
//  public static String Deployment = nameSpace + "Deployment";
//  public static String deployedSystem = nameSpace + "deployedSystem";
//  public static String hashSubSystem = nameSpace + "hasSubSystem";
//  public static String Stimulus = nameSpace + "Stimulus";
//  public static String isProxyFor = nameSpace + "isProxyFor";
//  public static String wasOriginatedBy = nameSpace + "wasOriginatedBy";
//  public static String detects = nameSpace + "detects";
//  public static String Property = nameSpace + "Property";
//  public static String hasProperty = nameSpace + "hasProperty";
//  public static String isPropertyOf = nameSpace + "isPropertyOf";
//  public static String forProperty = nameSpace + "forProperty";



}
