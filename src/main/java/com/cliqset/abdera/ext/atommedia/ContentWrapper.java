package com.cliqset.abdera.ext.atommedia;

import javax.activation.DataHandler;
import javax.activation.MimeType;
import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Content;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ExtensibleElementWrapper;
import org.apache.abdera.util.Constants;

public class ContentWrapper extends ExtensibleElementWrapper implements Content {

	protected Type type = Type.TEXT;

	public ContentWrapper(Element internal) {
		super(internal);
	}

	protected ContentWrapper(Factory factory, QName qname) {
		super(factory, qname);
	}

	public Type getContentType() {
		return type;
	}

	public DataHandler getDataHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	public MimeType getMimeType() {
		if (getContentType().equals(Content.Type.MEDIA)) {
			try {
				String type = getAttributeValue(Constants.TYPE);
				return (type != null) ? new MimeType(type) : null;
			} catch (javax.activation.MimeTypeParseException e) {
				throw new org.apache.abdera.util.MimeTypeParseException(e);
			}
		}
		return null;
	}

	public IRI getResolvedSrc() {
		return null;
	}

	public IRI getSrc() {
		return new IRI(super.getAttributeValue(Constants.SRC));
	}

	public String getValue() {
		return super.getText();
	}

	public <T extends Element> T getValueElement() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWrappedValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Content setContentType(Type type) {
		this.type = type;
		if (Type.TEXT.equals(type))
			setAttributeValue(Constants.TYPE, "text");
		else if (Type.HTML.equals(type))
			setAttributeValue(Constants.TYPE, "html");
		else if (Type.XHTML.equals(type))
			setAttributeValue(Constants.TYPE, "xhtml");
		else if (Type.XML.equals(type))
			setAttributeValue(Constants.TYPE, "application/xml");
		else {
			removeAttribute(Constants.TYPE);
		}
		return this;
	}

	public Content setDataHandler(DataHandler dataHandler) {
		// TODO Auto-generated method stub
		return null;
	}

	public Content setMimeType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Content setSrc(String src) {
		super.setAttributeValue(Constants.SRC, src);
		return this;
	}

	public Content setValue(String value) {
		super.setText(value);
		return this;
	}

	public <T extends Element> Content setValueElement(T value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Content setWrappedValue(String wrappedValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
