package lucaZanetti.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lucaZanetti.mainPackage.Settings;


public class GUIMain extends JFrame{
	/* First appearing GUI
	 * JFrame and JPanel settings and adding the needed buttons 
	 */
	private int windowWidth = lucaZanetti.mainPackage.Settings.WindowLengh;
	private int windowHeight = lucaZanetti.mainPackage.Settings.WindowHeight;
	private String title = lucaZanetti.mainPackage.Settings.title;
	private String imagePath = Settings.getImagePath()+"GUIMainPicture.png";
	public static JButton toFractals; public static JButton toGame; public static JPanel mainPanel; 
	public static JFrame mainFrame; public static JButton toSettings;
	
	//Constructor for the JFrame
	public GUIMain() { 
		mainFrame = this;
		this.setSize(windowWidth+150, windowHeight);
		this.setResizable(false);
		this.setTitle(title);
		this.addWindowListener(new WindowListeners());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.add(mainPanel());
		this.setVisible(true);
	}
	
	//Creating the JPanel with all needed buttons and labels
	private JPanel mainPanel() { 
		
		mainPanel = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		
		toFractals = newButton("Fractal approaches");
		toGame = newButton("Minigame");
		toSettings = newButton("Settings");
		
		JLabel autor = new JLabel("	 Software created by Luca Zanetti");
		
		ImageIcon middleImage = new ImageIcon(imagePath);
		JLabel image = new JLabel(middleImage);
		
		mainPanel.setLayout(borderLayout);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(toFractals, BorderLayout.EAST);
		mainPanel.add(autor, BorderLayout.SOUTH);
		mainPanel.add(image, BorderLayout.CENTER);
		mainPanel.add(toSettings, BorderLayout.WEST);
		mainPanel.setVisible(true);
		
		return mainPanel;
	}
	
	public JFrame getMainFrame() {
		return mainFrame;
	}
	
	//Constructor for JButtons with adding the action listener from ButtonListeners.java
	private JButton newButton(String displayText){ 
		JButton button = new JButton(displayText);
		button.addActionListener(new ButtonListeners());
		mainPanel.add(button);
		return button;
	}
}
