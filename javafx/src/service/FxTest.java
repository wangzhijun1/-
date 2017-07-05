package service;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FxTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * primaryStage.setTitle("Hello World"); Button btn = new Button();
		 * btn.setText("say hello world !"); btn.setOnAction(new
		 * EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) { // TODO
		 * Auto-generated method stub System.out.println("hello world"); } });
		 * StackPane root = new StackPane(); root.getChildren().add(btn);
		 * primaryStage.setScene(new Scene(root,300,250));
		 */

		/*
		 * Group root = new Group(); Scene scence = new
		 * Scene(root,800,600,Color.BLACK); primaryStage.setScene(scence);
		 * primaryStage.show();
		 */

		Group root = new Group();
		Scene scence = new Scene(root, 800, 600, Color.BLACK);
		primaryStage.setScene(scence);
		Rectangle rectangle = new Rectangle(scence.getWidth(), scence.getHeight(),
				new LinearGradient(0f, 1f, 1f, 0, true, CycleMethod.NO_CYCLE,
						new Stop[] { new Stop(0, Color.web("#f8bd55")), new Stop(0.14, Color.web("#c0fe56")),
								new Stop(0.28, Color.web("#5dfbc1")), new Stop(0.43, Color.web("#64c2f8")),
								new Stop(0.57, Color.web("#be4af7")), new Stop(0.71, Color.web("#ed5fc2")),
								new Stop(0.85, Color.web("#ef504c")), new Stop(1, Color.web("#f2660f")) }));

		Group circles = new Group();
		for (int i = 0; i < 30; i++) {
			   Circle circle = new Circle(150, Color.web("white", 0.05));
			   circle.setStrokeType(StrokeType.OUTSIDE);
			   circle.setStroke(Color.web("white", 0.16));
			   circle.setStrokeWidth(4);
			   circles.getChildren().add(circle);
		}
		/*
		 * root.getChildren().add(rectangle); root.getChildren().add(circles);
		 */
		Group blendModeGroup = new Group(new Rectangle(scence.getWidth(), scence.getHeight(), Color.BLACK), circles, rectangle);
		rectangle.setBlendMode(BlendMode.OVERLAY);
		root.getChildren().add(blendModeGroup);
		circles.setEffect(new BoxBlur(10, 10, 3));
		Timeline timeline = new Timeline();
		for (Node circle1: circles.getChildren()) {
		    timeline.getKeyFrames().addAll(
		        new KeyFrame(Duration.ZERO, // setstart position at 0
		            new KeyValue(circle1.translateXProperty(), Math.random() * 800),
		            new KeyValue(circle1.translateYProperty(), Math.random() * 600)
		        ),
		        new KeyFrame(new Duration(40000), //set end position at 40s
		            new KeyValue(circle1.translateXProperty(), Math.random() * 800),
		            new KeyValue(circle1.translateYProperty(), Math.random() * 600)
		        )
		    );
		}
		// play 40s ofanimation

		timeline.play();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
