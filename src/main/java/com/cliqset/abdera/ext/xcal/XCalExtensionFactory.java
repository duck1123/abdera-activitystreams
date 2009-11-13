package com.cliqset.abdera.ext.xcal;

import org.apache.abdera.util.AbstractExtensionFactory;

public class XCalExtensionFactory extends AbstractExtensionFactory {

	public XCalExtensionFactory() {
		super(XCalConstants.XCAL_NS);
		addImpl(XCalConstants.DTSTART, DTStart.class);
		addImpl(XCalConstants.DTEND, DTEnd.class);
		addImpl(XCalConstants.LOCATION, Location.class);
	}
}
