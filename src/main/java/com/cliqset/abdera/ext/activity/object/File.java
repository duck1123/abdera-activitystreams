package com.cliqset.abdera.ext.activity.object;

import java.util.List;

import javax.activation.MimeType;

import org.apache.abdera.model.Link;

import com.cliqset.abdera.ext.activity.Object;

public class File extends Object {

	public File(Object object) {
		super(object.getInternal());
	}

	public List<Link> getAssociatedFileUrls() {
		return super.getLinks(Link.REL_ENCLOSURE);
	}

	public Link getAssociatedFileUrl(MimeType type) {
		List<Link> links = super.getLinks(Link.REL_ENCLOSURE);
		for (Link link : links) {
			if (link.getMimeType().equals(type)) {
				return link;
			}
		}
		return null;
	}

	public Link addAssociatedFileUrl(String href, String type) {
		Link link = getFactory().newLink(getInternal());
		link.setHref(href);
		link.setMimeType(type);
		link.setRel(Link.REL_ENCLOSURE);
		return link;
	}

	public Link getPageLink() {
		return super.getPageLink();
	}

	public Link setPageLink(String href) {
		return super.setPageLink(href);
	}

}
