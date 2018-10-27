package insight.dev.noaa2rdf;

import insight.dev.noaa2rdf.vocabulary.Geo;
import insight.dev.noaa2rdf.vocabulary.Namespace;
import insight.dev.noaa2rdf.vocabulary.Wgs84;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.*;

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
public class Location {

  public  String locationId;
  private String lat = null;
  private String lon = null;
  private String name = null;
  private String countryCode = null;

  public static Resource locationResouce;


  public void setLocationId(String stationId){
    this.locationId = stationId;
  }

  public void setLon(String lon){
    this.lon = lon;
  }

  public void setLat(String lat){
    this.lat = lat;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setCountryCode(String countryCode){
    this.countryCode = countryCode;
  }

  public Resource getLocationResouce(){
    if (locationResouce == null) createLocationResource();
    return locationResouce;
  }

  private Resource createLocationResource(){
    locationResouce = ResourceFactory.createResource(Namespace.iot_location + locationId);
    return locationResouce;
  }

  public Model addToModel(Model model){
    if ((name != null) && (!name.equals(""))){
      model.add(locationResouce, Geo.geoname, name);
    }

    if ((countryCode != null) && (!countryCode.equals(""))){
      model.add(locationResouce, Geo.geoCountry, ResourceFactory.createPlainLiteral(countryCode));
    }

    Resource point = ResourceFactory.createResource(Namespace.iot_point + locationId);
        model.add(locationResouce, Wgs84.wgs84point, point);

    if (lat!=null){
      model.add(point, Wgs84.wgs84lat, ResourceFactory.createTypedLiteral(lat, XSDDatatype.XSDdouble));
    }

    if (lon!=null){
      model.add(point, Wgs84.wgs84lon, ResourceFactory.createTypedLiteral(lon, XSDDatatype.XSDdouble));
    }

    return model;
  }


  public static void main(String[] args){
    System.out.println("TestLocation");

    Location location = new Location();
             location.setName("VietNam");
             location.setLat("1");
             location.setLon("2");

    Model model = ModelFactory.createDefaultModel();
    Resource resource = ResourceFactory.createResource("http://example.org/Station");
          model = location.addToModel(model);
    model.write(System.out, "N-Triples");
  }
}
