package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.database.DbConnection;
import javafx.fxml.Initializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterController implements Initializable {


	@FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private TextField birthday;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Label confirmationMessage;

    @FXML
    private TextField number;
    
    @FXML
    private Hyperlink assessmentLink;
    
    // eventRegister will update the database
    
    public void eventRegister(ActionEvent event) throws IOException {
    	
    	Connection con = DbConnection.connect();
    	
    	try {
    		String studentNumber = number.getText();
    		String studentName = name.getText();
    		String studentBirthday = birthday.getText();
    		String studentAge = age.getText();
    		String studentEmail = email.getText();
    		String studentPassword = password.getText();
    		
    		Statement statement = con.createStatement();
    		
    		int status = statement.executeUpdate("insert into Student (studentNumber, studentName, studentBirthday, studentAge, studentEmail, studentPassword)" +
    						" values('" + studentNumber + "','" + studentName + "','" + studentBirthday + "','"+ studentAge + "','"+ studentEmail + "','" + studentPassword + "')");
    		
    		if(status>0) {
    			Student.setStudentNumber(studentNumber);
    			confirmationMessage.setText("Registered successfully.");
    			assessmentLink.setVisible(true);
    			con.close();
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	 
    	
    }
    
    public void proceedAssessment(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.hide();
		
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getClassLoader().getResource("application/resources/LSAssessment.fxml"));
		Loader.load();
		AnchorPane pane = Loader.getRoot();
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("Little Eden");
		Scene newScene = new Scene(pane);
		newScene.getStylesheets().add("application/resources/application.css");
		stage.setScene(newScene);
		stage.show();
		
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	assessmentLink.setVisible(false);
    	
    }    

}

