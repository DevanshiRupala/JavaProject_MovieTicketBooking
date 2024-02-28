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

import javapro.movie_ticket.entity.Movie;
import javapro.movie_ticket.entity.Theatre;
import javapro.movie_ticket.service.TheatreService;

@Controller
public class TheatreController {
    
    private TheatreService theaterService;
    
    @Autowired
    public TheatreController(TheatreService theaterService) {
        this.theaterService = theaterService;
    }
    
    @GetMapping("/showtheatre")
    public String AddTheater(@ModelAttribute Theatre h, Model m) {
    	theaterService.createTheatre(h);
    	List<Theatre>t = theaterService.getAllTheatres();
    	m.addAttribute("theater",t);
         return "showTheatre";
    }
    
    @GetMapping("/addtheatrepage")
    public String showAddTheaterForm() {
         return "addTheatre";
    }

    @GetMapping("/theatre")
    public String Theater(Model m) {
    	List<Theatre>t = theaterService.getAllTheatres();
    	m.addAttribute("theater",t);
         return "showTheatre";
    }
    
    @GetMapping("/deletetheatre/{id}")
    public String deletetheatre(@PathVariable long id) {  
    	theaterService.deleteTheatre(id);
        return "redirect:/theatre"; 
    }
    
    @GetMapping("/edittheatre/{id}")
    public String edittheatrepage(@PathVariable long id, Model m) {
    	Theatre m1 = theaterService.getTheatreById(id);
    	m.addAttribute("theatre", m1);
        return "editTheatre"; 
    }
    
    @GetMapping("/editth")
    public String edittheatre(@ModelAttribute Theatre t) { 
    	theaterService.createTheatre(t);
        return "redirect:/theatre"; 
    }

}

