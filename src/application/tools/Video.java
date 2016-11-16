package application.tools;

import javax.swing.*;

import application.MainAppFX;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.util.Duration;


public class Video extends JFrame {

  public static final String VID_URL = "https://api.telecharger-videos-youtube.com/file/20161116080220-1a140a6ab337496b870d5f630a1d97c6.mp4/sega-logo.mp4";
  
  private static final int VID_WIDTH     = 320;
  private static final int VID_HEIGHT    = 180;
  private static final int PLAYER_WIDTH  = 320;
  private static final int PLAYER_HEIGHT = 265;
  
  private MainAppFX mainAppFX;

  public void Splash(MainAppFX mainApp) {
	  this.mainAppFX = mainApp;
	  
	  	new Thread(new Runnable() {
	          @Override
	          public void run() {
					try {
						Thread.sleep(5200);
						System.out.println("EXIT SPLASH SCREEN");
						 mainAppFX.showOverview("viewer/Overview.fxml");
					} catch (InterruptedException e) {
						e.printStackTrace(); 
					}
	          }
	  	}).start();	
	    SwingUtilities.invokeLater(new Runnable() {
	    	@Override public void run() {
	    	  Video player = new Video();
	    	  player.play(VID_URL);
	    	
	    	}
	    });
  }  
  
  public void play(final String url) {
    final JFXPanel panel = new JFXPanel();
    Platform.runLater(new Runnable() {
    	@Override public void run() {
    		initFX(panel, url);
    	}
    });
    this.add(panel);
    this.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
  }
  

  private void initFX(JFXPanel panel, String url) {
    MediaView mediaView = MediaViewCustom(url);
    final Scene playerScene = new Scene(
    		PlayerLayoutCustom(mediaView), 
    		PLAYER_WIDTH, 
    		PLAYER_HEIGHT
    );
    panel.setScene(playerScene);
  }
  

  private MediaView MediaViewCustom(String url) {
    final Media clip = new Media(url);
    final MediaPlayer player = new MediaPlayer(clip);
    final MediaView view = new MediaView(player);
    view.setFitWidth(VID_WIDTH);
    view.setFitHeight(VID_HEIGHT);
    return view;
  }
  

  private VBox PlayerLayoutCustom(final MediaView view) {
	view.getMediaPlayer().seek(Duration.ZERO);
    view.getMediaPlayer().play();
    final VBox layout = new VBox(8);
    layout.setAlignment(Pos.CENTER);
    layout.getChildren().addAll(
      view
    );
    layout.setStyle("-fx-background-color: linear-gradient(to bottom, derive(white, -20%), blue);");
    return layout;
  }
  
}