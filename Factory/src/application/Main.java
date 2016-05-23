package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		 
			try {
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/Factory.fxml"));
		        loader.getController();
		        Parent root;
				root = loader.load();
			     primaryStage.initStyle(StageStyle.UNDECORATED);
			        Scene sc = new Scene(root);
			        primaryStage.initStyle(StageStyle.TRANSPARENT);
			        sc.getStylesheets().add("/application/application.css");
			        sc.setFill(null);
			        primaryStage.setScene(sc);
			        primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
