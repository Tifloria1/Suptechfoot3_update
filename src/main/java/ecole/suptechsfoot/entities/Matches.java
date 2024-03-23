package ecole.suptechsfoot.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity @Table(name = "matches")

public class Matches {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Long matchId; 
	LocalDate date;
	LocalTime houre;
	
	
	
	

    @JsonIgnore
	@ManyToOne
	Arbitre arbitre;
    
   
	
	@ManyToOne 
	Equipe equipe_domicile;
	@ManyToOne
	Equipe equipe_visiteur;

	
	@ManyToOne
	Stade stade;

	

}
