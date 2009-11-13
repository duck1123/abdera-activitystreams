package com.cliqset.abdera.ext.atommedia;

import javax.activation.MimeType;
import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ExtensibleElementWrapper;
import org.apache.abdera.model.Link;
import org.apache.abdera.util.Constants;

public class LinkWrapper extends ExtensibleElementWrapper implements Link {

	protected LinkWrapper(Element internal) {
		super(internal);
	}

	public LinkWrapper(Factory factory, QName qname) {
		super(factory, qname);
	}

	public IRI getHref() {
		String href = getAttributeValue(Constants.HREF);
		return null == href ? null : new IRI(href);
	}

	public IRI getResolvedHref() {
		IRI base = getResolvedBaseUri();
		return null == base ? null : base.resolve(getHref());
	}

	public Link setHref(String href) {
		if (href != null)
			setAttributeValue(Constants.HREF, (new IRI(href)).toString());
		else
			removeAttribute(Constants.HREF);
		return this;
	}

	public String getRel() {
		return getAttributeValue(Constants.REL);
	}

	public Link setRel(String rel) {
		setAttributeValue(Constants.REL, rel);
		return this;
	}

	public MimeType getMimeType() {
		try {
			String type = getAttributeValue(Constants.TYPE);
			return (type != null) ? new MimeType(type) : null;
		} catch (javax.activation.MimeTypeParseException e) {
			throw new org.apache.abdera.util.MimeTypeParseException(e);
		}
	}

	public void setMimeType(MimeType type) {
		complete();
		setAttributeValue(Constants.TYPE, (type != null) ? type.toString() : null);
	}

	public Link setMimeType(String type) {
		complete();
		try {
			if (type != null)
				setAttributeValue(Constants.TYPE, (new MimeType(type)).toString());
			else
				removeAttribute(Constants.TYPE);
		} catch (javax.activation.MimeTypeParseException e) {
			throw new org.apache.abdera.util.MimeTypeParseException(e);
		}
		return this;
	}

	public String getHrefLang() {
		return getAttributeValue(Constants.HREFLANG);
	}

	public Link setHrefLang(String lang) {
		complete();
		if (lang != null)
			setAttributeValue(Constants.HREFLANG, lang);
		else
			removeAttribute(Constants.HREFLANG);
		return this;
	}

	public String getTitle() {
		return getAttributeValue(Constants.ATITLE);
	}

	public Link setTitle(String title) {
		complete();
		if (title != null)
			setAttributeValue(Constants.ATITLE, title);
		else
			removeAttribute(Constants.ATITLE);
		return this;
	}

	public long getLength() {
		String l = getAttributeValue(Constants.LENGTH);
		return (l != null) ? Long.valueOf(l) : -1;
	}

	public Link setLength(long length) {
		complete();
		if (length > -1)
			setAttributeValue(Constants.LENGTH, (length >= 0) ? String.valueOf(length) : "0");
		else
			removeAttribute(Constants.LENGTH);
		return this;
	}

	public String getValue() {
		return getText();
	}

	public void setValue(String value) {
		complete();
		if (value != null)
			((Element) this).setText(value);
	}

}
