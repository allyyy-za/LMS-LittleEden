package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MathNumbersVideoController implements Initializable {

	@FXML
	private WebEngine engine;
	
	@FXML
	private WebView webnumberView;
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		engine = webnumberView.getEngine();	
	}

    @FXML
    void buttonviewNumber1(ActionEvent event) {
    	engine.load("https://www.youtube.com/embed/DR-cfDsHCGA");
    }

    @FXML
    void buttonviewNumber2(ActionEvent event) {
    	engine.load("https://www.youtube.com/embed/D0Ajq682yrA");
    }

    @FXML
    void buttonviewNumber3(ActionEvent event) {
    	engine.load("https://www.youtube.com/embed/xNw1SSz18Gg");
    }

    @FXML
    void buttonviewNumber4(ActionEvent event) {
    	engine.load("https://www.youtube.com/embed/_R9JK0Zbm0U");
    }


}
