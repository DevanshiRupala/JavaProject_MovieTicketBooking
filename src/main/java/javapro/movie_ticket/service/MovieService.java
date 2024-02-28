package javapro.movie_ticket.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javapro.movie_ticket.entity.Movie;
import javapro.movie_ticket.entity.Theatre;
import javapro.movie_ticket.repository.MovieRepository;

@Service
public class MovieService {
	
	  private MovieRepository movieRepository;
	  @Autowired
	  private TheatreService theatreService;
	    
	    @Autowired
	    public MovieService(MovieRepository movieRepository) {
	        this.movieRepository = movieRepository;
	    }
	    
	    public List<Movie> getAllMovies() {
	        return movieRepository.findAll();
	    }
	    
	    public Movie getMovieById(Long id) {
	        return movieRepository.findById(id).orElse(null);
	    }
	    
//	    public List<Movie> searchMoviesByTitle(String title) {
//	        return movieRepository.findByTitleContainingIgnoreCase(title);
//	    }
	    
	    public void saveMovie(Movie movie) {
	        movieRepository.save(movie);
	    }
	    
	    public void deleteMovieById(Long id) {
	        movieRepository.deleteById(id);
	    }   
	    
	    public List<Movie> getMovieByTheatreId(long id){
	        Theatre theatre = theatreService.getTheatreById(id);
	        List<Movie> movies = movieRepository.findByTheatre(theatre);
	        return movies;
	    }

}
