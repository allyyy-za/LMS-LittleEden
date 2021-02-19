package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class GradesController implements Initializable {
	 	
		@FXML
	    private AnchorPane assignment1;

	    @FXML
	    private Label assignment1Score;

	    @FXML
	    private Label assignment1Percentage;

	    @FXML
	    private AnchorPane quiz1;

	    @FXML
	    private Label quiz1Score;

	    @FXML
	    private Label quiz1Percentage;

	    @FXML
	    private AnchorPane assignment2;

	    @FXML
	    private Label assignment2Score;

	    @FXML
	    private Label assignment2Percentage;

	    @FXML
	    private AnchorPane quiz2;

	    @FXML
	    private Label quiz2Score;

	    @FXML
	    private Label quiz2Percentage;
	    
	
	private static int scoreAssignment1;
	private static float percentAssignment1;
	private static int scoreQuiz1;
	private static float percentQuiz1;
	private static int scoreAssignment2;
	private static float percentAssignment2;
	private static int scoreQuiz2;
	private static float percentQuiz2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		quiz1.setVisible(false);
		quiz2.setVisible(false);
		assignment1.setVisible(false);
		assignment2.setVisible(false);
		
		GradesController.scoreAssignment1 = Student.getAssignmentScore1();
		GradesController.scoreQuiz1 = Student.getQuizScore1();
		GradesController.scoreAssignment2 = Student.getAssignmentScore2();
		GradesController.scoreQuiz2 = Student.getQuizScore2();
		
		
		if(GradesController.scoreAssignment1 != 0) {
			
			assignment1.setVisible(true);
			
			GradesController.percentAssignment1 = (float) ((GradesController.scoreAssignment1/6.00)*100);
			
			this.assignment1Score.setText(String.valueOf(GradesController.scoreAssignment1));
			this.assignment1Percentage.setText(String.valueOf(String.format("%.2f", GradesController.percentAssignment1)) + "%");
			
		
		}
		
		if(GradesController.scoreQuiz1 != 0) {
			
			quiz1.setVisible(true);
			
			GradesController.percentQuiz1 = (float) ((GradesController.scoreQuiz1/9.00)*100);
			
			this.quiz1Score.setText(String.valueOf(GradesController.scoreQuiz1));
			this.quiz1Percentage.setText(String.valueOf(String.format("%.2f", GradesController.percentQuiz1)) + "%");
		}
		
		if(GradesController.scoreAssignment2 != 0) {
			
			assignment2.setVisible(true);
			
			GradesController.percentAssignment2 = (float) ((GradesController.scoreAssignment2/11.00)*100);
			
			this.assignment2Score.setText(String.valueOf(GradesController.scoreAssignment2));
			this.assignment2Percentage.setText(String.valueOf(String.format("%.2f", GradesController.percentAssignment2)) + "%");
			
		}
		
		if(GradesController.scoreQuiz2 != 0) {
			
			quiz2.setVisible(true);
			
			GradesController.percentQuiz2 = (float) ((GradesController.scoreQuiz2/9.00)*100);
			
			this.quiz2Score.setText(String.valueOf(GradesController.scoreQuiz1));
			this.quiz2Percentage.setText(String.valueOf(String.format("%.2f", GradesController.percentQuiz2)) + "%");
		}	
	
	}
	

}
