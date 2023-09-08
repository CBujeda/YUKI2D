package resources;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import tile.Tile;
import utils.Console;
import utils.Crypter;

public class Read {

	
	public static ArrayList<BufferedImage> player() {
		
		File sadowf = new File("./data/player/sadow.png");
		BufferedImage sadowimg = new BufferedImage(180,180,BufferedImage.TYPE_INT_ARGB); 
		try {
			sadowimg = ImageIO.read(sadowf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<BufferedImage> list = new ArrayList<BufferedImage>();
		File f = new File("./data/player/player.png");
		BufferedImage imagen = new BufferedImage(180,180,BufferedImage.TYPE_INT_ARGB); 
		try {
			imagen = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//  x1,y1,x2,y2
		for(int i = 0; i < 4; i++) {
			for(int r = 0; r < 4; r++) {
				list.add(imageFusion(imagen.getSubimage(45*r,45*i,45,45),sadowimg));
			}
		}
		return list;
	}
	
	public static ArrayList<ArrayList<Integer>> maps() {
		File f = new File("./data/maps/0.gwmap");
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		
		try {
			Scanner sc = new Scanner(f);
			if(sc.hasNextLine()) {
				sc.nextLine();
			}
			while(sc.hasNextLine()) {
				String data = sc.nextLine();
				String[] datos = data.split(" ");
				l.add(new ArrayList<Integer>());
				for(int i = 0; i < datos.length;i++) {
					String process = Crypter.inNumDataDecode(datos[i]);
					int dato = -1;
					try {
						dato = Integer.parseInt(process);
					}catch(Exception e) {
						System.err.println("Error al pasar datos de mapa : " + e);
					}
					l.get(l.size()-1).add(dato);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public static ArrayList<Tile> tileConfig() {
		ArrayList<Tile> list = new ArrayList<Tile>();
		File f = new File("./data/tiles/tiles.data");
		try {
			Scanner sc = new Scanner(f);
			if(sc.hasNextLine()) {
				System.out.println();
				Console.msg("Cargando Configuracion de tiles: \n");
				System.out.println(sc.nextLine());	
			}
			while(sc.hasNextLine()) {
				boolean error = false;
				String data = sc.nextLine();
				System.out.print(data + "   ║  ");
				data = data.replaceAll(" ", "");
				String[] datos = data.split(":");
				if(datos.length != 5) {
					error = true;
				} else {
					if(!datos[0].equalsIgnoreCase("false") ) {
						if(!datos[0].equalsIgnoreCase("true")) {
							error = true; 
						}
					}
					if(!datos[3].equalsIgnoreCase("false") ) {
						if(!datos[3].equalsIgnoreCase("true")) {
							error = true; 
						}
					}
					if(!datos[4].equalsIgnoreCase("false") ) { 
						if(!datos[4].equalsIgnoreCase("true")) {
							error = true; 
						}
					}
				}
				
				boolean collision;
				if(datos[0].equalsIgnoreCase("true") ) {
					collision = true;
				}else {collision = false;}
				File file = new File("./data/tiles/"+datos[1]);
				BufferedImage image = new BufferedImage(45,45,BufferedImage.TYPE_INT_ARGB); 
				try {
					image = ImageIO.read(file);
				} catch (IOException e) {
					error = true;
					e.printStackTrace();
				}
				String name = datos[2];
				boolean liquid;
				if(datos[3].equalsIgnoreCase("true") ) {
					liquid = true;
				}else {liquid = false;}
				boolean danger;
				if(datos[4].equalsIgnoreCase("true") ) {
					danger = true;
				}else {danger = false;}
				
				if(error == false) {
					list.add(new Tile(image,collision,name,liquid,danger));
					System.out.print("● ◄ OK");
				}else {
					System.err.print("x ◄ FAILED");
				}
				System.out.println();		
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
	}
	
	public static ArrayList<File> sounds() {
		ArrayList<File> fs = new ArrayList<File>();
		File file = new File("./data/sounds/ambient/0.wav");
		File file2 = new File("./data/sounds/ambient/1.wav");
		fs.add(file);fs.add(file2);
		return fs;
	}
	
	public static BufferedImage icon() {
		File f = new File("./data/config/icon.png");
		BufferedImage icon = new BufferedImage(10,10,BufferedImage.TYPE_INT_ARGB); 
		try {
			icon = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return icon;
	}
	
	public static BufferedImage frontMain() {
		File f = new File("./data/ui/front/main.png");
		BufferedImage img = new BufferedImage(10,10,BufferedImage.TYPE_INT_ARGB); 
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static ArrayList<File> fonts() {
		File f = new File("./data/ui/fonts");
		File[] list = f.listFiles();
		ArrayList<File> l = new ArrayList<File>();
		for(int i = 0; i < list.length;i++) {
			
			String[] data = list[i].getName().split("\\.");
			String extension = "";
			if(data.length > 1) {
				extension = data[1];
			}else {
				extension = "";
			}
			if(extension.equalsIgnoreCase("ttf")) {
				l.add(list[i]);
			}
		}
		return l;
	}
	
	
	public static ArrayList<BufferedImage> heart() {
		ArrayList<BufferedImage> list = new ArrayList<BufferedImage>();
		File f = new File("./data/ui/lives.png");
		BufferedImage imagen = new BufferedImage(180,180,BufferedImage.TYPE_INT_ARGB); 
		try {
			imagen = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//  x1,y1,x2,y2
		for(int i = 0; i < 5; i++) {
				list.add(imagen.getSubimage(14*i,0,14,13));
		}
		return list;
	}
	
	
	
	/**
	 * Metodo el cual fusiona dos imagenes
	 */
	public static BufferedImage imageFusion( BufferedImage spriteTop, BufferedImage spriteDown) {
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
