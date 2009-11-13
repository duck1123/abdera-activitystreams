package com.cliqset.abdera.ext.activity.object;

import java.util.List;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import org.apache.abdera.model.Content;
import org.apache.abdera.model.Link;

import com.cliqset.abdera.ext.activity.Object;
import com.cliqset.abdera.ext.atommedia.MediaDescription;
import com.cliqset.abdera.ext.atommedia.MediaLink;

public class Audio extends Object {

	private static MimeType allAudio = null;

	static {
		try {
			allAudio = new MimeType("audio/*");
		} catch (MimeTypeParseException mtpe) {
			throw new org.apache.abdera.util.MimeTypeParseException(mtpe);
		}
	}

	public Audio(Object object) {
		super(object.getInternal());
	}

	public Link getPageLink() {
		return super.getPageLink();
	}

	public Link setPageLink(String href) {
		return super.setPageLink(href);
	}

	public MediaLink getAudioStream() {
		for (Link link : super.getLinks(Link.REL_ENCLOSURE)) {
			if (allAudio.match(link.getMimeType())) {
				return new MediaLink(link);
			}
		}
		return null;
	}

	public MediaLink setAudioStream(String href, String type) {
		MediaLink existing = getAudioStream();
		if (null != existing) {
			existing.discard();
		}
		Link link = getFactory().newLink(getInternal());
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
