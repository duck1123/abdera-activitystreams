package com.cliqset.abdera.ext.activity.object;

import org.apache.abdera.ext.geo.GeoHelper;
import org.apache.abdera.ext.geo.Point;
import org.apache.abdera.ext.geo.Position;
import org.apache.abdera.ext.geo.GeoHelper.Encoding;
import org.apache.abdera.model.Text;

import com.cliqset.abdera.ext.activity.Object;
import com.cliqset.abdera.ext.poco.Address;
import com.cliqset.abdera.ext.poco.PocoConstants;

public class Place extends Object {

	public Place(Object object) {
		super(object.getInternal());
	}

	public String getName() {
		return super.getTitle();
	}

	public Text setName(String value) {
		return super.setTitle(value);
	}

	public void setLocationCoordinates(double latitude, double longitude) {
		GeoHelper.addPosition(this, new Point(latitude, longitude), Encoding.SIMPLE);
	}

	public Point getLocationCoordinates() {
		Position[] positions = GeoHelper.getPositions(this);
		if (null != positions && positions.length > 0) {
			return (Point) positions[0];
		}
		return null;
	}

	public Address setLocationAddress() {
		Address existing = getLocationAddress();
		if (null != existing) {
			existing.discard();
		}
		return super.addExtension(PocoConstants.ADDRESS);
	}

	public Address setLocationAddress(String formatted) {
		Address address = setLocationAddress();
		address.setFormatted(formatted);
		return address;
	}

	public Address setLocationAddress(String formatted, String streetAddress, String locality,
			String region, String postalCode, String country) {
		Address address = setLocationAddress();
		address.setFormatted(formatted);
		address.setStreetAddress(streetAddress);
		address.setLocality(locality);
		address.setRegion(region);
		address.setPostalCode(postalCode);
		address.setCountry(country);
		return address;
	}

	public Address getLocationAddress() {
		return super.getExtension(PocoConstants.ADDRESS);
	}
}
