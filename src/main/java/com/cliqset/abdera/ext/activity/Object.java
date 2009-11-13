package com.cliqset.abdera.ext.activity;

import java.util.ArrayList;
import java.util.List;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Content;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.ExtensibleElement;
import org.apache.abdera.model.IRIElement;
import org.apache.abdera.model.Link;

import com.cliqset.abdera.ext.atommedia.MediaConstants;
import com.cliqset.abdera.ext.atommedia.MediaDescription;
import com.cliqset.abdera.ext.atommedia.MediaLink;

public class Object extends EntryWrapper {

	private static final String REL_PREVIEW = "preview";

	private static MimeType jpeg = null;
	private static MimeType png = null;
	private static MimeType gif = null;
	private static MimeType textHtml = null;
	private static MimeType imageWildcard = null;
	private static MimeType imageUnknown = null;

	static {
		try {
			jpeg = new MimeType("image/jpeg");
			png = new MimeType("image/png");
			gif = new MimeType("image/gif");
			textHtml = new MimeType("text/html");
			imageWildcard = new MimeType("image/*");
			imageUnknown = new MimeType("image/unknown");
		} catch (MimeTypeParseException mtpe) {
			throw new org.apache.abdera.util.MimeTypeParseException(mtpe);
		}
	}

	public static Link getPageLink(Object object) {
		return object.getPageLink();
	}

	public Object(Element internal) {
		super(internal);
	}

	public Object(Factory factory) {
		super(factory, ActivityConstants.OBJECT);
	}

	public Object(Factory factory, QName name) {
		super(factory, name);
	}

	public IRI getObjectType() {
		return getObjectTypeElement().getValue();
	}

	public ObjectType getObjectTypeElement() {
		return super.getFirstChild(ActivityConstants.OBJECT_TYPE);
	}

	public List<ObjectType> getObjectTypes() {
		return super.getExtensions(ActivityConstants.OBJECT_TYPE);
	}

	public ObjectType setObjectType(String type) {
		ObjectType objectType = getFactory().newExtensionElement(ActivityConstants.OBJECT_TYPE,
				getExtInternal());
		objectType.setValue(type);
		return objectType;
	}

	public Entry setObjectTypeElement(ObjectType type) {
		ExtensibleElement internal = getExtInternal();
		IRIElement existing = getObjectTypeElement();
		if (null != existing) {
			existing.discard();
		}
		if (type != null) {
			internal.addExtension(type);
		}
		return this;
	}

	public List<MediaLink> getThumbnailsStrict() {
		List<MediaLink> thumbnails = new ArrayList<MediaLink>();
		for (Link link : super.getLinks(REL_PREVIEW)) {
			if (null != link.getMimeType()
					&& (jpeg.match(link.getMimeType()) || png.match(link.getMimeType()) || gif
							.match(link.getMimeType()))) {
				thumbnails.add(new MediaLink(link));
			}
		}
		return thumbnails;
	}

	public List<MediaLink> getThumbnails() {
		List<MediaLink> thumbnails = new ArrayList<MediaLink>();
		for (Link link : super.getLinks(REL_PREVIEW)) {
			if (null != link.getMimeType() && imageWildcard.match(link.getMimeType())) {
				thumbnails.add(new MediaLink(link));
			}
		}
		return thumbnails;
	}

	public MediaLink getThumbnail() {
		List<MediaLink> thumbnails = getThumbnails();
		return (null == thumbnails || thumbnails.size() < 1 ? null : thumbnails.get(0));
	}

	public Object addThumbnail(MediaLink link) {
		if (null == link.getMimeType()) {
			link.setMimeType(imageUnknown);
		}
		link.setRel(REL_PREVIEW);
		addExtension(link);
		return this;
	}

	public MediaLink addThumbnail(String href, String mimeType) {
		Link link = getFactory().newLink(getInternal());
		link.setMimeType(mimeType);
		link.setRel(REL_PREVIEW);
		link.setHref(href);
		return new MediaLink(link);
	}

	public MediaLink addThumbnail(String href, String mimeType, int height, int width) {
		MediaLink link = new MediaLink(getFactory().newLink(getInternal()));
		link.setMimeType(mimeType);
		link.setRel(REL_PREVIEW);
		link.setHref(href);
		link.setHeight(height);
		link.setWidth(width);
		return link;
	}

	protected Link getPageLink() {
		List<Link> links = super.getLinks();
		if (null != links) {
			for (Link link : links) {
				if (null != link && Link.REL_ALTERNATE.equals(link.getRel())
						&& textHtml.match(link.getMimeType())) {
					return link;
				}
			}
		}
		return null;
	}

	protected Link setPageLink(String href) {
		Link existing = getPageLink();
		if (null != existing) {
			existing.discard();
		}
		Link pageLink = getFactory().newLink(getInternal());
		pageLink.setRel(Link.REL_ALTERNATE);
		pageLink.setMimeType(textHtml.toString());
		pageLink.setHref(href);
		return pageLink;
	}

	protected MediaDescription getDescription() {
		return this.getExtInternal().getExtension(MediaConstants.DESCRIPTION);
	}

	protected MediaDescription setDescription(String description) {
		return this.setDescription(description, Content.Type.TEXT);
	}

	protected MediaDescription setDescription(String description, Content.Type type) {
		MediaDescription md = getExtInternal().addExtension(MediaConstants.DESCRIPTION);
		md.setText(description);
		md.setContentType(type);
		return md;
	}
}
