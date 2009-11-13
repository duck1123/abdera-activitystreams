package com.cliqset.abdera.ext.atomreview;

import javax.xml.namespace.QName;

public class ReviewConstants {

	public static final String REVIEW_PREFIX = "review";
	public static final String REVIEW_NS = "http://purl.org/syndication/atomreview";

	public static final String LN_RATING = "rating";
	public static final String LN_REVIEWED = "reviewed";
	public static final String LN_WORST = "worst";
	public static final String LN_BEST = "best";

	public static final QName RATING = new QName(REVIEW_NS, LN_RATING, REVIEW_PREFIX);
	public static final QName REVIEWED = new QName(REVIEW_NS, LN_REVIEWED, REVIEW_PREFIX);
	public static final QName WORST = new QName(REVIEW_NS, LN_WORST, REVIEW_PREFIX);
	public static final QName BEST = new QName(REVIEW_NS, LN_BEST, REVIEW_PREFIX);
}
