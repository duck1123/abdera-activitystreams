package com.cliqset.abdera.ext.activity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.MimeType;
import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Category;
import org.apache.abdera.model.Content;
import org.apache.abdera.model.Control;
import org.apache.abdera.model.DateTime;
import org.apache.abdera.model.Div;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.ExtensibleElement;
import org.apache.abdera.model.ExtensibleElementWrapper;
import org.apache.abdera.model.IRIElement;
import org.apache.abdera.model.Link;
import org.apache.abdera.model.Person;
import org.apache.abdera.model.Source;
import org.apache.abdera.model.Text;
import org.apache.abdera.model.Content.Type;
import org.apache.abdera.util.Constants;

public class EntryWrapper extends ExtensibleElementWrapper implements Entry {

	public EntryWrapper(Element internal) {
		super(internal);
	}

	public EntryWrapper(Factory factory, QName qname) {
		super(factory, qname);
	}

	public Entry addAuthor(Person person) {
		addExtension(person);
		return this;
	}

	public Person addAuthor(String name) {
		Person author = getFactory().newAuthor(getInternal());
		author.setName(name);
		return author;
	}

	public Person addAuthor(String name, String email, String uri) {
		Person author = getFactory().newAuthor(getInternal());
		author.setName(name);
		author.setEmail(email);
		author.setUri(uri);
		return author;
	}

	public Entry addCategory(Category category) {
		addExtension(category);
		return this;
	}

	public Category addCategory(String term) {
		Category category = getFactory().newCategory(this);
		category.setTerm(term);
		return category;
	}

	public Category addCategory(String scheme, String term, String label) {
		Category category = getFactory().newCategory(getInternal());
		category.setScheme(scheme);
		category.setTerm(term);
		category.setLabel(label);
		return category;
	}

	public Entry addContributor(Person person) {
		addExtension(person);
		return this;
	}

	public Person addContributor(String name) {
		Person contributor = getFactory().newContributor(getInternal());
		contributor.setName(name);
		return contributor;
	}

	public Person addContributor(String name, String email, String uri) {
		Person contributor = getFactory().newContributor(getInternal());
		contributor.setName(name);
		contributor.setEmail(email);
		contributor.setUri(uri);
		return contributor;
	}

	public Control addControl() {
		Control control = getFactory().newControl(getInternal());
		return control;
	}

	public Entry addLink(Link link) {
		addExtension(link);
		return this;
	}

	public Link addLink(String href) {
		Link link = getFactory().newLink(getInternal());
		link.setHref(href);
		return link;
	}

	public Link addLink(String href, String rel) {
		Link link = getFactory().newLink(getInternal());
		link.setHref(href);
		link.setRel(rel);
		return link;
	}

	public Link addLink(String href, String rel, String type, String title, String hreflang,
			long length) {
		Link link = getFactory().newLink(getInternal());
		link.setHref(href);
		link.setRel(rel);
		link.setMimeType(type);
		link.setTitle(title);
		link.setHrefLang(hreflang);
		link.setLength(length);
		return link;
	}

	public Link getAlternateLink() {
		List<Link> links = getExtensions(Constants.LINK);
		for (Link link : links) {
			if (link.getRel() == null || link.getRel().equals("alternate")) {
				return link;
			}
		}
		return null;
	}

	public Link getAlternateLink(String type, String hreflang) {
		List<Link> links = getExtensions(Constants.LINK);
		for (Link link : links) {
			if ((link.getRel() == null || link.getRel().equals(Link.REL_ALTERNATE))
					&& link.getMimeType().equals(type) && link.getHrefLang().equals(hreflang)) {
				return link;
			}
		}
		return null;
	}

	public IRI getAlternateLinkResolvedHref() {
		Link link = getAlternateLink();
		return (null == link ? null : link.getHref());
	}

	public IRI getAlternateLinkResolvedHref(String type, String hreflang) {
		Link link = getAlternateLink(type, hreflang);
		return (null == link ? null : link.getHref());
	}

	public Person getAuthor() {
		return (Person) getFirstChild(org.apache.abdera.util.Constants.AUTHOR);
	}

	public List<Person> getAuthors() {
		return getExtensions(Constants.AUTHOR);
	}

	public List<Category> getCategories() {
		return getExtensions(Constants.CATEGORY);
	}

	public List<Category> getCategories(String scheme) {
		List<Category> allCategories = getCategories();
		List<Category> schemeCategories = new ArrayList<Category>();
		IRI iriScheme = new IRI(scheme);
		for (Category c : allCategories) {
			if (iriScheme.equals(c.getScheme())) {
				schemeCategories.add(c);
			}
		}
		return schemeCategories;
	}

	public String getContent() {
		Content content = getContentElement();
		return content.getValue();
	}

	public Content getContentElement() {
		return (Content) getFirstChild(Constants.CONTENT);
	}

