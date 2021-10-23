package lucaZanetti.mainPackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FileMethods {
	/* Class with file methods
	 * Only method to create a new file
	 */
	public static void createNewFile(Path path){
		
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
