package Static.Arabic.Model.Handler;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {
	private String bookName;
	private String bookId;
	private String bookAuthor;
	private String bookDescription;
	private PropertyChangeSupport notifier;

	public Model() {
		super();
		notifier = new PropertyChangeSupport(this);

	}

	// .............
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookNames) {
		this.bookName = bookNames;
		notifier.firePropertyChange("bookName", "old", this.bookName);
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookIds) {
		this.bookId = bookIds;
		notifier.firePropertyChange("bookId", "old", this.bookId);
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthors) {
		this.bookAuthor = bookAuthors;
		notifier.firePropertyChange("bookAuthor", "old", this.bookAuthor);
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescriptions) {
		this.bookDescription = bookDescriptions;
		notifier.firePropertyChange("bookDescription", "old", this.bookDescription);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.notifier.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.notifier.removePropertyChangeListener(listener);
	}
//.....................
}
