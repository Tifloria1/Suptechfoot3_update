package ecole.suptechsfoot.repository;





import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ecole.suptechsfoot.entities.Equipe;
import ecole.suptechsfoot.entities.Matches;
public interface MatchesRepository extends JpaRepository<Matches, Long>{
	
	public List<Matches> findByDate(LocalDate date);
	Optional<Matches> findById(Long matchId);
	public Optional<Matches> findEquipeByMatchId(Long matchId);
	  List<Matches> findByDateBefore(LocalDate date);





	


}
