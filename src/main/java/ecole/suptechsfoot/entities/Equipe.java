package ecole.suptechsfoot.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor @Data @Entity

public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	 
	
	Long equipeId;
	String nameEquipe;
	String pays;
	


    @JsonIgnore
    @OneToMany(mappedBy = "equipe")
    List<Player> player;

    @JsonIgnore
    @OneToMany(mappedBy = "equipe_domicile")
    List<Matches> match_domicile;

    @JsonIgnore
    @OneToMany(mappedBy = "equipe_visiteur")
    List<Matches> match_visiteur;
}
