package javapro.movie_ticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javapro.movie_ticket.entity.User;
import javapro.movie_ticket.service.UserService;

@Controller
public class HomeController {
	 
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/registerpage")
	public String register()
	{
		return "registration";
	}
	
	@GetMapping("/adlogin")
	public String adlogin()
	{
		return "adlogin";
	}

}
