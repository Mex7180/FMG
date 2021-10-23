package lucaZanetti.mainPackage;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import lucaZanetti.GUI.ErrorMessage;

public class SettingsMethods {
	/* Class with methods to safe and load the settings
	 * Also included are the queries before every
	 * generation or in the settings window
	 */
	public static String pathName = "res/settings";

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		SettingsMethods.pathName = pathName;
	}
	/* Method to safe the settings
	 * in the settings file on the
	 * computer
	 */
	public static void safeSettings(String path) {
		//Test if the file exist, if not a new one is created
		File file = new File(path);
		System.out.println(path);
		if(file.exists() == false) {
			ErrorMessage fl = new ErrorMessage("Fehler beim Speichern der Einstellungen ");
			System.out.println(Settings.getSettingsPath());
			return;
		} else {
			//Write all settings down in the file
			try {
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write("ANZAHLPUNKTE "+Settings.getAmountOfPoints()); writer.newLine();
				writer.write("FAKTORPUNKTEZUFENSTERLAENGE "+Settings.getFactorPointToWindowHeight());writer.newLine();
				writer.write("FAKTORPUNKTEZUFENSTERBREITE "+Settings.getFactorPointToWindowWidth());writer.newLine();
				writer.write("RandomIntervall "+Settings.getRandomIntervall());writer.newLine();
				writer.write("COUNTERPATH notUsedAnymore");writer.newLine();
				writer.write("MAINPATH "+Settings.getMainpath());writer.newLine();
				writer.write("CreateFileOf "+Settings.CreateFileOf);writer.newLine();
				writer.write("ITERATIONENANZAHL " + Settings.getIterationAmount()); writer.newLine();
				writer.write("CASE " + Settings.getCase());writer.newLine();
				writer.write("WindowXPosition " + Settings.getWindowXPosition());writer.newLine();
				writer.write("WindowYPosition " + Settings.getWindowYPosition()); writer.newLine();
				writer.write("title "+Settings.getTitle());writer.newLine();
				writer.write("JMCEckPunkt1 "+Settings.getJMCCornerPoint1().x+"|"+Settings.getJMCCornerPoint1().y); writer.newLine();
				writer.write("JMCEckPunkt2 "+Settings.getJMCornerPoint2().x+"|"+Settings.getJMCornerPoint2().y); writer.newLine();
				writer.write("JMCRadius "+Settings.getJMCRadius()); writer.newLine();
				writer.write("C "+Settings.C.getRealPart()+"|"+Settings.C.getImaginaryPart()); writer.newLine();
				writer.write("StartPunktSchneeFlocke "+Settings.getStartPunktSF().x+"|"+Settings.getStartPunktSF().y); writer.newLine();
				writer.write("EndPunktSchneeFlocke "+Settings.getEndPunktSF().x+"|"+Settings.getEndPunktSF().y);writer.newLine();
				writer.write("EinstellungenDateiPfad "+Settings.getSettingsPath());
				writer.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	/* Method to load the settings
	 * from the file on the computer
	 */
	public static void loadSettings(String path) {
		//Test if the file exists; if not: print error message as dialog window
		File file = new File(Settings.getSettingsPath());
		if(file.exists() == false) {
			ErrorMessage fl = new ErrorMessage("Fehler beim Laden der Einstellungen");
			return;
		} else {
			try {
				//Read the file and safe it into an Array
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
				String[] settings = new String[19];
				String content;
				int i = 0;
				while((content = reader.readLine()) != null) {
					
					settings[i] = content.split(" ")[1];
					i++;
				}
				
				reader.close();
				//Safe the settings in the settings class, make the changes which have to be made
				Settings.setAmountOfPoints(Integer.valueOf(settings[0]));
				Settings.setFactorPointToWindowHeight(Integer.valueOf(settings[1]));
				Settings.setFactorPointToWindowWidth(Integer.valueOf(settings[2]));
				Settings.setRandomIntervall(Integer.valueOf(settings[3]));
				Settings.setMainpath(settings[5]);
				Settings.setCreateFileOf(Boolean.parseBoolean(settings[6]));
				Settings.setIterationAmount(Integer.valueOf(settings[7]));
				Settings.setCase(Integer.valueOf(settings[8]));
				Settings.setWindowXPosition(Integer.valueOf(settings[9]));
				Settings.setWindowYPosition(Integer.valueOf(settings[10]));
				Settings.setTitle(settings[11]);
				Settings.setJMCCornerPoint1(new Point(Integer.valueOf(settings[12].split("\\|")[0]), 
						Integer.valueOf(settings[12].split("\\|")[1])));
				Settings.setJMCornerPoint2(new Point(Integer.valueOf(settings[13].split("\\|")[0]), 
						Integer.valueOf(settings[13].split("\\|")[1])));
				Settings.setJMCRadius(Double.parseDouble(settings[14]));
				Settings.setC(new ComplexNumber(Double.parseDouble(settings[15].split("\\|")[0]), 
						Double.parseDouble(settings[15].split("\\|")[1])));
				Settings.setStartPointSnowFlake(new Point(Integer.valueOf(settings[16].split("\\|")[0]), 
						Integer.valueOf(settings[16].split("\\|")[1])));
				Settings.setEndPointSnowFlake(new Point(Integer.valueOf(settings[17].split("\\|")[0]), 
						Integer.valueOf(settings[17].split("\\|")[1])));
				Settings.setSettingsPath(settings[18]);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}