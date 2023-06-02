package lv.finals.models.users;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.finals.models.Course;
import lv.finals.models.Thesis;

@Table(name = "student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AttributeOverride(name = "Idp", column = @Column(name = "Ids")) //pārsauc Id 
public class Student extends Person{
	
	//TODO izveidot dataJPA anotācijaas 
	//TODO izveidot validāciju anotācijas
	//TODO izveidot sasaisti ar Course klasi ManyToMany
	@Column(name = "MatricumaNo")
	@NotNull
	@Pattern(regexp = "[0-9]{8,20}")
	private String matriculaNo;
	
	@Column(name = "FinancialDept")
	private boolean financialDept;

	
	@ManyToMany
	@JoinTable(name = "student_debt_courses_table", joinColumns = @JoinColumn(name = "Idc"), inverseJoinColumns = @JoinColumn(name = "Idp"))
	private Collection<Course> debtCourses = new ArrayList<>();
	
	@OneToMany(mappedBy = "student")
	private Collection<Thesis> thesis;
	
	
	
	
	
	
	
	public Student(
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String name,
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String surname,
			@NotNull @Pattern(regexp = "[0-9]{6}-[0-9]{5}") @Size(min = 12, max = 12) String personcode, User user,
			@NotNull @Pattern(regexp = "[0-9]{8,20}") String matriculaNo, boolean financialDept) {
		super(name, surname, personcode, user);
		this.matriculaNo = matriculaNo;
		this.financialDept = financialDept;
	}
	
	public void addDeptCourse (Course course) {
		if(!debtCourses.contains(course)) {
			debtCourses.add(course);
		}
	}
	
	
	// TODO izveidot remove debtCourses
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
