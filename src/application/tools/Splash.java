package application.tools;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ProgressBar;
import javafx.application.Preloader;

/**
 * 
 * @author Neo_Ryu
 */
public class Splash extends Preloader { 
	  
    private ProgressBar bar; 
    private Stage stage; 
  
    @Override 
    public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) { 
        if (stateChangeNotification.getType() == StateChangeNotification.Type.BEFORE_START) { 
            stage.hide(); 
        } 
    } 
  
    @Override 
    public void handleProgressNotification(ProgressNotification progressNotification) { 
        bar.setProgress(progressNotification.getProgress()); 
    }

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage; 
        bar = new ProgressBar(); 
        final BorderPane root = new BorderPane(); 
        root.setCenter(bar); 
        final Scene scene = new Scene(root, 300, 150); 
        stage.setScene(scene); 
        stage.show(); 		
	} 
}