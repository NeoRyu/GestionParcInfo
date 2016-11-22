package application.viewer;

import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import application.MainAppFX;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class ImagePanel extends JPanel {
   
	private BufferedImage image;
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public static int hauteur = 360;
	public static int largeur = 360;	
	public static Dimension size = new Dimension(hauteur, largeur);
    
	// CONSTRUCTEUR
	public void Init(BufferedImage image) {
    	setImage(image);
    	
    	JFrame frame = new JFrame();
        frame.setTitle("HADOKEN !");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ImagePanel());
        frame.setSize(size);
        frame.setVisible(true);     	
	}
	
	// AFFICHAGE IMAGE
    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null); 
	}

    
    public BufferedImage createImage(String imgURL) {
	    BufferedImage image = null;
		
	    try {
	    	String path = "\\bin\\res\\";
	    	MainAppFX.explorer(path);
	    	
			String imageURL = "\n"+System.getProperty("user.dir")+path+imgURL;
			System.out.println(imageURL);

			// TODO : javax.imageio.IIOException: Can't read input file!
			image = ImageIO.read(new File(imageURL));		
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
    }
	

}
