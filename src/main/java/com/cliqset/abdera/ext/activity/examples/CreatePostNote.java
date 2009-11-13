package com.cliqset.abdera.ext.activity.examples;

import java.util.Date;

import org.apache.abdera.Abdera;
import org.apache.abdera.model.Feed;

import com.cliqset.abdera.ext.activity.ActivityEntry;
import com.cliqset.abdera.ext.activity.ActivityExtensionFactory;
import com.cliqset.abdera.ext.activity.ObjectType;
import com.cliqset.abdera.ext.activity.Verb;
import com.cliqset.abdera.ext.activity.object.Note;
import com.cliqset.abdera.ext.serviceprovider.ServiceProviderExtensionFactory;

public class CreatePostNote {
	public static void main(String[] args) {
		Abdera abdera = new Abdera();
		abdera.getFactory().registerExtension(new ActivityExtensionFactory());
		abdera.getFactory().registerExtension(new ServiceProviderExtensionFactory());
		
		Feed feed = abdera.newFeed();
		
		ActivityEntry entry = new ActivityEntry(feed.addEntry());
		
		entry.setId("tag:site.org,2009-01-01:/some/unique/id");
		entry.setTitle("noteposter posted a note!");
		entry.setContent("The weather is great outside.");
		entry.setPublished(new Date());
		
		entry.setVerb(Verb.POST, false);
		entry.setLocationCoordinates(19.313735, -155.32196);
		
		Note note = entry.addTypedObject(ObjectType.NOTE);
		note.setContent("The weather is great outside.");
		note.setPermaLink("http://notepostingsite.org/noteposter/1234567890");

		entry.setServiceProvider("NotePostingSite", "http://www.notepostingsite.org", "http://notepostingsite.org/icon.jpg");
		
		try {
			feed.writeTo(System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
