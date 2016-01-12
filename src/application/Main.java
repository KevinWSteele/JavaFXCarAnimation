package application;
//Kevin Steele

import javafx.animation.*;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Main extends Application {

final StringBuilder key = new StringBuilder();
	double rate;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			primaryStage.setTitle("Kevin Steele, Assignment 11");
	        Group root = new Group();
	        Rectangle Rec = new Rectangle(0,30, 50, 10);
	        Rec.setFill(Color.LIGHTGREEN);
	        Circle circle = new Circle(10, 45, 6);
	        Circle circle2 = new Circle(40, 45, 6);
	        Polygon poly = new Polygon();
	        poly.getPoints().addAll(new Double[]{
	                10.0, 30.0,
	                20.0, 20.0,
	                30.0, 20.0,
	                40.0, 30.0 } );
	        poly.setFill(Color.RED);
	        
	        root.getChildren().add(Rec);
	        root.getChildren().add(circle);
	        root.getChildren().add(circle2);
	        root.getChildren().add(poly);
	        
	        final Timeline timeline = new Timeline();
	        timeline.setCycleCount(Animation.INDEFINITE);
	        timeline.setAutoReverse(false);
	        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000),
	        new KeyValue (root.translateXProperty(), 350 )));
	        timeline.play();
	        primaryStage.setResizable(false);
	     
	        primaryStage.setScene(new Scene(root, 350, 55));
	        primaryStage.show();
	        
	        final String keyCombination1 = "_CONTROL_MINUS";
	        final String keyCombination2 = "_CONTROL_EQUALS";
	        
	        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                 String codeStr = event.getCode().toString();
	                 if(!key.toString().endsWith("_"+codeStr)){
	                      key.append("_"+codeStr);
	                 }
	            }
	       });
	                 
	      primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                 if(key.length()>0){
	                      if(key.toString().equals(keyCombination1)){
	                    	  rate = timeline.getRate();
	                    	  rate = rate * 0.75;
	                    	  timeline.setRate(rate);
	                          System.out.println("Slow Down");
	                                     
	                      }
	                      if(key.toString().equals(keyCombination2)){
	                    	  rate = timeline.getRate();
	                    	  rate = rate + 0.5;
	                    	  timeline.setRate(rate);
	                          System.out.println("Faster");
	                       
	                      }
	                      key.setLength(0);
	                 }
	            }
	       });
	      
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
