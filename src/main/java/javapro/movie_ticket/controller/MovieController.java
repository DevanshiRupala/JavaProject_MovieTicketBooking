package javapro.movie_ticket.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javapro.movie_ticket.entity.Movie;
import javapro.movie_ticket.service.MovieService;

@Controller
public class MovieController {
    
    private MovieService movieService;
    
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    
    @PostMapping("/movies/add")
    public String addMovieForm(@ModelAttribute Movie m2, Model m) {
        movieService.saveMovie(m2);
        List<Movie> m1 = movieService.getAllMovies(); 
        m.addAttribute("movies", m1);
        return "showMovie";
    }
    
    @GetMapping("/addmoviepage")
    public String addMoviepage() {      
        return "addMovie"; 
    }
   
    @GetMapping("/showMovies")
    public String showMovie(Model m, @RequestParam("username") String name,@RequestParam("password") String pass) {  
    	if(name.equals("admin") && pass.equals("admin@321"))
    	{
    		List<Movie> m1 = movieService.getAllMovies(); 
            m.addAttribute("movies", m1);
           return "showMovie"; 
    	}
    	return "redirect:/adlogin"; 
    }
    
    @GetMapping("/deletemovie/{id}")
    public String deletemovie(@PathVariable long id) {  
    	movieService.deleteMovieById(id);
        return "redirect:/showMovies"; 
    }
    
    @GetMapping("/editmovie/{id}")
    public String editmoviepage(@PathVariable long id, Model m) {
    	Movie m1 = movieService.getMovieById(id);
    	m.addAttribute("movie", m1);
        return "editmovie"; 
    }
    
    @GetMapping("/edit")
    public String editmovie(@ModelAttribute Movie m) { 
    	movieService.saveMovie(m);
        return "redirect:/showMovies"; 
    }
}

