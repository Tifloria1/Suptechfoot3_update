package ecole.suptechsfoot.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Entity

public class Arbitre {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	
	Long arbitreId;
	String nameArbitre;
	String Nationality;  
	
	@JsonIgnore
	@OneToMany(mappedBy="arbitre")
	List<Matches>matches;

}
