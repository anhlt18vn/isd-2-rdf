package insight.dev.noaa2rdf.classes;

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

    public Resource locationResource;
    public Resource pointResource;
    private String lat = null;
    private String lon = null;
    private String name = null;
    private String countryCode = null;
    private String locationId;

    public Location(String locationId) {
        this.locationId = locationId;
        this.locationResource = getLocationResouce();
        this.pointResource = getPointResource();
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLat() {return lat;}

    public String getLon() {return lon;}

    public Resource getLocationResouce() {
        if (locationResource == null) locationResource = ResourceFactory.createResource(Namespace.iot_location + this.locationId);
        return locationResource;
    }

    public Resource getPointResource(){
        if (pointResource == null) pointResource = ResourceFactory.createResource(Namespace.iot_point + this.locationId);
        return pointResource;
    }

    public Model addToModel(Model model) {
        if ((name != null) && (!name.equals(""))) {
            model.add(locationResource, Geo.geoname, name);
        }

        if ((countryCode != null) && (!countryCode.equals(""))) {
            model.add(locationResource, Geo.geoCountry, ResourceFactory.createPlainLiteral(countryCode));
        }

        model.add(locationResource, Wgs84.wgs84point, pointResource);

        if (lat != null) {
            model.add(locationResource, Wgs84.wgs84lat, ResourceFactory.createTypedLiteral(lat, XSDDatatype.XSDdouble));
        }

        if (lon != null) {
            model.add(locationResource, Wgs84.wgs84lon, ResourceFactory.createTypedLiteral(lon, XSDDatatype.XSDdouble));
        }

        return model;
    }

}
