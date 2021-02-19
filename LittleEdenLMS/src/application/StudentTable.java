package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class StudentTable implements Initializable {
	
	private String studentNumber;
	private String studentName;
	private String studentAge;
	private String studentBirthday;
	private String studentStyle;
	private int scoreAssignment1;
	private int scoreAssignment2;
	private int scoreQuiz1;
	private int scoreQuiz2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public StudentTable (String number, String name, String age, String birthday, String style, int score1, int score2, int score3, int score4) {
		this.setStudentNumber(number);
		this.studentName = name;
		this.studentAge = age;
		this.studentBirthday = birthday;
		this.studentStyle = style;
		this.scoreAssignment1 = score1;
		this.scoreAssignment2 = score2;
		this.scoreQuiz1 = score3;
		this.scoreQuiz1 = score4;
	}

	public int getScoreQuiz2() {
		return scoreQuiz2;
	}

	public void setScoreQuiz2(int scoreQuiz2) {
		this.scoreQuiz2 = scoreQuiz2;
	}

	public int getScoreQuiz1() {
		return scoreQuiz1;
	}

	public void setScoreQuiz1(int scoreQuiz1) {
		this.scoreQuiz1 = scoreQuiz1;
	}

	public int getScoreAssignment2() {
		return scoreAssignment2;
	}

	public void setScoreAssignment2(int scoreAssignment2) {
		this.scoreAssignment2 = scoreAssignment2;
	}

	public int getScoreAssignment1() {
		return scoreAssignment1;
	}

	public void setScoreAssignment1(int scoreAssignment1) {
		this.scoreAssignment1 = scoreAssignment1;
	}

	public String getStudentStyle() {
		return studentStyle;
	}

	public void setStudentStyle(String studentStyle) {
		this.studentStyle = studentStyle;
	}

	public String getStudentBirthday() {
		return studentBirthday;
	}

	public void setStudentBirthday(String studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

}
