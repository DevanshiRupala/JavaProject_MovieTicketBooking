package javapro.movie_ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javapro.movie_ticket.entity.Booking;
import javapro.movie_ticket.entity.User;
import javapro.movie_ticket.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking addBooking(Booking booking) {
            return bookingRepository.save(booking);
        }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
