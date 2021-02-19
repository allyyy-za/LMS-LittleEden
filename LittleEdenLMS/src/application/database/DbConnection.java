package application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import application.Student;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DbConnection {
	
	private static Boolean validation = false;
	
	// connection to database
	
	public static Connection connect() {
		Connection con = null;
		 try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:Student.db"); // connecting to our database
			System.out.println("Connected.");
		 } catch (ClassNotFoundException | SQLException e) {
			System.out.println(e+"");
		}
		 return con;
	}
	
	
	// for the validation of login credentials
	
	public static void validateLogin(String email, String password) throws SQLException {
		
	
    	Connection con = DbConnection.connect();
    	Statement statement = con.createStatement();
    	ResultSet rs = statement.executeQuery("select * from Student where studentEmail = '" + email + "' and studentPassword = '" + password + "'");
    	
    	if(rs.next()) {
    		Student.setStudentNumber(rs.getString("studentNumber"));
    		Student.setStudentName(rs.getString("studentName"));
    		Student.setStudentBirthday(rs.getString("studentBirthday"));
    		Student.setStudentAge(rs.getString("studentAge"));
    		Student.setStudentStyle(rs.getString("studentStyle"));
    		Student.setAssignmentScore1(rs.getInt("assignment1Score"));
    		Student.setQuizScore1(rs.getInt("quiz1Score"));
    		Student.setAssignmentScore2(rs.getInt("assignment2Score"));
    		Student.setQuizScore2(rs.getInt("quiz2Score"));
    		setValidation(true);
    		con.close();
    	}
    	else
    		con.close();
	}

	
	// setter and getter of validation for login
	
	public static Boolean getValidation() {
		return validation;
	}

	public static void setValidation(Boolean validation) {
		DbConnection.validation = validation;
	}
	
	
	// send feedback to database
	
	public static void sendFeedbackDb(String name, String email, String comment) throws SQLException {
		Connection con = DbConnection.connect();
		Statement statement = con.createStatement();
		int status = statement.executeUpdate("insert into Feedback (studentName, studentEmail, studentComment)" +
						" values('" + name + "','" + email + "','" + comment  + "')");
		
    	if(status>0)  {
    		System.out.println("Feedback sent.");
    		Alert a = new Alert(AlertType.INFORMATION);
    		a.setContentText("Your feedback is sent.");
    		a.show();
    		con.close();
    	}
	}
	
	// send score to database
	
	public static void updateScoreDb(int score, String kindScore, String studentNumber) throws SQLException {
		
		Connection con = DbConnection.connect();
    	PreparedStatement preparedStatement = null;
    	String query = "update Student set '" + kindScore + "'='" + score + "'where studentNumber='" + studentNumber + "'";
    	preparedStatement = con.prepareStatement(query);
    	preparedStatement.executeUpdate();
    	
    	con.close();
		
	}
	
	// validate login of admin
	
	public static boolean validateAdmin(String username, String password) throws SQLException {
		
		boolean admin = false;
		
		Connection con = DbConnection.connect();
    	Statement statement = con.createStatement();
    	ResultSet rs = statement.executeQuery("select * from Admin where username = '" + username + "' and password = '" + password + "'");
    	
    	if(rs.next())
    		admin = true;
		
    	con.close();
		return admin;
	}
	
}
