package lv.finals.models.users;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.finals.models.Thesis;

@Table(name = "academic_personel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AttributeOverride(name = "Idp", column = @Column(name = "Ida"))
public class AcademicPersonel extends Person{
	
	@Column(name = "Degree")
	private Degree degree;
	
	
	@OneToMany(mappedBy = "supervisor")
	private Collection<Thesis> thesis;
	
	@ManyToMany(mappedBy = "reviewers")
	private Collection<Thesis> thesisForReviewers = new ArrayList<>();
	
	
	public void addThesisForReviewers (Thesis inputThesis) {
		if (!thesisForReviewers.contains(inputThesis)) {
			thesisForReviewers.add(inputThesis);
		}
	}


	public AcademicPersonel(
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String name,
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String surname,
			@NotNull @Pattern(regexp = "[0-9]{6}-[0-9]{5}") @Size(min = 12, max = 12) String personcode, User user,
			Degree degree) {
		super(name, surname, personcode, user);
		this.degree = degree;
	}
	
	
	
}
