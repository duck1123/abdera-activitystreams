package com.cliqset.abdera.ext.activity.object;

import java.util.ArrayList;
import java.util.List;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import org.apache.abdera.ext.geo.GeoHelper;
import org.apache.abdera.ext.geo.Point;
import org.apache.abdera.ext.geo.Position;
import org.apache.abdera.ext.geo.GeoHelper.Encoding;
import org.apache.abdera.model.Content;
import org.apache.abdera.model.Link;

import com.cliqset.abdera.ext.activity.Object;
import com.cliqset.abdera.ext.atommedia.MediaDescription;
import com.cliqset.abdera.ext.atommedia.MediaLink;
import com.cliqset.abdera.ext.poco.Address;
import com.cliqset.abdera.ext.poco.PocoConstants;

public class Image extends Object {

	private static MimeType jpeg = null;
	private static MimeType png = null;
	private static MimeType gif = null;

	static {
		try {
			jpeg = new MimeType("image/jpeg");
			png = new MimeType("image/png");
			gif = new MimeType("image/gif");
		} catch (MimeTypeParseException mtpe) {
			throw new org.apache.abdera.util.MimeTypeParseException(mtpe);
		}
	}

	public Image(Object object) {
		super(object.getInternal());
	}

	public List<MediaLink> getLargerImages() {
		List<MediaLink> largerImages = new ArrayList<MediaLink>();
		for (Link link : super.getLinks(Link.REL_ENCLOSURE)) {
			if (jpeg.match(link.getMimeType()) || png.match(link.getMimeType())
					|| gif.match(link.getMimeType())) {
				largerImages.add(new MediaLink(link));
			}
		}
		return largerImages;
	}

	public MediaLink getLargerImage() {
		List<MediaLink> largerImages = getLargerImages();
		return (null == largerImages || largerImages.size() < 1 ? null : largerImages.get(0));
	}

	public Object addLargeImage(MediaLink link) {
		addExtension(link);
		return this;
	}

	public MediaLink addLargerImage(String href, String mimeType) {
		Link link = getFactory().newLink(getInternal());
		link.setMimeType(mimeType);
		link.setRel(Link.REL_ENCLOSURE);
		link.setHref(href);
		return new MediaLink(link);
	}

	public MediaLink addLargerImage(String href, String mimeType, int height, int width) {
		MediaLink link = new MediaLink(getFactory().newLink(getInternal()));
		link.setMimeType(mimeType);
		link.setRel(Link.REL_ENCLOSURE);
		link.setHref(href);
		link.setHeight(height);
		link.setWidth(width);
		return link;
	}

	public Link getPageLink() {
		return super.getPageLink();
	}

	public Link setPageLink(String href) {
		return super.setPageLink(href);
	}

	public MediaDescription getDescription() {
		return super.getDescription();
	}

	public MediaDescription setDescription(String description) {
		return super.setDescription(description, Content.Type.TEXT);
	}

	public MediaDescription setDescription(String description, Content.Type type) {
		return super.setDescription(description, type);
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
