package com.cliqset.abdera.ext.atommedia;

import javax.xml.namespace.QName;

public class MediaConstants {

	public static final String[] SHOULD_IMAGE_TYPES = new String[] { "image/jpeg", "image/png",
			"image/gif" };

	public static final String MEDIA_NS = "http://purl.org/syndication/atommedia";
	public static final String MEDIA_PREFIX = "media";

	public static final String LN_WIDTH = "width";
	public static final String LN_HEIGHT = "height";
	public static final String LN_DURATION = "duration";
	public static final String LN_DESCRIPTION = "description";

	public static final QName WIDTH = new QName(MEDIA_NS, LN_WIDTH, MEDIA_PREFIX);
	public static final QName HEIGHT = new QName(MEDIA_NS, LN_HEIGHT, MEDIA_PREFIX);
	public static final QName DURATION = new QName(MEDIA_NS, LN_DURATION, MEDIA_PREFIX);
	public static final QName DESCRIPTION = new QName(MEDIA_NS, LN_DESCRIPTION, MEDIA_PREFIX);
}
