package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import application.database.DbConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class DevelopersController implements Initializable {
	
		@FXML
		private AnchorPane scrollanchor;
		
		@FXML
		private TextField tf_name;
		
		@FXML
		private TextField tf_email;
		
		@FXML
		private TextArea ta_comment;

	    public void sendFeedback(MouseEvent event) throws SQLException {
	    	String name = tf_name.getText();
	    	String email = tf_email.getText();
	   		String comment = ta_comment.getText();
			
	   		DbConnection.sendFeedbackDb(name, email, comment);

	    }
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
