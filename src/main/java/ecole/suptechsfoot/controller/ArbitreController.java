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
import org.springframework.web.service.annotation.DeleteExchange;

import ecole.suptechsfoot.entities.Arbitre;
import ecole.suptechsfoot.repository.ArbitreRepository;

@RestController @RequestMapping("api")

public class ArbitreController {
	@Autowired ArbitreRepository arbitreRepository;
	
	@PostMapping("arbitre")
	public Arbitre saveArbitre(@RequestBody Arbitre arbitre) {
			return arbitreRepository.save(arbitre);
		}
	
	@GetMapping("arbitres")
	public List<Arbitre>getAllArbitres(@RequestBody Arbitre arbitre){
		return arbitreRepository.findAll();
	}
	
	@GetMapping("arbitre/{id}")
	public Optional<Arbitre>getArbitreById(@PathVariable Long arbitreId){
		return arbitreRepository.findById(arbitreId);
	}
	
	 @DeleteMapping("arbitre/{arbitreId}")
	    public void deleteArbitre(@PathVariable Long arbitreId) {
	        arbitreRepository.deleteById(arbitreId);
	    }
	 
	 @PutMapping("arbitre/{arbitreId}")
	    public Arbitre updateArbitre(@PathVariable Long arbitreId, @RequestBody Arbitre updatedArbitre) {
	        Arbitre existingArbitre = arbitreRepository.findById(arbitreId).get();
	        
	        existingArbitre.setNameArbitre(updatedArbitre.getNameArbitre());
	        existingArbitre.setNationality(updatedArbitre.getNationality());
	        
	        return arbitreRepository.save(existingArbitre);
	    }
	
		

}
