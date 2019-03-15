package se.lexicon.daniel.spring.model;

import java.util.Objects;

public class StudentModel {
	private static Integer sequencer = 0;
	private final Integer studentId;
	private String studentName;
	private String studentEmail;
	private String studentAddress;
	
	/**
	 * @param studentId
	 * @param studentName
	 * @param studentEmail
	 * @param studentAddress
	 */

	public StudentModel(String studentName, String studentEmail, String studentAddress) {
		this.studentId = ++sequencer;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
	}
	
	public int getStudentId() {return studentId;}

	public String getStudentName() {return studentName;}

	public void setStudentName(String studentName) {this.studentName = studentName;}

	public String getStudentEmail() {return studentEmail;}

	public void setStudentEmail(String studentEmail) {this.studentEmail = studentEmail;}

	public String getStudentAddress() {return studentAddress;}

	public void setStudentAddress(String studentAddress) {this.studentAddress = studentAddress;}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentModel other = (StudentModel) obj;
		return Objects.equals(studentAddress, other.studentAddress) && Objects.equals(studentEmail, other.studentEmail)
				&& studentId == other.studentId && Objects.equals(studentName, other.studentName);
	}

	public String stringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n *** Student List stringBuilder *** \n");
		
		sb.append(" [Id] = ");
		sb.append(studentId + "\n");
		
		sb.append(" [Name] = ");
		sb.append(studentName + "\n");
		
		sb.append(" [Email] = ");
		sb.append(studentEmail + "\n");
		
		sb.append(" [Address] = ");
		sb.append(studentAddress + "\n");

		return sb.toString(); 
	}
}
