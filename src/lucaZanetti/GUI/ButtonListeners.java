package lucaZanetti.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import lucaZanetti.mainPackage.Graphic;
import lucaZanetti.mainPackage.Settings;

public class ButtonListeners implements ActionListener{
	/* Buttonlisteners for all GUI's
	 * Class with the actionListener to check for all interactions with buttons on all GUIs
	 */
	JFrame mainFrame = GUIMain.mainFrame;
	JFrame fractalGUI = FractalGUI.fractalGUI;
	JFrame graphicFrame = Graphic.getFrame();
	JButton bGraphicBack;
	JFrame GUISettingsW = GUISettings.getFrame();
	private int generatingCase;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		
		//MAIN-LISTENERS
		if(source == GUIMain.toFractals) {
			
			FractalGUI FGUI = new FractalGUI();
			mainFrame.setVisible(false);
			
		} else if(source == GUIMain.toSettings) {
			GUISettings GUIE = new GUISettings();
			mainFrame.setVisible(false);
			
			//GUI with the generation options for the different fractal approaches and fractals
			
			
			//PolyLine
		} else if(source == FractalGUI.buttonPolyLine) {
			
			GUISettings GUIE = new GUISettings(false);
			generatingCase = GUIE.PolyLineQuery();
			if(generatingCase == 0) {
				Settings.setCase(0);
				graphicFrame = graphikInit();
			}
			GUIE.getDialog().dispose();
			//Julia Set
		} else if(source == FractalGUI.buttonJuliaSet) {
			GUISettings GUIE = new GUISettings(false);
			generatingCase = GUIE.JMQuery();
			if(generatingCase == 0) {
				Settings.setCase(2);
				graphicFrame = graphikInit();
			}
			GUIE.getDialog().dispose();
			//snow flake
		} else if(source == FractalGUI.buttonSnowFlake) {
			GUISettings GUIE = new GUISettings(false);
			generatingCase = GUIE.CSFQuery();
			if(generatingCase == 0) {
				Settings.setCase(3);
				graphicFrame = graphikInit();
			}
			GUIE.getDialog().dispose();
			//snow flake mountain
		} else if(source == FractalGUI.buttonSnowFflakeMountain) {
			GUISettings GUIE = new GUISettings(false);
			generatingCase = GUIE.CSFQuery();
			if(generatingCase == 0) {
				Settings.setCase(4);
				graphicFrame = graphikInit();
			}
			GUIE.getDialog().dispose();
			//Sierpinski triangle
		} else if(source == FractalGUI.buttonSierpinskiTriangle) {
			GUISettings GUIE = new GUISettings(false);
			generatingCase = GUIE.sierpinskiTriangel();
			if(generatingCase == 0) {
				Settings.setCase(6);
				graphicFrame = graphikInit();
			}
			GUIE.getDialog().dispose();
			//Midpoint displacement method
		} else if(source == FractalGUI.buttonMidpointDisplacement) {
			GUISettings GUIE = new GUISettings(false);
			generatingCase = GUIE.MidpointdisplacementQuery();
			if(generatingCase == 0) {
				Settings.setCase(5);
				graphicFrame = graphikInit();
			}
			// Overlapping frequencies
		} else if(source == FractalGUI.buttonOverlappingFrequencies) {
			GUISettings GUIS = new GUISettings(false);
			generatingCase = GUIS.CosSinFrequencies();
			if(generatingCase == 0) {
				Settings.setCase(8);
				graphicFrame = graphikInit();
			}
			// Cantor Dust
		} else if(source == FractalGUI.buttonCantorDust) {
			Settings.setCase(7);
			graphicFrame = graphikInit();
			//Back to the main menu
		} else if(source == FractalGUI.back) {
			mainFrame.setVisible(true);
			FractalGUI.fractalGUI.dispose();		
			// polyline 2, Perlin Noise 
		} else if(source == FractalGUI.buttonPolyLineV2) {
			GUISettings GUIS = new GUISettings(false);
			generatingCase = GUIS.polyLineV2();
			if(generatingCase == 0) {
				Settings.setCase(9);
				graphicFrame = graphikInit();
			}
			//back to the fractal GUI
		}else if(source == bGraphicBack) {
			fractalGUI.setVisible(true);
			graphicFrame.dispose();
			
			//Settings polyline
		} else if(source == GUISettings.polyLineS){
			GUISettings GUIE = new GUISettings(false);
			GUIE.PolyLineQuery();
			GUIE.getDialog().dispose();
			
			//back to main menu
		} else if(source == GUISettings.back) {
			GUISettingsW.dispose();
			mainFrame.setVisible(true);
			
			//Settings Julia Set
		} else if(source == GUISettings.JMCS) {
			GUISettings GUIE = new GUISettings(false);
			GUIE.JMQuery();
			GUIE.getDialog().dispose();
			
			//settings snow flake
		} else if(source == GUISettings.SFCS) {
			GUISettings GUIE = new GUISettings(false);
			GUIE.CSFQuery();
			GUIE.getDialog().dispose();
			
			//settings Sierpisnki triangle
		} else if(source == GUISettings.ST) {
			GUISettings GUIE = new GUISettings(false);
			GUIE.sierpinskiTriangel();
			GUIE.getDialog().dispose();
			
			//settings polyline 2
		} else if(source == GUISettings.polyLineV2) {
			GUISettings GUIS = new GUISettings(false);
			GUIS.polyLineV2();
			GUIS.getDialog().dispose();
			
			//settings for frequencies overlapping
		} else if(source == GUISettings.cosSinFreq) {
			GUISettings GUIS = new GUISettings(false);
			GUIS.CosSinFrequencies();
			GUIS.getDialog().dispose();
			
			//snow flake mountains
		} else if(source == GUISettings.SFMS) {
			GUISettings GUIS = new GUISettings(false);
			GUIS.CSFQuery();
			GUIS.getDialog().dispose();
			
			//settings midpoint displacement
		} else if(source == GUISettings.MPDS) {
			GUISettings GUIS = new GUISettings(false); 
			GUIS.MidpointdisplacementQuery();
			GUIS.getDialog().dispose();
		}
	}
	/* Method to call the graphic class as a
	 * new object to start the generation of one
	 * fractal approach or figure (decided by the int 
	 * value for the case variable in the Settings class)
	 */
	public JFrame graphikInit() {
		
		Graphic gr = new Graphic();
		
		fractalGUI.setVisible(false);
		bGraphicBack = new JButton("Back");
		bGraphicBack.addActionListener(this);
		bGraphicBack.setVisible(true);
		gr.addButton(bGraphicBack, BorderLayout.SOUTH);
		return gr;
	}
	
}
