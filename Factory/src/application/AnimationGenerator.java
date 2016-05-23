package application;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

public class AnimationGenerator {


    public void applyRotationOn(Node node, int duration, double angle, int cycleCount) {
        RotateTransition rotateTransition =
                new RotateTransition(Duration.millis(duration), node);
        rotateTransition.setByAngle(angle);
        rotateTransition.setCycleCount(cycleCount);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();
    } 

    public void applyTranslateAnimationOn(Node node, int duration, double from, double to) {
        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(duration), node);
        translateTransition.setFromX(from);
        translateTransition.setToX(to);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }
    
    public void applyXYTranslateAnimationOn(Node node, int duration, double fromX, double toX, double fromY, double toY) {
        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(duration), node);
        translateTransition.setFromX(fromX);
        translateTransition.setToX(toX);
        translateTransition.setFromY(fromY);
        translateTransition.setToY(toY); 
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }
    
    public void applyFadeAnimation(Node node, int duration, double from, double to, EventHandler<ActionEvent> eventHandler){
    	FadeTransition fade = new FadeTransition(Duration.millis(duration),node);
    	fade.setOnFinished(eventHandler);
    	fade.setFromValue(from);
    	fade.setToValue(to);
    	fade.setAutoReverse(true);
    	fade.play();
    }
    
    public void scaleTransition(Node node, int duration, double from, double to){
    	ScaleTransition scale = new ScaleTransition(Duration.millis(duration),node);
    	scale.setFromX(from);
    	scale.setToX(to);
    	scale.setAutoReverse(true);
    	scale.play();
    }

}
