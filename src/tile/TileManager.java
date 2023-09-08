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
import utils.Console;
import utils.Crypter;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class TileManager {
	
	private GamePanel gp;
	private ArrayList<Tile> tiles;
	private ArrayList<ArrayList<Integer>> mapData;
	private int mapSizeX;
	private int mapSizeY;
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tiles = Read.tileConfig();
		mapData = Read.maps();
		Console.line(50);
		Console.msg("Cargando Mapa: \n");
		for(int i = 0; i < mapData.size(); i++) {
			for(int r = 0; r < mapData.get(i).size();r++) {
				System.out.print(Crypter.inNumDataCode(Integer.toString(mapData.get(i).get(r)+1*2)) + " ");
			}
			System.out.println();
		}
		Console.line(50);
		mapSizeX = mapData.size();
		mapSizeY = mapData.get(0).size();
	}
	
	public void draw(Graphics2D g2) {
		for(int worlCol1 = 0; worlCol1 < mapData.size();worlCol1++ ) {
			for(int worldRow2 = 0; worldRow2 < mapData.get(worlCol1).size(); worldRow2++) {
				int tileNumber = mapData.get(worlCol1).get(worldRow2);
				int worldX = worlCol1 * gp.tileSize;	
				int worldY = worldRow2 * gp.tileSize;
				double screenX = worldX - gp.player.worldX + gp.player.screenX;
				double screenY = worldY - gp.player.worldY + gp.player.screenY;
				if(		worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
						worldX - gp.tileSize < gp.player.worldX +  gp.player.screenX &&
						worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
						worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
					if(worldY + gp.tileSize > gp.player.worldY - gp.player.screenY) {
						if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX) {
							g2.drawImage(tiles.get(tileNumber).getImage(),(int) screenX,(int)screenY,gp.tileSize,gp.tileSize,null);
						}
					}
				}
			}
		}
	}

	public int getMapSizeX() {
		return mapSizeX;
	}
	public void setMapSizeX(int mapSizeX) {
		this.mapSizeX = mapSizeX;
	}
	public int getMapSizeY() {
		return mapSizeY;
	}
	public void setMapSizeY(int mapSizeY) {
		this.mapSizeY = mapSizeY;
	}
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	public ArrayList<ArrayList<Integer>> getMapData() {
		return mapData;
	}
	public void setMapData(ArrayList<ArrayList<Integer>> mapData) {
		this.mapData = mapData;
	}
	
	
}
