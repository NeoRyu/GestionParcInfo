package application.tools;

import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;

import java.awt.Label;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;

/**
 * TODO : A FAIRE SPLASH SCREEN
 * @author Neo_Ryu
 */
public class Splash extends Application { 
	  
	private Pane splashLayout;
    private ProgressBar loadProgress;
    private Label progressText;
    private Stage mainStage;
    private static final int SPLASH_WIDTH = 600;
    private static final int SPLASH_HEIGHT = 300;

    public static void main(String[] args) throws Exception
    {
        launch(args);
    }

    @Override
    public void init()
    {
        
    }

    @Override
    public void start(final Stage initStage) throws Exception
    {
        
    }


    private void showSplash(final Stage initStage, Task task)
    {
        initStage.show();
    }
}