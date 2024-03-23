package ecole.suptechsfoot.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import ecole.suptechsfoot.entities.Stade;

public interface StadeRepository extends JpaRepository<Stade, Long>{
	
	  Optional<Stade> findById(Long stadeId);


}
