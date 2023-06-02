package lv.finals.models.users;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
	
	
	public void addThesisForReviewers (Thesis reviewer) {
		if (!thesisForReviewers.contains(reviewer)) {
			thesisForReviewers.add(reviewer);
		}
	}
	
}
