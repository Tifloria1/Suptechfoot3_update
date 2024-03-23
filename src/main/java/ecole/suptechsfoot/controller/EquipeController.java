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

import ecole.suptechsfoot.entities.Equipe;
import ecole.suptechsfoot.repository.EquipeRepository;

@RestController @RequestMapping("api")

public class EquipeController {
	@Autowired EquipeRepository equipeRepository;
	
	@GetMapping("equipes")
	List<Equipe>getAllEquipes(@RequestBody Equipe equipe)
	 {
		return equipeRepository.findAll();
	}
	
	 @GetMapping("equipes/{equipeId}")
	    public Optional<Equipe> getEquipeById(@PathVariable Long equipeId) {
	        return equipeRepository.findById(equipeId);
	    }
	
	@PostMapping("equipes")
	Equipe savEquipe(@RequestBody Equipe equipe){
		return equipeRepository.save(equipe);
	}
	
	@DeleteMapping("equipes/{equipeId}")
    public void deleteEquipe(@PathVariable Long equipeId) {
        equipeRepository.deleteById(equipeId);
    }
	
	 @PutMapping("equipes/{equipeId}")
	    public Equipe updateEquipe(@PathVariable Long equipeId, @RequestBody Equipe updatedEquipe) {
	        Equipe existingEquipe = equipeRepository.findById(equipeId).get();
	        
	        existingEquipe.setNameEquipe(updatedEquipe.getNameEquipe());
	        existingEquipe.setPays(updatedEquipe.getPays());

	        return equipeRepository.save(existingEquipe);
	    }
	 
	 //@GetMapping("equipes/pays/{pays}")
	   // public List<Equipe> getEquipeByPays(@PathVariable String pays) {
	     //   return equipeRepository.findByPays(pays);
	    //}

	@GetMapping("equipes/pays/{pays}")
    public List<Equipe> getEquipesByPays(@PathVariable String pays) {
        return equipeRepository.findByPays(pays);
    }
	

}
