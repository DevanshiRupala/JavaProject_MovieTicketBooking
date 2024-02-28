package javapro.movie_ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javapro.movie_ticket.entity.Movie;
import javapro.movie_ticket.entity.Theatre;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    List<Movie> findByTitleContainingIgnoreCase(String keyword);
    
    List<Movie> findByTheatre(Theatre t);
    
}

