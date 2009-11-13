package com.cliqset.abdera.ext.poco;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ExtensibleElement;
import org.apache.abdera.model.ExtensibleElementWrapper;

public class Address extends ExtensibleElementWrapper {

	public Address(Element internal) {
		super(internal);
	}

	public Address(Factory factory, QName qname) {
		super(factory, qname);
	}

	// formatted
	public Element getFormattedElement() {
		return super.getFirstChild(PocoConstants.FORMATTED);
	}

	public String getFormatted() {
		Element name = getFormattedElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setFormatted(String formatted) {
		ExtensibleElement internal = getExtInternal();
		Element el = getFormattedElement();
		if (formatted != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.FORMATTED, internal);
			el.setText(formatted);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	// street address
	public Element getStreetAddressElement() {
		return super.getFirstChild(PocoConstants.STREET_ADDRESS);
	}

	public String getStreetAddress() {
		Element name = getStreetAddressElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setStreetAddress(String streetAddress) {
		ExtensibleElement internal = getExtInternal();
		Element el = getStreetAddressElement();
		if (streetAddress != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.STREET_ADDRESS, internal);
			el.setText(streetAddress);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	// locality
	public Element getLocalityElement() {
		return super.getFirstChild(PocoConstants.LOCALITY);
	}

	public String getLocality() {
		Element name = getLocalityElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setLocality(String locality) {
		ExtensibleElement internal = getExtInternal();
		Element el = getLocalityElement();
		if (locality != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.LOCALITY, internal);
			el.setText(locality);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	// region
	public Element getRegionElement() {
		return super.getFirstChild(PocoConstants.REGION);
	}

	public String getRegion() {
		Element name = getRegionElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setRegion(String region) {
		ExtensibleElement internal = getExtInternal();
		Element el = getRegionElement();
		if (region != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.REGION, internal);
			el.setText(region);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	// postal code
	public Element getPostalCodeElement() {
		return super.getFirstChild(PocoConstants.POSTAL_CODE);
	}

	public String getPostalCode() {
		Element name = getPostalCodeElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setPostalCode(String postalCode) {
		ExtensibleElement internal = getExtInternal();
		Element el = getPostalCodeElement();
		if (postalCode != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.POSTAL_CODE, internal);
			el.setText(postalCode);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	// coutnry
	public Element getCountryElement() {
		return super.getFirstChild(PocoConstants.COUNTRY);
	}

	public String getCountry() {
		Element name = getCountryElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setCountry(String country) {
		ExtensibleElement internal = getExtInternal();
		Element el = getCountryElement();
		if (country != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.COUNTRY, internal);
			el.setText(country);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}
}
