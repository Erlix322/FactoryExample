package Controller;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MFactory {
	
	StringProperty auto = new SimpleStringProperty();
	BooleanProperty running = new SimpleBooleanProperty();
	
	
	public final StringProperty autoProperty() {
		return this.auto;
	}
	

	public final java.lang.String getAuto() {
		return this.autoProperty().get();
	}
	

	public final void setAuto(final java.lang.String auto) {
		this.autoProperty().set(auto);
	}


	public final BooleanProperty runningProperty() {
		return this.running;
	}
	


	public final boolean isRunning() {
		return this.runningProperty().get();
	}
	


	public final void setRunning(final boolean running) {
		this.runningProperty().set(running);
	}
	
	
	
	
	
}
