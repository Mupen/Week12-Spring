package se.lexicon.daniel.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import se.lexicon.daniel.spring.config.ComponentScanConfig;
import se.lexicon.daniel.spring.data.StudentDao;
import se.lexicon.daniel.spring.data.StudentDaoListImpl;
import se.lexicon.daniel.spring.model.StudentModel;

@Service
public class StudentManagementConsoleImpl implements StudentManagement {
	private AnnotationConfigApplicationContext context;
	private UserInputService userInputInstance;
	private StudentDaoListImpl studentDaoInstance;

	@Autowired
	public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDaoListImp) {
        this.context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        this.studentDaoInstance = context.getBean(StudentDaoListImpl.class);
        this.userInputInstance = context.getBean(UserInputService.class);
	}

	@Override
	public StudentModel createStudent() {
		String userInputName = userInputInstance.getString("\n Name? ");
		String userInputEmail = userInputInstance.getString("\n Email? ");
		String userInputAddres = userInputInstance.getString("\n Addres? ");
		return studentDaoInstance.saveStudentToStorage(new StudentModel(userInputName, userInputEmail, userInputAddres));
	}
	
	@Override
	public StudentModel saveStudent(StudentModel studentObject) {
		return studentDaoInstance.saveStudentToStorage(studentObject);
		
	}
	
	@Override
	public StudentModel findStudentById(Integer studentid) {
		return studentDaoInstance.findStudentById(studentid);
		
	}
	
	@Override
	public StudentModel removeStudentById(Integer studentid) {
		return studentDaoInstance.removeStudentById(studentid);
		
	}
	
	@Override
	public List<StudentModel> findAllStudents() {
		return studentDaoInstance.findAllStudents();
	}
	
	@Override
	public StudentModel editStudent(StudentModel student) {
		String userInput = userInputInstance.getString("\n What action do you want to take? \n" +
				"\n" +
				" [Name]   Edit student Name. \n" +
				" [Email]   Edit student Email. \n" +
				" [Address]   Edit student Address. \n" +
				" \n" +
				" Your selection... "
				);
		switch (userInput.toLowerCase()) {
		case "name":
			System.out.println("");
			System.out.println("|-----------|");
			System.out.println("| Edit Name |");
			System.out.println("|-----------|");
			System.out.println("");
			String userInputName = userInputInstance.getString("\n Enter name... ");
			student.setStudentName(userInputName);
			break;
		case "email":
			System.out.println("");
			System.out.println("|------------|");
			System.out.println("| Edit Email |");
			System.out.println("|------------|");
			System.out.println("");
			String userInputEmail = userInputInstance.getString("\n Enter email... ");
			student.setStudentEmail(userInputEmail);
			break;
		case "address":
			System.out.println("");
			System.out.println("|--------------|");
			System.out.println("| Edit Address |");
			System.out.println("|--------------|");
			System.out.println("");
			String userInputAddress = userInputInstance.getString("\n Enter address... ");
			student.setStudentAddress(userInputAddress);
			break;
		default:
			System.out.println("");
			System.out.println("|-------------------|");
			System.out.println("| No such choice... |");
			System.out.println("|-------------------|");
			System.out.println("");

		}
		return student;
	}
}
