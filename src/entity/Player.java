package entity;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import resources.Read;

import java.awt.image.BufferedImage;
public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	int hasKey = 0;
	
	
	public Player(GamePanel gp,KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		this.screenX = (gp.screenWidth/2 - (gp.tileSize/2));
		this.screenY = (gp.screenHeight/2 - (gp.tileSize/2));
		
		solidArea = new Rectangle();// revisar
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX =  solidArea.x ;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		worldX = (gp.tileSize * (gp.getTileM().getMapSizeX()/2))-gp.tileSize;
		worldY = (gp.tileSize * (gp.getTileM().getMapSizeY()/2))-gp.tileSize;
		//speed = gp.worldWidth/600;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		try {
			ArrayList<BufferedImage> l = Read.player();
			up0 = l.get(12);
			up1 = l.get(13);
			up2 = l.get(15);
			down0 = l.get(0);
			down1 = l.get(1);
			down2 = l.get(3);
			left0 = l.get(4);
			left1 = l.get(5);
			left2 = l.get(7);
			right0 = l.get(8);
			right1 = l.get(9);
			right2 = l.get(11);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void update() {
		if( keyH.upPressed == true || 
			keyH.downPressed == true || 
			keyH.leftPressed == true || 
			keyH.rightPressed == true) {			
			if(keyH.upPressed == true) {
				//worldY -= speed; // es lo mismo que |  playerY = playerY - playerSpeed;
				direction = "up";
			} else if(keyH.downPressed == true) {
				//worldY += speed;
				direction = "down";
			} else if(keyH.leftPressed == true) {
				//worldX -= speed;
				direction = "left";
			} else if(keyH.rightPressed == true) {
				//worldX += speed;
				direction = "right";
			}

			collisionOn = false;

			if(collisionOn == false) {
				switch(direction) {
				case "up" : worldY -= speed; break;
				case "down": worldY += speed; break;
				case "left": worldX -= speed; break;
				case "right": worldX += speed; break;
				}
			}
			
			// actualizar animacion
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum == 1){
					spriteNum = 2;
				} else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}	
	}

	public void draw(Graphics2D g2) {
		/*
			g2.setColor(Color.white);
			g2.fillRect(x,y,gp.tileSize,gp.tileSize);
		*/
		
		BufferedImage image = null;
		switch(direction) {
		case "up" :
			if(keyH.upPressed == true) {
				
				if(spriteNum == 1){
					image = up1;
				} else if(spriteNum == 2) {
					image = up2;
				}
			} else {
				image = up0;
			}
			
			break;
		case "down" :
			if(keyH.downPressed == true) {
				if(spriteNum == 1){
					image = down1;
				} else if(spriteNum == 2) {
					image = down2;
				}
			} else {
				image = down0;
			}
			break;
		case "left" :
			if(keyH.leftPressed == true) {
				if(spriteNum == 1){
					image = left1;
				} else if(spriteNum == 2) {
					image = left2;
				}
			}else {
				image = left0;
			}
			break;
		case "right" :
			if(keyH.rightPressed == true) {
				if(spriteNum == 1){
					image = right1;
				} else if(spriteNum == 2) {
					image = right2;
				}
			}else {
				image = right0;
			}
			break;
		}
		g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
	}
}
