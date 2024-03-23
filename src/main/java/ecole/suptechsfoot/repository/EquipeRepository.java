package ecole.suptechsfoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ecole.suptechsfoot.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long>{
	
	 List<Equipe> findByPays(String pays);
	 List<Equipe> findByNameEquipe(String nameEquipe);
	 

	 

}
