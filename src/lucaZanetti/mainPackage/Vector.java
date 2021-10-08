package lucaZanetti.mainPackage;

import java.awt.Point;

public class Vector {
	/* Class for the vector object
	 * Multiple constructors (constructor 1: x and y 
	 * coordinates, constructor 2: point , constructor 3: 2 points)
	 * Methods to return different values, multiply a vector with 
	 * a number and to get a rotated version of a vector.
	 */
	private double x;
	private double y;
	//Constructor with the 2 vector coordinates
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	//Constructor to get a vector from the origin to the point
	public Vector(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	//Constructor to get a vector between two points
	public Vector(Point Anfangspunkt, Point Endpunkt) {
		this.x = Endpunkt.x-Anfangspunkt.x;
		this.y = Endpunkt.y-Anfangspunkt.y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY() {
		return y;
	}
	//Returns the absolute value of a vector
	public double absValue(){
		double betrag = Math.sqrt(x*x+y*y);
		return betrag;
	}
	//Returns a vector, which has been rotated for 90 degrees
	public Vector getRotatedVektor() {
		Vector vRotated = new Vector(x*Math.cos(Math.PI/2)-y*Math.sin(Math.PI/2), 
									x*Math.sin(Math.PI/2)+y*Math.cos(Math.PI/2));
		return vRotated;
	}
	//Returns the vector multiplied by a number
	public Vector multiplyByNum(double number) {
		double newX = (double)x*number;
		double newY = (double)y*number;
		Vector vn = new Vector(newX, newY);
		return vn;
	}
	//Returns the point, to which input point and vector point to
	public Point addToPoint(Point p) {
		
		Point point = new Point();
		point.setLocation((int)(x+p.getX()),(int) (y+p.getY()));
		return point;
	}

	/* returns a vector as sum of the other two (input, and the one, by which
	 * the function was called)
	 */
	public Vector addVektor(Vector v2) {
		Vector resVektor = new Vector(x+v2.x, y+v2.y);
		return resVektor;
	}
}
