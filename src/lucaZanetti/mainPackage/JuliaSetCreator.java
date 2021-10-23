package lucaZanetti.mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class JuliaSetCreator extends JPanel{
	/* Class to create Julia sets
	 * Creates an JPanel with the drawing on it
	 */
	private static JPanel panel;
	/* Method to iterative calculated
	 * the behavior of a complex number,
	 * given by the coordinates of the inserted point
	 */
	public int juliaSetPixelIteration(long x, long y, ComplexNumber C){
		
		int amountIterations = 0;
		/* calculate the real and imaginary part of the complex number by it's coordinates
		 * The CornerPoints where used to introduce a zoom in and out, but has later been taken out.
		 */
		double re = ((x-(Settings.WindowLengh/2)+Settings.getJMCCornerPoint1().x)*Settings.getJMCVariableFactor());
		double im = ((-y+(Settings.WindowHeight/2)-Settings.getJMCCornerPoint1().x)*Settings.getJMCVariableFactor());

		ComplexNumber pixel = new ComplexNumber(re, im);

		//Calculate every iteration
		for(int i = 0; i<Settings.IterationAmount; i++) {
			
			pixel = pixel.cSquare();
			pixel = pixel.addInC(C);
			
			if(pixel.getR() <= 2) {
				amountIterations++;
			} else {
				i = Settings.IterationAmount;
			}
		}
		/* Return the amount of iterations inside the circle with radius r = 2, 
		 * a big amount means the value will probably not be divergent, while a small 
		 * one surely means divergent behavior.
		 */
		return amountIterations;
	}
	
	/* The paint method to paint when the object is created
	 * Also controls the generation in a for loop
	 * in which every point of the window is given in to the
	 * juliaSetPixelIteration() method
	 */
	public void paintComponent(Graphics g) {
		
		int hight = Settings.WindowHeight;
		int width = Settings.WindowLengh;
		
		JuliaSetCreator JSC = new JuliaSetCreator();
		int iterationAmount;

		/* Begin the iteration of every single point by calling
		 * the juliaSetPixelIteration method
		*/
		for(int y = 0; y<=hight; y++) {
			
			for(int x = 0; x <= width; x++) {
				
				iterationAmount = JSC.juliaSetPixelIteration((long)x, (long)y, Settings.C);
				g.setColor(defineColorForJuliaSet(iterationAmount));
				g.drawOval(x, y, 1, 1);
			}
		}
	}
	/* Method to define the used color for a specific pixel
	 * Takes the amount of iterations calculated in juliaSetPixelIteration()
	 * and defines a color depending on this amount
	 */
	private Color defineColorForJuliaSet(int iterationAmount) {
		
		int colorNumber = iterationAmount*40;
		Color color;
		
		while(colorNumber>3*253) {
			colorNumber= colorNumber-3*253;
		}
		
		if(colorNumber > 2*253) {
			colorNumber = colorNumber-2*253;
			color = new Color(colorNumber,0 , 0);
		} else if(colorNumber > 253) {
			colorNumber = colorNumber-253;
			color = new Color(0, colorNumber, 0);
		} else {
			color = new Color(0,0, colorNumber);
		}
		
		return color;
	}
	
	//Constructor of the class as a JPanel
	public JuliaSetCreator() {
		panel = this;
		this.setSize(Settings.WindowLengh, Settings.WindowHeight);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		Settings.setIterationAmount(60);
	}
	
	public static JPanel getPanel(){
		return panel;
	}
}
