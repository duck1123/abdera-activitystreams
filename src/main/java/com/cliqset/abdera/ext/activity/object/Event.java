package com.cliqset.abdera.ext.activity.object;

import com.cliqset.abdera.ext.activity.Object;

public class Event extends Object {

	public Event(Object object) {
		super(object.getInternal());
	}
}
