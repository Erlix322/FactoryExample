package CarPool;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GreenCar implements Car{

	@Override
	public void showCar() {
		AnchorPane apane = new AnchorPane();
		ImageView img = new ImageView("Car_green.png");
		apane.setMaxSize(256, 256);
		apane.prefHeight(100.0);
		apane.prefWidth(100.0);
		apane.getChildren().add(img);
		Scene scene = new Scene(apane,256,256);
		Stage auto = new Stage();
		auto.setScene(scene);
		auto.show();		
	}

}
