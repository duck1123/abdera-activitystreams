package com.cliqset.abdera.ext.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.abdera.ext.geo.GeoHelper;
import org.apache.abdera.ext.geo.Point;
import org.apache.abdera.ext.geo.Position;
import org.apache.abdera.ext.geo.GeoHelper.Encoding;
import org.apache.abdera.factory.Factory;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.IRIElement;

import com.cliqset.abdera.ext.activity.object.Article;
import com.cliqset.abdera.ext.activity.object.Audio;
import com.cliqset.abdera.ext.activity.object.AudioPodcast;
import com.cliqset.abdera.ext.activity.object.Book;
import com.cliqset.abdera.ext.activity.object.Bookmark;
import com.cliqset.abdera.ext.activity.object.Event;
import com.cliqset.abdera.ext.activity.object.File;
import com.cliqset.abdera.ext.activity.object.Group;
import com.cliqset.abdera.ext.activity.object.Image;
import com.cliqset.abdera.ext.activity.object.Movie;
import com.cliqset.abdera.ext.activity.object.MusicAlbum;
import com.cliqset.abdera.ext.activity.object.Note;
import com.cliqset.abdera.ext.activity.object.Person;
import com.cliqset.abdera.ext.activity.object.Photo;
import com.cliqset.abdera.ext.activity.object.PhotoAlbum;
import com.cliqset.abdera.ext.activity.object.Place;
import com.cliqset.abdera.ext.activity.object.Playlist;
import com.cliqset.abdera.ext.activity.object.Review;
import com.cliqset.abdera.ext.activity.object.Song;
import com.cliqset.abdera.ext.activity.object.TVEpisode;
import com.cliqset.abdera.ext.activity.object.Video;
import com.cliqset.abdera.ext.activity.object.VideoPodcast;
import com.cliqset.abdera.ext.activity.object.WeblogEntry;
import com.cliqset.abdera.ext.poco.Address;
import com.cliqset.abdera.ext.poco.PocoConstants;
import com.cliqset.abdera.ext.serviceprovider.Provider;
import com.cliqset.abdera.ext.serviceprovider.ServiceProviderConstants;

public class ActivityEntry extends EntryWrapper {

	private static Map<String, Class<? extends Object>> objectTypeMap = new HashMap<String, Class<? extends Object>>();

	static {
		objectTypeMap.put(ObjectType.ARTICLE, Article.class);
		objectTypeMap.put(ObjectType.AUDIO, Audio.class);
		objectTypeMap.put(ObjectType.AUDIO_PODCAST, AudioPodcast.class);
		objectTypeMap.put(ObjectType.BOOKMARK, Bookmark.class);
		objectTypeMap.put(ObjectType.EVENT, Event.class);
		objectTypeMap.put(ObjectType.FILE, File.class);
		objectTypeMap.put(ObjectType.GROUP, Group.class);
		objectTypeMap.put(ObjectType.IMAGE, Image.class);
		objectTypeMap.put(ObjectType.MOVIE, Movie.class);
		objectTypeMap.put(ObjectType.MUSIC_ALBUM, MusicAlbum.class);
		objectTypeMap.put(ObjectType.NOTE, Note.class);
		objectTypeMap.put(ObjectType.PERSON, Person.class);
		objectTypeMap.put(ObjectType.PHOTO, Photo.class);
		objectTypeMap.put(ObjectType.PHOTO_ALBUM, PhotoAlbum.class);
		objectTypeMap.put(ObjectType.PLACE, Place.class);
		objectTypeMap.put(ObjectType.PLAYLIST, Playlist.class);
		objectTypeMap.put(ObjectType.REVIEW, Review.class);
		objectTypeMap.put(ObjectType.SONG, Song.class);
		objectTypeMap.put(ObjectType.TV_EPISODE, TVEpisode.class);
		objectTypeMap.put(ObjectType.VIDEO, Video.class);
		objectTypeMap.put(ObjectType.VIDEO_PODCAST, VideoPodcast.class);
		objectTypeMap.put(ObjectType.WEBLOG_ENTRY, WeblogEntry.class);
		objectTypeMap.put(ObjectType.BOOK, Book.class);
	}

