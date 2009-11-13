package com.cliqset.abdera.ext.atommedia;

import org.apache.abdera.util.AbstractExtensionFactory;

public class AtomMediaExtensionFactory extends AbstractExtensionFactory {

	public AtomMediaExtensionFactory() {
		super(MediaConstants.MEDIA_NS);
		addImpl(MediaConstants.DESCRIPTION, MediaDescription.class);
	}
}
