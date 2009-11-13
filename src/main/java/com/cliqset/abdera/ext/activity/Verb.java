package com.cliqset.abdera.ext.activity;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ElementWrapper;
import org.apache.abdera.model.IRIElement;

public class Verb extends ElementWrapper implements IRIElement {

	public static final String POST = "http://activitystrea.ms/schema/1.0/post";
	public static final String SHARE = "http://activitystrea.ms/schema/1.0/share";
	public static final String SAVE = "http://activitystrea.ms/schema/1.0/save";
	public static final String MARK_AS_FAVORITE = "http://activitystrea.ms/schema/1.0/favorite";
	public static final String LIKE = "http://activitystrea.ms/schema/1.0/like";
	// public static final String VIEW =
	// "http://activitystrea.ms/schema/1.0/view";
	public static final String PLAY = "http://activitystrea.ms/schema/1.0/play";
	public static final String READ = "http://activitystrea.ms/schema/1.0/read";
	public static final String START_FOLLOWING = "http://activitystrea.ms/schema/1.0/follow";
	public static final String STOP_FOLLOWING = "http://activitystrea.ms/schema/1.0/unfollow";
	public static final String CONFIRM_CONNECTION = "http://activitystrea.ms/schema/1.0/confirm-connection";
	public static final String JOIN = "http://activitystrea.ms/schema/1.0/join";
	public static final String LEAVE = "http://activitystrea.ms/schema/1.0/leave";
	public static final String INVITE = "http://activitystrea.ms/schema/1.0/invite";
	public static final String TAG = "http://activitystrea.ms/schema/1.0/tag";
	public static final String POSITIVE_RSVP = "http://activitystrea.ms/schema/1.0/rsvp-yes";
	public static final String POSSIBLE_RSVP = "http://activitystrea.ms/schema/1.0/rsvp-maybe";
	public static final String NEGATIVE_RSVP = "http://activitystrea.ms/schema/1.0/rsvp-no";

	public Verb(Element internal) {
		super(internal);
	}

	public Verb(Factory factory) {
		super(factory, ActivityConstants.VERB);
	}

	public IRI getResolvedValue() {
		return getValue();
	}

	public IRI getValue() {
		String value = getText().trim();
		return (value != null) ? new IRI(value) : null;
	}

	public IRIElement setNormalizedValue(String iri) {
		return setValue(iri);
	}

	public IRIElement setValue(String iri) {
		if (iri != null)
			setText(new IRI(iri).toString());
		else
			setText((String) null);
		return this;
	}
}
