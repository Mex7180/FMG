package lucaZanetti.mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;

public class Midpointdisplacement  extends JPanel{
	/* Method for generating 2D images for mountain with 
	 * the midpoint displacement method.
	 */
	private JPanel panel;
	
	private int amountIterations = Settings.getAmountIterationsMPD();
	private Point A1 = Settings.getAMPD();
	private Point B1 = Settings.getBMPD();
	private int f = Settings.getFactorGaussianRand();
	
	// Constructor of the Class as JPanel
	public Midpointdisplacement() {
		panel = this;
		panel.setSize(Settings.getWindowHeight(), Settings.getWindowLengh());
		panel.setVisible(true);
	}
	
	//paint method, calls shift() to start the generation
	public void paintComponent(Graphics g) { 
		shift(A1,B1,0,amountIterations, g);
	}
	
	/* Method for the generation.
	 * Recursive generation of the picture, using the Vector and Random class. Calculates the
	 * midpoint of a certain track and shifts it by a random gaussian number multiplied by an
	 * factor f, defined by the user.
	 */
	private void shift(Point A, Point B, int thisIteration, int maxIteration, Graphics g) {
		
		Vector AB = new Vector(A,B);

		Random random = new Random();
		AB = AB.multiplyByNum(0.5);
		
		Vector v = new Vector(0, f*(random.nextGaussian()-0.5));
		
		v = v.addVektor(AB);
		Point p1 = v.addToPoint(A);
		
		if(thisIteration<maxIteration) {
			
			shift(A,p1, thisIteration+1, maxIteration,g);
			shift(p1,B, thisIteration+1, maxIteration,g);
			
		} else {
			
			int[] xPoints = new int[3];
			int[] yPoints = new int[3];
			xPoints[0] = A.x; yPoints[0] = A.y;
			xPoints[1] = p1.x; yPoints[1] = p1.y;
			xPoints[2] = B.x; yPoints[2] = B.y;
			
			fill(xPoints, yPoints, g);
			g.setColor(Color.DARK_GRAY);
			g.drawPolyline(xPoints, yPoints, xPoints.length);
		}
	}
	/*Method to fill the mountain
	 * Creating a polygon to do so and fill it with GRAY Color
	 */
	private void fill(int[] xP, int[] yP, Graphics g) {
		
		int[] xPoints = new int[xP.length+2];
		int[] yPoints = new int[yP.length+2];
		
		for(int i = 0; i<xP.length; i++) {
			xPoints[i+2] = xP[i];
			yPoints[i+2] = yP[i];
		}
		
		xPoints[1] = xPoints[2];
		yPoints[1] = Settings.getWindowHeight();
		xPoints[0] = xPoints[xPoints.length-1];
		yPoints[0] = Settings.getWindowHeight();
		
		g.setColor(Color.GRAY);
		g.fillPolygon(xPoints, yPoints, xPoints.length);
	}
}