package lucaZanetti.mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;



public class SFMountain extends JPanel{
	/* Class to create a mountain
	 * consisting of multiply snow flakes
	 * by Koch
	 */
	Point startPoint;
	Point endPoint;
	int maxAnzahlEbenen = Settings.getIterationAmount();
	// Constructor to the class, creates an JPanel with the used settings
	public SFMountain() {
		setSize(Settings.WindowLengh, Settings.WindowHeight);
		setBackground(Color.BLACK);
		setVisible(true);
	}
	/* Method to create the mountain
	 * firstly the amount of points and 
	 * their distribution is calculated
	 * Than the snow flakes are created between two points
	 */
	public void createSFMountain(Graphics g) {
		int x = 0;
		int y;
		startPoint = new Point(x, 300);
		Random anzahlPunkte = new Random();
		int Punkte = anzahlPunkte.nextInt(30);
		// Test if the amount of chosen points is under 10; if yes: 10 is added to the amount
		if(Punkte < 10) {
			Punkte = Punkte+10;
		}
		//For loop for each point, in which the y value is defined and added
		for(int i = 0; i < Punkte; i ++) {
			
			Random ranx = new Random();
			Random rany = new Random();
			x = x+ranx.nextInt(100)+Settings.WindowLengh/2/Punkte;
			
			y = rany.nextInt(50)*8;
			endPoint = new Point(x, y);
			//Create snow flakes between to points, for that the CreateSnowFlake class is used
			CreateSnowFlake CSF = new CreateSnowFlake(startPoint, endPoint, maxAnzahlEbenen);
			CSF.newSF(g, startPoint, endPoint, maxAnzahlEbenen, 1);
			CSF.fillMountain(g);
			startPoint = endPoint;
		}
	}
	//Method to draw the component: calls createSFMountain
	public void paintComponent(Graphics g) {
		createSFMountain(g);
	}
}