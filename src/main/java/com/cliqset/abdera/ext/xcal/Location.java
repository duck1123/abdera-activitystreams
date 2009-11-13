package com.cliqset.abdera.ext.xcal;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ElementWrapper;

public class Location extends ElementWrapper {

	public Location(Element internal) {
		super(internal);
	}

	public Location(Factory factory, QName qname) {
		super(factory, qname);
	}
}
