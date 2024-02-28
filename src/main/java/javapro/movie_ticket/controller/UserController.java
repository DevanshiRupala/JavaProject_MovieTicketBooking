package javapro.movie_ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;
import javapro.movie_ticket.entity.Movie;
import javapro.movie_ticket.entity.Theatre;
import javapro.movie_ticket.entity.User;
import javapro.movie_ticket.service.MovieService;
import javapro.movie_ticket.service.TheatreService;
import javapro.movie_ticket.service.UserService;

@Controller
public class UserController {
    
    private UserService userService;
    @Autowired
    private TheatreService theatreService;
    @Autowired
    private MovieService movieService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/movies")
	public String movies(@ModelAttribute User u, Model m,HttpSession session)
	{
    	userService.registerUser(u);
    	session.setAttribute("user", u);
    	List<Theatre> theatre = theatreService.getAllTheatres();
    	m.addAttribute("theatre",theatre);
		return "movies";
	}
    
    @GetMapping("/showmovies")
	public String movies(@RequestParam ("username") String name,@RequestParam ("email") String email,Model m, HttpSession session)
	{
    	User u = userService.getUserByEmail(email);
    	if(u!= null) {
    	List<Theatre> theatre = theatreService.getAllTheatres();
    	m.addAttribute("theatre",theatre);
    	session.setAttribute("user", u);
    	return "movies";
    	}
    	return "redirect:/login";
	}
    
    @GetMapping("/theatremovie/{id}")
    public String theatremovie(@PathVariable long id, Model m1,@SessionAttribute("user") User user)
    {
    	List<Movie> m = movieService.getMovieByTheatreId(id);
    	m1.addAttribute("movie",m);
    	Theatre t = theatreService.getTheatreById(id);
    	m1.addAttribute("th",t);
    	m1.addAttribute("user",user);
    	return "thwisemovie";
    }
}
