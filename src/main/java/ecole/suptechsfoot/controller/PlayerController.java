package ecole.suptechsfoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecole.suptechsfoot.entities.Arbitre;
import ecole.suptechsfoot.entities.Equipe;
import ecole.suptechsfoot.entities.Player;
import ecole.suptechsfoot.repository.EquipeRepository;
import ecole.suptechsfoot.repository.PlayerRepository;

@RestController @RequestMapping("api") 

public class PlayerController {
	@Autowired PlayerRepository playerRepository;
	@Autowired EquipeRepository equipeRepository;
	
	@PostMapping ("player/equipe/{idequipe}")
	public Player addPlayerByIdEquipeId(@PathVariable("idequipe") Long equipeId, @RequestBody Player player) {
	    Optional<Equipe> equipe = equipeRepository.findById(equipeId);
	    if (equipe.isPresent()) {
	        player.setEquipe(equipe.get());
	        return playerRepository.save(player);
	    }
	    return null;
	}
	 @GetMapping("player/equipe/{equipeId}")
	    public List<Player> getPlayersByEquipeId(@PathVariable Long equipeId) {
		  	return playerRepository.findByEquipeEquipeId(equipeId);
		 
		
		}
	
	
	@GetMapping("players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
	
	@GetMapping("player/{playerId}")
    public Optional<Player> getPlayerById(@PathVariable Long playerId) {
        return playerRepository.findById(playerId);
    }

	@DeleteMapping("player/{playerId}")
    public void deletePlayer(@PathVariable Long playerId) {
        playerRepository.deleteById(playerId);
    }
	
	 @PutMapping("player/{playerId}")
	    public Player updatePlayer(@PathVariable Long playerId, @RequestBody Player updatedPlayer) {
	        Player existingPlayer = playerRepository.findById(playerId).get();
	        
	        existingPlayer.setNamePlayer(updatedPlayer.getNamePlayer());
	        existingPlayer.setNamePoste(updatedPlayer.getNamePoste());
	      
	        
	        return playerRepository.save(existingPlayer);
	    }
	 
	 @GetMapping("equipe/{nameEquipe}/players/namePoste/attaquant")
	 public List<Player> getAttaquantsByEquipe(@PathVariable String nameEquipe) {
	     return playerRepository.findByEquipeNameEquipeAndNamePoste(nameEquipe, "attaquant");
	 }
	
	 
	

}
