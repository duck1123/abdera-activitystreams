package com.cliqset.abdera.ext.activity.object;

import java.util.Date;

import org.apache.abdera.model.DateTime;
import org.apache.abdera.model.Link;

import com.cliqset.abdera.ext.activity.Object;
import com.cliqset.abdera.ext.atomreview.Rating;
import com.cliqset.abdera.ext.atomreview.ReviewConstants;

public class Review extends Object {

	public Review(Object object) {
		super(object.getInternal());
	}

	public Link getPermalink() {
		return super.getPageLink();
	}

	public Link setPermaLink(String href) {
		return super.setPageLink(href);
	}

	public DateTime getReviewedElement() {
		return super.getExtension(ReviewConstants.REVIEWED);
	}

	public Date getReviewed() {
		DateTime reviewedElement = getReviewedElement();
		if (null != reviewedElement) {
			return reviewedElement.getDate();
		}
		return null;
	}

	public DateTime setReviewed(Date reviewed) {
		DateTime existing = getReviewedElement();
		if (null != existing) {
			existing.discard();
		}
		DateTime reviewedElement = super.addExtension(ReviewConstants.REVIEWED);
		reviewedElement.setDate(reviewed);
		return reviewedElement;
	}

	public Float getRating() {
		Rating rating = getRatingElement();
		if (null != rating) {
			return rating.getValue();
		}
		return null;
	}

	public Rating getRatingElement() {
		return super.getExtension(ReviewConstants.RATING);
	}

	public Rating setRating(float rating) {
		Rating ratingElement = super.addExtension(ReviewConstants.RATING);
		ratingElement.setValue(rating);
		return ratingElement;
	}

	public Rating setRating(float rating, float worst, float best) {
		Rating existing = getRatingElement();
		if (null != existing) {
			existing.discard();
		}
		Rating ratingElement = super.addExtension(ReviewConstants.RATING);
		ratingElement.setValue(rating);
		ratingElement.setWorst(worst);
		ratingElement.setBest(best);
		return ratingElement;
	}
}
