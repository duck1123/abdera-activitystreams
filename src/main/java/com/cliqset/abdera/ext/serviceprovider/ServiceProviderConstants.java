package com.cliqset.abdera.ext.serviceprovider;

import javax.xml.namespace.QName;

public class ServiceProviderConstants {

	public static final String SERVICE_PROVIDER_NS = "http://activitystrea.ms/service-provider";

	public static final String LN_PROVIDER = "provider";

	public static final QName PROVIDER = new QName(SERVICE_PROVIDER_NS, LN_PROVIDER, "service");
}
