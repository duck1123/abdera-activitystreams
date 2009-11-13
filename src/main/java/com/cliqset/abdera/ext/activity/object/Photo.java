package com.cliqset.abdera.ext.activity.object;

import java.util.Date;

import com.cliqset.abdera.ext.activity.Object;

public class Photo extends Image {

	public Photo(Object object) {
		super(object);
	}

	public Date getPhotoTakenDate() {
		throw new UnsupportedOperationException();
	}
}
