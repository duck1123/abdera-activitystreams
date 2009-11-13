package com.cliqset.abdera.ext.activity;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ElementWrapper;
import org.apache.abdera.model.IRIElement;

public class ObjectType extends ElementWrapper implements IRIElement {

	public static final String ARTICLE = "http://activitystrea.ms/schema/1.0/article";
	public static final String WEBLOG_ENTRY = "http://activitystrea.ms/schema/1.0/blog-entry";
	public static final String NOTE = "http://activitystrea.ms/schema/1.0/note";
	public static final String FILE = "http://activitystrea.ms/schema/1.0/file";
	public static final String IMAGE = "http://activitystrea.ms/schema/1.0/image";
	public static final String PHOTO = "http://activitystrea.ms/schema/1.0/photo";
	public static final String PHOTO_ALBUM = "http://activitystrea.ms/schema/1.0/photo-album";
	public static final String PLAYLIST = "http://activitystrea.ms/schema/1.0/playlist";
	public static final String VIDEO = "http://activitystrea.ms/schema/1.0/video";
	public static final String TV_EPISODE = "http://activitystrea.ms/schema/1.0/tv-episode";
	public static final String MOVIE = "http://activitystrea.ms/schema/1.0/movie";
	public static final String AUDIO = "http://activitystrea.ms/schema/1.0/audio";
	public static final String BOOKMARK = "http://activitystrea.ms/schema/1.0/bookmark";
	public static final String PERSON = "http://activitystrea.ms/schema/1.0/person";
	public static final String GROUP = "http://activitystrea.ms/schema/1.0/group";
	public static final String PLACE = "http://activitystrea.ms/schema/1.0/place";
	public static final String MUSIC_ALBUM = "http://activitystrea.ms/schema/1.0/music-album";
	public static final String SONG = "http://activitystrea.ms/schema/1.0/song";
	public static final String AUDIO_PODCAST = "http://activitystrea.ms/schema/1.0/audio-podcast";
	public static final String VIDEO_PODCAST = "http://activitystrea.ms/schema/1.0/video-podcast";
	public static final String EVENT = "http://activitystrea.ms/schema/1.0/event";
	public static final String REVIEW = "http://activitystrea.ms/schema/1.0/review";
	public static final String BOOK = "http://activitystrea.ms/schema/1.0/book";

	public ObjectType(Element internal) {
		super(internal);
	}

	public ObjectType(Factory factory) {
		super(factory, ActivityConstants.OBJECT_TYPE);
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
