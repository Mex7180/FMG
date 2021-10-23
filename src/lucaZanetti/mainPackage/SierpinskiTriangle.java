package lucaZanetti.mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class SierpinskiTriangle extends JPanel{
	/* Class to create a Sierpinski triangle 
	 * Creates an JPanel and draws the Sierpinksi triangle on it
	 */
	private int windowHight = Settings.getWindowHeight();
	private int windowLengh = Settings.getWindowLengh();
	private int maxLayer = Settings.getIterationAmountSD();
	private int thisLayer = 1;
	private double sidelenght = (windowHight-200)/(Math.sqrt(3)/2);
	private Point A = new Point(50, windowHight-100); 
	private Point B = new Point((int) (50+sidelenght), windowHight-100); 
	private Point C = new Point((int)(50+sidelenght/2), 100);
	private int[] xPoints = new int[3];
	private int[] yPoints = new int[3];
	
	//Constructor for the class, creates an JPanel object
	public SierpinskiTriangle(){
		setSize(windowLengh, windowHight);
		setBackground(Color.WHITE);
		setName("Sierpinski-Dreieck");
		setVisible(true);
	}
	
	//Method to paint the component, calls the private createSierpnksiTriangle()
	public void paintComponent(Graphics g) {
		createSierpinskiTriangle(A, B, C, maxLayer, thisLayer, g);
	}
	
	/* Method for the generation
	 * Firstly all the vectors of the input points are calculated
	 * Then the vectors are divided by two and the new points calculated
	 * (middle points of the sides)
	 * If the max amount of iterations isn't reached, the function calls
	 * itself three times again (for each new triangle once)
	 */
	private void createSierpinskiTriangle(Point a, Point b, Point c, int maxEbenen, int momentaneEbenen, Graphics g){
		Vector AB = new Vector(a, b); AB = AB.multiplyByNum(0.5);
		Vector BC = new Vector(b, c); BC = BC.multiplyByNum(0.5);
		Vector AC = new Vector(a, c); AC = AC.multiplyByNum(0.5);
		
		Point newA1 = a;
		Point newB1 = AB.addToPoint(a);
		Point newC1 = AC.addToPoint(a);
		
		Point newA2 = newC1;
		Point newB2 = BC.addToPoint(b);
		Point newC2 = c;
		
		Point newA3 = newB1;
		Point newB3 = b;
		Point newC3 = newB2;
		
		if(momentaneEbenen < maxEbenen) {
			momentaneEbenen++;
			createSierpinskiTriangle(newA1, newB1, newC1, maxEbenen, momentaneEbenen, g);
			createSierpinskiTriangle(newA2, newB2, newC2, maxEbenen, momentaneEbenen, g);
			createSierpinskiTriangle(newA3, newB3, newC3, maxEbenen, momentaneEbenen, g);
			
		} else {
			xPoints[0] = newA1.x; yPoints[0] = newA1.y;
			xPoints[1] = newB1.x; yPoints[1] = newB1.y;
			xPoints[2] = newC1.x; yPoints[2] = newC1.y;
			g.setColor(Color.RED);
			g.fillPolygon(xPoints, yPoints, xPoints.length);
			
			xPoints[0] = newA2.x; yPoints[0] = newA2.y;
			xPoints[1] = newB2.x; yPoints[1] = newB2.y;
			xPoints[2] = newC2.x; yPoints[2] = newC2.y;
			g.setColor(Color.GREEN);
			g.fillPolygon(xPoints, yPoints, xPoints.length);
			
			xPoints[0] = newA3.x; yPoints[0] = newA3.y;
			xPoints[1] = newB3.x; yPoints[1] = newB3.y;
			xPoints[2] = newC3.x; yPoints[2] = newC3.y;
			g.setColor(Color.BLUE);
			g.fillPolygon(xPoints, yPoints, xPoints.length);
		}
	}
}