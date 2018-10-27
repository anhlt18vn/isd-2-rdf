package insight.dev.noaa2rdf.vocabulary;

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


  public static Resource System = ResourceFactory.createResource(Namespace.ssn + "System");
  public static Property hasSubSystem = ResourceFactory.createProperty(Namespace.ssn + "hashSubSystem");

//  public static Resource System = nameSpace + "System";
//  public static String Deployment = nameSpace + "Deployment";
//  public static String deployedSystem = nameSpace + "deployedSystem";
//  public static String hashSubSystem = nameSpace + "hasSubSystem";
//  public static String Stimulus = nameSpace + "Stimulus";
//  public static String isProxyFor = nameSpace + "isProxyFor";
//  public static String wasOriginatedBy = nameSpace + "wasOriginatedBy";
//  public static String detects = nameSpace + "detects";
//  public static String Property = nameSpace + "Property";
  public static Property hasProperty = ResourceFactory.createProperty(Namespace.ssn + "hasProperty");
//  public static String isPropertyOf = nameSpace + "isPropertyOf";
//  public static String forProperty = nameSpace + "forProperty";



}
