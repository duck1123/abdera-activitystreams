package com.cliqset.abdera.ext.activity.object;

import java.util.ArrayList;
import java.util.List;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import org.apache.abdera.model.Link;
import org.apache.abdera.model.Text;

import com.cliqset.abdera.ext.activity.Object;
import com.cliqset.abdera.ext.atommedia.MediaLink;
import com.cliqset.abdera.ext.poco.Gender;
import com.cliqset.abdera.ext.poco.Name;
import com.cliqset.abdera.ext.poco.PocoConstants;

public class Person extends Object {

	private static String REL_AVATAR = "avatar";

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

	public Person(Object object) {
		super(object.getInternal());
	}

	public String getDisplayName() {
		return super.getTitle();
	}

	public Text setDisplayName(String value) {
		return super.setTitle(value);
	}

	public List<MediaLink> getAvatars() {
		List<MediaLink> avatars = new ArrayList<MediaLink>();
		for (Link link : super.getLinks(REL_AVATAR)) {
			if (jpeg.match(link.getMimeType()) || png.match(link.getMimeType())
					|| gif.match(link.getMimeType())) {
				avatars.add(new MediaLink(link));
			}
		}
		return avatars;
	}

	public MediaLink addAvatar(String href, String mimeType) {
		Link link = getFactory().newLink(getInternal());
		link.setMimeType(mimeType);
		link.setRel(REL_AVATAR);
		link.setHref(href);
		return new MediaLink(link);
	}

	public MediaLink addAvatar(String href, String mimeType, int height, int width) {
		MediaLink link = new MediaLink(getFactory().newLink(getInternal()));
		link.setMimeType(mimeType);
		link.setRel(REL_AVATAR);
		link.setHref(href);
		link.setHeight(height);
		link.setWidth(width);
		return link;
	}

	public Name getNameElement() {
		return super.getExtension(PocoConstants.NAME);
	}

	public Name setName(String givenName, String familyName) {
		Name existing = getNameElement();
		if (null != existing) {
			existing.discard();
		}
		Name name = super.addExtension(PocoConstants.NAME);
		name.setGiven(givenName);
		name.setFamily(familyName);
		return name;
	}

	public Name setName(String honorificPrefix, String givenName, String familyName,
			String honorificSuffix) {
		Name name = setName(givenName, familyName);
		name.setHonorificPrefix(honorificPrefix);
		name.setHonorificSuffix(honorificSuffix);
		return name;
	}

	public String getGender() {
		Gender g = getGenderElement();
		if (null != g) {
			return g.getValue();
		}
		return null;
	}

	public Gender getGenderElement() {
		return super.getExtension(PocoConstants.GENDER);
	}

	public Gender setGender(String gender) {
		Gender existing = getGenderElement();
		if (null != existing) {
			existing.discard();
		}
		Gender g = super.addExtension(PocoConstants.GENDER);
		g.setValue(gender);
		return g;
	}
}
