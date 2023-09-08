package main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import resources.Read;
import utils.GraphicUtils;
import utils.SystemUtils;
import utils.logicObj.ListButton;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class UI {

	private GamePanel gp;
	Font arial_40;
	ArrayList<Font> f;
	ListButton lb;
	private int up;
	private int down;
	private int enter;
	
	public UI(GamePanel gp) {
		super();
		this.gp = gp;
		arial_40 = new Font("Arial",Font.PLAIN,20);
		lb = new ListButton(new String[] {"Jugar","Online","Config","Exit"});
		lb.select(0);
		ArrayList<File> fi = Read.fonts();
		f = new ArrayList<Font>();
		for(int i = 0; i < fi.size();i++) {
			 try {
				InputStream is = new FileInputStream(fi.get(i));
				try {
					f.add(Font.createFont(Font.TRUETYPE_FONT,is));
				} catch (FontFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 		
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		if(fi.size() == 0) {
			InputStream is = getClass().getResourceAsStream("/font/0.ttf");
			try {
				f.add(Font.createFont(Font.TRUETYPE_FONT,is));
			} catch (FontFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.setFont(f.get(0));
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20));
		drawInterface(g2);
		if(gp.devMode()) {
			drawDev(g2);
		}
	}
	
	
	public void mainWindow(Graphics2D g2) {
		g2.setFont(f.get(0));
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20));
		
		g2.drawImage(Read.frontMain(), 0,0, 900, 540,null);
		
		
		display();
		mainMenuAcction();
		
		
		int size = 30;
		int width = GraphicUtils.getXCenterScreenText(lb.getStringButton(0),g2,gp);
		for(int i = 0; i < lb.size(); i++) {
			String str = lb.getStringButtonAndSelected(i);
			int height = ((gp.screenHeight)/2)+ ((GraphicUtils.getHeightText(str,g2)*i));
			drawString(str,g2.getFont(),Color.white,width,height,size,Font.BOLD, g2);
		}
	}
	public void mainMenuAcction() {
		int acc = ifselected();
		if(acc == 0) {
			
			gp.setGameStart(true);
		}else if(acc == 3){
			SystemUtils.exit();
		}
	} 
	
	public int ifselected() {
		if(enter == 1) {
			enter = 0;
			return lb.getAcction(lb.getSelect());
		}else {
			return -1;
		}
	}
	
	public void display() {
		lb.display(up, down); up = 0; down = 0;
	}
	
	
	public void drawInterface(Graphics2D g2) {
		ArrayList<BufferedImage> l = Read.heart();
		int lives = gp.player.getLives();
		int cont = 0;
		int img = 0;
		for(int i = 0; i < gp.player.livesMax; i++) {
			if(lives > i) {
				g2.drawImage(l.get(0),(i*3)+((gp.tileSize/2)*i),5,(gp.tileSize/2),gp.tileSize/2,null);
			}else {
				g2.drawImage(l.get(4),(i*3)+((gp.tileSize/2)*i),5,(gp.tileSize/2),gp.tileSize/2,null);
			}
		}
	}
	
	
	
	
	public void drawDev(Graphics2D g2) {
		int posicion = g2.getFont().getSize();
		g2.setColor(new Color(0,0,0,100));
		g2.fillRect(0,0,gp.tileSize*3,posicion*5+10);
		drawString("X: " + gp.player.worldX/gp.tileSize + " Y: " + gp.player.worldY/gp.tileSize,
					g2.getFont(),Color.cyan,10,posicion,20,Font.BOLD, g2);
		drawString("FPS: "+ gp.getRealFPS(),
					g2.getFont(),Color.white,10,posicion*2,20,Font.BOLD, g2);
		String[] ram = SystemUtils.getRamStr();
		drawString(ram[0],g2.getFont(),Color.white,10,posicion*3,20,Font.BOLD, g2);
		drawString(ram[1],g2.getFont(),Color.green,40,posicion*4,20,Font.BOLD, g2);
		drawString(ram[2],g2.getFont(),Color.orange,40,posicion*5,20,Font.BOLD, g2);
		
	}
	
	
	
	public void drawString(String string,Font font,Color color,int x,int y,int size,int style,Graphics2D g2) {
		g2.setColor(color);
		g2.setFont(g2.getFont().deriveFont(style,size));
		g2.drawString(string, x, y);
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getEnter() {
		return enter;
	}

	public void setEnter(int enter) {
		this.enter = enter;
	}
	
	
}
