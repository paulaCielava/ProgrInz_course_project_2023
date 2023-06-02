package lv.finals.models;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.finals.models.users.AcademicPersonel;

@Table(name = "comments_personel")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comments {

	@Setter(value = AccessLevel.NONE) 
	@Column(name = "Idco")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idco;
	
	@Column(name = "Text")
	private String text;
	
	@Column(name = "DateTime")
	private LocalDateTime commentDate;
	
	
	@ManyToOne
	@JoinColumn(name = "Ida")
	private AcademicPersonel academicPersonal;
	
	
	@ManyToOne
	@JoinColumn(name = "Idt")
	private Thesis thesisComment;

	public Comments(String text, AcademicPersonel academicPersonal, Thesis thesisComment) {
		super();
		this.text = text;
		this.academicPersonal = academicPersonal;
		this.thesisComment = thesisComment;
		this.commentDate = LocalDateTime.now();
	}
	
	
	
	
	
	
	
	
	
	
	
}
