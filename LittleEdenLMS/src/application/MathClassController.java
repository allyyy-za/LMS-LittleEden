package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MathClassController {

    @FXML
    private AnchorPane mainBoard;


    @FXML
    void loadShapesPage(ActionEvent event) throws IOException {
    	FXMLLoader Loader = new FXMLLoader();
    	Loader.setLocation(getClass().getClassLoader().getResource("application/resources/MathShapes.fxml"));
    	Loader.load();
    	AnchorPane root = Loader.getRoot();
    	mainBoard.getChildren().setAll(root);
    }
    
    @FXML
    void loadColorsPage(ActionEvent event) throws IOException {
    	FXMLLoader Loader = new FXMLLoader();
    	Loader.setLocation(getClass().getClassLoader().getResource("application/resources/MathColors.fxml"));
    	Loader.load();
    	AnchorPane root = Loader.getRoot();
    	mainBoard.getChildren().setAll(root);
    }
    
    @FXML
    void loadNumbersPage(ActionEvent event) throws IOException {
    	FXMLLoader Loader = new FXMLLoader();
    	Loader.setLocation(getClass().getClassLoader().getResource("application/resources/MathNumbers.fxml"));
    	Loader.load();
    	AnchorPane root = Loader.getRoot();
    	mainBoard.getChildren().setAll(root);
    }

}
