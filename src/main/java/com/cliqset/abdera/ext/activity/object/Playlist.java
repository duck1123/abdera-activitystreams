package com.cliqset.abdera.ext.activity.object;

import java.util.List;

import org.apache.abdera.model.Link;

import com.cliqset.abdera.ext.activity.Object;
import com.cliqset.abdera.ext.atommedia.MediaLink;

public class Playlist extends Object {

	public Playlist(Object object) {
		super(object.getInternal());
	}

	public MediaLink getThumbnail() {
		return super.getThumbnail();
	}

	public List<MediaLink> getThumbnails() {
		return super.getThumbnails();
	}

	public MediaLink addThumbnail(String href, String mimeType) {
		return super.addThumbnail(href, mimeType);
	}

	public MediaLink addThumbnail(String href, String mimeType, int height, int width) {
		return super.addThumbnail(href, mimeType, height, width);
	}

	public Link getPageLink() {
		return super.getPageLink();
	}

	public Link setPageLink(String href) {
		return super.setPageLink(href);
	}
}
