package resources;

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
				list.add(imagen.getSubimage(45*r,45*i,45,45));
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
}
