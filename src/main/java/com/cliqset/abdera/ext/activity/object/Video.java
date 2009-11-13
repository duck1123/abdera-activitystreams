package com.cliqset.abdera.ext.activity.object;

import java.util.List;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import org.apache.abdera.model.Content;
import org.apache.abdera.model.Link;

import com.cliqset.abdera.ext.activity.Object;
import com.cliqset.abdera.ext.atommedia.MediaDescription;
import com.cliqset.abdera.ext.atommedia.MediaLink;

public class Video extends Object {

	private static MimeType allVideo = null;

	static {
		try {
			allVideo = new MimeType("video/*");
		} catch (MimeTypeParseException mtpe) {
			throw new org.apache.abdera.util.MimeTypeParseException(mtpe);
		}
	}

	public Video(Object object) {
		super(object.getInternal());
	}

	public Link getPageLink() {
		return super.getPageLink();
	}

	public Link setPageLink(String href) {
		return super.setPageLink(href);
	}

	public MediaLink getVideoStream() {
		for (Link link : super.getLinks(Link.REL_ENCLOSURE)) {
			if (allVideo.match(link.getMimeType())) {
				return new MediaLink(link);
			}
		}
		return null;
	}

	public MediaLink setVideoStream(String href, String type) {
		MediaLink existing = getVideoStream();
		if (null != existing) {
			existing.discard();
		}
		Link link = getFactory().newLink(getInternal());
		link.setRel(Link.REL_ENCLOSURE);
		link.setHref(href);
		link.setMimeType(type);
		return new MediaLink(link);
	}

	public List<Link> getPlayerApplets() {
		return super.getLinks(Link.REL_ALTERNATE);
	}

	public Link addPlayerApplet(String href, String type) {
		Link link = getFactory().newLink(getInternal());
		link.setRel(Link.REL_ALTERNATE);
		link.setHref(href);
		link.setMimeType(type);
		return link;
	}

	public MediaDescription getDescription() {
		return super.getDescription();
	}

	public MediaDescription setDescription(String description) {
		return super.setDescription(description);
	}

	public MediaDescription setDescription(String description, Content.Type type) {
		return super.setDescription(description, type);
	}
}
