package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import application.database.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LSAssessmentController implements Initializable {

    @FXML
    private Text numberq;

    @FXML
    private Text titleq;

    @FXML
    private Text question1;

    @FXML
    private Text question2;

    @FXML
    private Text question3;

    @FXML
    private RadioButton yes1;

    @FXML
    private RadioButton yes2;

    @FXML
    private RadioButton yes3;
    
    @FXML
    private Button button;
    
    @FXML
    private Hyperlink loginLink;
    
    // non-fxml variables
    int yesV=0;
    int yesA=0;
    int page=1;
    String learningStyle;
    
    public void submit() throws SQLException {
    	
    	Connection con = DbConnection.connect();
    	PreparedStatement preparedStatement = null;
    	
    	
    	if(yesV>yesA)
    		learningStyle = "Visual Learner";
    	else if(yesA>yesV)
    		learningStyle = "Auditory Learner";
    	else if(yesA==yesV)
    		learningStyle = "Audio-Visual Learner";
    	else
    		System.out.println("Unable to tell.");
    
    	String query = "update Student set studentStyle='"+ learningStyle + "'where studentNumber='" + Student.getStudentNumber() + "'";
    	preparedStatement = con.prepareStatement(query);
    	preparedStatement.executeUpdate();
    	
    	Alert a = new Alert(AlertType.INFORMATION);
    	a.setContentText("Your learning style is " + learningStyle);
    	a.show();
    	
    	loginLink.setVisible(true);
    	

    }
    
    public void showLogin(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.hide();
		
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getClassLoader().getResource("application/resources/Login.fxml"));
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
    
    
    public void questionOnAction(ActionEvent e) throws IOException, SQLException {
    	if(page==2) {
    		if(yes1.isSelected()==true) {
        		if(page==1)
        			yesV++;
        		if(page==2)
        			yesA++;
        	}
        	
        	if(yes2.isSelected()==true) {
        		if(page==1)
        			yesV++;
        		if(page==2)
        			yesA++;
        	}
        	
        	if(yes1.isSelected()==true) {
        		if(page==1)
        			yesV++;
        		if(page==2)
        			yesA++;
        	}
    		submit();
    	} else {
    		if(yes1.isSelected()==true) {
        		if(page==1)
        			yesV++;
        		if(page==2)
        			yesA++;
        	}
        	
        	if(yes2.isSelected()==true) {
        		if(page==1)
        			yesV++;
        		if(page==2)
        			yesA++;
        	}
        	
        	if(yes1.isSelected()==true) {
        		if(page==1)
        			yesV++;
        		if(page==2)
        			yesA++;
        	}
        	yes1.setSelected(false);
        	yes2.setSelected(false);
        	yes3.setSelected(false);
	    	numberq.setText("2");
	    	button.setText("Submit");
	    	titleq.setText("Is your child an auditory learner?");
	    	question1.setText("My child excels at auditory activities (such as music).");
	    	question2.setText("My child does well when following verbal instructions.");
	    	question3.setText("My child enjoys talking and having conversations with others.");
	    	page++;
    	} 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	yes1.setSelected(false);
    	yes2.setSelected(false);
    	yes3.setSelected(false);

    	loginLink.setVisible(false);
    } 
    

}