	public MimeType getContentMimeType() {
		Content content = getContentElement();
		return (null == content ? null : content.getMimeType());
	}

	public IRI getContentSrc() {
		Content content = getContentElement();
		return (null == content ? null : content.getSrc());
	}

	public InputStream getContentStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Type getContentType() {
		Content content = getContentElement();
		return (null == content ? null : content.getContentType());
	}

	public List<Person> getContributors() {
		return getExtensions(Constants.CONTRIBUTOR);
	}

	public Control getControl() {
		return getFirstChild(Constants.CONTROL);
	}

	public Control getControl(boolean create) {
		Control control = getControl();
		if (create && null == control) {
			control = getFactory().newControl(getInternal());
			setControl(control);
		}
		return control;
	}

	public Link getEditLink() {
		return getLink(Link.REL_EDIT);
	}

	public IRI getEditLinkResolvedHref() {
		return getLinkResolvedHref(Link.REL_EDIT);
	}

	public Link getEditMediaLink() {
		return getLink(Link.REL_EDIT_MEDIA);
	}

	public Link getEditMediaLink(String type, String hreflang) {
		return getLink(Link.REL_EDIT_MEDIA, type, hreflang);
	}

	public IRI getEditMediaLinkResolvedHref() {
		return getLinkResolvedHref(Link.REL_EDIT_MEDIA);
	}

	public IRI getEditMediaLinkResolvedHref(String type, String hreflang) {
		Link link = getLink(Link.REL_EDIT_MEDIA, type, hreflang);
		return (null == link ? null : link.getHref());
	}

	public Date getEdited() {
		DateTime edited = getEditedElement();
		return edited.getDate();
	}

	public DateTime getEditedElement() {
		return (DateTime) getFirstChild(Constants.EDITED);
	}

	public Link getEnclosureLink() {
		return getLink(Link.REL_ENCLOSURE);
	}

	public IRI getEnclosureLinkResolvedHref() {
		return getLinkResolvedHref(Link.REL_EDIT_MEDIA);
	}

	public IRI getId() {
		IRIElement id = getIdElement();
		return id.getValue();
	}

	public IRIElement getIdElement() {
		return (IRIElement) getFirstChild(Constants.ID);
	}

	public Link getLink(String rel) {
		List<Link> links = getExtensions(Constants.LINK);
		for (Link link : links) {
			if (link.getRel().equals(rel)) {
				return link;
			}
		}
		return null;
	}

	protected Link getLink(String rel, String type, String hreflang) {
		List<Link> links = getExtensions(Constants.LINK);
		for (Link link : links) {
			if (link.getRel().equals(rel) && link.getMimeType().equals(type)
					&& link.getHrefLang().equals(hreflang)) {
				return link;
			}
		}
		return null;
	}

	public IRI getLinkResolvedHref(String rel) {
		Link link = getLink(rel);
		return (null == link ? null : link.getHref());
	}

	public List<Link> getLinks() {
		return getExtensions(Constants.LINK);
	}

	public List<Link> getLinks(String rel) {

		if (null == rel) {
			throw new IllegalArgumentException("rel must not be null.");
		}

		List<Link> links = getLinks();
		List<Link> matches = new ArrayList<Link>();
		for (Link link : links) {
			if (rel.equals(link.getRel())) {
				matches.add(link);
				break;
			}
		}
		return matches;
	}

	public List<Link> getLinks(String... rel) {
		List<Link> links = getLinks();
		List<Link> matches = new ArrayList<Link>();
		for (Link link : links) {
			for (String r : rel) {
				if (null != r && r.equals(link.getRel())) {
					matches.add(link);
					break;
				}
			}
		}
		return matches;
	}

	public Date getPublished() {
		DateTime published = getPublishedElement();
		return (null == published ? null : published.getDate());
	}

	public DateTime getPublishedElement() {
		return getFirstChild(Constants.PUBLISHED);
	}

	public String getRights() {
		Text rights = getRightsElement();
		return (null == rights ? null : rights.getValue());
	}

	public Text getRightsElement() {
		return getFirstChild(Constants.RIGHTS);
	}

	public org.apache.abdera.model.Text.Type getRightsType() {
		Text rights = getRightsElement();
		return (null == rights ? null : rights.getTextType());
	}

	public Link getSelfLink() {
		return getLink(Link.REL_SELF);
	}

	public IRI getSelfLinkResolvedHref() {
		return getLinkResolvedHref(Link.REL_SELF);
	}

	public Source getSource() {
		return (Source) getFirstChild(Constants.SOURCE);
	}

	public String getSummary() {
		Text summary = getSummaryElement();
		return (null == summary ? null : summary.getValue());
	}

	public Text getSummaryElement() {
		return (Text) getFirstChild(Constants.SUMMARY);
	}

