package lucaZanetti.GUI;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lucaZanetti.mainPackage.Graphic;
import lucaZanetti.mainPackage.Settings;
import lucaZanetti.mainPackage.SettingsMethods;

public class WindowListeners implements WindowListener{
	/* Class to listen to windowClosing event
	 * Opens a JOptionPane with two options:
	 * 1. closing down everything
	 * 2. if cancel is pressed: return to the window before
	 */
	JFrame mainGUI = GUIMain.mainFrame;
	JFrame fractalFrame = FractalGUI.fractalGUI;
	JFrame settingsFrame = GUISettings.getFrame();
	JFrame graphicsFrame = Graphic.getFrame();
	
	//WindowClosing event with the query and specific reaction
	public void windowClosing(WindowEvent e) {
		int Eingabe = JOptionPane.showConfirmDialog(null, "Do you want to close the program?", "WARNING" , 0);
		
		if(Eingabe == 0) {
			try {
				SettingsMethods SM = new SettingsMethods();
				SM.safeSettings(Settings.getSettingsPath());
			} catch(Exception exce) {
				ErrorMessage fl = new ErrorMessage("Could bot safe the settings! Path: "+Settings.getSettingsPath());
				System.out.println("Error while saving the settings");
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
				System.out.println("[Error] Error with the windowclosing event in windowlisteners!");
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
