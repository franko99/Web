package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@Bean
//	public CommandLineRunner demo(MovieRepository repo) {
//		return (args) -> {
//			repo.save(new Movie("Star Wars - A New Hope", "1977", "tt0076759"));
//			repo.save(new Movie("Star Wars: The Force Awakens", "2015", "tt2488496"));
//			repo.save(new Movie("Indiana Jones and the Last Crusade", "1989", "tt0097576"));
//			repo.save(new Movie("Die Hard", "1988", "tt0095016"));
//			
//			//fetch all movies
//			log.info("Movies found with findAll():");
//			log.info("----------------------------");
//			for(Movie movie: repo.findAll()) {
//				log.info(movie.toString());
//			}			
//			log.info("");
//			
//			//fetch movies by title
//			log.info("Movie found with findByTitle('Indiana Jones and the Last Crusade'):");
//			log.info("------------------------------------------");
//			for(Movie movie: repo.findByTitle("Indiana Jones and the Last Crusade")) {
//				log.info(movie.toString());
//			}
//			log.info("");
//			
//			//fetch movies by year
//			log.info("Movie found with findByYear('1988'):");
//			log.info("------------------------------------------");
//			for(Movie movie: repo.findByYear("1988")) {
//				log.info(movie.toString());
//			}
//			log.info("");
//			
//			//fetch movies by ID
//			log.info("Movie found with findOne('1L'):");
//			log.info("-------------------------------");
//			Movie movie = repo.findOne(1L);
//			log.info(movie.toString());
//			log.info("");
//		};
//	}
}