	public ActivityEntry(Element internal) {
		super(internal);
	}

	public ActivityEntry(Factory factory) {
		super(factory, ActivityConstants.OBJECT);
	}

	public ActivityEntry(Factory factory, QName name) {
		super(factory, name);
	}

	public Verb getVerbElement() {
		return super.getExtension(ActivityConstants.VERB);
	}

	public IRI getVerb() {
		Verb v = getVerbElement();
		return null == v ? null : v.getValue();
	}

	public Verb setVerb(String verb, boolean normalize) {
		Verb existing = getVerbElement();
		if (null != existing) {
			existing.discard();
		}
		IRIElement newVerb = getFactory().newIRIElement(ActivityConstants.VERB, getInternal());
		if (normalize) {
			newVerb.setNormalizedValue(verb);
		} else {
			newVerb.setValue(verb);
		}
		return new Verb(newVerb);
	}

	public List<Object> getObjects() {
		return super.getExtensions(ActivityConstants.OBJECT);
	}

	public <T extends Object> List<T> getObjects(String objectType) {
		List<T> objects = new ArrayList<T>();
		for (Object o : this.getObjects()) {
			if (o.getObjectType().equals(objectType)) {
				objects.add((T) o);
			}
		}
		return objects;
	}

	public <T extends Object> T getObject(String objectType) {
		for (Object o : this.getObjects()) {
			if (o.getObjectType().equals(objectType)) {
				return (T) o;
			}
		}
		return null;
	}

	public Object addObject(String objectType) {
		Object o = addExtension(ActivityConstants.OBJECT);
		o.setObjectType(objectType);
		return o;
	}

	@SuppressWarnings("unchecked")
	public <T extends Object> T addTypedObject(String objectType) {
		Object o = this.addObject(objectType);
		T t = null;
		Class<? extends Object> impl = objectTypeMap.get(objectType);
		if (impl != null) {
			try {
				t = (T) impl.getConstructor(new Class[] { Object.class }).newInstance(
						new Object[] { o });
			} catch (Exception e) {
			}
		}
		return t != null ? t : (T) o;
	}

	public Object addObject(ObjectType type) {
		Object o = addExtension(ActivityConstants.OBJECT);
		o.setObjectTypeElement(type);
		return o;
	}

	public ActivityEntry addObject(Object object) {
		addExtension(object);
		return this;
	}

	public Object getActor() {
		return super.getExtension(ActivityConstants.ACTOR);
	}

	@SuppressWarnings("unchecked")
	public <T extends Object> T setActor(String objectType) {
		Object a = getActor();
		if (null != a) {
			a.discard();
		}
		Object o = super.addExtension(ActivityConstants.ACTOR);
		o.setObjectType(objectType);
		T t = null;
		Class<? extends Object> impl = objectTypeMap.get(objectType);
		if (impl != null) {
			try {
				t = (T) impl.getConstructor(new Class[] { Object.class }).newInstance(
						new Object[] { o });
			} catch (Exception e) {
			}
		}
		return t != null ? t : (T) o;
	}

	public Object getTarget() {
		return super.getExtension(ActivityConstants.TARGET);
	}

	@SuppressWarnings("unchecked")
	public <T extends Object> T setTarget(String objectType) {
		Object existing = getTarget();
		if (null != existing) {
			existing.discard();
		}
		Object o = super.addExtension(ActivityConstants.TARGET);
		o.setObjectType(objectType);
		T t = null;
		Class<? extends Object> impl = objectTypeMap.get(objectType);
		if (impl != null) {
			try {
				t = (T) impl.getConstructor(new Class[] { Object.class }).newInstance(
						new Object[] { o });
			} catch (Exception e) {
			}
		}
		return t != null ? t : (T) o;
	}

	public Provider getServiceProvider() {
		return super.getExtension(ServiceProviderConstants.PROVIDER);
	}

	public Provider setServiceProvider(String name, String uri, String iconUri) {
		Provider existing = getServiceProvider();
		if (null != existing) {
			existing.discard();
		}
		Provider provider = super.addExtension(ServiceProviderConstants.PROVIDER);
		provider.setName(name);
		provider.setUri(uri);
		provider.setIcon(iconUri);
		return provider;
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
