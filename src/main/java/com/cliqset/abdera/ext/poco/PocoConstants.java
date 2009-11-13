package com.cliqset.abdera.ext.poco;

import javax.xml.namespace.QName;

public class PocoConstants {
	public static final String POCO_PREFIX = "poco";
	public static final String POCO_NS = "http://portablecontacts.net/spec/1.0";

	public static final String LN_NAME = "name";
	public static final String LN_FORMATTED = "formatted";
	public static final String LN_FAMILY_NAME = "familyName";
	public static final String LN_GIVEN_NAME = "givenName";
	public static final String LN_MIDDLE_NAME = "middleName";
	public static final String LN_HONORIFIC_PREFIX = "honorificPrefix";
	public static final String LN_HONORIFIC_SUFFIX = "honorificSuffix";
	public static final String LN_BIRTHDAY = "birthday";
	public static final String LN_GENDER = "gender";
	public static final String LN_ADDRESS = "address";
	public static final String LN_STREET_ADDRESS = "streetAddress";
	public static final String LN_LOCALITY = "locality";
	public static final String LN_REGION = "region";
	public static final String LN_POSTAL_CODE = "postalCode";
	public static final String LN_COUNTRY = "country";

	public static final QName NAME = new QName(POCO_NS, LN_NAME, POCO_PREFIX);
	public static final QName FORMATTED = new QName(POCO_NS, LN_FORMATTED, POCO_PREFIX);
	public static final QName FAMILY_NAME = new QName(POCO_NS, LN_FAMILY_NAME, POCO_PREFIX);
	public static final QName GIVEN_NAME = new QName(POCO_NS, LN_GIVEN_NAME, POCO_PREFIX);
	public static final QName MIDDLE_NAME = new QName(POCO_NS, LN_MIDDLE_NAME, POCO_PREFIX);
	public static final QName HONORIFIC_PREFIX = new QName(POCO_NS, LN_HONORIFIC_PREFIX,
			POCO_PREFIX);
	public static final QName HONORIFIC_SUFFIX = new QName(POCO_NS, LN_HONORIFIC_SUFFIX,
			POCO_PREFIX);
	public static final QName BIRTHDAY = new QName(POCO_NS, LN_BIRTHDAY, POCO_PREFIX);
	public static final QName GENDER = new QName(POCO_NS, LN_GENDER, POCO_PREFIX);
	public static final QName ADDRESS = new QName(POCO_NS, LN_ADDRESS, POCO_PREFIX);
	public static final QName STREET_ADDRESS = new QName(POCO_NS, LN_STREET_ADDRESS, POCO_PREFIX);
	public static final QName LOCALITY = new QName(POCO_NS, LN_LOCALITY, POCO_PREFIX);
	public static final QName REGION = new QName(POCO_NS, LN_REGION, POCO_PREFIX);
	public static final QName POSTAL_CODE = new QName(POCO_NS, LN_POSTAL_CODE, POCO_PREFIX);
	public static final QName COUNTRY = new QName(POCO_NS, LN_COUNTRY, POCO_PREFIX);
}
