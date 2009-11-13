package com.cliqset.abdera.ext.poco;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ExtensibleElement;
import org.apache.abdera.model.ExtensibleElementWrapper;

public class Name extends ExtensibleElementWrapper {

	public Name(Element internal) {
		super(internal);
	}

	public Name(Factory factory, QName qname) {
		super(factory, qname);
	}

	public Element getFormattedElement() {
		return super.getFirstChild(PocoConstants.FORMATTED);
	}

	public String getFormatted() {
		Element name = getFormattedElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setFormatted(String formattedName) {
		ExtensibleElement internal = getExtInternal();
		Element el = getFormattedElement();
		if (formattedName != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.FORMATTED, internal);
			el.setText(formattedName);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	public Element getFamilyElement() {
		return super.getFirstChild(PocoConstants.FAMILY_NAME);
	}

	public String getFamily() {
		Element name = getFamilyElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setFamily(String familyName) {
		ExtensibleElement internal = getExtInternal();
		Element el = getFamilyElement();
		if (familyName != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.FAMILY_NAME, internal);
			el.setText(familyName);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	public Element getGivenElement() {
		return super.getFirstChild(PocoConstants.GIVEN_NAME);
	}

	public String getGiven() {
		Element name = getGivenElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setGiven(String givenName) {
		ExtensibleElement internal = getExtInternal();
		Element el = getGivenElement();
		if (givenName != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.GIVEN_NAME, internal);
			el.setText(givenName);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	public Element getMiddleElement() {
		return super.getFirstChild(PocoConstants.MIDDLE_NAME);
	}

	public String getMiddle() {
		Element name = getMiddleElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setMiddle(String middleName) {
		ExtensibleElement internal = getExtInternal();
		Element el = getMiddleElement();
		if (middleName != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.MIDDLE_NAME, internal);
			el.setText(middleName);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	public Element getHonorificPrefixElement() {
		return super.getFirstChild(PocoConstants.HONORIFIC_PREFIX);
	}

	public String getHonorificPrefix() {
		Element name = getHonorificPrefixElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setHonorificPrefix(String honorificPrefix) {
		ExtensibleElement internal = getExtInternal();
		Element el = getHonorificPrefixElement();
		if (honorificPrefix != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.HONORIFIC_PREFIX, internal);
			el.setText(honorificPrefix);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}

	public Element getHonorificSuffixElement() {
		return super.getFirstChild(PocoConstants.HONORIFIC_SUFFIX);
	}

	public String getHonorificSuffix() {
		Element name = getHonorificSuffixElement();
		return (name != null) ? name.getText() : null;
	}

	public Element setHonorificSuffix(String honorificSuffix) {
		ExtensibleElement internal = getExtInternal();
		Element el = getHonorificSuffixElement();
		if (honorificSuffix != null) {
			if (el == null)
				el = internal.getFactory().newElement(PocoConstants.HONORIFIC_SUFFIX, internal);
			el.setText(honorificSuffix);
			return el;
		} else {
			if (el != null)
				el.discard();
			return null;
		}
	}
}
