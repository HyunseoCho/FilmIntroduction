import java.io.Serializable;
import java.util.Date;

public class Movie implements Serializable {
	private String title;
	private Date releaseDate;
	private String intro;
	private String genre;
	private String director;
	private String trailerLink;
	
	public String getShortIntroduction(){
		return intro.substring(0, 100) + "...";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getTrailerLink() {
		return trailerLink;
	}
	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}
}
