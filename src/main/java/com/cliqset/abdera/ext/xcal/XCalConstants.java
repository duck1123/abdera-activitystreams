package com.cliqset.abdera.ext.xcal;

import javax.xml.namespace.QName;

public class XCalConstants {

	public static final String XCAL_PREFIX = "xCal";

	public static final String XCAL_NS = "urn:ietf:params:xml:ns:xcal";

	public static final String LN_SUMMARY = "summary";
	public static final String LN_DTSTART = "dtstart";
	public static final String LN_DTEND = "dtend";
	public static final String LN_LOCATION = "location";
	public static final String LN_VENUE = "x-calconnect-venue";
	public static final String LN_VENUE_ID = "x-calconnect-venue-id";
	public static final String LN_ADR = "adr";
	public static final String LN_VENUE_NAME = "x-calconnect-venue-name";
	public static final String LN_STREET = "x-calconnect-street";
	public static final String LN_CITY = "x-calconnect-city";
	public static final String LN_REGION = "x-calconnect-region";
	public static final String LN_POSTAL_CODE = "x-calconnect-postalcode";
	public static final String LN_COUNTRY = "x-calconnect-country";
	public static final String LN_URL = "url";

	public static final QName SUMMARY = new QName(XCAL_NS, LN_SUMMARY, XCAL_PREFIX);
	public static final QName DTSTART = new QName(XCAL_NS, LN_DTSTART, XCAL_PREFIX);
	public static final QName DTEND = new QName(XCAL_NS, LN_DTEND, XCAL_PREFIX);
	public static final QName LOCATION = new QName(XCAL_NS, LN_LOCATION, XCAL_PREFIX);
	public static final QName VENUE = new QName(XCAL_NS, LN_VENUE, XCAL_PREFIX);
	public static final QName VENUE_ID = new QName(XCAL_NS, LN_VENUE_ID, XCAL_PREFIX);
	public static final QName ADR = new QName(XCAL_NS, LN_ADR, XCAL_PREFIX);
	public static final QName VENUE_NAME = new QName(XCAL_NS, LN_VENUE_NAME, XCAL_PREFIX);
	public static final QName STREET = new QName(XCAL_NS, LN_STREET, XCAL_PREFIX);
	public static final QName CITY = new QName(XCAL_NS, LN_CITY, XCAL_PREFIX);
	public static final QName REGION = new QName(XCAL_NS, LN_REGION, XCAL_PREFIX);
	public static final QName POSTAL_CODE = new QName(XCAL_NS, LN_POSTAL_CODE, XCAL_PREFIX);
	public static final QName COUNTRY = new QName(XCAL_NS, LN_COUNTRY, XCAL_PREFIX);
	public static final QName URL = new QName(XCAL_NS, LN_URL, XCAL_PREFIX);

	public static final String DATE_FORMAT_STRING = "yyyyMMdd'T'hhmmssz";
}
