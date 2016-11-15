package application.tools;

import application.MainAppFX;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

/**
*
* @author Neo_Ryu
*/
public class Sound {
	
	// VARIABLES / INSTANCIATIONS
	private MainAppFX mainAppFX;
	
	public MediaPlayer mediaPlayer;
	
	private Media media;
	public void setMedia(Media media) {
		this.media = media;
	}
	
	private URL music;
	public URL getMusic() {
		return music;
	}	
	public void setMusic(String musicURL) {		
		this.music = getClass().getResource(musicURL);
		//System.out.println("SON : "+this.music.getPath().toString());
	}
	
	
	// CONSTRUCTEURS
	public Sound() {} // POUR JAVABEANS
	public Sound(String sound) {	
		this.setMusic(sound);
		this.media = new Media(music.toExternalForm());
	}
	public Sound(MainAppFX mainApp, String sound) {	
		this.mainAppFX = mainApp;
		this.setMusic(sound);
		this.media = new Media(music.toExternalForm());
	}
	
	public void Play() {
		this.mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play(); 
	}

}