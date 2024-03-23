package ecole.suptechsfoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ecole.suptechsfoot.entities.Equipe;
import ecole.suptechsfoot.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{

		 
	 List<Player> findByEquipeEquipeId(Long equipeId);
	//List<Player> findByEquipeId(Long idEquipe);
	 List<Player> findByEquipeNameEquipeAndNamePoste(String nameEquipe, String namePoste);



}
