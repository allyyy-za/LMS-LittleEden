package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import application.database.DbConnection;
import java.sql.SQLException;


public class LoginController implements Initializable {

    @FXML
    private TextField Email;

    @FXML
    private PasswordField Password;

    @FXML
    private Label LoginMessage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    } 
    
    // login button event to check login
    
    public void LoginOnAction(ActionEvent event) throws IOException, SQLException {
    	String studentEmail = Email.getText();
    	String studentPassword = Password.getText();
    	
    	DbConnection.validateLogin(studentEmail, studentPassword);
    	
    	if(DbConnection.getValidation()==true) {
    		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		primaryStage.hide();
  
    		FXMLLoader Loader = new FXMLLoader();
    		Loader.setLocation(getClass().getClassLoader().getResource("application/resources/Homepage.fxml"));
    		Loader.load();
    		AnchorPane rootPane = Loader.getRoot();
    		Stage stage = new Stage();
    		stage.setResizable(false);
    		stage.setTitle("Little Eden");
    		Scene newScene = new Scene(rootPane);
    		newScene.getStylesheets().add("application/resources/application.css");
    		stage.setScene(newScene);
    		stage.show();
    	} else if(DbConnection.getValidation()==false) {
    		LoginMessage.setText("Login failed. Try again.");
    	}
    }
    
    // register button event to show the registration window
    
    public void RegisterOnAction(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.hide();
		AnchorPane rootPane = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/resources/Registration.fxml"));
		Scene newScene = new Scene(rootPane,400,500);
		newScene.getStylesheets().add("application/resources/application.css");
	    Stage stage = new Stage();
	    stage.setTitle("Little Eden");
	    stage.setScene(newScene);
	    stage.show(); 
    }
    
    // admin login link to show the admin login page
    
    public void showAdminLogin(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.hide();
		AnchorPane rootPane = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/resources/AdminLogin.fxml"));
		Scene newScene = new Scene(rootPane,700,400);
		newScene.getStylesheets().add("application/resources/application.css");
	    Stage stage = new Stage();
	    stage.setTitle("ADMIN: Little Eden");
	    stage.setScene(newScene);
	    stage.show(); 
    }
 
}
