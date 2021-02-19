package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ClassesController implements Initializable {

    @FXML
    private AnchorPane classesPage;
    
    @FXML
    private AnchorPane reading;
    
  
    @FXML
    void loadReadingPage(MouseEvent event) throws IOException {
    	FXMLLoader Loader = new FXMLLoader();
    	Loader.setLocation(getClass().getClassLoader().getResource("application/resources/MathClass.fxml"));
    	Loader.load();
    	AnchorPane root = Loader.getRoot();
    	classesPage.getChildren().setAll(root);	
    }
    
    @FXML
    public void loadMathPage(MouseEvent event) throws IOException {
    	FXMLLoader Loader = new FXMLLoader();
    	Loader.setLocation(getClass().getClassLoader().getResource("application/resources/MathClass.fxml"));
    	Loader.load();
    	AnchorPane root = Loader.getRoot();
    	classesPage.getChildren().setAll(root);
    	
    }
    
 

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		reading.setVisible(false);
	}

	
}
