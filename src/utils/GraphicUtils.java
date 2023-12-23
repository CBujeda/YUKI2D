package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.GamePanel;

public class GraphicUtils {

	public static int getWidthText(String text,Graphics2D g2) {
		return (int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();
	}
	public static int getHeightText(String text,Graphics2D g2) {
		return (int) g2.getFontMetrics().getStringBounds(text,g2).getHeight();
	}
	public static int getXCenterScreenText(String text,Graphics2D g2,GamePanel gp) {
		return (gp.screenWidth/2) - (GraphicUtils.getWidthText(text,g2)/2);
	}
	
	public void drawString(String string,Font font,Color color,int x,int y,int size,int style,Graphics2D g2) {
		g2.setColor(color);
		g2.setFont(g2.getFont().deriveFont(style,size));
		g2.drawString(string, x, y);
	}
}
