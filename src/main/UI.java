package main;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;

public class UI {

	private GamePanel gp;
	Font arial_40;
	
	public UI(GamePanel gp) {
		super();
		this.gp = gp;
		arial_40 = new Font("Arial",Font.PLAIN,40);
	}
	
	public void draw(Graphics2D g2) {
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		g2.drawString("X: " + gp.player.worldX/gp.tileSize + " Y: " + gp.player.worldY/gp.tileSize, 50, 50);
	}
	
}
