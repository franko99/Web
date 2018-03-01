package hello;

import org.hibernate.validator.constraints.NotBlank;

public class MovieCriteria {

	@NotBlank(message = "Title cannot be blank!")
	private String title;
	private String year;
	private String imdbID;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getImdbID() {
		return imdbID;
	}
	
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
}