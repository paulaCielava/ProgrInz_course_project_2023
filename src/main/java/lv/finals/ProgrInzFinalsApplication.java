package lv.finals;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.finals.models.Course;
import lv.finals.models.Thesis;
import lv.finals.models.users.AcademicPersonel;
import lv.finals.models.users.Degree;
import lv.finals.models.users.Student;
import lv.finals.models.users.User;
import lv.finals.repos.ICourseRepo;
import lv.finals.repos.IThesisRepo;
import lv.finals.users.repos.IAcademicPersonelRepo;
import lv.finals.users.repos.IPersonRepo;
import lv.finals.users.repos.IStudentRepo;
import lv.finals.users.repos.IUserRepo;

@SpringBootApplication
public class ProgrInzFinalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrInzFinalsApplication.class, args);
	}

	@Bean
	public CommandLineRunner testModel (ICourseRepo courseRepo, IThesisRepo thesisRepo, IAcademicPersonelRepo academicRepo, IPersonRepo personRepo, IStudentRepo studentRepo, IUserRepo userRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				User us1 = new User("123", "paula.cielava@venta.lv");
				User us2 = new User("123", "karlis.immers@venta.lv");
				User us3 = new User("123", "janis.berzins@venta.lv");
				User us4 = new User("123", "liene.klava@venta.lv");
				userRepo.save(us1);
				userRepo.save(us2);
				userRepo.save(us3);
				userRepo.save(us4);
				
				
				Course c1 = new Course("Javaa", 4);
				Course c2 = new Course("Datastr", 2);
				courseRepo.save(c1);
				courseRepo.save(c2);
				
				
				AcademicPersonel ac1 = new AcademicPersonel("Paula", "Cielava", "121212-14714", us1, Degree.bsc);
				AcademicPersonel ac2 = new AcademicPersonel("Karlis", "Immers", "310512-14714", us2, Degree.mg);
				academicRepo.save(ac1);
				academicRepo.save(ac2);
				
				Student s1 = new Student("Janis", "Berzins", "141414-99999", us3, "12345678", false);
				Student s2 = new Student("Liene", "Klava", "140591-98643", us4, "87456321", true);
				s2.addDeptCourse(c1);
				s2.addDeptCourse(c2);
				studentRepo.save(s1);
				studentRepo.save(s2);
				c1.addStudent(s2);
				c2.addStudent(s2);
				courseRepo.save(c1);
				courseRepo.save(c2);
				
				
				Thesis th1 = new Thesis("Sistemas izstrade", "Development of system", "Development", "1...2.3..4", s1, ac1);
				Thesis th2 = new Thesis("Petijums", "Research", "Research", "1...2.3..4", s2, ac2);
				th1.addReviewer(ac2);
				th2.addReviewer(ac1);
				thesisRepo.save(th1);
				thesisRepo.save(th2);
				ac1.addThesisForReviewers(th2);
				ac2.addThesisForReviewers(th1);
				academicRepo.save(ac1);
				academicRepo.save(ac2);
				
				
				
			}
		};
	}
	
	
	
}
