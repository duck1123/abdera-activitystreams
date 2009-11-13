package com.cliqset.abdera.ext.activity.examples;

import java.util.Date;

import org.apache.abdera.Abdera;
import org.apache.abdera.model.Feed;

import com.cliqset.abdera.ext.activity.ActivityEntry;
import com.cliqset.abdera.ext.activity.ActivityExtensionFactory;
import com.cliqset.abdera.ext.activity.ObjectType;
import com.cliqset.abdera.ext.activity.Verb;
import com.cliqset.abdera.ext.activity.object.Photo;
import com.cliqset.abdera.ext.atommedia.AtomMediaExtensionFactory;
import com.cliqset.abdera.ext.serviceprovider.ServiceProviderExtensionFactory;

public class CreatePostPhoto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Abdera abdera = new Abdera();
		abdera.getFactory().registerExtension(new ActivityExtensionFactory());
		abdera.getFactory().registerExtension(new ServiceProviderExtensionFactory());
		abdera.getFactory().registerExtension(new AtomMediaExtensionFactory());
		
		Feed feed = abdera.newFeed();
		
		ActivityEntry entry = new ActivityEntry(feed.addEntry());
		
		entry.setId("tag:site.org,2009-01-01:/some/unique/id");
		entry.setTitle("picturetaker took a Picture!");
		entry.setVerb(Verb.POST, false);
		entry.setPublished(new Date());

		Photo photo = entry.addTypedObject(ObjectType.PHOTO);
		photo.addThumbnail("https://picturepostingsite.com/picturetaker/1234567890/thumbnail", "image/jpeg", 16, 32);
		photo.addLargerImage("http://picturepostingsite.com/picturetaker/1234567890/larger", "image/jpeg", 1024, 768);
		photo.setTitle("My backyard!");
		photo.setDescription("this is an excellent shot of my backyard on a summer evening.");
		photo.setPageLink("http://picturepostingsite.com/picturetaker/1234567890");

		entry.setServiceProvider("PicturePostingSite", "http://www.picturepostingsite.com", "http://www.picturepostingsite.com/icon.jpg");
		
		try {
			feed.writeTo(System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
