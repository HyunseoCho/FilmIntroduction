import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MovieIntroductor {
	List<Movie> movies;
	private String filename;
	
	public MovieIntroductor(String filename) {
		this.setFilename(filename);
		movies = readMovies();
	}

	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	public Movie getMovie(String title){
		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			if (movie.getTitle().equals(title)) {
				return movie;
			}
		}
		return null;
	}
	
	public Movie getMovie(int id){
		return movies.get(id);
	}
	
	public List<Movie> getMovies(String genre){
		List<Movie> return_movies = new ArrayList<Movie>();
		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			if (movie.getGenre().equals(genre)) {
				return_movies.add(movie);
			}
		}
		return return_movies;
	}
	public List<Movie> getMovies(Date releaseDate){
		List<Movie> return_movies = new ArrayList<Movie>();
		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			if (movie.getReleaseDate().compareTo(releaseDate)>0) {
				return_movies.add(movie);
			}
		}
		return return_movies;
	}
	public List<Movie> readMovies() {
		//this is a method that calls movies from the file
		List<Movie> movies = new ArrayList<Movie>();
		try{
			FileInputStream fis =
					new FileInputStream(filename);
			ObjectInput ois;
			if (fis.available() > 0) {
				ois = new ObjectInputStream(fis);
			}		
			while (ois.available() > 0) {
				Movie movie = (Movie) ois.readObject();
				movies.add(movie);
			}
//			movies = (List<Movie>)ois.readObject();
//			fis.close();
		}
		catch(Throwable e){
//			System.err.println(e);
			e.printStackTrace();
		}
		return movies;
	}
	public void writeMovies(){
		//This is a method that lets you add movies to the file
		try{
			FileOutputStream f = new FileOutputStream(filename);
			ObjectOutput s = new ObjectOutputStream(f);
			
			for (int i = 0; i < this.movies.size(); i++) {
				Movie movie = this.movies.get(i);
				s.writeObject(movie);
			}
			
			s.flush();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

}
