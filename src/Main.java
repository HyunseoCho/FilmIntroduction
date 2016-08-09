import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
	static MovieIntroductor introductor = new MovieIntroductor("movie.bin");
	
	public static void main(String[] args) throws ParseException{
		
		Scanner scanner = new Scanner(System.in);
		boolean exit=false;
		do{
//			System.out.println("Would you like to see movies categorized by genre(1) or by newest first(2)?");
			System.out.println("1. View movies by genre");
			System.out.println("2. View the newest movies");
			System.out.println("3. Add movie");
			System.out.println("Otherwise, Exit");
			int choice = scanner.nextInt();

			switch(choice){
				case 1:	
					viewGenreMovies();
					break;

				case 2:
					viewNewestMovies();
					break;
				
				case 3:
					addMovie();
					break;

				default:
					exit=true;
					break;
			
			}
		}while(exit!=true);
		introductor.writeMovies();
	}

	private static void addMovie() throws ParseException {
		Movie movie = new Movie();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Title? ");
		String title = sc.nextLine();
		movie.setTitle(title);
		
		System.out.println("Release Date? (ex. 2000-01-01) ");
		String dateString = sc.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(dateString);
		movie.setReleaseDate(date);
		
		System.out.println("Type in a introduction to the film.");
		String intro=sc.nextLine();
		movie.setIntro(intro);
		
		System.out.println("Genre?");
		String genre=sc.nextLine();
		movie.setGenre(genre);
		
		System.out.println("Director?");
		String director=sc.nextLine();
		movie.setDirector(director);
		
		System.out.println("Link to trailer?");
		String link=sc.nextLine();
		movie.setTrailerLink(link);
		
		introductor.addMovie(movie);
		System.out.println("The movie was added successfully");
	}

	private static void viewNewestMovies() throws ParseException {
		System.out.println("From when? ");
		Scanner scanner = new Scanner(System.in);
		String date = scanner.nextLine();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date releaseDate = format.parse(date);
		
		List<Movie> movies = introductor.getMovies(releaseDate);
		System.out.println("Your results are: ");
		for (int i = 0; i < movies.size(); i++) {
			System.out.println(movies.get(i).getTitle());
		}
	}

	private static void viewGenreMovies() {
		System.out.println("Which Genre? ");
		Scanner scanner = new Scanner(System.in);
		String genre = scanner.nextLine();
		
		List<Movie> movies = introductor.getMovies(genre);
		System.out.println("Your results are: ");
		for (int i = 0; i < movies.size(); i++) {
			System.out.println(movies.get(i).getTitle());
		}
	}
}
