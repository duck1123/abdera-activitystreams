package com.cliqset.abdera.ext.activity;

import org.apache.abdera.util.AbstractExtensionFactory;

public class ActivityExtensionFactory extends AbstractExtensionFactory {

	public ActivityExtensionFactory() {
		super(ActivityConstants.ACTIVITY_NS);
		addImpl(ActivityConstants.ACTOR, Object.class);
		addImpl(ActivityConstants.OBJECT, Object.class);
		addImpl(ActivityConstants.OBJECT_TYPE, ObjectType.class);
		addImpl(ActivityConstants.TARGET, Object.class);
		addImpl(ActivityConstants.VERB, Verb.class);
	}
}
