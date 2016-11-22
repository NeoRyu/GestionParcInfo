package application;

import application.beans.Composant;
import application.beans.Machine;
import application.dao.DAOMachine;
import application.tools.LectureRB;
import application.viewer.RootLayoutController;
import application.viewer.SplashController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import application.tools.Language;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import application.viewer.OverviewController;
import application.viewer.ComposantController;
import application.viewer.MachineController;
import application.viewer.MachineEditDialogController;

/**
 * 
 * @author Neo_Ryu
 */
public class MainAppFX extends Application {


    static DAOMachine daoMachine = new DAOMachine();
    private Stage primaryStage;
    private Scene scene;
    private BorderPane rootLayout;

    private ObservableList<Machine> DataMachine = FXCollections.observableArrayList();
    public static Font f;

    private boolean TEST = false;

    public MainAppFX() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (TEST) {
                    // JEU D'ESSAI HORS LIGNE
                    DataMachine.add(new Machine(0,1, "localhost", "333 4444", "2016-10-10", 2,"PC", "127.0.0.1",false,1,new ArrayList<Composant>()));
                    DataMachine.add(new Machine(1,1, "ANDEUXK", "365 2000", "1999-12-31", 1,"BUG", "4.5.1.6", false,1,new ArrayList<Composant>()));
                    DataMachine.add(new Machine(2,1, "MAYA", "212 2012", "2012-12-21", 2,"MAYA", "21.12.20.12",false,1,new ArrayList<Composant>()));
                    DataMachine.add(new Machine(3,1, "MIR", "222 1345", "1999-08-11", 2, "MIR", "48.86.2.33",false,1,new ArrayList<Composant>()));
                } else {
                    // JEU D'ESSAI BDD
                    List<Machine> liste = daoMachine.lecture(LectureRB.lireRB("query", "lectureMachines"));
                    DataMachine.addAll(liste);
                }
                // On récupère d'abord les données a partir du SGBD pour permettre l'affichage
                //   getDataMachine();

            }
        });

    }


    // Récupération des données dans une liste d'objets observables de type Machine
    public void getDataMachine() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                List<Machine> liste = daoMachine.lecture(LectureRB.lireRB("query", "lectureMachines"));
                DataMachine.addAll(liste);
            }
        });

    }
    public ObservableList<Machine> getData() {
        return DataMachine;
    }

    @Override
    public void start(Stage primaryStage) {
        // GESTION DE LA LANGUE
        ResourceBundle language = ResourceBundle.getBundle("application.resources.Lang");
        Language.setLang(new Locale(language.getString("lang"), language.getString("pays")));
        System.out.println("(MainAppFX) Langue définie sur : "+Language.getLang().toString());
        Language.setRsc(ResourceBundle.getBundle("application.resources.UIResources", Language.getLang()));

        // GESTION DE LA POLICE D'ECRITURE
        try {
            f = Font.loadFont(new FileInputStream(new File("src/application/8BIT.TTF")), 12);
            //System.out.println(f.getFamily());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // TITRE + ICONE
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ITpark Manager");
        this.primaryStage.getIcons().add(new Image("@../../res/itmp.png"));
        primaryStage.setResizable(false);
        primaryStage.setMaxHeight(545);
        primaryStage.setMaxWidth(575);

        
        // Methode permettant d'appeler le layout d'intro
        String  choixLayout = "viewer/Overview.fxml";        
        if (ResourceBundle.getBundle("application.Config").getString("sound").equals("ON")) {
        	// Mettre dans Config.properties : Sound = ON
        	choixLayout = "viewer/Splash.fxml";
        }

        
        // On affiche les layouts
        initRootLayout(choixLayout);
        showOverview(choixLayout);
    }

    public void initRootLayout(String choixLayout) {
        try {
            // Chargement du layout racine à partir du fichier fxml
            ResourceBundle bundle = Language.getsetRsc(ResourceBundle.getBundle("application.resources.UIResources", Language.getLang()));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewer/RootLayout.fxml"), bundle);
            loader.setLocation(MainAppFX.class.getResource("viewer/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            loader.setController(this);

            // Montrer la scene contenant le layout racine
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().addAll(this.getClass().getResource("viewer/theme_RootLayout.css").toExternalForm());
            primaryStage.setScene(scene);

            // Accorder au controller un acces a MainAppFX
            RootLayoutController.setMainApp(this, choixLayout);

            // Affichage de la scene dans le stage
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshRootLayout(String LayoutActuel) {
        try {
            // Chargement du layout racine à partir du fichier fxml
            Language.setRsc(ResourceBundle.getBundle("application.resources.UIResources", Language.getLang()));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewer/RootLayout.fxml"), Language.getRsc());
            loader.setLocation(MainAppFX.class.getResource("viewer/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            loader.setController(this);

            // Montrer la scene contenant le layout racine
            scene = new Scene(rootLayout);
            scene.getStylesheets().addAll(this.getClass().getResource("viewer/theme_RootLayout.css").toExternalForm());
            primaryStage.setScene(scene);

            // Accorder au controller un acces a MainAppFX
            RootLayoutController.setMainApp(this, LayoutActuel);
            showOverview(LayoutActuel);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showOverview(String choixLayout) {
        try {
            // charger l'apercu (overview) fxml
            Language.setRsc(ResourceBundle.getBundle("application.resources.UIResources", Language.getLang()));
            FXMLLoader loader = new FXMLLoader(getClass().getResource(choixLayout), Language.getRsc());
            loader.setLocation(MainAppFX.class.getResource(choixLayout));
            AnchorPane overview = (AnchorPane) loader.load();

            // charger cet apercu au centre du layout racine
            rootLayout.setCenter(overview);

            // TODO - ajouts des données dans le tableview controller
            switch (choixLayout) {
	            case "viewer/Splash.fxml" :
	                SplashController SplashCtrl = loader.getController();
	                SplashCtrl.setMainAppFX(this);	                
	                break;
                case "viewer/Machine.fxml" :
                    MachineController machineCtrl = loader.getController();
                    machineCtrl.setMainAppFX(this);
                    break;
                case "viewer/Composant.fxml" :
                    ComposantController composantCtrl = loader.getController();
                    composantCtrl.setMainAppFX(this);
                    break;
                case "viewer/Overview.fxml" :
                default :
                    OverviewController overviewCtrl = loader.getController();
                    overviewCtrl.setMainAppFX(this);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean showMachineEditDialog(Machine machine) {
        try {
            // Charge le fichier FXML et creation d'un nouveau stage dans une popup
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAppFX.class.getResource("viewer/MachineEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Creation du Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("ITpark Manager Editor");
            dialogStage.getIcons().add(new Image("@../../res/itmp.png"));
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Configure l'objet (machine) dans un controlleur
            MachineEditDialogController MachineEDC = loader.getController();
            MachineEDC.setDialogStage(dialogStage);
            MachineEDC.setMachine(machine);

            // Montre la popup tant qu'elle n'est pas fermée
            dialogStage.showAndWait();
            return MachineEDC.isOkClic();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public Scene getScene() {
        return scene;
    }
    
    // [DEBUG MODE] Methode permettant l'affichage des ressources disponibles dans le dossier visé
    // MainAppFX.explorer("\\bin\\res\\");
    public static void explorer(String path) {
    	System.out.println("\n"+System.getProperty("user.dir")+path +" :");
		File files = new File(System.getProperty("user.dir")+path);			
		for (File file : files.listFiles()) System.out.println("fichier : " + file.getName());
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
