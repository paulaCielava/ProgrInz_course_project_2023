package lv.finals.models.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "person_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {


	@Setter(value = AccessLevel.NONE) 
	@Column(name = "Idu")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idp;
	
	@Column(name = "Name") 
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+")
	@Size(min = 3, max = 100)
	private String name;
	
	@Column(name = "Surname") 
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+")
	@Size(min = 3, max = 100)
	private String surname;
	
	@Column(name = "Personcode") 
	@NotNull
	@Pattern(regexp = "[0-9]{6}-[0-9]{5}")
	@Size(min = 12, max = 12)
	private String personcode;
	
	@OneToOne
	@JoinColumn(name = "Idu")
	private User user;

	public Person(
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String name,
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String surname,
			@NotNull @Pattern(regexp = "[0-9]{6}-[0-9]{5}") @Size(min = 12, max = 12) String personcode, User user) {
		this.name = name;
		this.surname = surname;
		this.personcode = personcode;
		this.user = user;
	}
	
	
	
	
}
