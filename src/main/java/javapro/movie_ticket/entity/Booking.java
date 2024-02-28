package javapro.movie_ticket.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
      
    private int numTickets;
    @ManyToOne
    private User user;
    @ManyToOne
    private Theatre theatre;
    @ManyToOne
    private Movie movie;
    private String seattype;

	public Long getId() {
		return id;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public Movie getMovie() {
		return movie;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSeattype() {
		return seattype;
	}

	public void setSeattype(String seattype) {
		this.seattype = seattype;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Theatre getTheatre() {
		return theatre;
	}
	
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public int getNumTickets() {
		return numTickets;
	}


	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}
    
}


	

