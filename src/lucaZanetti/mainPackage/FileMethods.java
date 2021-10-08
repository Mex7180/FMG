package lucaZanetti.mainPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileMethods {
	/* Class with file methods
	 * Only method to create a new file
	 */
	public void createNewFile(Path path){//Datei generieren
		
		File file = new File(path.toString());
		if (file.exists() != true) {
			try {
				
				file.createNewFile();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} 
	}
}
