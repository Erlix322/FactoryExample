package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import CarPool.Car;
import CarPool.FactoryCars;
import application.AnimationGenerator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CFactory implements Initializable{
	ObservableList<String> list = FXCollections.observableArrayList();
	
	MFactory model = new MFactory();
	
	@FXML
	AnchorPane pane;
	@FXML
	ChoiceBox choice;
	@FXML
	ImageView cloud;
	@FXML
	Button btn;
	AnimationGenerator anim = new AnimationGenerator();
	FactoryCars fac = new FactoryCars();
	
	private static final int startX = 0;
    private static final int endX = 100;
    private static final int startY = 0;
    private static final int endY = -150;
    
    @FXML
    public void startWork(){
    	ImageView newCloud = new ImageView("cloud.png");
    	newCloud.setLayoutX(132.0);
    	newCloud.setLayoutY(51.0);
    	newCloud.setFitHeight(109.0);
    	newCloud.setFitWidth(171.0);
    	pane.getChildren().add(newCloud);
    	
    	
   
    	Task ta = new Task(){
    		
    		int i = 0;
			@Override
			protected Object call() throws Exception {
				while(i<10){
					model.setRunning(true);
					anim.applyXYTranslateAnimationOn(newCloud, 500, startX, endX,startY,endY);
			    	anim.scaleTransition(newCloud, 500, 1, 3);
			    	i++;
			    	Thread.sleep(500);
				}
				return null;
			}
    		
    	};
    	
    	ta.setOnSucceeded(new EventHandler(){

			@Override
			public void handle(Event event) {
				System.out.println("***************Arbeit ist vollbracht!***************"
						+"\nAuto: "+model.getAuto()+" hergestellt");				
				
			fac.getCar(model.getAuto()).createCar();
			model.setRunning(false);
		
			}
    		
    	});
    	
    	Thread td = new Thread(ta);
    	td.start();
    	
    	
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pane.setStyle("-fx-background-color:transparent;");
		list.add("Blau"); list.add("Grün");list.add("Rot");
		btn.disableProperty().bindBidirectional(model.runningProperty());
		
		choice.setItems(list);
		choice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					model.setAuto(newValue);
			}
			
		});
		choice.getSelectionModel().selectFirst();
	}

}
