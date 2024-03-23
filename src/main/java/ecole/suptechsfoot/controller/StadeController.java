package ecole.suptechsfoot.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ecole.suptechsfoot.entities.Stade;
import ecole.suptechsfoot.repository.MatchesRepository;
import ecole.suptechsfoot.repository.StadeRepository;


@RestController @RequestMapping("api")


public class StadeController {
	@Autowired StadeRepository stadeRepository;
	@Autowired MatchesRepository matchesRepository;
	
	@PostMapping("stade")
	public Stade saveStade(@RequestBody Stade stade) {
		return stadeRepository.save(stade);
	}
	
	@GetMapping("stades")
	public List<Stade>getAllStades(){
		return stadeRepository.findAll();
	}
	
	@GetMapping("stade/{id}")
	public Optional<Stade>getStadeById(@PathVariable Long stadeId){
		return stadeRepository.findById(stadeId);
	}
	
    @DeleteMapping("stade/{stadeId}")
    public void  deleteStade(@PathVariable Long stadeId) {
    	stadeRepository.deleteById(stadeId);
    }
    
    
   
        
        
    
   
}
       
	
	


