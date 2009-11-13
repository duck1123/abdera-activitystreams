package com.cliqset.abdera.ext.activity.object;

import org.apache.abdera.model.Link;

import com.cliqset.abdera.ext.activity.Object;

public class Bookmark extends Object {

	public Bookmark(Object object) {
		super(object.getInternal());
	}

	public Link getTargetURL() {
		return super.getLink(Link.REL_RELATED);
	}

	public Link setTargetURL(String href, String title) {
		Link link = getFactory().newLink(getInternal());
		link.setRel(Link.REL_RELATED);
		link.setHref(href);
		link.setTitle(title);
		return link;
	}

	public Link getPageLink() {
		return super.getPageLink();
	}

	public Link setPageLink(String href) {
		return super.setPageLink(href);
	}

	public String getTargetTitle() {
		Link target = this.getTargetURL();
		return (null == target ? null : target.getTitle());
	}

	public void setTargetTitle(String title) {
		Link target = this.getTargetURL();
		if (null != target) {
			target.setTitle(title);
		}
	}
}
