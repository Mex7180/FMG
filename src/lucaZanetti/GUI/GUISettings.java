package lucaZanetti.GUI;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lucaZanetti.mainPackage.ComplexNumber;
import lucaZanetti.mainPackage.Settings;


public class GUISettings extends JFrame{
	/* GUI with the Settings
	 * GUI with JPanel and JFrame
	 * All the functions for settings asked before the generation of an approach (with JOptionPanes)
	 */
	private int windowWidth = Settings.WindowLengh;
	private int windowHeight = Settings.WindowHeight;
	static JButton generalS; static JButton polyLineS; static JButton JMCS; static JButton SFCS; 
	static JButton SFMS; public static JButton back; static JButton ST; static JButton cosSinFreq;
	static JButton polyLineV2; static JButton MPDS;
	private String title = "settings";
	private JPanel panel = new JPanel();
	private static JFrame frame;
	private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	private JDialog dialog;
	private Point newEndP;
	private Point newStartP;
	private boolean valueOK;
	
	// Constructor for the JFrame
	public GUISettings() { 
		frame = this;
		this.setSize(windowWidth, windowHeight);
		this.setResizable(false);
		this.setTitle(title);
		setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowListeners());
		this.add(mainPanel());
		this.setVisible(true);
	}
	
	public GUISettings(boolean setFalse) {	
		frame = this;
	}
	
	// Creating the JPanel with all the features (grid and buttons)
	private JPanel mainPanel() { 
		
		GridLayout gridLayout = new GridLayout(0, 1);
		
		panel.setSize(windowWidth, windowHeight);
		panel.setBackground(Color.WHITE);
		panel.setLayout(gridLayout);
		
		polyLineS = newButton("Settings for PolyLineMountain");
		JMCS = newButton("Settings for Julia groups");
		SFCS = newButton("Settings for snowflakes");
		SFMS = newButton("Settings for snowflake mountains");
		ST = newButton("Settings for Sierpinski triangle");
		cosSinFreq = newButton("Settings for frequency overlay");
		polyLineV2 = newButton("Settings for PolyLineMountain V2");
		MPDS = newButton("Settings for midpoint displacement methode");
		back = newButton("Back");
		panel.setVisible(true);
		
		return panel;
	}
	
	//Constructor for JButtons with actionlistener added
	private JButton newButton(String displayText){ 
		JButton button = new JButton(displayText);
		button.addActionListener(new ButtonListeners());
		panel.add(button);
		
		return button;
	}
	
	//Query for the settings for a polyline generation
	public int PolyLineQuery() { 
		JTextField fAmountOfPoints = new JTextField(String.valueOf(Settings.getAmountOfPoints()));
		JTextField fWindowHeight = new JTextField(String.valueOf(Settings.WindowHeight));
		JTextField fWindowWidth = new JTextField(String.valueOf(Settings.WindowLengh));
		JTextField fIntervall = new JTextField(String.valueOf(Settings.getRandomIntervall()));
		JTextField fAmountRandVaues = new JTextField(String.valueOf(Settings.getAmountRandValues()));
		Object [] message = {"Amount of points", fAmountOfPoints, "Window height in pixels", fWindowHeight, 
				"Window width in pixels", fWindowWidth, "Intervall during the shift", fIntervall, "Amount of used random values per point", fAmountRandVaues};
		
		JOptionPane pane = new JOptionPane( message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION);
		
		pane.setSize(300, 300);
		dialog = pane.createDialog(null, "settings");
		dialog.setVisible(true);
		
		int amountP =  Integer.valueOf(fAmountOfPoints.getText());
		int windowH = Integer.valueOf(fWindowHeight.getText())/amountP;
		int windowW = Integer.valueOf(fWindowWidth.getText())/amountP;
		int intervall = Integer.valueOf(fIntervall.getText());
		int amountRandValues = Integer.valueOf(fAmountRandVaues.getText());
		
		if(pane.getValue()!= null) {
			int re = (int) pane.getValue();
			if(re == 0) {
				Settings.setAmountOfPoints(amountP);
				Settings.setFactorPointToWindowWidth(windowH);
				Settings.setFactorPointToWindowHeight(windowW);
				Settings.setRandomIntervall(intervall);
				Settings.setAmountRandValues(amountRandValues);
			}
			return (int) re;
		} else {
			return 3;
		}
	}
	
	//Querry for the settings of the Julia Set
	public int JMQuery() {
		ComplexNumber c = Settings.C;
		JTextField z  = new JTextField(String.valueOf(c.getRealPart())+"+"+String.valueOf(c.getImaginaryPart())+"i");
		
		Object [] message = {"Complex number z", z};
		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION);
		
		pane.setSize(300,300);
		dialog = pane.createDialog(null, "settings");
		dialog.setVisible(true);
		String[] eingabe = z.getText().replace("i", "").replace(" ", "").split("\\+");
		if(eingabe.length == 2 && pattern.matcher(eingabe[0]).matches() == true && pattern.matcher(eingabe[1]).matches() == true) {
			
			double RealtTeil = Double.valueOf(eingabe[0]);
			double ImmagTeil = Double.valueOf(eingabe[1]);
			if(pane.getValue()!= null) {
				int re = (int) pane.getValue();
				
				if(re == 0) {
					Settings.setC(new ComplexNumber(RealtTeil, ImmagTeil));
				}
				
				return (int) re;
			} 
			
		} else {
			ErrorMessage FM = new ErrorMessage("Not valid complex number, simulation started with previous value! Please use the format: a+b*i");
		}
		return 3;	             
	}
	
	// Querry for the setting for the creation of a snow flake by Koch
	public int CSFQuery() { 
		Point startP = Settings.getStartPunktSF();
		Point endP = Settings.getEndPunktSF();
		int Iterationen = Settings.getIterationAmount();
		
		JTextField TStartP = new JTextField((int)startP.getX()+ " " + (int)startP.getY());
		JTextField TEndP = new JTextField((int)endP.getX()+ " " + (int)endP.getY());
		JTextField TIterationen = new JTextField(String.valueOf(Iterationen));
		
		Object [] message = {"starting point", TStartP, "endpoint", TEndP, "Number of iterations (recommended: 1-15)", TIterationen};
		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		pane.setSize(300,300);
		dialog = pane.createDialog(null, "settings");
		dialog.setVisible(true);
		
		if(pattern.matcher(TStartP.getText().split(" ", 2)[0]).matches() == true &&  pattern.matcher(TStartP.getText().split(" ", 2)[1]).matches() == true){
			newStartP = new Point(Integer.valueOf(TStartP.getText().split(" ")[0]), Integer.valueOf(TStartP.getText().split(" ")[1]));
		} else {
			ErrorMessage fl = new ErrorMessage("This input for the starting point cannot be used. The animation was started with the old value. Please use the format: 'x y'");
		}
				
		if(pattern.matcher(TEndP.getText().split(" ", 2)[0]).matches() == true &&  pattern.matcher(TEndP.getText().split(" ", 2)[1]).matches() == true){
			newEndP = new Point(Integer.valueOf(TEndP.getText().split(" ")[0]), Integer.valueOf(TEndP.getText().split(" ", 2)[1]));
			//Settings.setEndPunktSchneeFlocke(newEndP);
		} else {
			ErrorMessage fl = new ErrorMessage("This input for the endpoint cannot be used. The animation was started with the old value. Please use the format: 'x y'");
		}
		
		if(pattern.matcher(TIterationen.getText()).matches() == true && Integer.valueOf(TIterationen.getText()) < 16 && Integer.valueOf(TIterationen.getText()) > 0) {
			//Settings.setITERATIONENANZAHL(Integer.valueOf(TIterationen.getText()));
			valueOK = true;
		} else {
			ErrorMessage fl = new ErrorMessage("This specification for the iteration number is invalid, please use a natural number between 1 and 15.");
			valueOK = false;
		}
		if(pane.getValue()!= null) {
			int re = (int) pane.getValue();
			if(re == 0) {
				if(valueOK == true) {
					Settings.setIterationAmount(Integer.valueOf(TIterationen.getText()));
				}
				Settings.setEndPointSnowFlake(newEndP);
				Settings.setStartPointSnowFlake(newStartP);
			}
			return (int) re;
		} else {
			return 3;
		}
	}
	
	// Query for the creation of a Sierpinski triangle
	public int sierpinskiTriangel() {
		JTextField anzahlIterationen = new JTextField(String.valueOf(Settings.getIterationAmountSD()));
		Object [] message = {"Amount of interations, recommended 1-15:", anzahlIterationen};
		
		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		pane.setSize(300, 300);
		dialog = pane.createDialog(null, "settings");
		dialog.setVisible(true);
		
		int input = Integer.valueOf(anzahlIterationen.getText());
		
		if(pane.getValue() != null) {
			int re = (int) pane.getValue();
			if(re == 0) {
				if(input > 0 && input < 16) {
					Settings.setIterationAmountSD(input);
				} else {
					ErrorMessage EM = new ErrorMessage("Invalid input! Please enter a number between 1 and 15! The value " +
				Settings.getIterationAmountSD()+ " was used for the calculation. ");
				}
			}
			return re;
		} else {
		
			return 3;
		}
	}
	//Query for the simple Perlin Noise, Polilyne V2
	public int polyLineV2() {
		
		JTextField factorYValue = new JTextField(String.valueOf(Settings.getFactorYValue()));
		JTextField amountIterations = new JTextField(String.valueOf(Settings.getIterationAmountPolyLine2()));
		Object [] message = {"Factor G for y-value determination (between 1-12, 1: very flat, 12: steep/cliffy):", factorYValue,
				"Amount of iterations (between 4 and 15):", amountIterations};
		
		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		pane.setSize(300, 300);
		dialog = pane.createDialog(null, "settings");
		dialog.setVisible(true);
		
		int input = Integer.valueOf(factorYValue.getText());
		int input2 = Integer.valueOf(amountIterations.getText());
		
		if(pane.getValue() != null) {
			int re = (int) pane.getValue();
			if(re == 0) {
				if(input > 0 && input < 13) {
					Settings.setFactorYValue(input);
				} else {
					ErrorMessage EM = new ErrorMessage("Invalid input! Please enter a number between 1 and 12! The value "+
				Settings.getFactorYValue()+"was used for the calculation. ");
				}
				if(input2 > 3 && input2 < 16) {
					Settings.setIterationAmountPolyLine2(input2);
				} else {
					ErrorMessage EM = new ErrorMessage("Invalid Input! Please enter a number between 4 and 15. The value "+Settings.getIterationAmountPolyLine2()+
							" was used for the calculation");
				}
			} return re;
		} else {
			return 3;
		}
	}
	
	//Query for the frequencies stacking
	public int CosSinFrequencies() {
		
		JTextField amountFrequencies = new JTextField(String.valueOf(Settings.getAmountOfFrequencies()));
		Object [] message = {"Number of stacked frequencies (low number (<50): curvy mountains, high number (>150) "+
		"spiky/cliffy)\nRecommended number between 10-500", amountFrequencies};
		
		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		dialog = pane.createDialog(null, "settings");
		dialog.setVisible(true);
		int input = Integer.valueOf(amountFrequencies.getText());
		
		if(pane.getValue() != null) {
			int re = (int) pane.getValue();
			if(re == 0) {
				if(input > 0 && input < 600) {
					Settings.setAmountOfFrequencies(input);
				} else {
					ErrorMessage EM = new ErrorMessage("Invalid input! Please enter a"+
							" number between 1 and 600. It was calculated with the value "+Settings.getAmountOfFrequencies()+".");
				}
			} return re;
		} else {
			return 3;
		}
	}
	
	// Query for the midpoint displacement method
	public int MidpointdisplacementQuery() {
		
		JTextField amountIterations = new JTextField(String.valueOf(Settings.getAmountIterationsMPD()));
		JTextField gaussianF = new JTextField(String.valueOf(Settings.getFactorGaussianRand()));
		JTextField pointA = new JTextField(String.valueOf(Settings.getAMPD().x)+" "+String.valueOf(Settings.getAMPD().y));
		JTextField pointB = new JTextField(String.valueOf(Settings.getBMPD().x)+" "+String.valueOf(Settings.getBMPD().y));
		Object []  message = {"Amount of iterations", amountIterations, "Factor for the random, gaussian distributed values",
				gaussianF,"Startingpoint", pointA, "Endpoint", pointB};
		
		JOptionPane panel = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		dialog = panel.createDialog(null, "settings");
		dialog.setVisible(true);
		
		int inputAmountIterations = Integer.valueOf(amountIterations.getText());
		int inputGaussianF = Integer.valueOf(gaussianF.getText());
		String inputPointA = pointA.getText();
		String inputPointB = pointB.getText();
		
		Point newPointB = new Point();
		Point newPointA = new Point();
		
		if(panel.getValue() != null) {
			int re = (int) panel.getValue();
			
			if(re == 0) {
				if(pattern.matcher(pointA.getText().split(" ")[0]).matches() == true  && pattern.matcher(pointA.getText().split(" ")[1]).matches() == true ) {
					
					newPointA = new Point(Integer.valueOf(pointA.getText().split(" ")[0]), Integer.valueOf(pointA.getText().split(" ")[1]));
					Settings.setAMPD(newPointA);
					
				} else {
					ErrorMessage fl = new ErrorMessage("This input for the starting point cannot be used. The animation was started with the old value. Please use the format: 'x y'");
				}
				
				if(pattern.matcher(pointB.getText().split(" ")[0]).matches() == true && pattern.matcher(pointB.getText().split(" ")[1]).matches() == true ) {
					
					newPointB = new Point(Integer.valueOf(pointB.getText().split(" ")[0]), Integer.valueOf(pointB.getText().split(" ")[1]));
					Settings.setBMPD(newPointB);
					
				} else {
					ErrorMessage fl = new ErrorMessage("This input for the ending point cannot be used. The animation was started with the old value. Please use the format: 'x y'");
				}
				
				int inputAmountIterationsInt = Integer.valueOf(inputAmountIterations);
				int inputGaussianFInt = Integer.valueOf(inputGaussianF);
				
				if(inputAmountIterationsInt > 0 && inputAmountIterationsInt < 20) {
					Settings.setAmountIterationsMPD(inputAmountIterations);
				} else {
					ErrorMessage fl = new ErrorMessage("This input for the amount of iterations is outside the borders, please use a value between 1 and 19. The old one was used for the generation.");
				}
				
				if(inputGaussianFInt > 0 && inputGaussianFInt < 21) {
					Settings.setFactorGaussianRand(inputGaussianFInt);
				} else {
					ErrorMessage fl = new ErrorMessage("Please use a factor between 1 and 21. The old value was used.");
				}
			}
			return re;
		} else {
			return 3;
		}
	}
	
	public static JFrame getFrame(){
		return frame;
	}
	
	public JDialog getDialog(){
		return dialog;
	}
}
