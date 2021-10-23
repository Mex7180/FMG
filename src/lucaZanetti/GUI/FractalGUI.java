package lucaZanetti.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lucaZanetti.mainPackage.Settings;

public class FractalGUI extends JFrame{
	/* GUI with the fractal approaches
	 * JFrame and JPanel for the GUI, including all the buttons which are controlled by an actionlistener in the class ButtonListener.java
	 */
	public static JFrame fractalGUI; public JPanel fractalPanel;
	public static JButton buttonPolyLine;
	public static JButton buttonJuliaSet;
	public static JButton buttonSnowFlake;
	public static JButton buttonSnowFflakeMountain;
	public static JButton back;
	public static JButton buttonMidpointDisplacement;
	public static JButton buttonSierpinskiTriangle;
	public static JButton buttonCantorDust;
	public static JButton buttonOverlappingFrequencies;
	public static JButton buttonPolyLineV2;
	private JLabel mountainGenerating;
	private JLabel fractalFigures;
	private String imagePath = Settings.getImagePath()+"FractalGUIPicture.png";
	
	String fractalPanelName = "Fractal approaches";
	
	//Constructor of the class with an JFrame object
	public FractalGUI() {
		fractalGUI = this;
		this.setSize(Settings.WindowLengh+250, Settings.WindowHeight);
		this.setResizable(false);
		this.setTitle(fractalPanelName);
		this.setLocationRelativeTo(null);
		GridLayout gridLayout = new GridLayout(0,2,10,5);
		this.setLayout(gridLayout);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowListeners());
		ImageIcon middleImage = new ImageIcon(imagePath);
		JLabel image = new JLabel(middleImage);
		
		
		this.add(init());
		this.add(image);
		this.setVisible(true);
	}
	//All the settings and adding of the Buttons + Labels for the JPanel 
	private JPanel init() {
		fractalPanel = new JPanel();
		fractalPanel.setSize(Settings.WindowLengh+250, Settings.WindowHeight);
		fractalPanel.setBackground(Color.WHITE);
		fractalPanel.setVisible(true);
		
		mountainGenerating = newLabel("Create mountains                  ");
		buttonPolyLine = newButton("Random generation with height (y-value) displacement (Polyline)");
		
		buttonSnowFflakeMountain = newButton("Mountains with snow flakes by Koch");
		
		buttonMidpointDisplacement = newButton("Mountains with the midpoint displacement method");
		
		buttonOverlappingFrequencies = newButton("Mountain with stacked frequencies");
		
		buttonPolyLineV2 = newButton("Mountain out of easy Perlin Noise methode (Polyline V2)");
		
		fractalFigures = newLabel("Fractal figures                   ");
		buttonSierpinskiTriangle = newButton("Generate a Sierpinski-Triangle");
		buttonCantorDust = newButton("Generate Cantor-Dust");
		buttonJuliaSet = newButton("Create a Julia Set");
		buttonSnowFlake = newButton("Create a snow flake by Koch");
		
		back = newButton("Back");

		return fractalPanel;
	}
	/* Constructor for the JButtons, takes the displayed text as an input and returns
	 * a button connected to the ButtonListener class
	 */
	private JButton newButton(String displayText){ 
		JButton button = new JButton(displayText);
		button.addActionListener(new ButtonListeners());
		fractalPanel.add(button);
		return button;
	}
	/* Method to create new JLabels as titles. Takes the displayed text as input and 
	 * returns an JLabel object
	 */
	private JLabel newLabel(String displayText) { 
		JLabel label = new JLabel(displayText);
		label.setFont(new Font(null, ALLBITS, ALLBITS));
		fractalPanel.add(label);
		return label;
	}
}