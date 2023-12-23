package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	
	public boolean upPressed,downPressed,leftPressed,rightPressed;
	
	GamePanel gp;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(gp.isGameStart()) {
			if(code == KeyEvent.VK_W) {
				upPressed = true;
			}
			
			if(code == KeyEvent.VK_S) {
				downPressed = true;
			}
			
			if(code == KeyEvent.VK_A) {
				leftPressed = true;
			}
			
			if(code == KeyEvent.VK_D) {
				rightPressed = true;
			}
			
			if(code == KeyEvent.VK_O) {
				if(gp.devMode() == true) {
					gp.setDevMode(false);
				}else {
					gp.setDevMode(true);
				}
			}
			
			if(code == KeyEvent.VK_ESCAPE) {
				if(gp.isGameStart()) {
					if(gp.isPauseGame()) {
						gp.setPauseGame(false);
					}else {
						gp.setPauseGame(true);
					}
				}
			}
			
			
		}else {
			if(code == KeyEvent.VK_UP) {
				gp.getUi().setUp(1);
			}
			
			if(code == KeyEvent.VK_DOWN) {
				gp.getUi().setDown(1);
			}
			if(code == KeyEvent.VK_ENTER) {
				gp.getUi().setEnter(1);
			}
		}
		
		
		/*
		if(code == KeyEvent.VK_UP) {
			gp.zoomInOut(1);
		}
		
		if(code == KeyEvent.VK_DOWN) {
			gp.zoomInOut(-1);
		}
		*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(gp.isGameStart()) {
			if(code == KeyEvent.VK_W) {
				upPressed = false;
			}
			
			if(code == KeyEvent.VK_S) {
				downPressed = false;
			}
			
			if(code == KeyEvent.VK_A) {
				leftPressed = false;
			}
			
			if(code == KeyEvent.VK_D) {
				rightPressed = false;
			}
		}
	}

}
