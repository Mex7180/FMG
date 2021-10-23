package lucaZanetti.mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.stream.IntStream;

import javax.swing.JPanel;

public class PolyLineV2 extends JPanel{
	/* Class to create a polyline
	 * this generation method is 
	 * a simple method of the 
	 * Perlin Noise method
	 * by Ken Perlin.
	 */
	private JPanel panel;
	private int width = Settings.getWindowLengh();
	private int height = Settings.getWindowHeight();
	private int amountOfPoints = width;
	private int maxLayer = Settings.getIterationAmountPolyLine2();
	private int[] yPoints = new int[width+1];
	private int amountChosenPoints;
	private int factorYValue = Settings.getFactorYValue();
	
	//Constructor (JPanel with settings)
	public PolyLineV2() {
		panel = new JPanel();
		panel.setSize(width, height);
		panel.setBackground(Color.WHITE);
		panel.setVisible(true);
	}
	
	/* Paint method to paint the generation when the
	 * JPanel object is created
	 */
	public void paintComponent(Graphics g) {
		draw(g, 1, yPoints, createRandomValues(amountOfPoints+1, 100*factorYValue));
	}
	
	/* Private recursive method to calculate and later draw the generation
	 * Firstly the amount of used points per octave is calculated
	 * After the points ,which are used in the generation, are chosen
	 * All the calculations for the linear interpolation between two
	 * points is made and the y-values for all points added to the existing
	 * y value in an seperate Array
	 */
	private void draw(Graphics g, int thisLayer, int[] yPoints, int[] randomValues) { 
		
		amountChosenPoints = (int)(Math.pow(2, thisLayer));
		
		
		int dxPoints = (int)(width/(amountChosenPoints-1));
		int[] chosenPoints = new int[amountChosenPoints];
		int indexChosenPoints = 0;
		
		for(int i = 0; i<amountChosenPoints; i++) {
			chosenPoints[i] = dxPoints*i;
		}
		
		for(int i = 0; i<amountOfPoints; i++) {//if i is a chosenPoint; get y value out of randomValues[]
			if((indexChosenPoints<amountChosenPoints-1) && (i == chosenPoints[indexChosenPoints])) {
				
				yPoints[i] = (int) (yPoints[i]+((randomValues[chosenPoints[indexChosenPoints]])/(Math.pow(2, thisLayer)))); 
				indexChosenPoints++;
				
			} else {
				/* i is not a chosen value; calculate the y value with 
				the chosen one before and the chosen one after. 
				*/
				int valueBefore = randomValues[chosenPoints[indexChosenPoints-1]];
				int valueAfter = randomValues[chosenPoints[indexChosenPoints]];
				double dy = (valueAfter-valueBefore);
				double dyPerPoint = (dy/dxPoints);
				double y = ((i-chosenPoints[indexChosenPoints-1])*dyPerPoint+valueBefore)/(Math.pow(2, thisLayer));;
				
				yPoints[i] = yPoints[i]+(int)y;
			}
		}
		//If-clause: more recursions or not? yes--> recall draw() else --> draw it
		if(thisLayer < maxLayer) { 
			draw(g, thisLayer+1, yPoints, randomValues);
		} else {
			//find the biggest y value
			int biggestY = 0;
			for(int i = 0; i < yPoints.length; i++) { 
				if(biggestY < yPoints[i]) biggestY = yPoints[i];
			}
			// set y values to an useful amount --> on the window
			for(int i = 0; i < yPoints.length; i++) { 
				yPoints[i] = yPoints[i]-(biggestY-height+100);
			}
			
			int[] xPoints = IntStream.range(0, width+1).toArray();
			g.setColor(Color.GRAY);
			//Draw the mountain
			for(int i = 0; i<yPoints.length; i++) { 
				int x = xPoints[i];
				int y = yPoints[i]+1;
				g.drawLine(x, y, x, height);
			}
			g.setColor(Color.BLACK);
			g.drawPolyline(xPoints, yPoints, yPoints.length);
		}
	}
	
	// Method to create an Array with a certain amount of random values
	private int[] createRandomValues(int amount, int maxValue) { 
		int[] values = new int[amount];
		
		for(int i = 0; i< values.length; i++) {
			Random ran = new Random();
			values[i] = (ran.nextInt(maxValue));
		}
		return values;
	}
}