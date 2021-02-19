package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class Student implements Initializable {
	
	// basic information of the student
	
	private static String studentNumber;
	private static String studentName;
	private static String studentAge;
	private static String studentBirthday;
	private static String studentStyle;
	private static int QuizScore1;
	private static int AssignmentScore1;
	private static int QuizScore2;
	private static int AssignmentScore2;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	// constructor
	
	public Student(String number, String name, String age, String birthday, String style, int score1, int score2, int score3, int score4) {
		studentNumber = number;
		studentName = name;
		studentAge = age;
		studentBirthday = birthday;
		studentStyle = style;
		AssignmentScore1 = score1;
		AssignmentScore2 = score2;
		QuizScore1 = score3;
		QuizScore2 = score4;
	}
	
	// student number
	
	public static String getStudentNumber() {
		return studentNumber;
	}
	public static void setStudentNumber(String studentNumber) {
		Student.studentNumber = studentNumber;
	}
	
	// student name
	
	public static String getStudentName() {
		return studentName;
	}
	public static void setStudentName(String studentName) {
		Student.studentName = studentName;
	}
	
	// student age
	
	public static String getStudentAge() {
		return studentAge;
	}
	public static void setStudentAge(String studentAge) {
		Student.studentAge = studentAge;
	}
	
	// student birthday
	
	public static String getStudentBirthday() {
		return studentBirthday;
	}
	public static void setStudentBirthday(String studentBirthday) {
		Student.studentBirthday = studentBirthday;
	}
	
	// student style
	
	public static String getStudentStyle() {
		return studentStyle;
	}
	public static void setStudentStyle(String studentStyle) {
		Student.studentStyle = studentStyle;
	}

	public static int getQuizScore1() {
		return QuizScore1;
	}

	public static void setQuizScore1(int quizScore1) {
		QuizScore1 = quizScore1;
	}

	public static int getAssignmentScore1() {
		return AssignmentScore1;
	}

	public static void setAssignmentScore1(int assignmentScore1) {
		AssignmentScore1 = assignmentScore1;
	}

	public static int getQuizScore2() {
		return QuizScore2;
	}

	public static void setQuizScore2(int quizScore2) {
		QuizScore2 = quizScore2;
	}

	public static int getAssignmentScore2() {
		return AssignmentScore2;
	}

	public static void setAssignmentScore2(int assignmentScore2) {
		AssignmentScore2 = assignmentScore2;
	}
	

}
