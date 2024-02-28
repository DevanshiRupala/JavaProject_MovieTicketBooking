package javapro.movie_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javapro.movie_ticket.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    
    Theatre findByName(String name);
    
}
