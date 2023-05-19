package lv.finals.models.users;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "User_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
// pievienot @ToString ,ja ir nepieciešams
public class User {
	
	@Setter(value = AccessLevel.NONE) // -> noņem anotāciju (set funkciju) tieši šim mainīgajam
	@Column(name = "Idu")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idu;
	
	
	@Column(name = "Password")
	@NotNull
	//TODO papildināt ar validāciju, kad ir zināms passwordEncoder
	@Size(min = 8, max = 40)
	private String password; //TODO kad pievienos spring security tad jauzliek passwordEncoder
	
	
	@Column(name = "Email")
	@NotNull
	@Email
	private String email;


	public User(@NotNull @Size(min = 8, max = 40) String password, @NotNull @Email String email) {
		this.password = password;
		this.email = email;
	}
	
	
	
	
	
}
