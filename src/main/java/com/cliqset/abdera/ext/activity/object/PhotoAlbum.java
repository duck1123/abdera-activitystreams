package com.cliqset.abdera.ext.activity.object;

import org.apache.abdera.model.Link;

import com.cliqset.abdera.ext.activity.Object;

public class PhotoAlbum extends Object {

	public PhotoAlbum(Object object) {
		super(object.getInternal());
	}

	public Link getPageLink() {
		return super.getPageLink();
	}

	public Link setPageLink(String href) {
		return super.setPageLink(href);
	}
}
