package com.cliqset.abdera.ext.activity.object;

import com.cliqset.abdera.ext.activity.Object;

public class TVEpisode extends Object {

	public TVEpisode(Object object) {
		super(object.getInternal());
	}
}
