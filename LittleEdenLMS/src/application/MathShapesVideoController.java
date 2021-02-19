package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MathShapesVideoController implements Initializable {
	
	@FXML 
	private WebView webView;
	
	@FXML
	private WebEngine engine;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		engine = webView.getEngine();	
	}
	
	public void buttonAction1(ActionEvent event) {
		engine.load("https://www.youtube.com/embed/TJhfl5vdxp4");
	}
	
	public void buttonAction2(ActionEvent event) {
		engine.load("https://www.youtube.com/embed/jbxXG6hwcRk");
	}
	
	public void buttonAction3(ActionEvent event) {
		engine.load("https://www.youtube.com/embed/lcl8uB2AWM0");
	}
	
	public void buttonAction4(ActionEvent event) {
		engine.load("https://www.youtube.com/embed/AnoNb2OMQ6s");
	}

}



