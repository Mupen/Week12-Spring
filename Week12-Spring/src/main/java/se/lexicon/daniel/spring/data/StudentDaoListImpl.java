package se.lexicon.daniel.spring.data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import se.lexicon.daniel.spring.model.StudentModel;

@Component
public class StudentDaoListImpl implements StudentDao  {
	private List<StudentModel> studentStorage = new ArrayList<>();
	
	@Override
	public StudentModel saveStudentToStorage(StudentModel studentObject) {
		try {
			this.studentStorage.add(studentObject);
			return studentObject;
		} 
		catch(NullPointerException e) {
			System.out.println("*** IllegalArgumentException ***");
		}
		return studentObject;
	}
		
	
	@Override
	public StudentModel findStudentById(Integer studentId) {
		Optional<StudentModel> tempStudent = studentStorage.stream()
				.filter(s->s.getStudentId()==studentId).findFirst();
		try {
			return tempStudent.get();
		} 
		catch(NullPointerException e) {
			System.out.println("*** IllegalArgumentException ***");
			StudentModel catchTempStudent = new StudentModel("", "", "");
			return catchTempStudent;
		}
	}
	
	@Override
	public List<StudentModel> findAllStudents() {
		List<StudentModel> tempStudentList = new ArrayList<StudentModel>();
		for(StudentModel tempStudent : studentStorage) {	
			try {tempStudentList.add(tempStudent);} 
			catch(NullPointerException e) {
				System.out.println("*** IllegalArgumentException ***");
			}
		}
		return tempStudentList;
	}
	
	@Override
	public StudentModel removeStudentById(Integer studentId) {
		StudentModel tempStudent = findStudentById(studentId);
		try {
			this.studentStorage.remove(tempStudent);
		} 
		catch(NullPointerException e) {
			System.out.println("*** IllegalArgumentException ***");
		}
		return tempStudent;
	}
}