	public org.apache.abdera.model.Text.Type getSummaryType() {
		Text summary = getSummaryElement();
		return (null == summary ? null : summary.getTextType());
	}

	public String getTitle() {
		Text title = getTitleElement();
		return (null == title ? null : title.getValue());
	}

	public Text getTitleElement() {
		return (Text) getFirstChild(Constants.TITLE);
	}

	public org.apache.abdera.model.Text.Type getTitleType() {
		Text title = (Text) getFirstChild(Constants.TITLE);
		return (null == title ? null : title.getTextType());
	}

	public Date getUpdated() {
		DateTime updated = getUpdatedElement();
		return (null == updated ? null : updated.getDate());
	}

	public DateTime getUpdatedElement() {
		return ((DateTime) getFirstChild(Constants.UPDATED));
	}

	public boolean isDraft() {
		// TODO Auto-generated method stub
		return false;
	}

	public IRIElement newId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Content setContent(String value) {
		Content content = getFactory().newContent(Content.Type.TEXT, getInternal());
		content.setValue(value);
		return content;
	}

	public Content setContent(Element value) {
		Content content = getFactory().newContent();
		content.setParentElement(getInternal());
		content.setValueElement(value);
		return content;
	}

	public Content setContent(DataHandler dataHandler) {
		Content content = getFactory().newContent();
		content.setParentElement(getInternal());
		content.setDataHandler(dataHandler);
		return content;
	}

	public Content setContent(InputStream inputStream) {
		// TODO Auto-generated method stub
		return null;
	}

	public Content setContent(String value, Type type) {
		Content content = getFactory().newContent(type, getInternal());
		content.setValue(value);
		return content;
	}

	public Content setContent(Element element, String mediatype) {
		MimeType mimeType;
		try {
			mimeType = new MimeType(mediatype);
		} catch (javax.activation.MimeTypeParseException mtpe) {
			throw new org.apache.abdera.util.MimeTypeParseException(mtpe);
		}
		Content content = getFactory().newContent(mimeType, getInternal());
		content.setValueElement(element);
		return content;
	}

	public Content setContent(DataHandler dataHandler, String mediatype) {
		MimeType mimeType;
		try {
			mimeType = new MimeType(mediatype);
		} catch (javax.activation.MimeTypeParseException mtpe) {
			throw new org.apache.abdera.util.MimeTypeParseException(mtpe);
		}
		Content content = getFactory().newContent(mimeType, getInternal());
		content.setDataHandler(dataHandler);
		return content;
	}

	public Content setContent(InputStream inputStream, String mediatype) {
		// TODO Auto-generated method stub
		return null;
	}

	public Content setContent(String value, String mediatype) {
		MimeType mimeType;
		try {
			mimeType = new MimeType(mediatype);
		} catch (javax.activation.MimeTypeParseException mtpe) {
			throw new org.apache.abdera.util.MimeTypeParseException(mtpe);
		}
		Content content = getFactory().newContent(mimeType, getInternal());
		content.setValue(value);
		return content;
	}

	public Content setContent(IRI uri, String mediatype) {
		MimeType mimeType;
		try {
			mimeType = new MimeType(mediatype);
		} catch (javax.activation.MimeTypeParseException mtpe) {
			throw new org.apache.abdera.util.MimeTypeParseException(mtpe);
		}
		Content content = getFactory().newContent(mimeType, getInternal());
		content.setSrc(uri.toString());
		return content;
	}

	public Content setContentAsHtml(String value) {
		return setContent(value, Type.HTML);
	}

	public Content setContentAsXhtml(String value) {
		return setContent(value, Type.XHTML);
	}

	public Entry setContentElement(Content content) {
		ExtensibleElement internal = getExtInternal();
		Content existing = getContentElement();
		if (null != existing) {
			existing.discard();
		}
		if (content != null) {
			internal.addExtension(content);
		}
		return this;
	}

	public Entry setControl(Control control) {
		ExtensibleElement internal = getExtInternal();
		Control existing = getControl();
		if (null != existing) {
			existing.discard();
		}
		if (control != null) {
			internal.addExtension(control);
		}
		return this;
	}

	public Entry setDraft(boolean draft) {
		// TODO Auto-generated method stub
		return null;
	}

	public DateTime setEdited(Date value) {
		DateTime modified = getFactory().newEdited(getInternal());
		modified.setDate(value);
		setEditedElement(modified);
		return modified;
	}

	public DateTime setEdited(String value) {
		DateTime modified = getFactory().newEdited(getInternal());
		modified.setString(value);
		setEditedElement(modified);
		return modified;
	}

	public void setEditedElement(DateTime modified) {
		ExtensibleElement internal = getExtInternal();
		DateTime existing = getEditedElement();
		if (null != existing) {
			existing.discard();
		}
		if (modified != null) {
			internal.addExtension(modified);
		}
	}

