package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String year;
	private String imdbID;
	
	protected Movie() {
		
	}
	
	public Movie(String title, String year, String imdbID) {
		this.title = title;
		this.year = year;
		this.imdbID = imdbID;
	}
	
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
	
	@Override
	public String toString() {
		return String.format("Movie[id=%d, title='%s', year='%s', imdbID='%s']", id, title, year, imdbID);
	}
}