package com.cliqset.abdera.ext.serviceprovider;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ExtensibleElement;
import org.apache.abdera.model.ExtensibleElementWrapper;
import org.apache.abdera.model.IRIElement;
import org.apache.abdera.util.Constants;

public class Provider extends ExtensibleElementWrapper {

	public Provider(Element internal) {
		super(internal);
	}

	public Provider(Factory factory, QName qname) {
		super(factory, qname);
	}

	public String getName() {
		Element name = getNameElement();
		return (name != null) ? name.getText() : null;
	}

	public Element getNameElement() {
		return getInternal().getFirstChild(Constants.NAME);
	}

	public IRI getIcon() {
		IRIElement icon = getIconElement();
		return (icon != null) ? icon.getValue() : null;
	}

	public IRIElement getIconElement() {
		return getInternal().getFirstChild(Constants.ICON);
	}

	public IRI getUri() {
		IRIElement uri = getUriElement();
		return (uri != null) ? uri.getValue() : null;
	}

	public IRIElement getUriElement() {
		return getInternal().getFirstChild(Constants.URI);
	}

	public Element setName(String name) {
		ExtensibleElement internal = getExtInternal();
		Element el = getNameElement();
		if (name != null) {
			if (el == null)
				el = internal.getFactory().newName(internal);
			el.setText(name);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	public Provider setNameElement(Element element) {
		ExtensibleElement internal = getExtInternal();
		Element el = getNameElement();
		if (el != null)
			el.discard();
		if (element != null)
			internal.addExtension(element);
		return this;
	}

	public IRIElement setUri(String uri) {
		ExtensibleElement internal = getExtInternal();
		IRIElement el = getUriElement();
		if (uri != null) {
			if (el == null)
				el = internal.getFactory().newIRIElement(Constants.URI, internal);
			el.setText(uri.toString());
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	public Provider setUriElement(IRIElement element) {
		ExtensibleElement internal = getExtInternal();
		Element el = getUriElement();
		if (el != null)
			el.discard();
		if (element != null)
			internal.addExtension(element);
		return this;
	}

	public IRIElement setIcon(String uri) {
		ExtensibleElement internal = getExtInternal();
		IRIElement el = getIconElement();
		if (uri != null) {
			if (el == null)
				el = internal.getFactory().newIRIElement(Constants.ICON, internal);
			el.setText(uri.toString());
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	public Provider setIconElement(IRIElement element) {
		ExtensibleElement internal = getExtInternal();
		Element el = getIconElement();
		if (el != null)
			el.discard();
		if (element != null)
			internal.addExtension(element);
		return this;
	}
}
