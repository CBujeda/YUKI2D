package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Player;
import resources.Read;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	// Serial
	private static final long serialVersionUID = 3587031526761099141L;
	
	// screen setings
	final int originalTileSize = 45; // 16x16 tile -- 64x64
	final int scale = 1;
	  
	public int tileSize = originalTileSize*scale; // 48x48 tile
	public int maxScreenCol = 16;
	public int maxScreenRow = 12;
	public int screenWidth = tileSize * maxScreenCol; // 768 px
	public int screenHeight = tileSize * maxScreenRow; // 576 px
	
	// WORLD SETINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	
	// FPS
	int fps = 60;
	TileManager tileM = new TileManager(this);
	//TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	public Player player = new Player(this,keyH);
	Thread gameThread;

	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		Read.tileConfig();
		
		ArrayList<ArrayList<Integer>> l = Read.maps();
		for(int i = 0; i < l.size(); i++) {
			for(int r = 0; r < l.get(i).size();r++) {
				System.out.print(l.get(i).get(r) + " ");
			}
			System.out.println();
		}
		
		
		
	}
	
	public void setupGame() {
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/fps; // 0.01666 seconds
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}

			if(timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}		
	}
	
	
	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		tileM.draw(g2);
		player.draw(g2);
		g2.dispose();
	}
	
}