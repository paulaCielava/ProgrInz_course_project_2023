package lv.finals.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.finals.models.users.Student;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
//@ToString
public class Course {
	
	@Setter(value = AccessLevel.NONE) // -> noņem anotāciju (set funkciju) tieši šim mainīgajam
	@Column(name = "Idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc; //idc - id course
	
	@Column(name = "Title")
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņūģ\\ ]+")
	@Size(min = 3, max = 30)
	private String title;
	
	@Column(name = "CreditPoints")
	@Min(value = 1)
	@Max(value = 20)
	private int creditPoints;
	
	@ManyToMany(mappedBy = "debtCourses")
	private Collection<Student> debtStudents = new ArrayList<>();

	//argumenta konstruktors 
	public Course(String title, int creditPoints) {
		this.title = title;
		this.creditPoints = creditPoints;
	}
	
	public void addStudent (Student student) {
		if(!debtStudents.contains(student)) {
			debtStudents.add(student);
		}
	}
	
	// TODO izveidot removeStudent
	
}
