package com.cliqset.abdera.ext.poco;

import org.apache.abdera.util.AbstractExtensionFactory;

public class PocoExtensionFactory extends AbstractExtensionFactory {

	public PocoExtensionFactory() {
		super(PocoConstants.POCO_NS);
		addImpl(PocoConstants.NAME, Name.class);
		addImpl(PocoConstants.GENDER, Gender.class);
		addImpl(PocoConstants.BIRTHDAY, Birthday.class);
		addImpl(PocoConstants.ADDRESS, Address.class);
	}
}