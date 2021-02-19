package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import application.database.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminHomepageController implements Initializable {
	
	@FXML
    private TableView<StudentTable> studentTable;

    @FXML
    private TableColumn<StudentTable, String> sNumber;

    @FXML
    private TableColumn<StudentTable, String> sName;

    @FXML
    private TableColumn<StudentTable, String> sAge;

    @FXML
    private TableColumn<StudentTable, String> sBirthday;

    @FXML
    private TableColumn<StudentTable, String> sStyle;

    @FXML
    private TableColumn<StudentTable, Integer> sScore1A;

    @FXML
    private TableColumn<StudentTable, Integer> sScore2A;

    @FXML
    private TableColumn<StudentTable, Integer> sScore1Q;

    @FXML
    private TableColumn<StudentTable, Integer> sScore2Q;
    
    @FXML
    private Label dateLabel;
    
    ObservableList<StudentTable> studentList = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		studentTable.setFocusTraversable(false);
		
		Date date=java.util.Calendar.getInstance().getTime();  
		String dateString = date.toString();
		dateLabel.setText(dateString);
		 
		try {
			Connection con = DbConnection.connect();
	    	PreparedStatement statement = con.prepareStatement("select * from Student");
	    	ResultSet rs = statement.executeQuery();
	    	
	    	while(rs.next()) {
	    		studentList.add(new StudentTable(rs.getString("studentNumber"),rs.getString("studentName"), rs.getString("studentAge")
						, rs.getString("studentBirthday"), rs.getString("studentStyle"), rs.getInt("assignment1Score")
						, rs.getInt("assignment2Score"), rs.getInt("quiz1Score"), rs.getInt("quiz2Score")));
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sNumber.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("studentNumber"));
		sName.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("studentName"));
		sAge.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("studentAge"));
		sBirthday.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("studentBirthday"));
		sStyle.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("studentStyle"));
		sScore1A.setCellValueFactory(new PropertyValueFactory<StudentTable, Integer>("scoreAssignment1"));
		sScore2A.setCellValueFactory(new PropertyValueFactory<StudentTable, Integer>("scoreAssignment2"));
		sScore1Q.setCellValueFactory(new PropertyValueFactory<StudentTable, Integer>("scoreQuiz1"));
		sScore2Q.setCellValueFactory(new PropertyValueFactory<StudentTable, Integer>("scoreQuiz2"));
	
		studentTable.setItems(studentList);
	}
	
	public void refreshEvent(ActionEvent event) throws IOException {
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.hide();

		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getClassLoader().getResource("application/resources/AdminHomepage.fxml"));
		Loader.load();
		AnchorPane rootPane = Loader.getRoot();
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("ADMIN: Little Eden");
		Scene newScene = new Scene(rootPane);
		newScene.getStylesheets().add("application/resources/application.css");
		stage.setScene(newScene);
		stage.show();
	}
	
	// delete button event
	
	public void deleteEvent(ActionEvent event) throws SQLException {
		StudentTable selected = studentTable.getSelectionModel().getSelectedItem();
		String studentNumber = selected.getStudentNumber().toString();
		
		Connection con = DbConnection.connect();
    	PreparedStatement preparedStatement = null;
		String query = "delete from Student where studentNumber = '" + studentNumber + "'";
		preparedStatement = con.prepareStatement(query);
    	preparedStatement.executeUpdate();
	
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("Data is removed. Refresh the table.");
	}
	
	// edit button event 
	
	public void editEvent(ActionEvent event) throws SQLException {
		
	}

}
