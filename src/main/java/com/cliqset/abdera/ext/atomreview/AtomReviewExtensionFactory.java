package com.cliqset.abdera.ext.atomreview;

import org.apache.abdera.model.DateTimeWrapper;
import org.apache.abdera.util.AbstractExtensionFactory;

public class AtomReviewExtensionFactory extends AbstractExtensionFactory {

	public AtomReviewExtensionFactory() {
		super(ReviewConstants.REVIEW_NS);
		addImpl(ReviewConstants.RATING, Rating.class);
		addImpl(ReviewConstants.REVIEWED, DateTimeWrapper.class);
	}
}
