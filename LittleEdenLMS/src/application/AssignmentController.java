package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class AssignmentController implements Initializable {
	
	@FXML
	private VBox vBox;

	@FXML
	private AnchorPane mainPane;
	
	@FXML
	private AnchorPane One, Two;

    @Override
    public void initialize(URL url, ResourceBundle rb)  {
    
    }    


    public void assignment1Event(ActionEvent event) throws IOException {
	    vBox.setVisible(false);
	    FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getClassLoader().getResource("application/resources/Assignment1.fxml"));
		Loader.load();
		AnchorPane rootPane = Loader.getRoot();
		this.mainPane.getChildren().setAll(rootPane);
    }


	public void assignment2Event(ActionEvent event) throws IOException {
		vBox.setVisible(false);
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getClassLoader().getResource("application/resources/Assignment2.fxml"));
		Loader.load();
		AnchorPane rootPane = Loader.getRoot();
		this.mainPane.getChildren().setAll(rootPane);
	}

}

      

