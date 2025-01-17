package ecole.suptechsfoot.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data @Entity

public class Player {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long playerId;
	String namePlayer;
	String namePoste;

	
	@ManyToOne
	@JoinColumn(name ="id_equipe")
    Equipe equipe;
	
	@ManyToOne
    @JoinColumn
    private Matches match;
	
	

}
