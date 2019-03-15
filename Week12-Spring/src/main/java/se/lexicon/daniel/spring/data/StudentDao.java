package se.lexicon.daniel.spring.data;

import java.util.List;

import se.lexicon.daniel.spring.model.StudentModel;

public interface StudentDao {
	
	public StudentModel saveStudentToStorage(StudentModel studentObject);
	public StudentModel findStudentById(Integer studentid);
	public StudentModel removeStudentById(Integer studentId);
	public List<StudentModel> findAllStudents();
	
}
