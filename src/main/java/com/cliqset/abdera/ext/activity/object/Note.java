package com.cliqset.abdera.ext.activity.object;

import org.apache.abdera.model.Link;

import com.cliqset.abdera.ext.activity.Object;

public class Note extends Object {

	public Note(Object object) {
		super(object.getInternal());
	}

	public Link getPermalink() {
		return super.getPageLink();
	}

	public Link setPermaLink(String href) {
		return super.setPageLink(href);
	}
}
