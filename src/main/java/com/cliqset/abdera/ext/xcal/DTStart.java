package com.cliqset.abdera.ext.xcal;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ElementWrapper;

public class DTStart extends ElementWrapper {

	public DTStart(Element internal) {
		super(internal);
	}

	public DTStart(Factory factory, QName qname) {
		super(factory, qname);
	}

	public void setValue(Date value) {
		SimpleDateFormat formatter = new SimpleDateFormat(XCalConstants.DATE_FORMAT_STRING);
		super.setText(formatter.format(value));
	}

	public Date getValue() {
		String value = super.getText();
		if (null != value) {
			try {
				return new SimpleDateFormat(XCalConstants.DATE_FORMAT_STRING).parse(value);
			} catch (Exception e) {
			}
		}
		return null;
	}
}
