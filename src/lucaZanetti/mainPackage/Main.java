package lucaZanetti.mainPackage;

import java.nio.file.Paths;

import lucaZanetti.GUI.GUIMain;

public class Main {
	/* Main Class
	 * First settings are being loaded and the GUI is being created as an GUIMain object
	 */
	public static void main(String[] args) {
		//Load the settings and safe them with the corresponding variables in the settings class
		if(Paths.get(Settings.getSettingsPath()).toFile().exists() == false) {
			//File has to be created
			FileMethods.createNewFile(Paths.get(Settings.getSettingsPath()));
			SettingsMethods.safeSettings(Settings.getSettingsPath());
			SettingsMethods.loadSettings(Settings.getSettingsPath());
		} else {
			//File exists allready
			SettingsMethods.loadSettings(Settings.getSettingsPath());
		}
		System.out.println("[FGM] The settings are saved at: "+Settings.getSettingsPath()); // =settings Path
		
		GUIMain GUIMain = new GUIMain();
	}
}