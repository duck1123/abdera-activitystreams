package com.cliqset.abdera.ext.activity.object;

import java.util.ArrayList;
import java.util.List;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import org.apache.abdera.model.Link;
import org.apache.abdera.model.Text;

import com.cliqset.abdera.ext.activity.Object;
import com.cliqset.abdera.ext.atommedia.MediaLink;

public class Group extends Object {
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

	public Group(Object object) {
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
}
