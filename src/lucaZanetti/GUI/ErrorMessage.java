package lucaZanetti.GUI;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ErrorMessage extends JDialog{
	/* Error message object
	 * simple error message with an input string and an ok button
	 */
	String messageContent; JDialog dialog = this;
	
	public ErrorMessage(String message) {
		this.messageContent = message;
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
}