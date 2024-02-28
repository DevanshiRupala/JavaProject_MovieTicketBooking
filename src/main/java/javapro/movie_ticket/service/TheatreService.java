package javapro.movie_ticket.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javapro.movie_ticket.entity.Theatre;
import javapro.movie_ticket.repository.TheatreRepository;

@Service
public class TheatreService {
    
    @Autowired
    private TheatreRepository theatreRepository;

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre getTheatreById(Long theatreId) {
        return theatreRepository.findById(theatreId).orElse(null);
    }

    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public void deleteTheatre(Long theatreId) {
        theatreRepository.deleteById(theatreId);
    }


}

