package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MathColorsVideoController implements Initializable {
	@FXML private 
	WebView webcolorView;
	
	@FXML
	private WebEngine engine;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		engine = webcolorView.getEngine();
	}

    @FXML
    void btncolor1(ActionEvent event) {
    	engine.load("https://www.youtube.com/embed/tkpfg-1FJLU");
    }

    @FXML
    void btncolor2(ActionEvent event) {
    	engine.load("https://www.youtube.com/embed/SLZcWGQQsmg");
    }

    @FXML
    void btncolor3(ActionEvent event) {
    	engine.load("https://www.youtube.com/embed/IEF8_q5yDYc");
    }

    @FXML
    void btncolor4(ActionEvent event) {
    	engine.load("https://www.youtube.com/embed/79NNPQqNdks");
    }

}
