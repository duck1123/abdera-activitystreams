package com.cliqset.abdera.ext.activity;

import javax.xml.namespace.QName;

public class ActivityConstants {

	public static final String ACTIVITY_PREFIX = "activity";
	public static final String ACTIVITY_NS = "http://activitystrea.ms/spec/1.0/";

	public static final String LN_ACTOR = "actor";
	public static final String LN_OBJECT = "object";
	public static final String LN_OBJECT_TYPE = "object-type";
	public static final String LN_TARGET = "target";
	public static final String LN_VERB = "verb";
	public static final String LN_SUBJECT = "subject";

	public static final QName ACTOR = new QName(ACTIVITY_NS, LN_ACTOR, ACTIVITY_PREFIX);
	public static final QName OBJECT = new QName(ACTIVITY_NS, LN_OBJECT, ACTIVITY_PREFIX);
	public static final QName OBJECT_TYPE = new QName(ACTIVITY_NS, LN_OBJECT_TYPE, ACTIVITY_PREFIX);
	public static final QName TARGET = new QName(ACTIVITY_NS, LN_TARGET, ACTIVITY_PREFIX);
	public static final QName VERB = new QName(ACTIVITY_NS, LN_VERB, ACTIVITY_PREFIX);
	public static final QName SUBJECT = new QName(ACTIVITY_NS, LN_SUBJECT, ACTIVITY_PREFIX);

}
