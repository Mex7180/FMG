package lucaZanetti.mainPackage;


import java.awt.Graphics;
import java.awt.Point;
import java.io.Console;
import java.nio.file.Paths;

import javax.swing.JPanel;

import lucaZanetti.GUI.GUIMain;

public class Main {
	/* Main Class
	 * First settings are being loaded and the GUI is being created as an GUIMain object
	 */
	public static void main(String[] args) {
		//Load the settings and safe them with the corresponding variables in the settings class
	SettingsMethods sM = new SettingsMethods();
		if(Paths.get(Settings.getSettingsPath()).toFile().exists() == false) {
			//File has to be created
			FileMethods Fm = new FileMethods();
			Fm.createNewFile(Paths.get(Settings.getSettingsPath()));
			sM.safeSettings(Settings.getSettingsPath());
			sM.loadSettings(Settings.getSettingsPath());
		} else {
			//File exists allready
			sM.loadSettings(Settings.getSettingsPath());
		}
		System.out.println("[FGM] The settings are saved at: "+Settings.getSettingsPath()); // =settings Path
		
		GUIMain GUIMain = new GUIMain();
	}
}