package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MathColorsController implements Initializable {

    @FXML
    void loadMathVideosColors(ActionEvent event) throws IOException {
    	FXMLLoader Loader = new FXMLLoader();
    	
    	Loader.setLocation(getClass().getClassLoader().getResource("application/resources/MathColorsVideo.fxml"));
    	Loader.load();
    	AnchorPane rootPane = Loader.getRoot();
    	
    	Stage stage = new Stage();
    	stage.setResizable(false);
    	stage.setTitle("Little Eden TV");
    	Scene newScene = new Scene(rootPane);
    	
    	newScene.getStylesheets().add("application/resources/classes.css");
    	stage.setScene(newScene);
    	stage.initModality(Modality.APPLICATION_MODAL);
    	stage.show();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
