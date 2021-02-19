package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import application.database.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminLoginController implements Initializable {
	
	@FXML
	private TextField Username;

	@FXML
	private PasswordField Password;

	@FXML
	private Label LoginMessage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void LoginOnAction(ActionEvent event) throws IOException, SQLException {
    	String username = Username.getText();
    	String password = Password.getText();
    	
    	if(DbConnection.validateAdmin(username, password)==true) {
    		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		primaryStage.hide();
  
    		FXMLLoader Loader = new FXMLLoader();
    		Loader.setLocation(getClass().getClassLoader().getResource("application/resources/AdminHomepage.fxml"));
    		Loader.load();
    		AnchorPane rootPane = Loader.getRoot();
    		Stage stage = new Stage();
    		stage.setResizable(false);
    		stage.setTitle("ADMIN: Little Eden");
    		Scene newScene = new Scene(rootPane);
    		newScene.getStylesheets().add("application/resources/application.css");
    		stage.setScene(newScene);
    		stage.show();
    	} else {
    		LoginMessage.setText("Login failed. Try again.");
    	}
    	
	}

}
