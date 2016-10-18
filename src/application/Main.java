package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);	// C'est la seule instruction que doit contenir la fonction main()
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Création du groupe root (root = 1 par scene)
			Group root = new Group();
			//BorderPane root = new BorderPane();
			
		 // Création de la scène
			Scene scene = new Scene(root,400,400, Color.LIGHTBLUE);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
	        
	     // CERCLE
	        Circle cercle = new Circle();
	        cercle.setCenterX(200);//réglage de la position, de la taille et de la couleur du cercle
	        cercle.setCenterY(200);
	        cercle.setRadius(100);
	        cercle.setFill(Color.DARKBLUE);
	        cercle.setStroke(Color.BLUE);//réglage de la couleur de la bordure et de son épaisseur
	        cercle.setStrokeWidth(5);
	        root.getChildren().add(cercle);//on ajoute le cercle au groupe root
	        
	     // Ajout d'un bouton
 			Button btn = new Button();
 	        btn.setLayoutX(150);
 	        btn.setLayoutY(80);
 	        btn.setText("Hello World");
 	        btn.setOnAction(new EventHandler<ActionEvent>() {

 	            public void handle(ActionEvent event) {
 	                System.out.println("Hello World");
 	            }
 	        });
 	        root.getChildren().add(btn);
	        
	     // Affichage de la fenêtre
	     	primaryStage.setTitle("Hello World");	 
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
