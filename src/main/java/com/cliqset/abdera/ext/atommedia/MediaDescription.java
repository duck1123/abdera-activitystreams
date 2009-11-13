package com.cliqset.abdera.ext.atommedia;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.model.Element;

public class MediaDescription extends ContentWrapper {

	public MediaDescription(Element internal) {
		super(internal);
	}

	protected MediaDescription(Factory factory, QName qname) {
		super(factory, qname);
	}

}
