package lv.finals.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.finals.models.users.AcademicPersonel;
import lv.finals.models.users.Student;

@Table(name = "thesis_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
//@ToString
public class Thesis {
	
	@Setter(value = AccessLevel.NONE) // -> noņem anotāciju (set funkciju) tieši šim mainīgajam
	@Column(name = "Idt")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idt;
	
	@Column(name = "TitleEn")
	// TODO pievienot validācijas
	private String titleEn;
	
	@Column(name = "TitleLv")
	// TODO pievienot validācijas
	private String titleLv;
	
	@Column(name = "Aim")
	// TODO pievienot validācijas
	private String aim; //mērķi
	
	@Column(name = "Tasks")
	// TODO pievienot validācijas
	private String tasks; //uzdevumi
	
	//TODO servisā vai konstruktorā pie jauna objekta izveides japievieno LocalDateTime.now()
	@Column(name = "SubmitDateTime")
	private LocalDateTime submitDateTime;  //saņemšanas datums
	
	@Column(name = "StatusFromSupervisor")
	private boolean statusFromSupervisor;
	
	// TODO servisā vai konstruktorā uzlikt pēc noklusējuma 
	@Column(name = "AccStatus")
	private AcceptanceStatus accStatus; 
	
	@Column(name = "AccDateTime")
	private LocalDateTime accDateTime;
	
	
	
	@ManyToOne
	@JoinColumn(name = "Ids")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "Ida")
	private AcademicPersonel supervisor;
	
	// TODO ja nepieciešams izveidot saitu starp konsultantu, vērtētāju utt.
	
	
	
	
	
	
}
