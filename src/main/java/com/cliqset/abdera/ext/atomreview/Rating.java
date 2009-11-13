package com.cliqset.abdera.ext.atomreview;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ElementWrapper;

public class Rating extends ElementWrapper {

	public Rating(Element internal) {
		super(internal);
	}

	protected Rating(Factory factory, QName qname) {
		super(factory, qname);
	}

	public Float getValue() {
		String text = super.getText();
		Float value = null;
		try {
			value = Float.parseFloat(text);
		} catch (NumberFormatException nfe) {
			super.setText((String) null);
		}
		return value;
	}

	public void setValue(Float value) {
		super.setText(Float.toString(value));
	}

	public Float getWorst() {
		String text = super.getAttributeValue(ReviewConstants.WORST);
		Float value = null;
		try {
			value = Float.parseFloat(text);
		} catch (NumberFormatException nfe) {
			super.setAttributeValue(ReviewConstants.WORST, (String) null);
		}
		return value;
	}

	public void setWorst(Float value) {
		super.setAttributeValue(ReviewConstants.WORST, Float.toString(value));
	}

	public Float getBest() {
		String text = super.getAttributeValue(ReviewConstants.BEST);
		Float value = null;
		try {
			value = Float.parseFloat(text);
		} catch (NumberFormatException nfe) {
			super.setAttributeValue(ReviewConstants.BEST, (String) null);
		}
		return value;
	}

	public void setBest(Float value) {
		super.setAttributeValue(ReviewConstants.BEST, Float.toString(value));
	}
}
