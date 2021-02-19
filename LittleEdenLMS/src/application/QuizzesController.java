package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class QuizzesController implements Initializable {
	
	@FXML
	private AnchorPane main;
	
	@FXML
    private AnchorPane readingQuiz;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		readingQuiz.setVisible(false);
		
	}
	
	public void showMathQuiz(MouseEvent event) throws IOException {
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getClassLoader().getResource("application/resources/QuizMath.fxml"));
		Loader.load();
		AnchorPane rootPane = Loader.getRoot();
		main.getChildren().setAll(rootPane);
	}
	
	public void showReadingQuiz(MouseEvent event) throws IOException {
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getClassLoader().getResource("application/resources/ReadingQuiz.fxml"));
		Loader.load();
		AnchorPane rootPane = Loader.getRoot();
		main.getChildren().setAll(rootPane);
	}
	

}
