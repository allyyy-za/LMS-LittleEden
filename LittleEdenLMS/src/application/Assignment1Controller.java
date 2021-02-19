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
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Assignment1Controller implements Initializable {

	@FXML
    private AnchorPane One;

    @FXML
    private RadioButton star;

    @FXML
    private ToggleGroup Star;

    @FXML
    private ToggleGroup Rectangle;

    @FXML
    private ToggleGroup Triangle;

    @FXML
    private RadioButton triangle;

    @FXML
    private RadioButton heart;

    @FXML
    private ToggleGroup Heart;

    @FXML
    private RadioButton square;

    @FXML
    private ToggleGroup Square;

    @FXML
    private ToggleGroup Diamond;

    @FXML
    private RadioButton diamond;

    @FXML
    private RadioButton rectangle;
    
    int Score=0;
    public static int totalScore=0;
    String starAnswer, rectangleAnswer, squareAnswer, diamondAnswer, heartAnswer, triangleAnswer;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	this.starAnswer = this.star.getText();
    	this.rectangleAnswer = this.rectangle.getText();
    	this.squareAnswer = this.square.getText();
    	this.diamondAnswer = this.diamond.getText();
    	this.heartAnswer = this.heart.getText();
    	this.triangleAnswer = this.triangle.getText();
    }    
    
    public void submitEvent(ActionEvent event) throws SQLException, IOException {
    	
    	String kindScore = "assignment1Score";
    	String studentNumber = Student.getStudentNumber();
    	
    	System.out.println("Submitted.");
    	
    	RadioButton selectedStar = (RadioButton) Star.getSelectedToggle();
    	RadioButton selectedRectangle = (RadioButton) Rectangle.getSelectedToggle();
    	RadioButton selectedDiamond = (RadioButton) Diamond.getSelectedToggle();
    	RadioButton selectedSquare = (RadioButton) Square.getSelectedToggle();
    	RadioButton selectedTriangle = (RadioButton) Triangle.getSelectedToggle();
    	RadioButton selectedHeart = (RadioButton) Heart.getSelectedToggle();
    	
    	
    	if(selectedStar.getText()==starAnswer)
    		this.Score += 1;
    	if(selectedRectangle.getText()==rectangleAnswer)
    		this.Score += 1;
    	if(selectedSquare.getText()==squareAnswer)
    		this.Score += 1;
    	if(selectedDiamond.getText()==diamondAnswer)
    		this.Score += 1;
    	if(selectedHeart.getText()==heartAnswer)
    		this.Score += 1;
    	if(selectedTriangle.getText()==triangleAnswer)
    		this.Score += 1;
    	
    	
    	Assignment1Controller.totalScore = this.Score;
    	System.out.println(Assignment1Controller.totalScore + " is the score.");
    	Student.setAssignmentScore1(Assignment1Controller.totalScore);
    	
    	DbConnection.updateScoreDb(Assignment1Controller.totalScore, kindScore, studentNumber);
    	
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
    	
    	Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("Your assignment is recorded. Check Grades for your score.");
		a.show();
		
		
    
    }
    
}
