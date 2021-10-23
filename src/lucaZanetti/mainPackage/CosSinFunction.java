package lucaZanetti.mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class CosSinFunction extends JPanel{
	/* harmonic oscillations
	 * Object for oscillations with the form:
	 * y(t) = A*sin(w*t) + B*cos(w*t)
	 * Constructor included with methods for overlaying oscillations,
	 * for calculating all the values and for visualizing them, inclusive
	 * fill() function
	 */
	private double a;
	private double b;
	private double omega;
	private String function;
	private JPanel panel;
	private int[] xPoints;
	private int[] yPoints;
	
	private int shiftInY = 300;
	
	// Constructor with A, B and omega as Input for the oscillation equation
	public CosSinFunction(double a, double b, double omega) {
		
		this.a = a;
		this.b = b;
		this.omega = omega;
		calculateValues(a,b,omega);
		function = "y(t) = "+String.valueOf(a)+"*sin(t*"+String.valueOf(omega)+")+"+String.valueOf(b)+"*cos(t*"+String.valueOf(omega)+")";
		
		panel = new JPanel();
		panel.setVisible(true);
		panel.setBackground(Color.WHITE);
		panel.setSize(Settings.getWindowLengh(), Settings.getWindowHeight());
		
	}
	
	/*Private method to calculate all values of a certain oscillation for
	later displaying them
	*/
	private void calculateValues(double a, double b, double omega) {
		
		xPoints = new int[Settings.getWindowLengh()];
		yPoints = new int[Settings.getWindowLengh()];
		
		for(int x = 0; x<Settings.getWindowLengh(); x++) {
			xPoints[x] = x;
			yPoints[x] = (int)(100+valueOf(x, a, b, omega)+shiftInY);
		}
	}
	
	//calculate a single value, based on oscillation equation
	private double valueOf(double t, double a, double b, double omega) {
		
		double y = a*Math.sin(omega*t)+b*Math.cos(omega*t);
		return y;
	}
	
	/* Add two oscillations on top of each other, by adding the new y-values to the old ones
	 * and change the string in which the equation is saved for printing
	 */
	public void addOtherFunction(double a, double b, double omega) {
		
		int smallestY = 200000000;
		
		for(int i = 0; i<yPoints.length; i++) {
			yPoints[i] = (int)(yPoints[i] + valueOf(i, a, b, omega));
			
			if(yPoints[i] < smallestY) {
				smallestY = yPoints[i];
			}
		}
		
		for(int i = 0; i<yPoints.length; i++) {
			yPoints[i] = yPoints[i] - (smallestY-10);
		}
		
		setValues(yPoints);
		function = function+"+" +String.valueOf(a)+"*sin(t*"+String.valueOf(omega)+")+"+String.valueOf(b)+"*cos(t*"+String.valueOf(omega)+")";
		setFunction(function);
		panel.repaint();
		
	}
	
	//Method called by paintComponent, start the drawing process.
	private void draw(Graphics g) {		
		fillMountains(yPoints, g);
		g.setColor(Color.BLACK);
		g.drawPolyline(xPoints, yPoints, xPoints.length);
		
	}
	
	public void paintComponent(Graphics g) {
		draw(g);
	}
	
	
	private void setValues(int[] yPoints) {
		this.yPoints = yPoints;
	}

	/* Method called from outside the class (from the CosSinFunction object)
	 * to create the generation of a mountain
	 */
	public void createMountain(int amountOfFrequences) {
		
		Random ran = new Random();
		double thisValue;
		double thisValue2;
		double factor;
		
		for(int i = 0; i<amountOfFrequences; i++) {
			
			thisValue = ran.nextDouble();
			thisValue2 = ran.nextDouble();
			addOtherFunction(thisValue*200*(1.0/i), thisValue2*200*(1.0/i), 0.01/2*i);
			
		}
	}
	
	public String getFunction() {
		return function;
	}
	
	private void setFunction(String function) {
		this.function = function;
	}
	
	// Fill the area under the curve (montain)
	private void fillMountains(int[] yPoints, Graphics g) {
		
		int thisValue;
		for(int i = 0; i < yPoints.length; i++) {
			thisValue = yPoints[i]+1;
			
			g.setColor(Color.GRAY);
			g.drawLine(i, (Settings.getWindowHeight()), i, thisValue);
		}
	}
}