package javapro.movie_ticket.controller;

import java.util.ArrayList;
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

import javapro.movie_ticket.entity.Booking;
import javapro.movie_ticket.entity.Movie;
import javapro.movie_ticket.entity.Theatre;
import javapro.movie_ticket.entity.User;
import javapro.movie_ticket.service.BookingService;

@Controller
public class BookingController {
    
    private BookingService bookingService;
    
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    
    @GetMapping("/confirm")
    public String booking(@RequestParam("theatre") Theatre t,@RequestParam("user") User u,@RequestParam("movie") Movie m,
    		@RequestParam("seattype") String type,@RequestParam("numsTickets") int n)
    {
    	Booking b = new Booking();
    	b.setMovie(m);
    	b.setNumTickets(n);
    	b.setUser(u);
    	b.setSeattype(type);
    	b.setTheatre(t);
    	bookingService.addBooking(b);
    	return "confirm";
    }
    
}