	public IRIElement setId(String id) {
		return setId(id, false);
	}

	public IRIElement setId(String id, boolean normalize) {
		IRIElement newId = getFactory().newID(getInternal());
		if (normalize) {
			newId.setNormalizedValue(id);
		} else {
			newId.setValue(id);
		}
		return newId;
	}

	public Entry setIdElement(IRIElement id) {
		ExtensibleElement internal = getExtInternal();
		IRIElement existing = getIdElement();
		if (null != existing) {
			existing.discard();
		}
		if (id != null) {
			internal.addExtension(id);
		}
		return this;
	}

	public DateTime setPublished(Date value) {
		DateTime published = getFactory().newPublished(getInternal());
		published.setDate(value);
		setPublishedElement(published);
		return published;
	}

	public DateTime setPublished(String value) {
		DateTime published = getFactory().newPublished(getInternal());
		published.setString(value);
		setPublishedElement(published);
		return published;
	}

	public Entry setPublishedElement(DateTime dateTime) {
		ExtensibleElement internal = getExtInternal();
		DateTime existing = getPublishedElement();
		if (null != existing) {
			existing.discard();
		}
		if (dateTime != null) {
			internal.addExtension(dateTime);
		}
		return this;
	}

	public Text setRights(String value) {
		return setRights(value, Text.Type.TEXT);
	}

	public Text setRights(Div value) {
		Text rights = getFactory().newRights(getInternal());
		rights.setValueElement(value);
		setRightsElement(rights);
		return rights;
	}

	public Text setRights(String value, org.apache.abdera.model.Text.Type type) {
		Text rights = getFactory().newRights(type, getInternal());
		rights.setValue(value);
		setRightsElement(rights);
		return rights;
	}

	public Text setRightsAsHtml(String value) {
		return setRights(value, Text.Type.HTML);
	}

	public Text setRightsAsXhtml(String value) {
		return setRights(value, Text.Type.XHTML);
	}

	public Entry setRightsElement(Text text) {
		ExtensibleElement internal = getExtInternal();
		Text existing = getRightsElement();
		if (null != existing) {
			existing.discard();
		}
		if (text != null) {
			internal.addExtension(text);
		}
		return this;
	}

	public Entry setSource(Source source) {
		addExtension(source);
		return this;
	}

	public Text setSummary(String value) {
		return setSummary(value, Text.Type.TEXT);
	}

	public Text setSummary(Div value) {
		Text summary = getFactory().newSummary(getInternal());
		summary.setValueElement(value);
		return summary;
	}

	public Text setSummary(String value, org.apache.abdera.model.Text.Type type) {
		Text summary = getFactory().newSummary(type, getInternal());
		summary.setValue(value);
		return summary;
	}

	public Text setSummaryAsHtml(String value) {
		return setSummary(value, Text.Type.HTML);
	}

	public Text setSummaryAsXhtml(String value) {
		return setSummary(value, Text.Type.XHTML);
	}

	public Entry setSummaryElement(Text text) {
		ExtensibleElement internal = getExtInternal();
		Text existing = getSummaryElement();
		if (null != existing) {
			existing.discard();
		}
		if (text != null) {
			internal.addExtension(text);
		}
		return this;
	}

	public Text setTitle(String value) {
		return setTitle(value, Text.Type.TEXT);
	}

	public Text setTitle(Div value) {
		Text title = getFactory().newSummary(getInternal());
		title.setValueElement(value);
		return title;
	}

	public Text setTitle(String value, org.apache.abdera.model.Text.Type type) {
		Text text = getFactory().newTitle(getInternal());
		text.setValue(value);
		text.setTextType(type);
		setTitleElement(text);
		return text;
	}

	public Text setTitleAsHtml(String value) {
		return setTitle(value, Text.Type.HTML);
	}

	public Text setTitleAsXhtml(String value) {
		return setTitle(value, Text.Type.XHTML);
	}

	public Entry setTitleElement(Text title) {
		ExtensibleElement internal = getExtInternal();
		Text existing = getTitleElement();
		if (null != existing) {
			existing.discard();
		}
		if (title != null) {
			internal.addExtension(title);
		}
		return this;
	}

	public DateTime setUpdated(Date value) {
		DateTime updated = getFactory().newUpdated(getInternal());
		updated.setDate(value);
		setUpdatedElement(updated);
		return updated;
	}

	public DateTime setUpdated(String value) {
		DateTime updated = getFactory().newUpdated(getInternal());
		updated.setString(value);
		setUpdatedElement(updated);
		return updated;
	}

	public Entry setUpdatedElement(DateTime updated) {
		ExtensibleElement internal = getExtInternal();
		DateTime existing = getUpdatedElement();
		if (null != existing) {
			existing.discard();
		}
		if (updated != null) {
			internal.addExtension(updated);
		}
		return this;
	}
}
