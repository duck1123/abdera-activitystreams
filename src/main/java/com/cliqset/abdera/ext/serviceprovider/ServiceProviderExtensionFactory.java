package com.cliqset.abdera.ext.serviceprovider;

import org.apache.abdera.util.AbstractExtensionFactory;

public class ServiceProviderExtensionFactory extends AbstractExtensionFactory {

	public ServiceProviderExtensionFactory() {
		super(ServiceProviderConstants.SERVICE_PROVIDER_NS);
		addImpl(ServiceProviderConstants.PROVIDER, Provider.class);
	}
}
