package lucaZanetti.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import lucaZanetti.mainPackage.Graphic;
import lucaZanetti.mainPackage.Settings;

public class MouseListener implements java.awt.event.MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object source = e.getSource();
		Point loc = e.getPoint();
		
		if(source == Graphic.getFrame() && Settings.getCanPlacePoints() == true) {
				Settings.addPointTSPS(loc);
				Graphics g = e.getComponent().getGraphics();
				g.setColor(Color.BLACK);
				g.fillOval(loc.x, loc.y, 6, 6);
				g.setColor(Color.WHITE);
				g.fillOval(loc.x+2, loc.y+2, 2, 2);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		return;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		return;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		return;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		return;
		
	}
}