package Static.Arabic.Model;

public class FetchData {
	private String bookName;
	private String bookId;
	private String bookAuthor;
	private String bookDescription;
	private Dumy dumy;
	public FetchData(Dumy dumy)
	{
		this.dumy=dumy;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	} 
	
	public boolean checkData(String name,String id, String author,String description) {
		boolean result=false;
		FetchData fetch=this.dumy.fetchData(name, id, author, description);
		if(fetch!=null) {
			result=true;
		}
		return result;

		 
	}
}
