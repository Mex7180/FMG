package lucaZanetti.mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import lucaZanetti.GUI.WindowListeners;


public class Graphic extends JFrame{
	/* Class where all the different generations are called from
	 * JFrame object, where the chosen JPanel (generation) is added
	 * 
	 */
	private Point SFPStart = Settings.getStartPunktSF();
	private Point SFPEnd = Settings.getEndPunktSF();
	private static JFrame frame;
	private int amountOfFrequencies = Settings.getAmountOfFrequencies();
	
	//Constructor with the Frame settings
	public Graphic() { 
		
		frame = this;
		this.setSize(Settings.WindowLengh, Settings.WindowHeight);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.addWindowListener(new WindowListeners());
		this.setTitle(Settings.title);
		this.setResizable(false);

		

		this.setLocation(Settings.WindowXPosition, Settings.WindowYPosition);
		int Case = Settings.Case;
		/*Case 0: Polyline V1
		* Case 2: Julia Menge
		* Case 3: Snow flake by Koch
		* Case 4: Mountain out of snow flakes
		* Case 5: Midpointdisplacement 
		* Case 6: Sierpinski-triangle
		* Case 7: Cantor-Dust
		* Case 8: Frequencies stacking 
		* Case 9: Polyline V2; simple Perlin Noise
		*/
		if(Case == 0) {
			getContentPane().add(new PolyLineCreator(), BorderLayout.CENTER);
		}  else if(Case == 2) {
			getContentPane().add(new JuliaSetCreator(), BorderLayout.CENTER);
		} else if(Case == 3) {
			getContentPane().add(new CreateSnowFlake(SFPStart, SFPEnd, Settings.IterationAmount), BorderLayout.CENTER);
		} else if(Case == 4) {
			getContentPane().add(new SFMountain(), BorderLayout.CENTER);
		} else if(Case == 5) {
			getContentPane().add(new Midpointdisplacement(), BorderLayout.CENTER);
		} else if(Case == 6) {
			getContentPane().add(new SierpinskiTriangle(), BorderLayout.CENTER);
		} else if(Case == 7) {
			getContentPane().add(new CantorDust(), BorderLayout.CENTER);
		} else if(Case == 8) {
			CosSinFunction f = new CosSinFunction(0, 50, 0.00838);
			getContentPane().add(f, BorderLayout.CENTER);
			inItCosSin(f);
		}else if(Case == 9) {
			getContentPane().add(new PolyLineV2(), BorderLayout.CENTER);
			
		}else{
			System.out.println("Fehler: Diesen Case gibt es nicht!");
		}
		
		this.setVisible(true);
		
	}
	
	//Create the frequencies and overlap them + show function in textarea
	private void inItCosSin(CosSinFunction f) {
		f.createMountain(amountOfFrequencies);
		
		TextArea area = new TextArea(f.getFunction());
		area.setText("Anzahl Frequenzen: "+ amountOfFrequencies+"\n"+f.getFunction());
		area.setEditable(false);
		getContentPane().add(area, BorderLayout.NORTH);
	}

	public void addButton(JButton b, String Borderlayout) {
		this.add(b, Borderlayout);
	}
	
	public static JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
	
	


