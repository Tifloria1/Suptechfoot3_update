package ecole.suptechsfoot.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data  @Entity

public class Stade {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Id
	Long stadeId;
	String nameStade;
	String City;
	
	@OneToMany(mappedBy="stade")
	List<Matches>matches;

}
