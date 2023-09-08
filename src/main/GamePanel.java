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
import utils.CollisionCheker;
import utils.Console;
import utils.Sound;

public class GamePanel extends JPanel implements Runnable{
	// Serial
	private static final long serialVersionUID = 3587031526761099141L;
	
	// screen setings
	final int originalTileSize = 45; // 16x16 tile -- 64x64
	final int scale = 1;
	  
	public int tileSize = originalTileSize*scale; // 48x48 tile
	public int maxScreenCol = 20;
	public int maxScreenRow = 12;
	public int screenWidth = tileSize * maxScreenCol; // 768 px
	public int screenHeight = tileSize * maxScreenRow; // 576 px
	// DevMode
	private boolean devMode;
	//STATE
	private boolean gameStart;
	private boolean online;
	// FPS
	private int fps = 60;
	// real FPS
	private int realFPS;
	private TileManager tileM = new TileManager(this);
	private CollisionCheker cCheker = new CollisionCheker(this);
	private Sound sound = new Sound(Read.sounds());
	KeyHandler keyH = new KeyHandler(this);
	public Player player = new Player(this,keyH);
	private UI ui = new UI(this);
	Thread gameThread;

	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		devMode = false;
		gameStart = false;
		online = false;
		playMusic(0);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void printMain(Graphics2D g2) {
		ui.mainWindow(g2);
		
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
				//System.out.println();
				realFPS = drawCount;
				Console.msg("FPS: " + drawCount);
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
		if(gameStart == false) {
			printMain(g2);
		}else {
			tileM.draw(g2);
			player.draw(g2);
			ui.draw(g2);
			g2.dispose();
		}
	}

	public TileManager getTileM() {
		return tileM;
	}

	public void setTileM(TileManager tileM) {
		this.tileM = tileM;
	}
	
	public void playMusic(int i) {
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	
	public void stopMusic() {
		sound.stop();
	}
	
	public void playSoundEffect(int i) {
		sound.setFile(i);
		sound.play();
	}
	
	// Modo del Juego
	public boolean devMode() {
		return devMode;
	}
	
	
	// GETES AND SETTERS
	public UI getUi() {
		return ui;
	}
	public void setUi(UI ui) {
		this.ui = ui;
	}

	public int getRealFPS() {
		return realFPS;
	}

	public void setRealFPS(int realFPS) {
		this.realFPS = realFPS;
	}

	public boolean isDevMode() {
		return devMode;
	}

	public void setDevMode(boolean devMode) {
		this.devMode = devMode;
	}

	public CollisionCheker getcCheker() {
		return cCheker;
	}

	public void setcCheker(CollisionCheker cCheker) {
		this.cCheker = cCheker;
	}

	public boolean isGameStart() {
		return gameStart;
	}

	public void setGameStart(boolean gameStart) {
		this.gameStart = gameStart;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getOriginalTileSize() {
		return originalTileSize;
	}

	public int getScale() {
		return scale;
	}

	public int getTileSize() {
		return tileSize;
	}

	public int getMaxScreenCol() {
		return maxScreenCol;
	}

	public int getMaxScreenRow() {
		return maxScreenRow;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public boolean isOnline() {
		return online;
	}

	public int getFps() {
		return fps;
	}

	public Sound getSound() {
		return sound;
	}

	public KeyHandler getKeyH() {
		return keyH;
	}

	public Player getPlayer() {
		return player;
	}

	public Thread getGameThread() {
		return gameThread;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public void setMaxScreenCol(int maxScreenCol) {
		this.maxScreenCol = maxScreenCol;
	}

	public void setMaxScreenRow(int maxScreenRow) {
		this.maxScreenRow = maxScreenRow;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	public void setKeyH(KeyHandler keyH) {
		this.keyH = keyH;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setGameThread(Thread gameThread) {
		this.gameThread = gameThread;
	}
	
}
