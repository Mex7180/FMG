package lucaZanetti.mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.Random;

import javax.swing.JPanel;

public class PolyLineCreator extends JPanel{
	/* Class to create a simple polyline
	 * with random y-value displacement
	 */
	private int AmountRandValues = Settings.getAmountRandValues();
	private int amountOfUsedPoints = Settings.AmountOfPoints;
	
	/* Method to calculate the y-values and stacking the octaves
	 * Saves them in an Array which is returned at the end
	 */
	public int[] createNewPolyLine(){

		//Arrays with for the coordinates of the points
		int[] yPoints = new int[amountOfUsedPoints];
		/* Calculate the values and add them to the Array	
		 * First loop is for the amount of used points
		 * The inner loop is for the octaves 
		 */
		for (int i=0; i!=amountOfUsedPoints; i++) {
			int diff= 0; Random ran;
			
			for(int j = 0; j<AmountRandValues; j++) {
				
				ran = new Random();
				diff = diff +ran.nextInt(Settings.RandomIntervall);
				
			}
			//Calculate the final value for each point; scale the y-value (mirroring)
			yPoints[i] = Settings.getWindowHeight()-diff-100;
		}
		return yPoints;
	}
	/* Paint method to paint the generation when 
	 * the object is created. Starts the generation 
	 * by calling the createNewPolyLine() method
	 */
	public void paintComponent(Graphics g) {
		int amountPoint = Settings.AmountOfPoints;
		Color BackgroundColor = Color.WHITE;
		Color PenColor = Color.DARK_GRAY;
		int[] xPoints = new int[amountPoint];
		int[] yPoints = new int[amountPoint];
		int numberOfPoints = xPoints.length;
		
		//calculate the a and y values
		yPoints = createNewPolyLine();
		for (int i=0; i!=amountPoint; i++) {
			xPoints[i] = Settings.FactorPointToWindowHeight*i;
		}
		//Visualization: first the filled mountain and then the silhouette again
		super.paintComponent(g);
		this.setBackground(BackgroundColor);
		
		Graphics2D g2D = (Graphics2D) g;
		fill(xPoints, yPoints, g2D);
		g2D.setColor(PenColor);
		g2D.drawPolyline(xPoints, yPoints, numberOfPoints);
	}
	//Constructor for the classs as an JPanel with the used settings
	public PolyLineCreator() {
		setSize(Settings.WindowLengh, Settings.WindowHeight);
		setBackground(Color.WHITE);
		setVisible(true);
	}
	/* Method to fill the mountain generation
	 * takes the x and y values in form from Arrays
	 * as input.
	 */
	private void fill(int[] xPoints, int[] yPoints, Graphics2D g2d) {
		int size = xPoints.length;
		/* New Arrays to safe the input points and two new ones on the bottom window
		 * to later create an polygon object and fill it
		 */
		
		int[] newxPoints = new int[size+2];
		int[] newyPoints = new int[size+2];
		for(int i = 0; i < xPoints.length; i++) {
			newxPoints[i] = xPoints[i];
			newyPoints[i] = yPoints[i];
		}
		//Define the last two points
		newxPoints[size+1] = newxPoints[0];
		newxPoints[size] = newxPoints[size-1];
		newyPoints[size+1] = Settings.getWindowHeight();
		newyPoints[size] = Settings.getWindowHeight();
		//Draw the polygon
		g2d.setColor(Color.GRAY);
		g2d.fillPolygon(newxPoints, newyPoints, newxPoints.length);
	}
}