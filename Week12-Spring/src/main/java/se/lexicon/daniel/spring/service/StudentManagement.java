package se.lexicon.daniel.spring.service;

import java.util.List;

import se.lexicon.daniel.spring.model.StudentModel;

public interface StudentManagement {
	public StudentModel findStudentById(Integer id);
	public StudentModel removeStudentById(Integer id);

	public List<StudentModel> findAllStudents();

	public StudentModel editStudent(StudentModel student);

	public StudentModel saveStudent(StudentModel studentObject);

	public StudentModel createStudent();
}
