package utils;

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
}
