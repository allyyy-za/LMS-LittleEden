package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import application.database.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class Assignment2Controller implements Initializable {
	
	  @FXML
	    private AnchorPane Two;

	    @FXML
	    private ToggleGroup Five1;

	    @FXML
	    private RadioButton five;

	    @FXML
	    private ToggleGroup Three2;

	    @FXML
	    private RadioButton three;

	    @FXML
	    private ToggleGroup Seven3;

	    @FXML
	    private RadioButton seven;

	    @FXML
	    private RadioButton two;

	    @FXML
	    private ToggleGroup Two4;

	    @FXML
	    private RadioButton six;

	    @FXML
	    private ToggleGroup Six5;

	    @FXML
	    private ToggleGroup One6;

	    @FXML
	    private RadioButton one;

	    @FXML
	    private ToggleGroup Four7;

	    @FXML
	    private RadioButton four;

	    @FXML
	    private RadioButton seven2;

	    @FXML
	    private ToggleGroup Seven8;

	    @FXML
	    private RadioButton zero;

	    @FXML
	    private ToggleGroup Zero9;

	    @FXML
	    private ToggleGroup Nine10;

	    @FXML
	    private RadioButton nine;

	    @FXML
	    private ToggleGroup Ten11;

	    @FXML
	    private RadioButton ten;
	    
	    private int Score=0;
	    private static int totalScore;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    
    public void submitEvent(ActionEvent event) throws SQLException {
    	String kindScore = "assignment2Score";
    	String studentNumber = Student.getStudentNumber();
    	
    	RadioButton selectedOne = (RadioButton) Five1.getSelectedToggle();
    	RadioButton selectedTwo = (RadioButton) Three2.getSelectedToggle();
    	RadioButton selectedThree = (RadioButton) Seven3.getSelectedToggle();
    	RadioButton selectedFour = (RadioButton) Two4.getSelectedToggle();
    	RadioButton selectedFive = (RadioButton) Six5.getSelectedToggle();
    	RadioButton selectedSix = (RadioButton) One6.getSelectedToggle();
    	RadioButton selectedSeven = (RadioButton) Four7.getSelectedToggle();
    	RadioButton selectedEight = (RadioButton) Seven8.getSelectedToggle();
    	RadioButton selectedNine = (RadioButton) Zero9.getSelectedToggle();
    	RadioButton selectedTen = (RadioButton) Nine10.getSelectedToggle();
    	RadioButton selectedEleven = (RadioButton) Ten11.getSelectedToggle();

    	
    	if(selectedOne.getText().equals(five.getText()))
    		this.Score += 1;
    	if(selectedTwo.getText().equals(three.getText()))
    		this.Score += 1;
    	if(selectedThree.getText().equals(seven.getText()))
    		this.Score += 1;
    	if(selectedFour.getText().equals(two.getText()))
    		this.Score += 1;
    	if(selectedFive.getText().equals(six.getText()))
    		this.Score += 1;
    	if(selectedSix.getText().equals(one.getText()))
    		this.Score += 1;
    	if(selectedSeven.getText().equals(four.getText()))
    		this.Score += 1;
    	if(selectedEight.getText().equals(seven2.getText()))
    		this.Score += 1;
    	if(selectedNine.getText().equals(zero.getText()))
    		this.Score += 1;
    	if(selectedTen.getText().equals(nine.getText()))
    		this.Score += 1;
    	if(selectedEleven.getText().equals(ten.getText()))
    		this.Score += 1;
    	
    	Assignment2Controller.totalScore = this.Score;
    	Student.setAssignmentScore2(Assignment1Controller.totalScore);
    	
    	DbConnection.updateScoreDb(Assignment2Controller.totalScore, kindScore, studentNumber);

    }
    
}
