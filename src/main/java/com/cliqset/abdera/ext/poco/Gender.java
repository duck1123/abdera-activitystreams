package com.cliqset.abdera.ext.poco;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ExtensibleElementWrapper;

public class Gender extends ExtensibleElementWrapper {

	public static final String MALE = "male";
	public static final String FEMALE = "female";
	public static final String UNDISCLOSED = "undisclosed";

	public Gender(Element internal) {
		super(internal);
	}

	public Gender(Factory factory, QName qname) {
		super(factory, qname);
	}

	public String getValue() {
		return super.getText();
	}

	public void setValue(String gender) {
		super.setText(gender);
	}

	public boolean isMale() {
		return isValue(MALE);
	}

	public boolean isFemale() {
		return isValue(FEMALE);
	}

	public boolean isUndisclosed() {
		return isValue(UNDISCLOSED);
	}

	public boolean isValue(String value) {
		String v = getValue();
		return (v == null ? false : v == value);
	}
}
