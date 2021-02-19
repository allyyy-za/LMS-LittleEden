package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class HomepageController implements Initializable {   
    
    @FXML
    private AnchorPane main;
	
	@FXML
    private AnchorPane body;
    
    @FXML
    private Label welcomename;
    
    @FXML
    private Button classesBtn;
    
    @FXML
    private Label displayName;

    @FXML
    private Label displayAge;

    @FXML
    private Label displayBirthday;

    @FXML
    private Label displayStyle;
    
    
	private static String studentName;
	private static String studentAge;
	private static String studentBirthday;
	private static String studentStyle;
	
    @Override
    public void initialize(URL url, ResourceBundle rb){
    	
    	HomepageController.studentName = Student.getStudentName();
    	HomepageController.studentAge = Student.getStudentAge();
    	HomepageController.studentBirthday = Student.getStudentBirthday();
    	HomepageController.studentStyle = Student.getStudentStyle();
    	
    	this.welcomename.setText(HomepageController.studentName);
    	this.displayName.setText(HomepageController.studentName);
    	this.displayAge.setText(HomepageController.studentAge);
    	this.displayBirthday.setText(HomepageController.studentBirthday);
    	this.displayStyle.setText(HomepageController.studentStyle);
    }    
    
    // homeEvent to go back to homepage
    
    public void homeEvent(ActionEvent event) throws IOException, SQLException {
    	
    	FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getClassLoader().getResource("application/resources/Homepage.fxml"));
		Loader.load();
		AnchorPane rootPane = Loader.getRoot();
		main.getChildren().setAll(rootPane);
		
    }
    
    // developersEvent to show the developers page
    
    public void developersEvent(MouseEvent event) throws IOException {
    	loadPage("Developers");
    }
    
    
    // classesEvent to show the classes page
    
    public void classesEvent(ActionEvent event) throws IOException {
    	loadPage("Classes");
    
    }
    
    // assignmentEvent to show the assignment page
    
    public void assignmentEvent(ActionEvent event) throws IOException {
    	loadPage("Assignment");
    }
    
    
    // gradesEvent to show the grades page
    
    public void gradesEvent(ActionEvent event) throws IOException {
    	loadPage("Grades");
    	//System.out.println(this.studentId);
    	//System.out.println(this.studentName);
    }
    
    // quizzesEvent to show the quizzes page
    
    public void quizzesEvent(ActionEvent event) throws IOException {
    	loadPage("Quizzes");
    }
    
    
    // loadPage to load a specific page
    
    private void loadPage(String page) throws IOException {
    	
    	FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getClassLoader().getResource("application/resources/"+page+".fxml"));
		Loader.load();
		AnchorPane rootPane = Loader.getRoot();
		this.body.getChildren().setAll(rootPane);
    }
}

