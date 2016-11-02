package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/*
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Collection;
import java.util.Date;
*/

import application.DAO.objets.*;

/**
 *
 * @author Neo_Ryu
 */
public class MainAppFX extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Machine> Data = FXCollections.observableArrayList();
 
    public MainAppFX() {
    	
    	// ICI : Récupération des données SGBD pour affichage
    	// A titre d'exemple : Ajout de plusieurs lignes test
    	Data.add(new Machine("1","localhost", "localhost", null, "0", "128.0.0.1", "root", null));
    	
    }
    
    public ObservableList<Machine> getData() {
    	 return Data;
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        /*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        */
        
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Parc informatique");
        initRootLayout();
        showOverview();

    }
    
    public void initRootLayout() {
        try {
            // Chargement du layout racine Ã  partir du fichier fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAppFX.class.getResource("viewer/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Montrer la scene contenant le layout racine
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showOverview() {
        try {
            // charger l'apercu (overview) fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAppFX.class.getResource("viewer/FXMLOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            
            // charger cet apercu au centre du layout racine
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
