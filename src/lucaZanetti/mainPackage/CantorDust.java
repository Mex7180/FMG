package lucaZanetti.mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class CantorDust extends JPanel{
	/* Class for generationg the Cantor-Dust
	 * Generats the image on an JPanel
	 */
	private int windowWidth = Settings.getWindowLengh();
	private int windowHeight = Settings.getWindowHeight();

	private Point a = new Point(50, 50);
	private Point b = new Point(650, 50);
	private int thisLayer = 1;
	private int maxLayer = 6;
	
	private int[] xPoints = new int[4];
	private int[] yPoints = new int[4];
	//Constructor for the extended JPanel
	 public CantorDust(){
		 
		 setSize(windowWidth, windowHeight);
		 setBackground(Color.WHITE);
		 setName("Cantor dust");
		 setVisible(true);
	 }
	 /* Paint function, paints the first bar and starts the generation 
	  * by calling the recursive function paintDust()
	  */
	 public void paintComponent(Graphics g) {
		 
		 xPoints[0] = a.x; yPoints[0] = a.y;
		 xPoints[1] = a.x; yPoints[1] = a.y+4;
		 xPoints[2] = b.x; yPoints[2] = b.y+4;
		 xPoints[3] = b.x; yPoints[3] = b.y;
		 
		 g.fillPolygon(xPoints, yPoints, xPoints.length);
		 paintDust(a, b, thisLayer, maxLayer, g);
	 }
	 /* Recursive function to generate the dust
	  * Takes two points, the actual layer/this iteration as int
	  * the max. amount of layers/iterations as int and the graphics 
	  * object as input. 
	  * Calculates the two points in between and draws the bars of the dust before recalling itself.
	  */
	 private void paintDust(Point A, Point B, int thisLayer, int maxLayer, Graphics g) {
		 
		 Vector AB = new Vector(A, B);
		 AB = AB.multiplyByNum((double)1/3);
		 
		 Point p1 = AB.addToPoint(A);
		 Point p2 = AB.addToPoint(p1);
		 A.setLocation(A.x, A.y+10);
		 B.setLocation(B.x, B.y+10);
		 p1.setLocation(p1.x, p1.y+10);
		 p2.setLocation(p2.x, p2.y+10);
		  
		 g.setColor(Color.BLACK);
		 xPoints[0] = A.x; yPoints[0] = A.y;
		 xPoints[1] = A.x; yPoints[1] = A.y+4;
		 xPoints[2] = p1.x; yPoints[2] = p1.y+4;
		 xPoints[3] = p1.x; yPoints[3] = p1.y;
		 g.fillPolygon(xPoints, yPoints, xPoints.length);
		 
		 xPoints[0] = B.x; yPoints[0] = B.y;
		 xPoints[1] = B.x; yPoints[1] = B.y+4;
		 xPoints[2] = p2.x; yPoints[2] = p2.y+4;
		 xPoints[3] = p2.x; yPoints[3] = p2.y;
		 g.fillPolygon(xPoints, yPoints, xPoints.length);
	 
		 if(thisLayer < maxLayer) {
			 thisLayer++;
			 paintDust(A, p1, thisLayer, maxLayer, g);
			 paintDust(p2, B, thisLayer, maxLayer, g);
		 }
	 }
}
