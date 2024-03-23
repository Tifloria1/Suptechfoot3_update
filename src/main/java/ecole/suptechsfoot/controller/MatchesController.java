package ecole.suptechsfoot.controller;




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
import ecole.suptechsfoot.entities.Matches;
import ecole.suptechsfoot.entities.Stade;
import ecole.suptechsfoot.repository.ArbitreRepository;
import ecole.suptechsfoot.repository.EquipeRepository;
import ecole.suptechsfoot.repository.MatchesRepository;
import ecole.suptechsfoot.repository.StadeRepository;
import lombok.Data;

@RestController @RequestMapping("api")

public class MatchesController {
	@Autowired MatchesRepository matchesRepository;
	@Autowired EquipeRepository equipeRepository; 
	@Autowired ArbitreRepository arbitreRepository;
	@Autowired StadeRepository stadeRepository;
	
	
	//@PostMapping("match/stade/{idequipe1}/{idequipe2}/{idarbitre}/{idstade}/matches")
	//public Matches addMatches(
	  //  @PathVariable("idstade") Long idstade,
	    //@PathVariable("idarbitre") Long idarbitre,
	    //@PathVariable("idequipe1") Long idequipe1,
	    //@PathVariable("idequipe2") Long idequipe2,
	    //@RequestBody Matches match
	  
	//) {
	  //  Optional<Arbitre> arbitre = arbitreRepository.findById(idarbitre);
	    //Optional<Stade> stade = stadeRepository.findById(idstade);
	    //if (arbitre.isPresent() && stade.isPresent()) {
	    	//match.setArbitre(arbitre.get());
		    //match.setStade(stade.get());
	 
	        //return matchesRepository.save(match);
	    //}

	    //return null;
	//}
	
	@PostMapping("match/{idequipe_domicile}/vs/{idequipe_visiteur}/arbitre/{arbitreId}/stade/{stadeId}")
	public Matches addGame(@PathVariable("idequipe_domicile") Long equipeDomicileId,  // Use more descriptive variable names
	                       @PathVariable("idequipe_visiteur") Long equipeVisiteurId,
	                       @PathVariable("arbitreId") Long arbitreId,
	                       @PathVariable("stadeId") Long stadeId,
	                       @RequestBody Matches match) {

	    Optional<Arbitre> optionalArbitre = arbitreRepository.findById(arbitreId);
	    Optional<Stade> optionalStade = stadeRepository.findById(stadeId);
	    Optional<Equipe> optionalEquipeDomicile = equipeRepository.findById(equipeDomicileId);
	    Optional<Equipe> optionalEquipeVisiteur = equipeRepository.findById(equipeVisiteurId);

	    if (optionalArbitre.isPresent() && optionalStade.isPresent() &&
	            optionalEquipeDomicile.isPresent() && optionalEquipeVisiteur.isPresent()) {
	        match.setEquipe_domicile(optionalEquipeDomicile.get());
	        match.setEquipe_visiteur(optionalEquipeVisiteur.get());
	        match.setArbitre(optionalArbitre.get());
	        match.setStade(optionalStade.get());
	        return matchesRepository.save(match);
	    } else {
	       
	        return null; 
	    }
	}
	@GetMapping("match/date/{date}")
	public List<Matches> getMatchesByDate(@PathVariable String date) {
	    LocalDate localDate = LocalDate.parse(date);
	    return matchesRepository.findByDate(localDate);
	}
	
	
	  
	  @GetMapping("match/{matchId}/stade")
	  public Optional<Stade> getMatchesStade(@PathVariable Long matchId) {
	    return stadeRepository.findById(matchId); 
	  }
	
	

	
	
	 @DeleteMapping("match/{matchId}")
	    public void deleteMatch(@PathVariable Long matchId) {
	        matchesRepository.deleteById(matchId);
	    }
	 
	 
	 @PutMapping("match/{matchId}")
	    public Matches updateMatch(@PathVariable Long matchId, @RequestBody Matches updatedMatch) {
	        Matches existingMatch = matchesRepository.findById(matchId).get();
	        
	        existingMatch.setDate(updatedMatch.getDate());
	        existingMatch.setHoure(updatedMatch.getHoure());
	        
	        return matchesRepository.save(existingMatch);
	    }
	 
	 
	 @GetMapping("match/{matchId}/equipe")
	 public List<Equipe> getEquipesByMatchId(@PathVariable Long matchId) {
	        Optional<Matches> optionalMatch = matchesRepository.findEquipeByMatchId(matchId);
	        if (optionalMatch.isPresent()) {
	            Matches match = optionalMatch.get();
	            return Arrays.asList(match.getEquipe_domicile(), match.getEquipe_visiteur());	        }
	        return null;
	    }
	        
	    
       
	    
	 @DeleteMapping("match/past")
	  public void deletePastMatches() {
	        LocalDate thisday = LocalDate.now();
	        List<Matches> pastMatches = matchesRepository.findByDateBefore(thisday);
	        matchesRepository.deleteAll(pastMatches);
	    }
	
  
	        
	 
	@GetMapping("matches")
	public List<Matches> getAllMatches() {
		return matchesRepository.findAll();
}
}

