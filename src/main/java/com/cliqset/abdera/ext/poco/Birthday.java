package com.cliqset.abdera.ext.poco;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.model.DateTimeWrapper;
import org.apache.abdera.model.Element;

public class Birthday extends DateTimeWrapper {

	public Birthday(Element internal) {
		super(internal);
	}

	public Birthday(Factory factory, QName qname) {
		super(factory, qname);
	}
}
