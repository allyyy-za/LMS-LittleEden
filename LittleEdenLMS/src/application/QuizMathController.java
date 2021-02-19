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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class QuizMathController implements Initializable {
	
	  	@FXML
	  	private AnchorPane main;
		
		@FXML
	    private RadioButton circle;

	    @FXML
	    private ToggleGroup Clock;

	    @FXML
	    private ToggleGroup Window;

	    @FXML
	    private RadioButton square;

	    @FXML
	    private ToggleGroup Watermelon;

	    @FXML
	    private RadioButton triangle;

	    @FXML
	    private ToggleGroup Dolphin;

	    @FXML
	    private RadioButton blue;

	    @FXML
	    private ToggleGroup Crocodile;

	    @FXML
	    private RadioButton green;

	    @FXML
	    private RadioButton red;

	    @FXML
	    private ToggleGroup Bag;

	    @FXML
	    private ToggleGroup Balloons;

	    @FXML
	    private RadioButton nine;

	    @FXML
	    private RadioButton five;

	    @FXML
	    private ToggleGroup Hearts;

	    @FXML
	    private ToggleGroup Pencils;

	    @FXML
	    private RadioButton seven;

	    // controller variables
	    
	    private int Score;
	    private static int totalScore;
	    
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
		
		public void submitEvent(ActionEvent event) throws SQLException, IOException {
			String kindScore = "quiz1Score";
			String studentNumber = Student.getStudentNumber();
			
			RadioButton clock = (RadioButton) Clock.getSelectedToggle();
			RadioButton window = (RadioButton) Window.getSelectedToggle();
			RadioButton watermelon = (RadioButton) Watermelon.getSelectedToggle();
			RadioButton dolphin = (RadioButton) Dolphin.getSelectedToggle();
			RadioButton crocodile = (RadioButton) Crocodile.getSelectedToggle();
			RadioButton bag = (RadioButton) Bag.getSelectedToggle();
			RadioButton balloons = (RadioButton) Balloons.getSelectedToggle();
			RadioButton hearts = (RadioButton) Hearts.getSelectedToggle();
			RadioButton pencils = (RadioButton) Pencils.getSelectedToggle();
			
			if(clock.getText()==circle.getText())
				this.Score += 1;
			if(window.getText()==square.getText())
				this.Score += 1;
			if(watermelon.getText()==triangle.getText())
				this.Score += 1;
			if(dolphin.getText()==blue.getText())
				this.Score += 1;
			if(crocodile.getText()==green.getText())
				this.Score += 1;
			if(bag.getText()==red.getText())
				this.Score += 1;
			if(balloons.getText()==nine.getText())
				this.Score += 1;
			if(hearts.getText()==five.getText())
				this.Score += 1;
			if(pencils.getText()==seven.getText())
				this.Score += 1;
			
			QuizMathController.totalScore = this.Score;
			System.out.println(QuizMathController.totalScore + " is the score.");
			Student.setQuizScore1(QuizMathController.totalScore);
			
			DbConnection.updateScoreDb(QuizMathController.totalScore, kindScore, studentNumber);
			
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
			a.setContentText("Your quiz is recorded. Check Grades for your score.");
			a.show();
			
			
		}

}
