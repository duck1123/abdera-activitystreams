package com.cliqset.abdera.ext.atommedia;

import org.apache.abdera.model.Element;

public class MediaLink extends LinkWrapper {

	public MediaLink(Element internal) {
		super(internal);
	}

	public int getWidth() {
		String width = getAttributeValue(MediaConstants.WIDTH);
		return (width != null) ? Integer.parseInt(width) : -1;
	}

	public void setWidth(int width) {
		if (width > -1) {
			setAttributeValue(MediaConstants.WIDTH, String.valueOf(width));
		} else {
			removeAttribute(MediaConstants.HEIGHT);
		}
	}

	public int getHeight() {
		String height = getAttributeValue(MediaConstants.HEIGHT);
		return (height != null) ? Integer.parseInt(height) : -1;
	}

	public void setHeight(int height) {
		if (height > -1) {
			setAttributeValue(MediaConstants.HEIGHT, String.valueOf(height));
		} else {
			removeAttribute(MediaConstants.HEIGHT);
		}
	}

	public int getDuration() {
		String c = getAttributeValue(MediaConstants.DURATION);
		return (c != null) ? Integer.parseInt(c) : -1;
	}

	public void setDuration(int duration) {
		if (duration > -1)
			setAttributeValue(MediaConstants.DURATION, String.valueOf(duration));
		else
			removeAttribute(MediaConstants.DURATION);
	}
}
