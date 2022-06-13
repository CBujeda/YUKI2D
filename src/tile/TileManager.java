package tile;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import main.GamePanel;
import resources.Read;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class TileManager {
	
	GamePanel gp;
	
	//public Tile[] tile;
	//public int mapTileNumber[][];
	ArrayList<Tile> tiles;
	ArrayList<ArrayList<Integer>> mapData;
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		//this.tile = new Tile[10];
		//mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];
		tiles = Read.tileConfig();
		mapData = Read.maps();
	}
	
	
	
	public void draw(Graphics2D g2) {
		//g2.drawImage(tile[0].image,0,0,gp.tileSize,gp.tileSize,null);
		
		// revisar
		//int worlCol = 0;
		//int worldRow = 0;
		//while(worlCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

		//}
		for(int worlCol1 = 0; worlCol1 < mapData.size();worlCol1++ ) {
			for(int worldRow2 = 0; worldRow2 < mapData.get(worlCol1).size(); worldRow2++) {
				int tileNumber = mapData.get(worlCol1).get(worldRow2);
				int worldX = worlCol1 * gp.tileSize;	
				int worldY = worldRow2 * gp.tileSize;
				double screenX = worldX - gp.player.worldX + gp.player.screenX;
				double screenY = worldY - gp.player.worldY + gp.player.screenY;
						//mapTileNumber[worlCol][worldRow];
				if(		worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
						worldX - gp.tileSize < gp.player.worldX +  gp.player.screenX &&
						worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
						worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
					g2.drawImage(tiles.get(tileNumber).getImage(),(int) screenX,(int)screenY,gp.tileSize,gp.tileSize,null);
					
				}
				
			}
		}
		

		/*
		while(worlCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			int tileNumber = mapTileNumber[worlCol][worldRow];
			
			int worldX = worlCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			double screenX = worldX - gp.player.worldX + gp.player.screenX;
			double screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(		worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
					worldX - gp.tileSize < gp.player.worldX +  gp.player.screenX &&
					worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
					worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tile[tileNumber].getImage(),(int) screenX,(int)screenY,gp.tileSize,gp.tileSize,null);
				
			}
			
			worlCol++;

			if(worlCol == gp.maxWorldCol) {
				worlCol = 0;
				worldRow++;
			}
		}
		*/
	}
	
	/**
	 * Metodo el cual fusiona dos imagenes
	 */
	public BufferedImage imageFusion( BufferedImage spriteTop, BufferedImage spriteDown) {
		int w = Math.max(spriteDown.getWidth(), spriteTop.getWidth());
		int h = Math.max(spriteDown.getHeight(), spriteTop.getHeight());
		BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = combined.getGraphics();
		g.drawImage(spriteDown, 0, 0, null);
		g.drawImage(spriteTop, 0, 0, null);
		g.dispose();
		return combined;			
	}
}
