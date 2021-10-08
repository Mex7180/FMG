package lucaZanetti.GUI;



import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lucaZanetti.mainPackage.Graphic;
import lucaZanetti.mainPackage.Settings;
import lucaZanetti.mainPackage.SettingsMethods;

public class WindowListeners implements WindowListener{
	JFrame mainGUI = GUIMain.mainFrame;
	JFrame fractalFrame = FractalGUI.fractalGUI;
	JFrame settingsFrame = GUISettings.getFrame();
	JFrame graphicsFrame = Graphic.getFrame();
	
	
	public void windowClosing(WindowEvent e) {
		int Eingabe = JOptionPane.showConfirmDialog(null, "Willst du das gesamte Programm beenden?", "WARNUNG" , 0);
		
		if(Eingabe == 0) {
			try {
				SettingsMethods SM = new SettingsMethods();
				SM.safeSettings(Settings.getSettingsPath());
			} catch(Exception exce) {
				ErrorMessage fl = new ErrorMessage("Konnte die Einstellungen nicht speichern! "+(String)exce.getMessage()+"");
				System.out.print("F");
			}
			
			if(fractalFrame != null) fractalFrame.dispose();
			if(mainGUI != null) mainGUI.dispose();
			if(settingsFrame!= null) settingsFrame.dispose();
			if(graphicsFrame != null) graphicsFrame.dispose();
			
		} else {
			
			if(e.getWindow().equals(settingsFrame)) {
				mainGUI.setVisible(true);
				e.getWindow().dispose();
			} else if (e.getWindow().equals(fractalFrame)) {
				mainGUI.setVisible(true);
				e.getWindow().dispose();
			} else if(e.getWindow().equals(mainGUI)) {
				
			} else if(e.getWindow().equals(graphicsFrame)) {
				e.getWindow().dispose();
				fractalFrame.setVisible(true);
			} else
				System.out.println("[FEHLER] FEHLER BEI WINDOWCLOSING EVENT IN WINDOWLISTENERS");
		}
		return;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		return;
	}

	@Override
	public void windowClosed(WindowEvent e) {
		return;
	}

	@Override
	public void windowIconified(WindowEvent e) {
		return;
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		return;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		return;
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		return;
	}
	

}
