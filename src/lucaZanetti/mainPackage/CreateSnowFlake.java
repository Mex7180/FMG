package lucaZanetti.mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CreateSnowFlake extends JPanel{
	/* Class to create a snow flake by Koch
	 * Creates a JPanel object with the drawing on it
	 */
	private Point startPoint;
	private Point endPoint;
	private int maxAmountLayers;
	private int height = Settings.getWindowHeight();

	private ArrayList<Point> allPoints = new ArrayList<>();
	/* Constructor for the snow flake
	 * creates a JPanel with the drawing on it. 
	 */
	public CreateSnowFlake(Point startPoint, Point endPoint, int maxLayers) {
		
		this.setSize(400, 400);
		setBackground(Color.WHITE);
		setVisible(true);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.maxAmountLayers = maxLayers;
		allPoints.add(startPoint);
	}
	
	/* recursive method to draw the snow flake
	 * calculate the vector between start- and endpoint
	 * Calculate the 3 new points with vector
	 * Recall itself if the amount of iterations isn't reached
	 */
	public void newSF(Graphics g, Point startPoint, Point endPoint, int maxAmountLayers, int thisLayer) {
		Vector v = new Vector(startPoint, endPoint);
		v = v.multiplyByNum(1.0/3.0); // 1/3 of the old sidelength --> new sidelength

		Point p1 = new Point(v.addToPoint(startPoint)); //point next to the startpoint
		Point p3 = new Point(v.multiplyByNum(2).addToPoint(startPoint)); //point next to the endpoint
		Vector rotatedV = v.getRotatedVektor();
		Vector p1ToM = v.multiplyByNum(1.5);
		Vector p2V = rotatedV.addVektor(p1ToM);
		
		Point p2 = new Point(p2V.addToPoint(startPoint)); //point on top of the new "triangle" formed
		
		if(thisLayer < maxAmountLayers) { //recall the method --> max iterations not reached
			newSF(g, startPoint, p1, maxAmountLayers, thisLayer+1);
			newSF(g, p1, p2, maxAmountLayers, thisLayer+1);
			newSF(g, p2, p3, maxAmountLayers, thisLayer+1);
			newSF(g, p3, endPoint, maxAmountLayers, thisLayer+1);
		} else { //draw the part of the mountain
			int[] xPoints = new int[5];
			int[] yPoints = new int[5];
			xPoints[0] = startPoint.x; yPoints[0] = height- startPoint.y;
			xPoints[1] = p1.x; yPoints[1] = height- p1.y;
			xPoints[2] = p2.x; yPoints[2] = height- p2.y;
			xPoints[3] = p3.x; yPoints[3] = height- p3.y;
			xPoints[4] = endPoint.x; yPoints[4] = height- endPoint.y;

			allPoints.add(startPoint);allPoints.add(p1);allPoints.add(p2);allPoints.add(p3);allPoints.add(endPoint);

			g.setColor(Color.BLACK);
			g.drawPolyline(xPoints, yPoints, xPoints.length);
		}	
	}
	
	//Pain method for the graphic method
	public void paint(Graphics g) { 
		newSF(g, startPoint, endPoint, maxAmountLayers, 1);
	}
	
	//Fill the area under the curve --> fill the mountain
	public void fillMountain(Graphics g) { 
		
		int[] xPoints = new int[allPoints.size()+2];
		int[] yPoints = new int[allPoints.size()+2];
		
		//get x and y coordinates out of the points into an Array
		for(int i = 0; i < allPoints.size(); i++) { 
			Point p = allPoints.get(i);
			xPoints[i] = p.x;
			yPoints[i] = height- p.y;
		}
		//draw the created part of the mountain
		xPoints[allPoints.size()] = xPoints[allPoints.size()-1];
		xPoints[allPoints.size()+1] = xPoints[0];
		yPoints[allPoints.size()+1] = height;
		yPoints[allPoints.size()] = height;
		
		g.setColor(Color.GRAY); 
		g.fillPolygon(xPoints, yPoints, xPoints.length);
		allPoints.clear();
	}
}