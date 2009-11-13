package com.cliqset.abdera.ext.activity.object;

import com.cliqset.abdera.ext.activity.Object;

public class Movie extends Object {

	public Movie(Object internal) {
		super(internal.getInternal());
	}
}
